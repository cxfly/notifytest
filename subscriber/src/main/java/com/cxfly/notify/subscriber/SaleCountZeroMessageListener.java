package com.cxfly.notify.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cxfly.notify.common.message.SaleCountIsZeroMessage;
import com.taobao.hsf.notify.client.MessageListener;
import com.taobao.hsf.notify.client.MessageStatus;
import com.taobao.hsf.notify.client.message.BytesMessage;
import com.taobao.hsf.notify.client.message.Message;
import com.taobao.hsf.notify.client.message.ObjectMessage;
import com.taobao.hsf.notify.client.message.StringMessage;

public class SaleCountZeroMessageListener implements MessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(SaleCountZeroMessageListener.class);

    @Override
    public void receiveMessage(Message message, MessageStatus status) {
        StringBuilder generalInfo = new StringBuilder();
        generalInfo.append("收到");
        generalInfo.append("topic is:").append(message.getTopic());
        generalInfo.append("messageType is:").append(message.getMessageType());
        try {
            generalInfo.append("用户自定义属性:").append(message.getStringProperty("customHeader"));
        } catch (Exception e) {
            status.setReason("错误原因。。。");
            status.setRollbackOnly();
        }

        generalInfo.append("消息在客户端产生时间:").append(message.getBornTime());
        generalInfo.append("消息到达notify server时间:").append(message.getGMTCreate());
        generalInfo.append("消息最后一次投递时间:").append(message.getGMTLastDelivery());

        if (message instanceof StringMessage) {
            generalInfo.append("String消息body内容:");
            StringMessage stringMessage = (StringMessage) message;
            generalInfo.append(stringMessage.getBody());
        } else if (message instanceof BytesMessage) {
            generalInfo.append("Byte消息body内容:");
            BytesMessage bytesMessage = (BytesMessage) message;
            generalInfo.append(new String(bytesMessage.getBody()));
        } else if (message instanceof ObjectMessage) {
            ObjectMessage objMsg = (ObjectMessage) message;
            SaleCountIsZeroMessage msg = (SaleCountIsZeroMessage) objMsg.getObject();
            LOG.info("ObjectMessage: " + msg);
        }
        LOG.info("generalInfo: " + generalInfo);

    }

}
