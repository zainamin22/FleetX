package com.zzeebee.restapi;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeedLimit {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/speedlimit/{lat},{lon}", produces = "application/json")
    public Map<String, Integer> showSpeedLimitJson(@PathVariable("lat") final double p1,
            @PathVariable("lon") final double p2) {

        Map<String, Integer> speedlimit = new HashMap<>();
        speedlimit.put("speedlimit", 30);

        return speedlimit;
    }

}
