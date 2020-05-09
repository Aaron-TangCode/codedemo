package com.hailintang.demo.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author hailin.tang
 * @date 2020-04-13 14:42
 * @function
 */
public class TestConsumer {
    public static void main(String[] args) throws MQClientException {
        //broker 推送给消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rocketMQ");

        consumer.setNamesrvAddr("localhost:9876");

        consumer.subscribe("base","*");

        //设置消费模式：负载均衡||广播
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        //注册一个消息监听器
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//                for (MessageExt msg : msgs) {
//                    System.out.println("["+Thread.currentThread().getName()+"] "+new String(msg.getBody()));
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println("["+Thread.currentThread().getName()+"] "+new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        System.out.println("消费完成");
    }
}
