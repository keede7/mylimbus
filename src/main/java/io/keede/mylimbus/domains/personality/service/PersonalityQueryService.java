package io.keede.mylimbus.domains.personality.service;

import io.keede.mylimbus.domains.personality.entity.*;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesGroupByKeywordDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityByBaseName;
import io.keede.mylimbus.web.dto.request.RequestPersonalityBySkillSinDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityFilterDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<GetPersonalityResponseDto> getPersonalitiesGroupByKeyword(RequestPersonalitiesGroupByKeywordDto dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(personality -> personality.isMatchGroupKeyword(dto.keyword()))
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalityBySkillSin(RequestPersonalityBySkillSinDto dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(personality -> personality.isMatchSkillSin(dto.sin()))
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalityByBaseName(RequestPersonalityByBaseName dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(personality -> personality.isMatchName(dto.baseName()))
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public GetPersonalityResponseDto getPersonalityById(Long id) {
        return this.personalityRepository.findPersonalityById(id)
                .map(Personality::toDto)
                .orElseThrow(() -> new RuntimeException("없는 캐릭터입니다."));
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalityFilter(RequestPersonalityFilterDto dto) {
        String personalityKRName = dto.personalityKRName();
        List<Affinity> affinities = dto.toAffinitiesEffects();
        List<AttackType> skillTypes = dto.toSkillTypes();
        List<Sin> skillSinAttributes = dto.toSkillSin();

        List<Personality> personalities = this.personalityRepository.findPersonalityByKRName(personalityKRName)
                .stream()
                .filter(personality -> personality.isMatchAffinity(affinities))
                .filter(personality -> personality.isMatchSkillType(skillTypes))
                .filter(personality -> personality.isMatchSkillSin(skillSinAttributes))
                .toList();

        Set<Personality> response = new HashSet<>(personalities);

        return response
                .stream()
                .sorted(Comparator.comparing(Personality::getRarity).reversed()
                        .thenComparing(Personality::getPersonalityName))
                .map(Personality::toDto)
                .toList();
    }

}
