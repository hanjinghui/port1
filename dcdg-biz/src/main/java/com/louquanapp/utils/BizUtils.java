package com.louquanapp.utils;

import com.louquanapp.dao.model.Customer;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BizUtils {

    // 将double 类型的数字格式化保留2位小数点
    public static final String saveTwoPoint(Double doub) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(doub);
    }

    public static String getCustName(Customer customer) {
        if (null == customer) {
            return "";
        }
        String custName = customer.getCustPhone();
        if (StringUtils.isNotEmpty(customer.getRealName())) {
            custName = custName.concat("(").concat(customer.getRealName()).concat(")");
        }
        return custName;
    }

    public static boolean isWord(char c) {
        String regEx = "[\\w]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("" + c);
        return m.matches();
    }

    public static boolean isWord(String str) {
        Boolean bb=true;
        for(int i=0;i<str.length();i++){
            System.out.println(i+":"+str.charAt(i));
            if(!isWord(str.charAt(i))){
                bb=false;
                break;
            }
        }

        return bb;
    }

    public static void main(String[] args) {
        System.out.println(isWord("shIIA22"));
    }


}
