package com.super13.orderservice.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/orders")
@CrossOrigin("http://localhost:4200")
public class OrderController {


    @PostMapping("/createOrder")
    public String createOrder(@RequestBody Map<String, Object> data) throws Exception
    {

        System.out.println(data);

        int amt=Integer.parseInt(data.get("amount").toString());

        RazorpayClient client = new RazorpayClient("rzp_live_opnKtrGBorDpGJ", "61vmCqCVOtkSqDpAEnThayxX");

        JSONObject ob=new JSONObject();
        ob.put("amount", amt*100);
        ob.put("currency", "INR");
        ob.put("receipt", "txn_235425");

        //creating new order

        Order order = client.Orders.create(ob);
        System.out.println(order);

        return order.toString();
    }
}
      