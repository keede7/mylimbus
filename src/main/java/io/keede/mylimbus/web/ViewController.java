package io.keede.mylimbus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* @author keede
* Created on 2025/05/06
*/
@Controller
public class ViewController {

    @GetMapping("")
    public String main() {
        return "main";
    }

    @GetMapping("/mainTest")
    public String mainTest() {
        return "mainTest";
    }

}
