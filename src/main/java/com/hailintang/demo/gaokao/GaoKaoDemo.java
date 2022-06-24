package com.hailintang.demo.gaokao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GaoKaoDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        try {
//
//            String command = "curl 'https://api.qishengzy.com/volunteer/univList' \\\n" +
//                    "  -H 'authority: api.qishengzy.com' \\\n" +
//                    "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
//                    "  -H 'accept: application/json, text/plain, */*' \\\n" +
//                    "  -H 'content-type: application/x-www-form-urlencoded' \\\n" +
//                    "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
//                    "  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
//                    "  -H 'token: 9ec9435f-79b1-4fa7-983b-98dc083d8fd5' \\\n" +
//                    "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
//                    "  -H 'origin: https://m.qishengzy.com' \\\n" +
//                    "  -H 'sec-fetch-site: same-site' \\\n" +
//                    "  -H 'sec-fetch-mode: cors' \\\n" +
//                    "  -H 'sec-fetch-dest: empty' \\\n" +
//                    "  -H 'referer: https://m.qishengzy.com/' \\\n" +
//                    "  -H 'accept-language: zh-CN,zh;q=0.9,en;q=0.8' \\\n" +
//                    "  -H 'cookie: Hm_lvt_c54d29c46f6ae8d011bbac1a726d6e19=1656051666; Hm_lpvt_c54d29c46f6ae8d011bbac1a726d6e19=1656056504' \\\n" +
//                    "  --data-raw 'provinceId=20&majorTypeId=3&batchId=1&courseGroupId=41&isJunior=0&score=561&cityIds=&provIds=&is985=&is211=&isFirstLevel=&isFirstClass=&hasMaster=&hasRegular=&hasJunior=&isIndependent=&isBackbone=&isDemonstrative=&isPublic=&univTypes=&univIds=&majorClasses=&majors=&univName=&majorName=&cwb=&pageSize=10&page=1' \\\n";
//            System.out.println("command:"+command);
//            Process process = Runtime.getRuntime().exec(command);
//
//
//            InputStreamReader ir = new InputStreamReader(process.getInputStream());
//
//            BufferedReader input = new BufferedReader(ir);
//
//            String line;
//
//            while ((line = input.readLine()) != null) {
//
//                System.out.println(line);
//
//            }//end try
//        } catch (Exception e) {
//
//            System.err.println("IOException " + e.getMessage());
//
//        }
        // 启动数据库
        PreparedStatement statement = prepareDataBase();
        // 正式操作
        String a = "curl 'https://api.qishengzy.com/volunteer/univList' \\\n" +
                "  -H 'authority: api.qishengzy.com' \\\n" +
                "  -H 'sec-ch-ua: \" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"97\", \"Chromium\";v=\"97\"' \\\n" +
                "  -H 'accept: application/json, text/plain, */*' \\\n" +
                "  -H 'content-type: application/x-www-form-urlencoded' \\\n" +
                "  -H 'sec-ch-ua-mobile: ?0' \\\n" +
                "  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36' \\\n" +
                "  -H 'token: 9ec9435f-79b1-4fa7-983b-98dc083d8fd5' \\\n" +
                "  -H 'sec-ch-ua-platform: \"macOS\"' \\\n" +
                "  -H 'origin: https://m.qishengzy.com' \\\n" +
                "  -H 'sec-fetch-site: same-site' \\\n" +
                "  -H 'sec-fetch-mode: cors' \\\n" +
                "  -H 'sec-fetch-dest: empty' \\\n" +
                "  -H 'referer: https://m.qishengzy.com/' \\\n" +
                "  -H 'accept-language: zh-CN,zh;q=0.9,en;q=0.8' \\\n" +
                "  -H 'cookie: Hm_lvt_c54d29c46f6ae8d011bbac1a726d6e19=1656051666; Hm_lpvt_c54d29c46f6ae8d011bbac1a726d6e19=1656056504' \\\n" +
                "  --data-raw 'provinceId=20&majorTypeId=3&batchId=1&courseGroupId=41&isJunior=0&score=561&cityIds=&provIds=&is985=&is211=&isFirstLevel=&isFirstClass=&hasMaster=&hasRegular=&hasJunior=&isIndependent=&isBackbone=&isDemonstrative=&isPublic=&univTypes=&univIds=&majorClasses=&majors=&univName=&majorName=&cwb=&pageSize=10&page=";
//        String b = "1";

        String c = "'";
        String d = " \\\\\\n" + "--compressed";


        List<UniversiteEntity> result = new ArrayList<>();

        for(int i=1;i<2;i++){
            List<String> list = new ArrayList<>();
            list.add(a+i+c+d);
            try {
                Thread.sleep(1000+((int) Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<UniversiteEntity> universiteEntities = executeNewFlow(list,statement);
//            result.addAll(universiteEntities);
        }



//        System.out.println("结果集:"+JSON.toJSONString(result));

        System.out.println("结束了");
    }

    private static PreparedStatement prepareDataBase() throws ClassNotFoundException, SQLException {
         final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
         final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";
         final String USER = "root";
         final String PASS = "root";

        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);

        // 打开链接
        System.out.println("连接数据库...");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

        // 执行查询
        System.out.println(" 实例化Statement对象...");
        PreparedStatement preparedStatement = conn.prepareStatement("insert into university_info(name,score,rank,pici,kumu,year) values(?,?,?,?,?,?)");


        return preparedStatement;

    }

    public static List<UniversiteEntity> executeNewFlow(List<String> commands,PreparedStatement statement) {
//        List<String> rspList = new ArrayList<String>();
        List<UniversiteEntity> result = new ArrayList<>();

        Runtime run = Runtime.getRuntime();
        try {
            Process proc = run.exec("/bin/bash", null, null);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
            int count = 1;
            for (String line : commands) {
                System.out.println("第"+count+"次执行查询");
                count++;
                out.println(line);
            }
            // out.println("cd /home/test");
            // out.println("pwd");
            // out.println("rm -fr /home/proxy.log");
            out.println("exit");// 这个命令必须执行，否则in流不结束。
            String rspLine = "";
//            List<UniversiteEntity> result = new ArrayList<>();
            int resultCount = 1;
            while ((rspLine = in.readLine()) != null) {
                System.out.println("第"+resultCount+"次执行组装结果操作");
                resultCount++;
                JSONObject jsonObject = JSONObject.parseObject(rspLine);
                int code = jsonObject.getIntValue("code");
                if(code==1){

                    String data = jsonObject.getString("data");
                    JSONObject dataJson = JSONObject.parseObject(data);
                    String univList = dataJson.getString("univList");
                    JSONArray jsonArray = JSONArray.parseArray(univList);
                    if(jsonArray!=null && jsonArray.size()>0){
                        for (int i = 0; i < jsonArray.size(); i++) {
                            UniversiteEntity entity = new UniversiteEntity();

                            JSONObject dataSource = (JSONObject)jsonArray.get(i);
                            String univName = dataSource.getString("univName");
                            entity.setName(univName);
                            String enrollInfo = dataSource.getString("enrollInfo");
                            JSONArray jsonArray1 = JSONArray.parseArray(enrollInfo);
                            if(jsonArray1!=null && jsonArray1.size()>0){
                                JSONObject tempSource = (JSONObject)jsonArray1.get(0);
                                String year = tempSource.getString("year");
                                entity.setYear(year);
                                String lowScore = tempSource.getString("lowScore");
                                entity.setScore(lowScore);
                                String lowRank = tempSource.getString("lowRank");
                                entity.setRank(lowRank);
                                String batchName = tempSource.getString("batchName");
                                entity.setPici(batchName);
                                String majorTypeName = tempSource.getString("majorTypeName");
                                entity.setKemu(majorTypeName);
                            }
                            statement.setString(1,entity.getName());
                            statement.setString(2,entity.getScore());
                            statement.setString(3,entity.getRank());
                            statement.setString(4,entity.getPici());
                            statement.setString(5,entity.getKemu());
                            statement.setString(6,entity.getYear());

                            int execute = statement.executeUpdate();
//                            boolean execute = statement.execute("insert into university_info(name,score,rank,pici,kumu,year) value(?,?,?,?,?,?)", new String[]{entity.getName(), entity.getScore(), entity.getRank(), entity.getPici(), entity.getKemu(), entity.getYear()});
                            System.out.println(entity.getName()+"插入数据mysql："+execute);
//                            result.add(entity);
                        }
                    }
                }
//                rspList.add(rspLine);
            }

//            System.out.println("结果："+ JSON.toJSONString(result));

            proc.waitFor();
            in.close();
            out.close();
            proc.destroy();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
