package com.hackathon.zzwqg.demo.a.controller;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by zoltar on 17-5-20.
 */

@RestController
public class MonitorController {

    @Autowired private MetricRegistry metricRegistry;

    @RequestMapping("/load")
    public HashMap<String,Object> getLoad(){
        Timer timer = metricRegistry.getTimers().get("load");

        HashMap<String,Object> result = new HashMap<>();
        result.put("fifteenMinuteRate",timer.getFifteenMinuteRate());
        result.put("fiveMinuteRate",timer.getFiveMinuteRate());
        result.put("oneMinuteRate",timer.getOneMinuteRate());
        result.put("meanRate",timer.getMeanRate());
        result.put("count",timer.getCount());

        return result;
    }
}
