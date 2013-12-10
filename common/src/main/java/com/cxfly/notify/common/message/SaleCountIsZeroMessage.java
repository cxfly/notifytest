package com.cxfly.notify.common.message;
/**
 * Project: biz.wl.remoteservice
 * 
 * File Created at 2013-2-21
 * $Id$
 * 
 * Copyright 1999-2100 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */


import java.io.Serializable;

public class SaleCountIsZeroMessage implements Serializable {
    private static final long serialVersionUID = -7297286698887175281L;

    private String            skuId;                                   // SKUID

    private String            remark;                                  // 备注信息,详见SaleCountIsZeroSourceEnum定义

    public SaleCountIsZeroMessage() {
        super();
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SkuSaleCountIsZeroMessage [skuId=" + skuId + ", remark=" + remark + "]";
    }
}
