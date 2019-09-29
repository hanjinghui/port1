package com.louquanapp.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/14 14:43
 * @Description: 图片二维码
 */
public class ImageAndQRcode {
    //二维码颜色
    private static final int BLACK = 0xFF000000;
    //二维码颜色
    private static final int WHITE = 0xFFFFFFFF;


    ImageAndQRcode() {
    }

    /**
     * <span style="font-size:18px;font-weight:blod;">ZXing 方式生成二维码</span>
     *
     * @param text       <a href="javascript:void();">二维码内容</a>
     * @param width      二维码宽
     * @param height     二维码高
     * @param outPutPath 二维码生成保存路径
     * @param imageType  二维码生成格式
     */
    public static void zxingCodeCreate(String text, int width, int height, String outPutPath, String fileName, String imageType) {
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();
        //设置编码字符集
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            //1、生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);

            //2、获取二维码宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();

            //3、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //4、循环将二维码内容定入图片
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);
                }
            }
            File outPut = new File(outPutPath);
            //如果文件夹不存在创建图片
            if (!outPut.isDirectory()) {
                outPut.mkdirs();
            }
            File outPutImage = new File(outPutPath + "/" + fileName);
            //如果图片不存在创建图片
            if (!outPutImage.exists()) {
                outPutImage.createNewFile();
            }
            //5、将二维码写入图片
            ImageIO.write(image, imageType, outPutImage);
            System.out.println("生成成功");
        } catch (WriterException e) {
            e.printStackTrace();
            System.out.println("二维码生成失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成二维码图片失败");
        }
    }


    /**
     * 生成二维码图片
     * @param isBackground 是否融入背景[1-有背景 2-没有背景]
     * @param text    二维码内容 例：https://www.baidu.com
     * @param width   二维码宽度
     * @param height  二维码高度
     * @param bigPath 背景图路径
     * @param x       二维码距离左边像素
     * @param y       二维码距离顶部像素
     * @return 2018年11月23日
     */
    public static void zxingCodeCreateImage(Integer isBackground,String text, int width, int height, String bigPath, String outPath, String x, String y) {
        Map<EncodeHintType, String> his = new HashMap<EncodeHintType, String>();
        //设置编码字符集
        his.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            //1、生成二维码
            BitMatrix encode = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, his);

            //2、获取二维码宽高
            int codeWidth = encode.getWidth();
            int codeHeight = encode.getHeight();

            //3、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //4、循环将二维码内容定入图片
                    image.setRGB(i, j, encode.get(i, j) ? BLACK : WHITE);
                }
            }
            //设置圆角
            image = setClip(image, 2);
            image=setLogo(image,2);

            if(isBackground==1){
                //将二维码绘图到图片中
                mergeImage(bigPath, image, x, y, outPath);
            }else   if(isBackground==2){
                //将二维码绘图直接内存中
                ImageIO.write(image, "png", new File(outPath));
            }




        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("二维码图片生成失败");
        }
    }

    /**
     * 图片切圆角
     *
     * @param srcImage
     * @param radius
     * @return
     */
    public static BufferedImage setClip(BufferedImage srcImage, int radius) {
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gs = image.createGraphics();

        gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gs.setClip(new RoundRectangle2D.Double(0, 0, width, height, radius, radius));
        gs.drawImage(srcImage, 0, 0, null);
        gs.dispose();
        return image;
    }

    /**
     * 图片切圆角
     *
     * @param srcImage
     * @param radius
     * @return
     */
    public static BufferedImage setLogo(BufferedImage srcImage, int radius) throws IOException {
        Graphics2D gs = srcImage.createGraphics();
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        InputStream is = new FileInputStream(new File(path + "log.jpg"));

        // 先读入内存
        ByteArrayOutputStream buf = new ByteArrayOutputStream(8192);
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            buf.write(b, 0, len);
        }
        is = new ByteArrayInputStream(buf.toByteArray());
        //读取logo图片
        BufferedImage img = ImageIO.read(is);
        //设置二维码大小，太大，会覆盖二维码，此处20%
        int logoWidth = srcImage.getWidth() * 3 / 25;//img.getWidth(null) > image.getWidth()*2 /10 ? (image.getWidth()*2 /10) : img.getWidth(null);
        int logoHeight = srcImage.getHeight() * 3 / 25;//img.getHeight(null) > image.getHeight()*2 /10 ? (image.getHeight()*2 /10) : img.getHeight();
        //设置logo图片放置位置
        //中心
        int x = (srcImage.getWidth() - logoWidth) / 2;
        int y = (srcImage.getHeight() - logoHeight) / 2;

        //开始合并绘制图片
        gs.drawImage(img, x, y, logoWidth, logoHeight, null);
        gs.drawRoundRect(x, y, logoWidth, logoHeight, 15, 15);
        //logo边框大小
        gs.setStroke(new BasicStroke(2));
        //logo边框颜色
        gs.setColor(Color.WHITE);
        gs.drawRect(x, y, logoWidth, logoHeight);
        gs.dispose();
        img.flush();
        srcImage.flush();
        return srcImage;
    }

    /**
     * 将二维码绘图到图片中
     *
     * @param bigPath
     * @param small
     * @param x
     * @param y
     * @throws IOException 2018年11月23日
     */
    public static void mergeImage(String bigPath, BufferedImage small, String x, String y, String outPath) throws IOException {

        try {
            BufferedImage big = ImageIO.read(new File(bigPath));
            Graphics2D g = big.createGraphics();
            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int) fx;
            int y_i = (int) fy;
            g.drawImage(small, x_i, y_i, small.getWidth(), small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, "png", new File(outPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        System.out.println(path);
        String outPath = String.valueOf(new Date().getTime()) + ".png";
        //1000 1500
        zxingCodeCreateImage(1,"https://www.baidu.com", 412, 412, path + "bg.jpg", path + outPath, "169", "461");
//        String ossFilename = OssLocalClientUtils.convertPathToOssObject(path+outPath);
//        removeTempFile(path+outPath);

    }

    public static void removeTempFile(String path) {
        File file = new File(path);
        file.delete();
    }
}
