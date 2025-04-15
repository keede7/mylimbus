package io.keede.mylimbus.web.api;

import io.keede.mylimbus.domains.personality.service.PersonalityQueryService;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesByKeywordDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityBySkillSinDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return this.personalityQueryService.getPersonalities();
    }

    @GetMapping("/personality/keyword")
    public List<GetPersonalityResponseDto> getPersonalitiesByKeyword(RequestPersonalitiesByKeywordDto dto) {
        return this.personalityQueryService.getPersonalitiesByKeyword(dto);
    }

    @GetMapping("/personality/skill/sin")
    public List<GetPersonalityResponseDto> getPersonalityBySkillSin(RequestPersonalityBySkillSinDto dto) {
        return this.personalityQueryService.getPersonalityBySkillSin(dto);
    }
}
