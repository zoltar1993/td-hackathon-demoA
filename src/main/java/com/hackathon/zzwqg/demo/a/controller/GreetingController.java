package com.hackathon.zzwqg.demo.a.controller;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by zoltar on 17-5-20.
 */

@RestController
public class GreetingController {

    @Autowired private MetricRegistry metricRegistry;
    @Autowired private RestTemplate restTemplate;

    private Timer timer;

    @PostConstruct
    public void init(){
        timer = metricRegistry.timer("load");
    }

    @RequestMapping("/")
    public String greeting(){
        Timer.Context context = timer.time();

        restTemplate.getForObject("http://172.17.0.3:8888/demob/",String.class);
        restTemplate.getForObject("http://172.17.0.3:8888/demob/",String.class);
        restTemplate.getForObject("http://172.17.0.3:8888/democ/",String.class);
        restTemplate.getForObject("http://172.17.0.3:8888/democ/",String.class);
        restTemplate.getForObject("http://172.17.0.3:8888/democ/",String.class);

        context.stop();
        return "hello !";
    }
}
