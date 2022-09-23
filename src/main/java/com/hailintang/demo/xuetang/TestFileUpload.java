package com.hailintang.demo.xuetang;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class TestFileUpload {
    public static void main(String[] args) throws IOException {
//        MultipartFile file = new CommonsMultipartFile();
//        file.transferTo(new File(""));
//        double d = 0;
//        if(false){
//            d = 1;
//        }else if(true){
//            d = 2;
//        }else{
//            d = 3;
//        }
//
//        System.out.println(d);
        String msg = "@精选机器人    修改服务时间  订单id     1234-12-12   0:00:00";
        String subMsg = msg.substring(6);
        System.out.println("123"+subMsg);
        System.out.println("123"+subMsg.trim());
        String trim = subMsg.trim();
        String s1 = trim.replaceAll(" + ", " ");


        String[] s = trim.split(" ");
        String[] s2 = s1.split(" ");
        System.out.println(s);
        System.out.println(s2);
    }
}
