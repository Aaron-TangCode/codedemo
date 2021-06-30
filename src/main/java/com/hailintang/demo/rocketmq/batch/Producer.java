package com.hailintang.demo.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    public static void main(String[] args) throws Exception{
        //生产者组
        DefaultMQProducer producer = new DefaultMQProducer("batch_producer_group");

        //设置nameserver
        producer.setNamesrvAddr("localhost:9876");
        //启动生产者
        producer.start();

        //构建消息

        List<Message> msgs = new ArrayList<>();

        Message message1 = new Message("batchTopic","TagA","batchMessage1".getBytes(RemotingHelper.DEFAULT_CHARSET));
        Message message2 = new Message("batchTopic","TagA","batchMessage2".getBytes(RemotingHelper.DEFAULT_CHARSET));
        Message message3 = new Message("batchTopic","TagA","batchMessage3".getBytes(RemotingHelper.DEFAULT_CHARSET));
        msgs.add(message1);
        msgs.add(message2);
        msgs.add(message3);

        // 发送消息
        SendResult sendResult = producer.send(msgs);
        // 打印发送结果
        System.out.println("发送结果："+sendResult);
        // 关闭生产者
        producer.shutdown();
    }
}
