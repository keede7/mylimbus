package io.keede.mylimbus.web.api;

import io.keede.mylimbus.domains.personality.service.PersonalityQueryService;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesByKeywordDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityByBaseName;
import io.keede.mylimbus.web.dto.request.RequestPersonalityBySkillSinDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityFilterDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
* @author keede
* Created on 2025/04/13
*/
@RestController
@RequestMapping("/api")
public class ApiController {

    private final PersonalityQueryService personalityQueryService;

    public ApiController(
            PersonalityQueryService personalityQueryService
    ) {
        this.personalityQueryService = personalityQueryService;
    }

    @GetMapping("/personality")
    public List<GetPersonalityResponseDto> getPersonalities() {
        System.out.println("getPersonalities...");
        return this.personalityQueryService.getPersonalities();
    }

    @GetMapping("/personality/keyword")
    public List<GetPersonalityResponseDto> getPersonalitiesByKeyword(RequestPersonalitiesByKeywordDto dto) {
        System.out.println("getPersonalitiesByKeyword...");
        return this.personalityQueryService.getPersonalitiesByKeyword(dto);
    }

    @GetMapping("/personality/skill/sin")
    public List<GetPersonalityResponseDto> getPersonalityBySkillSin(RequestPersonalityBySkillSinDto dto) {
        System.out.println("getPersonalityBySkillSin...");
        return this.personalityQueryService.getPersonalityBySkillSin(dto);
    }

    @GetMapping("/personality/base")
    public List<GetPersonalityResponseDto> getPersonalityByBaseName(RequestPersonalityByBaseName dto) {
        System.out.println("getPersonalityByBaseName...");
        return this.personalityQueryService.getPersonalityByBaseName(dto);
    }

    @GetMapping("/personality/{id}")
    public GetPersonalityResponseDto getPersonality(@PathVariable("id") Long id) {
        System.out.println("getPersonalityById");
        return this.personalityQueryService.getPersonalityById(id);
    }

    @GetMapping("/personality/filter")
    public Set<GetPersonalityResponseDto> getPersonalityFilter(RequestPersonalityFilterDto dto) {
        System.out.println("getPersonalityFilter");
        System.out.println("dto = " + dto);
        return this.personalityQueryService.getPersonalityFilter(dto);
    }
}
