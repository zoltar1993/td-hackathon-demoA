package com.hackathon.zzwqg.demo.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zoltar on 17-5-20.
 */

@RestController
public class GreetingController {

    @Autowired private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public Map<String,Object> greeting(){
        HashMap<String,Object> result = new HashMap<>();

        result.put("services",discoveryClient.getServices());
        result.put("demob",discoveryClient.getInstances("demob"));

        return result;
    }
}
