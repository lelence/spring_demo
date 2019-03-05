package org.maogogo.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootEndpoint {

    @Autowired
    private RedisLock redisLock;

    @GetMapping("/hello")
    public String hello() {



        return "";
    }

}
