package org.maogogo.shopping.controller;

import org.maogogo.shopping.domain.TAgent;
import org.maogogo.shopping.service.TAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private TAgentService tAgentService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "toan");
        return "test";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<TAgent> getList() {
        List<TAgent> list = tAgentService.getList();
        // model.addAttribute("list", list);
        return list;
    }
}
