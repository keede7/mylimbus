package io.keede.mylimbus.web.api;

import io.keede.mylimbus.domains.personality.service.PersonalityQueryService;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesByKeywordDto;
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
        System.out.println("dto = " + dto);
        this.personalityQueryService.getPersonalitiesByKeyword(dto);
        return null;
    }
}
