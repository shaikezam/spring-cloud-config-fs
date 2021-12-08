package spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class BasicController {

    @Value("${blabla}")
    private String property;

    @GetMapping("/")
    @ResponseBody
    public String getAllTasks() {
        return property + " Hello World";
    }


}
