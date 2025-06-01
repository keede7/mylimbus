package io.keede.mylimbus.domains.statistic.service;

import io.keede.mylimbus.domains.statistic.entity.VisitorActivity;
import io.keede.mylimbus.domains.statistic.entity.VisitorActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitorActivityService {

    private final VisitorActivityRepository visitorActivityRepository;

    public VisitorActivityService(
            final VisitorActivityRepository visitorActivityRepository
    ) {
        this.visitorActivityRepository = visitorActivityRepository;
    }

    public void register(VisitorActivity entity) {
        visitorActivityRepository.save(entity);
    }
}
