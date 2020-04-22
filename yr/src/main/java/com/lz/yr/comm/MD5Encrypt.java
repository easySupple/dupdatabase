package com.lz.yr.comm;



import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
    public static byte[] MD5Encode(byte[] bytes) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            return md.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /*对字符串进行加密*/
    public static String encrypt(String inputStr) {
        try {
            return bytesToHexString(MD5Encrypt.MD5Encode(inputStr.getBytes("UTF8")));
        } catch (UnsupportedEncodingException e) {
            return bytesToHexString(MD5Encrypt.MD5Encode(inputStr.getBytes()));
        }
    }


    /**
     * 返回连接字符串进行MD5加密
     * @return
     */
    public static String returnStrNotDigital( String code, String passwd) {
        StringBuilder result = new StringBuilder();
        result.append(code);
        result.append(passwd);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5Encrypt.encrypt("123123456"));
        System.out.println(MD5Encrypt.encrypt("111123456"));
        System.out.println(MD5Encrypt.encrypt("121123456"));
        System.out.println(MD5Encrypt.encrypt(MD5Encrypt.encrypt("123123456")));

    }

}
