package com.louquanapp.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.huhuamin.common.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 阿里云 oss 图片 集成化配置
 */
public class OssLocalClientUtils {


    private static final Logger log = LoggerFactory.getLogger(OssLocalClientUtils.class);
    public static String imageUrlPrefix = "https://louquan.oss-cn-beijing.aliyuncs.com";
    public static String key = "louquan";
    private static OSSClient ossClient = null;

    static {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAIxwpfltO8WgBK";
        String accessKeySecret = "qhdAkf9fRGwF8iEgQGVT0xUU1018aW";
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    private OssLocalClientUtils() {
    }

    public static OSSClient getOssClient() {
        return ossClient;
    }

    public static String convertByteToOssObject(byte[] img) {
        String filename = "";
        if (null != img && img.length > 0) {
            String targetDirectory = "louquan/";
            String secPath = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
            String targetFileName = secPath.concat("/").concat(UUIDUtils.generateUuid22().concat(".jpg"));
            filename = targetDirectory + targetFileName;
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength((long) img.length);
            InputStream input = new ByteArrayInputStream(img);
            PutObjectResult result = ossClient.putObject(key, filename, input, meta);
            log.debug("oss result" + result + "\r\n uuid=" + filename);
        }

        return filename;
    }

    public static String convertFileToOssObject(MultipartFile doc, HttpServletRequest request) throws IOException {
        String filename = "";
        String targetDirectory = "louquan/";
        String contentType = request.getContentType();
        /*if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
            MultipartHttpServletRequest multipartRequest =
                    WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            doc = multipartRequest.getFile("file");
        }*/
        String secPath = new SimpleDateFormat("yyyyMMdd").format(new Date());
        /*String originalFileName = doc.getOriginalFilename();
        String appendixString = originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileNameString = UUIDUtils.generateUuid22().concat(appendixString);
        System.out.println("new File name" + newFileNameString);*/
        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        /* meta.setContentLength(doc.getSize());*/
        String targetFileName = secPath.concat("/").concat(UUIDUtils.generateUuid22().concat(".jpg"));
        String savaUrl = targetDirectory + targetFileName;
        System.out.println(savaUrl);
        PutObjectResult result = ossClient.putObject(key, savaUrl, doc.getInputStream(), meta);
        log.debug("oss result" + result + "\r\n uuid=" + filename);
        filename = targetDirectory + targetFileName;
        return filename;
    }

    public static String convertPathToOssObject(String outPath) {
        String filename = "";
        String targetDirectory = "louquan/";
        String secPath = new SimpleDateFormat("yyyyMMdd").format(new Date());
        ObjectMetadata meta = new ObjectMetadata();
        String targetFileName = secPath.concat("/").concat(UUIDUtils.generateUuid22().concat(".png"));
        String savaUrl = targetDirectory + targetFileName;
        PutObjectResult result = ossClient.putObject(key, savaUrl, new File(outPath), meta);
        log.debug("oss result" + result + "\r\n uuid=" + filename);
        filename = targetDirectory + targetFileName;
        return filename;

    }


    public static void deleteFile(String bucketName, String objectName) {

        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);

    }

    public static List<String> deleteFiles(String bucketName, List<String> keys) {

        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys));
        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        return deletedObjects;
    }
}
