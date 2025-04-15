package io.keede.mylimbus.domains.personality.service;

import io.keede.mylimbus.domains.personality.entity.Personality;
import io.keede.mylimbus.domains.personality.entity.PersonalityRepository;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesByKeywordDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author keede
 * Created on 2025/04/10
 */
@Service
public class PersonalityQueryService {

    private final PersonalityRepository personalityRepository;

    public PersonalityQueryService(
            PersonalityRepository personalityRepository
    ) {
        this.personalityRepository = personalityRepository;
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalities() {
        return this.personalityRepository.findPersonalities()
                .stream()
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalitiesByKeyword(RequestPersonalitiesByKeywordDto dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(s -> s.isMatchKeyword(dto.keyword()))
                .map(Personality::toDto)
                .toList();
    }
}
