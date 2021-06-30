package com.hailintang.demo.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListSplitter implements Iterator<List<Message>> {
    private final int SIZE_LIMIT = 1000 * 1000;
    private final List<Message> messages;
    private int currIndex;

    public ListSplitter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        return currIndex < messages.size();
    }

    @Override
    public List<Message> next() {
        int nextIndex = currIndex;
        int totalSize = 0;
        for (; nextIndex < messages.size(); nextIndex++) {
            Message message = messages.get(nextIndex);
            int tmpSize = message.getTopic().length() + message.getBody().length;
            Map<String, String> properties = message.getProperties();
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                tmpSize += entry.getKey().length() + entry.getValue().length();
            }
            tmpSize = tmpSize + 20; //for log overhead
            if (tmpSize > SIZE_LIMIT) {
                //it is unexpected that single message exceeds the SIZE_LIMIT
                //here just let it go, otherwise it will block the splitting process
                if (nextIndex - currIndex == 0) {
                    //if the next sublist has no element, add this one and then break, otherwise just break
                    nextIndex++;
                }
                break;
            }
            if (tmpSize + totalSize > SIZE_LIMIT) {
                break;
            } else {
                totalSize += tmpSize;
            }

        }
        List<Message> subList = messages.subList(currIndex, nextIndex);
        currIndex = nextIndex;
        return subList;
    }

    public static void main(String[] args) throws Exception {
        //生产者组
        DefaultMQProducer producer = new DefaultMQProducer("batch_producer_group");

        //设置nameserver
        producer.setNamesrvAddr("localhost:9876");
        //启动生产者
        producer.start();

        //构建消息

        List<Message> msgs = new ArrayList<>();
        byte[] bytes1 = new byte[100*600];//600k
        byte[] bytes2 = new byte[100*200];//200k
        byte[] bytes3 = new byte[100*1001];//1025k

        Message message1 = new Message("batchTopic", "TagA", bytes1);
        Message message2 = new Message("batchTopic", "TagA", bytes2);
        Message message3 = new Message("batchTopic", "TagA", bytes3);

        msgs.add(message1);
        msgs.add(message2);
        msgs.add(message3);

        // 发送消息
        //then you could split the large list into small ones:
        ListSplitter splitter = new ListSplitter(msgs);

        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                SendResult sendResult = producer.send(listItem);
                // 打印发送结果
                System.out.println("发送结果：" + sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                //handle the error
            }
        }

        // 关闭生产者
        producer.shutdown();

    }
}

