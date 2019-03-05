package org.maogogo.session;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootEndpoint {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
