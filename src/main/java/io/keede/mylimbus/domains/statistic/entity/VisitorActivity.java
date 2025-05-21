package io.keede.mylimbus.domains.statistic.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author keede
 * Created on 2025/05/21
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "visitor_activities")
public class VisitorActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visitor_id", nullable = false)
    private String visitorId;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent", length = 512)
    private String userAgent;

    @Column(name = "referrer", length = 512)
    private String referrer;

    @Column(name = "page_url", length = 512)
    private String pageUrl;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

}
