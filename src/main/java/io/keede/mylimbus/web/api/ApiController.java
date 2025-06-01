package io.keede.mylimbus.web.api;

import io.keede.mylimbus.domains.ego.service.EgoQueryService;
import io.keede.mylimbus.domains.personality.service.PersonalityQueryService;
import io.keede.mylimbus.web.dto.request.RequestPersonalitiesGroupByKeywordDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityByBaseName;
import io.keede.mylimbus.web.dto.request.RequestPersonalityBySkillSinDto;
import io.keede.mylimbus.web.dto.request.RequestPersonalityFilterDto;
import io.keede.mylimbus.web.dto.response.GetEGOResponseDto;
import io.keede.mylimbus.web.dto.response.GetPersonalityResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* @author keede
* Created on 2025/04/13
*/
@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    private final PersonalityQueryService personalityQueryService;
    private final EgoQueryService egoQueryService;

    public ApiController(
            final PersonalityQueryService personalityQueryService,
            final EgoQueryService egoQueryService
    ) {
        this.personalityQueryService = personalityQueryService;
        this.egoQueryService = egoQueryService;
    }

    @GetMapping("/personality")
    public List<GetPersonalityResponseDto> getPersonalities() {
        log.debug("getPersonalities...");
        return this.personalityQueryService.getPersonalities();
    }

    @GetMapping("/personality/group/keyword")
    public List<GetPersonalityResponseDto> getPersonalitiesGroupByKeyword(RequestPersonalitiesGroupByKeywordDto dto) {
        log.debug("getPersonalitiesGroupByKeyword...");
        log.debug("dto : {}", dto);
        return this.personalityQueryService.getPersonalitiesGroupByKeyword(dto);
    }

    @GetMapping("/personality/skill/sin")
    public List<GetPersonalityResponseDto> getPersonalityBySkillSin(RequestPersonalityBySkillSinDto dto) {
        log.debug("getPersonalityBySkillSin...");
        log.debug("dto : {}", dto);
        return this.personalityQueryService.getPersonalityBySkillSin(dto);
    }

    @GetMapping("/personality/base")
    public List<GetPersonalityResponseDto> getPersonalityByBaseName(RequestPersonalityByBaseName dto) {
        log.debug("getPersonalityByBaseName...");
        log.debug("dto : {}", this.bind(dto.baseName()));
        return this.personalityQueryService.getPersonalityByBaseName(dto);
    }

    @GetMapping("/personality/{id}")
    public GetPersonalityResponseDto getPersonality(@PathVariable("id") Long id) {
        log.debug("getPersonalityById");
        log.debug("id = {}", id);
        return this.personalityQueryService.getPersonalityById(id);
    }

    @GetMapping("/personality/filter")
    public List<GetPersonalityResponseDto> getPersonalityFilter(RequestPersonalityFilterDto dto) {
        log.debug("getPersonalityFilter");
        log.debug("name = {}", this.bind(dto.personalityKRName()));
        log.debug("dto = {}", dto);
        return this.personalityQueryService.getPersonalityFilter(dto);
    }

    @GetMapping("/ego/{characterKRName}")
    public List<GetEGOResponseDto> getEGOsByCharacterKRName(@PathVariable("characterKRName") String characterKRName) {
        log.debug("getEGOsByCharacterKRName");
        log.debug("characterKRName = {}", this.bind(characterKRName));
        return this.egoQueryService.getEGOsByCharacterKRName(characterKRName);
    }

    private String bind(String krName) {

        return switch (krName) {
            case "이상" -> "yisang";
            case "파우스트" -> "faust";
            case "돈키호테" -> "donquixote";
            case "료슈" -> "ryoshu";
            case "뫼르소" -> "meursault";
            case "홍루" -> "honglu";
            case "히스클리프" -> "heathcliff";
            case "이스마엘" -> "ishmael";
            case "로쟈" -> "rodion";
            case "싱클레어" -> "sinclair";
            case "오티스" -> "outis";
            case "그레고르" -> "gregor";
            default -> "unknown";
        };

    }

}
