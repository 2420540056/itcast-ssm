package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
   private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
   public static String encoderPassword(String enocoder){
       String encode = bCryptPasswordEncoder.encode(enocoder);
       return encode;
   }

    public static void main(String[] args) {
       String passWord="123";
        String s = encoderPassword(passWord);
        System.out.println(s);
    }
}
