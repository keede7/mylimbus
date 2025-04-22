package io.keede.mylimbus.domains.personality.service;

import io.keede.mylimbus.domains.personality.entity.Affinity;
import io.keede.mylimbus.domains.personality.entity.AttackType;
import io.keede.mylimbus.domains.personality.entity.Personality;
import io.keede.mylimbus.domains.personality.entity.PersonalityRepository;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesByKeywordDto;
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
    public List<GetPersonalityResponseDto> getPersonalitiesByKeyword(RequestPersonalitiesByKeywordDto dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(s -> s.isMatchKeyword(dto.keyword()))
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalityBySkillSin(RequestPersonalityBySkillSinDto dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(s -> s.isMatchSkillSin(dto.sin()))
                .map(Personality::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GetPersonalityResponseDto> getPersonalityByBaseName(RequestPersonalityByBaseName dto) {
        return this.personalityRepository.findPersonalities()
                .stream()
                .filter(s -> s.isMatchName(dto.baseName()))
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
        List<Affinity> affinities = dto.toAttackAffinities();
        List<AttackType> skillTypes = dto.toSkillTypes();

        Set<Personality> response = new HashSet<>();
        List<Personality> personalities = this.personalityRepository.findPersonalityByKRName(personalityKRName);

        System.out.println("personalities = " + personalities);

        List<Personality> personalitiesByAffinities = personalities.stream()
                .filter(personality -> personality.isMatchAffinity(affinities))
                .toList();

        System.out.println("personalitiesByAffinities = " + personalitiesByAffinities);

        List<Personality> personalitiesBySkillTypes = personalities.stream()
                .filter(personality -> personality.isMatchSkillType(skillTypes))
                .toList();

        System.out.println("personalitiesBySkillTypes = " + personalitiesBySkillTypes);

        response.addAll(personalitiesByAffinities);
        response.addAll(personalitiesBySkillTypes);

        return response
                .stream()
                .sorted(Comparator.comparing(Personality::getRarity).reversed()
                        .thenComparing(Personality::getPersonalityName))
                .map(Personality::toDto)
                .toList();
    }

}
