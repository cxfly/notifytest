package com.cxfly.notify.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxfly.notify.publisher.SaleCountZeroSender;

@Controller
@RequestMapping(value = "/notify/*")
public class NotifyController {

    public NotifyController(SaleCountZeroSender saleCountZeroSender) {
        super();
        this.saleCountZeroSender = saleCountZeroSender;
    }

    public NotifyController() {
        super();
    }

    @Resource
    private SaleCountZeroSender saleCountZeroSender;

    @RequestMapping
    public String test(Model model, HttpServletRequest request, HttpServletResponse response) {
        Object result = false;
        try {
            result = this.saleCountZeroSender.sendMsg("test");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("result", result);

        return "main.layout";
    }

}
