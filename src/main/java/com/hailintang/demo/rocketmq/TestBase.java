package com.hailintang.demo.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

/**
 * @author hailin.tang
 * @date 2020-04-13 14:11
 * @function
 */
public class TestBase {
    /**
     * 同步发送消息
     * @throws InterruptedException
     * @throws RemotingException
     * @throws MQClientException
     * @throws MQBrokerException
     */
    @Test
    public void test1() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        //创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("test");

        //指定nameServer
        producer.setNamesrvAddr("localhost:9876");

        //启动生产者
        producer.start();
        for (int i=0;i<10;i++){
            //创建消息
            Message message = new Message("base","tag3",("helloword"+i).getBytes());
            //发送消息
            SendResult result = producer.send(message);

            System.out.println(result);
            //睡一秒
            Thread.sleep(1000);
        }

        //关闭生产者
        producer.shutdown();
    }

    /**
     * 发送异步消息
     * @throws MQClientException
     * @throws RemotingException
     * @throws InterruptedException
     * @throws MQBrokerException
     */
    @Test
    public void testAsync() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("testAsync");

        producer.setNamesrvAddr("localhost:9876");

        //启动

        producer.start();

        //创建消息
        for (int i=0;i<10;i++){
            Message message = new Message("base","tag2",("hellowo123rd"+i).getBytes());

            //发送消息
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    System.out.println(e);
                }
            });

            //

            Thread.sleep(1000);
        }

    }

    /**
     * 单向发送消息：比如日志
     */
    @Test
    public void testSendOneWay() throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("testlog");

        producer.setNamesrvAddr("localhost:9876");

        producer.start();

        for (int i=0;i<10;i++){
            Message message = new Message("base","tag3","qwe".getBytes());

            producer.sendOneway(message);

            Thread.sleep(1000);
        }
    }
}
