package io.keede.mylimbus.domains.ego.service;

import io.keede.mylimbus.domains.ego.entity.EGO;
import io.keede.mylimbus.domains.ego.entity.EGORepository;
import io.keede.mylimbus.web.dto.response.GetEGOResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author keede
 * Created on 2025/05/02
 */
@Service
public class EgoQueryService {

    private final EGORepository egoRepository;

    public EgoQueryService(
            final EGORepository egoRepository
    ) {
        this.egoRepository = egoRepository;
    }

    public List<GetEGOResponseDto> getEGOsByCharacterKRName(String characterKRName) {
        List<String> riskOrder = Arrays.asList("ZAYIN", "TETH", "HE", "WAW", "ALEPH");
        return this.egoRepository.findEGOsByCharacterKRName(characterKRName)
                .stream()
                .map(EGO::toDto)
                .sorted(Comparator.comparing(ego -> riskOrder.indexOf(ego.egoName())))
                .toList();
    }
}
