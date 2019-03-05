package org.maogogo.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RootEndpoint implements APIV1 {

    @RequestMapping("/hello")
    public String hello() {
        return "hello: " + System.currentTimeMillis();
    }

    @GetMapping("/login")
    public Map<String, Object> firstResp(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("map", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }


    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Map<String, Object> sessions(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("map"));
        return map;
    }


}
