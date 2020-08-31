package com.hailintang.demo.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * @author hailin.tang
 * @date 2020/5/24 1:32 下午
 * @function
 */
@ComponentScan("com.hailintang.demo.spring")
public class Start {
    public static void main(String[] args) {
        test8();
    }

    private static void test2() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //扫描包
        annotationConfigApplicationContext.scan("com.hailintang.demo.spring");
        //刷新ioc容器
        annotationConfigApplicationContext.refresh();
        //从容器获取bean
        MyService bean = annotationConfigApplicationContext.getBean(MyService.class);

        TransferService transferService = (TransferService)annotationConfigApplicationContext.getBean("transferService");
        bean.doStuff();
        transferService.transfer();
    }

    public static void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = applicationContext.getBean(MyService.class);
        myService.doStuff();
        applicationContext.close();
    }
    public static void test3(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService1 = applicationContext.getBean(MyService.class);
        MyService myService2 = applicationContext.getBean(MyService.class);
        System.out.println("myService1==myService2:"+ myService1.equals(myService2));
        applicationContext.close();
    }
    public static void test4(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService1 = (MyService) applicationContext.getBean("mydao1");
        MyService myService2 = (MyService)applicationContext.getBean("mydao2");
        System.out.println("myService1==myService2:"+ myService1.equals(myService2));
        applicationContext.close();
    }

    public static void test5(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService1 = (MyService) applicationContext.getBean(MyService.class);
        myService1.doStuff();
        applicationContext.close();
    }

    /**
     * 测试@Profile
     */
    public static void test6(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //先指定环境，再去加载配置类
        applicationContext.getEnvironment().setActiveProfiles("pro");
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();

        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("IOC bean的数量="+beanDefinitionCount);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        Object mydao2 = applicationContext.getBean("mydao2");

        System.out.println(mydao2);
        //关闭容器
        applicationContext.close();
    }
    public static void test7(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AppConfig.class);

        annotationConfigApplicationContext.refresh();

        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        boolean foo = environment.containsProperty("user.timezone");
        System.out.println(foo);
        //jvm的系统变量
        Properties properties = System.getProperties();
        System.out.println("properties:"+properties);
        //系统的环境变量
        Map<String, String> getenv = System.getenv();
        System.out.println("getenv:"+getenv);

        String property = environment.getProperty("env.name");
        System.out.println(property);
    }

    public static void test8(){
        MessageSource messageSource = new AnnotationConfigApplicationContext(AppConfig.class);

        String message = messageSource.getMessage("message", null, "Default2", null);

        System.out.println(message);
    }
}
