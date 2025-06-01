package io.keede.mylimbus.web;

import java.util.Arrays;

public class MobileValidator {
    private static final String[] MOBILE_USER_AGENTS = {
            "Mobile", "Android", "iPhone", "iPad", "iPod", "BlackBerry",
            "IEMobile", "Opera Mini", "webOS", "Windows Phone"
    };

    private static final String[] TABLET_USER_AGENTS = {
            "iPad", "Android.*Tablet", "Kindle", "Silk", "PlayBook"
    };

    public static boolean isMobile(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) {
            return false;
        }

        return Arrays.stream(MOBILE_USER_AGENTS)
                .anyMatch(agent -> userAgent.toLowerCase().contains(agent.toLowerCase()));
    }

    public static boolean isTablet(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) {
            return false;
        }

        return Arrays.stream(TABLET_USER_AGENTS)
                .anyMatch(agent -> userAgent.toLowerCase().matches(".*" + agent.toLowerCase() + ".*"));
    }

    public static String getDeviceType(String userAgent) {
        if (isTablet(userAgent)) {
            return "tablet";
        } else if (isMobile(userAgent)) {
            return "mobile";
        } else {
            return "desktop";
        }
    }

}
