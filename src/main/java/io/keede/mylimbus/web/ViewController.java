package io.keede.mylimbus.web;

import io.keede.mylimbus.domains.statistic.entity.VisitorActivity;
import io.keede.mylimbus.domains.statistic.service.VisitorActivityService;
import io.keede.mylimbus.web.utils.MobileValidator;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

/**
* @author keede
* Created on 2025/05/06
*/
@Controller
@Slf4j
public class ViewController {

    private final VisitorActivityService visitorActivityService;

    public ViewController(
            final VisitorActivityService visitorActivityService
    ) {
        this.visitorActivityService = visitorActivityService;
    }

    @GetMapping("")
    public String main(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        String userAgent = request.getHeader("User-Agent");
        String deviceType = MobileValidator.getDeviceType(userAgent);

        this.recordVisitorActivity(request, response);

        if ("mobile".equals(deviceType) || "tablet".equals(deviceType)) {
            return "mobile-not-supported";
        }

        return "main";
    }

    @GetMapping("/mainTest")
    public String mainTest() {
        return "mainTest";
    }

    private void recordVisitorActivity(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 방문자 ID 가져오기 (쿠키에서 가져오거나 새로 생성)
            String visitorId = getVisitorIdFromCookie(request, response);

            // IP 주소 가져오기
            String ipAddress = getClientIpAddress(request);

            // User-Agent 정보 가져오기
            String userAgent = request.getHeader("User-Agent");

            // Referrer 정보 가져오기
            String referrer = request.getHeader("Referer");

            // 현재 페이지 URL 가져오기
            String pageUrl = request.getRequestURL().toString();

            // VisitorActivity 객체 생성
            VisitorActivity visitorActivity = new VisitorActivity(
                    visitorId,
                    ipAddress,
                    userAgent,
                    referrer,
                    pageUrl
            );

            // 서비스를 통해 방문자 활동 정보 저장
            visitorActivityService.register(visitorActivity);
        } catch (Exception e) {
            // 로깅 처리
            log.error("to Save Visitor Info Error : " + e.getMessage());
        }
    }

    private String getVisitorIdFromCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String visitorId = null;

        // 기존 쿠키에서 방문자 ID 찾기
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visitorId".equals(cookie.getName())) {
                    visitorId = cookie.getValue();
                    break;
                }
            }
        }

        // 방문자 ID가 없으면 새로 생성
        if (visitorId == null || visitorId.isEmpty()) {
            visitorId = UUID.randomUUID().toString();
            Cookie visitorCookie = new Cookie("visitorId", visitorId);
            visitorCookie.setMaxAge(60 * 60 * 24 * 365); // 1년 유효
            visitorCookie.setPath("/");
            response.addCookie(visitorCookie);
        }

        return visitorId;
    }

    private String getClientIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
