package com.hailintang.demo.rocketmq.filter;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class FilterConsumer {
    public static void main(String[] args) throws Exception {
        // 消费者组
        DefaultMQPushConsumer consumer =  new DefaultMQPushConsumer("filter_consumer_group");
        //注册nameserver
        consumer.setNamesrvAddr("localhost:9876");


        MessageSelector ms = MessageSelector.bySql("a > 5");
        // 订阅主题
        consumer.subscribe("filterTopic",ms);

        // 开启消费offset
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (int i = 0; i < list.size(); i++) {
                    MessageExt messageExt = list.get(i);
                    String msg = new String(messageExt.getBody());
                    System.out.println("消费消息："+msg);
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.start();

        System.out.println("启动消费者");
    }
}
