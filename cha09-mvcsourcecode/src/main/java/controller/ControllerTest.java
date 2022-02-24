package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/demo")
public class ControllerTest {
    @RequestMapping("/handle01")
    public String handler01(String name, Map<String,Object> map) {
        System.out.println("controller业务");
        Date date = new Date();
        map.put("date",date);
        return "success";
    }
}
