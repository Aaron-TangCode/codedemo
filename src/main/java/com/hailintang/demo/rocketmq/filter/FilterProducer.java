package com.hailintang.demo.rocketmq.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class FilterProducer {
    public static void main(String[] args) throws Exception{

        //生产者组
        DefaultMQProducer producer = new DefaultMQProducer("filter_producer_group");

        //设置nameserver
        producer.setNamesrvAddr("localhost:9876");

        //启动生产者
        producer.start();

        for(int i=0;i<10;i++){
            //构建消息
            Message message = new Message("filterTopic",("helloWorld"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));

            message.putUserProperty("a",String.valueOf(i));

            // 发送消息
            SendResult sendResult = producer.send(message);

            // 打印发送结果
            System.out.println("发送结果："+sendResult);
        }

        // 关闭生产者
        producer.shutdown();
    }
}
