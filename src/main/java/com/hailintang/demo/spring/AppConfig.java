package com.hailintang.demo.spring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

/**
 * @author hailin.tang
 * @date 2020/5/24 1:33 下午
 * @function
 */
@Configuration
@PropertySource("classpath:test.properties")
//@EnableLoadTimeWeaving
public class AppConfig {
    @Bean(initMethod = "init",destroyMethod = "des",name = {"mydao1","mydao2"})
//    @Scope("prototype")
    @Description("provide a basic example of a bean")
    @Profile("pro")
    public MyService myService(){
        return new MyServiceImpl();
    }
    @Bean
//    @Profile("dev")
    @ConditionalOnMissingBean(MyService.class)
    public TransferService transferService(){
        return new TransferServiceImpl();
    }
    @Bean
    public Foo foo(){
        return new Foo(new Bar());
    }
    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public ClientService clientService1(){
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }
    @Bean
    public ClientService clientService2(){
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    public ClientDao clientDao(){
        return new ClientDaoImpl();
    }
}
