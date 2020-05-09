package com.hailintang.demo.geekbang.course05;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020-03-23 19:42
 * @function
 */
public class TestFeign {

    @PostMapping("/server")
    public void server() throws InterruptedException {
        TimeUnit.MINUTES.sleep(10);
    }

//    @FeignClient(name = "clientsdk")
    public interface Client {
        @PostMapping("/feignandribbon/server")
        void server();
    }

    @GetMapping("client")
    public void timeout() {
        long begin=System.currentTimeMillis();
        try{
//            client.server();
        }catch (Exception ex){
//            log.warn("执行耗时：{}ms 错误：{}", System.currentTimeMillis() - begin, ex.getMessage());
        }
    }
}
