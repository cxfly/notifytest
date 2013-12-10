package com.cxfly.notify.publisher;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cxfly.notify.common.message.SaleCountIsZeroMessage;
import com.taobao.notify.message.ObjectMessage;
import com.taobao.notify.remotingclient.NotifyManagerBean;
import com.taobao.notify.remotingclient.SendResult;

@Component
public class SaleCountZeroSender {
    private static final Logger LOG = LoggerFactory.getLogger(SaleCountZeroSender.class);

    @Resource
    private NotifyManagerBean   notifyManager;

    public Object sendMsg(String data) {
        SaleCountIsZeroMessage obj = new SaleCountIsZeroMessage();
        obj.setSkuId("LP10342341");
        obj.setRemark(data);
        ObjectMessage message = new ObjectMessage();
        message.setTopic("TMALL_LP_WL_MAIN");
        message.setMessageType("4pl_sale_count_zero");
        message.setGroupId("LP_WL_PUBLISH_GROUPID");
        message.setObject(obj);

        LOG.info("sendObj: " + obj);

        SendResult result = notifyManager.sendMessage(message);
        LOG.info("sendResult, isSuccess: " + result.isSuccess() + " , messageId:"
                + result.getMessageId());

        return result.getMessageId();
    }
}
