package com.hailintang.demo.io;

import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

public class TestFile {
    public static void main(String[] args) throws IOException {
        String filename_excel = "34096484_72769AA9B413541E56E85EC0B4861AA5.out.xlsx";
        String taskResultUrl = "http://yunchuang.58dns.org/download/results/" + filename_excel;
        File file = new File("./tmp13.xlsx");
        if(file.exists()){
            file.delete();
        }
        HttpUtil.downloadFile(taskResultUrl,file);

        //读取文件
        ExcelReader reader = ExcelUtil.getReader(file);

        List<Map<String, Object>> mapList = reader.readAll();


    }

    /**
     * 根据byte数组，生成文件
     */
    public static void getFile(byte[] bfile, String filePath, String fileName) throws IOException {
        Workbook workBook = new XSSFWorkbook();
        Sheet sheet = workBook.createSheet("sheet1");
        File file = new File(filePath+fileName);

        OutputStream fos = new FileOutputStream(file);
        fos.write(bfile);
        fos.flush();
        workBook.write(fos);
        fos.close();
    }
}
