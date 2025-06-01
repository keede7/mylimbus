package io.keede.mylimbus.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* @author keede
* Created on 2025/05/06
*/
@Controller
public class ViewController {

    @GetMapping("")
    public String main(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String deviceType = MobileValidator.getDeviceType(userAgent);

        if ("mobile".equals(deviceType) || "tablet".equals(deviceType)) {
            return "mobile-not-supported";
        }

        return "main";
    }

    @GetMapping("/mainTest")
    public String mainTest() {
        return "mainTest";
    }

}
