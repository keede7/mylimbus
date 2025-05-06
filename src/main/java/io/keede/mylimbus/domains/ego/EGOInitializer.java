package io.keede.mylimbus.domains.ego;


import io.keede.mylimbus.domains.ego.entity.EGO;
import io.keede.mylimbus.domains.ego.entity.EGORepository;
import io.keede.mylimbus.domains.ego.entity.EGOUseCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static io.keede.mylimbus.domains.Characters.*;
import static io.keede.mylimbus.domains.ego.entity.RiskLevel.*;
import static io.keede.mylimbus.domains.personality.entity.AttackType.*;
import static io.keede.mylimbus.domains.personality.entity.Sin.*;

/**
 * @author keede
 * Created on 2025/04/30
 */
@Service
public class EGOInitializer {

    private final EGORepository egoRepository;

    public EGOInitializer(
            final EGORepository egoRepository
    ) {
        this.egoRepository = egoRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {

        if(!this.egoRepository.findAll().isEmpty()) {
            return;
        }

        List<EGO> egos = List.of(
                new EGO(
                        YISANG,
                        "여우비",
                        "/ego/yisang/280px-Sunshower_Yi_Sang.webp",
                        WAW,
                        SLOTH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "오감도",
                        "/ego/yisang/280px-Crow's_Eye_View_Yi_Sang.webp",
                        ZAYIN,
                        SLOTH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        3
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "소망석",
                        "/ego/yisang/280px-Wishing_Cairn_Yi_Sang.webp",
                        TETH,
                        SLOTH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "차원찢개",
                        "/ego/yisang/280px-Dimension_Shredder_Yi_Sang.webp",
                        HE,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "지난 날",
                        "/ego/yisang/280px-Bygone_Days_Yi_Sang.webp",
                        ZAYIN,
                        GLOOM,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "흉탄",
                        "/ego/yisang/280px-Fell_Bullet_Yi_Sang.webp",
                        HE,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        6
                                )
                        )
                ),
                new EGO(
                        YISANG,
                        "4번째 성냥불",
                        "/ego/yisang/280px-4th_Match_Flame_Yi_Sang.webp",
                        TETH,
                        WRATH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        5
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        1
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "물주머니",
                        "/ego/faust/280px-Fluid_Sac_Faust.webp",
                        HE,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        4
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "표상 방출기",
                        "/ego/faust/280px-Representation_Emitter_Faust.webp",
                        ZAYIN,
                        PRIDE,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        4
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "저주못",
                        "/ego/faust/280px-Hex_Nail_Faust.webp",
                        TETH,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        ENVY,
                                        6
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "9장 2절",
                        "/ego/faust/280px-9-2_Faust.webp",
                        WAW,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "영속",
                        "/ego/faust/280px-Everlasting_Faust.webp",
                        WAW,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "올가미",
                        "/ego/faust/280px-Lasso_Faust.webp",
                        TETH,
                        GLUTTONY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "전봇대",
                        "/ego/faust/280px-Telepole_Faust.webp",
                        HE,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        FAUST,
                        "흉통",
                        "/ego/faust/280px-Thoracalgia_Faust.webp",
                        WAW,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        5
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "전봇대",
                        "/ego/donquixote/280px-Telepole_Don_Quixote.webp",
                        HE,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "갈망-미르킬라",
                        "/ego/donquixote/280px-Yearning-Mircalla_Don_Quixote.webp",
                        WAW,
                        LUST,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        5
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "라 샹그레 데 산초",
                        "/ego/donquixote/280px-La_Sangre_de_Sancho_Don_Quixote.webp",
                        ZAYIN,
                        LUST,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "소망석",
                        "/ego/donquixote/280px-Wishing_Cairn_Don_Quixote.webp",
                        TETH,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "전기울음",
                        "/ego/donquixote/280px-Electric_Screaming_Don_Quixote.webp",
                        TETH,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        4
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "평생 스튜",
                        "/ego/donquixote/280px-Lifetime_Stew_Don_Quixote.webp",
                        TETH,
                        LUST,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        5
                                )
                        )
                ),
                new EGO(
                        DONQUIXOTE,
                        "물주머니",
                        "/ego/donquixote/280px-Fluid_Sac_Don_Quixote.webp",
                        HE,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "삼라염상",
                        "/ego/ryoshu/280px-Forest_for_the_Flames_Ryoshu.webp",
                        ZAYIN,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "소다",
                        "/ego/ryoshu/280px-Soda_Ryōshū.webp",
                        ZAYIN,
                        GLOOM,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "적안",
                        "/ego/ryoshu/280px-Red_Eyes_Ryōshū.webp",
                        TETH,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        1
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "맹목",
                        "/ego/ryoshu/280px-Blind_Obsession_Ryōshū.webp",
                        TETH,
                        PRIDE,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "4번째 성냥불",
                        "/ego/ryoshu/280px-4th_Match_Flame_Ryōshū.webp",
                        HE,
                        WRATH,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "적안(開)",
                        "/ego/ryoshu/280px-Red_Eyes_(Open)_Ryōshū.webp",
                        HE,
                        ENVY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "흉통",
                        "/ego/ryoshu/280px-Thoracalgia_Ryōshū.webp",
                        HE,
                        PRIDE,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        5
                                )
                        )
                ),
                new EGO(
                        RYOSHU,
                        "경멸, 경외",
                        "/ego/ryoshu/280px-Contempt,_Awe_Ryōshū.webp",
                        WAW,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        4
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "타인의 사슬",
                        "/ego/meursault/280px-Chains_of_Others_Meursault.webp",
                        ZAYIN,
                        PRIDE,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "나사빠진 일격",
                        "/ego/meursault/280px-Screwloose_Wallop_Meursault.webp",
                        TETH,
                        ENVY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "후회",
                        "/ego/meursault/280px-Regret_Meursault.webp",
                        TETH,
                        WRATH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "집행",
                        "/ego/meursault/280px-Pursuance_Meursault.webp",
                        HE,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "카포테",
                        "/ego/meursault/280px-Capote_Meursault.webp",
                        HE,
                        WRATH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "갈망-미르킬라",
                        "/ego/meursault/280px-Yearning-Mircalla_Meursault.webp",
                        WAW,
                        LUST,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        4
                                )
                        )
                ),
                new EGO(
                        MEURSAULT,
                        "전기울음",
                        "/ego/meursault/280px-Electric_Screaming_Meursault.webp",
                        TETH,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        4
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "허환경",
                        "/ego/honglu/280px-Land_of_Illusion_Hong_Lu.webp",
                        ZAYIN,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        5
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "분홍욕망",
                        "/ego/honglu/280px-Roseate_Desire_Hong_Lu.webp",
                        TETH,
                        LUST,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        4
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "소다",
                        "/ego/honglu/280px-Soda_Hong_Lu.webp",
                        TETH,
                        ENVY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "낮은울음",
                        "/ego/honglu/280px-Cavernous_Wailing_Hong_Lu.webp",
                        TETH,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "올가미",
                        "/ego/honglu/280px-Lasso_Hong_Lu.webp",
                        TETH,
                        GLUTTONY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "차원찢개",
                        "/ego/honglu/280px-Dimension_Shredder_Hong_Lu.webp",
                        HE,
                        PRIDE,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                )
                        )
                ),
                new EGO(
                        HONGLU,
                        "들끓는 부식",
                        "/ego/honglu/280px-Effervescent_Corrosion_Hong_Lu.webp",
                        HE,
                        GLUTTONY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        6
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "시체자루",
                        "/ego/heathcliff/280px-Bodysack_Heathcliff.webp",
                        ZAYIN,
                        ENVY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "홀리데이",
                        "/ego/heathcliff/280px-Holiday_Heathcliff.webp",
                        ZAYIN,
                        GLUTTONY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "AEDD",
                        "/ego/heathcliff/280px-AEDD_Heathcliff.webp",
                        TETH,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "흉탄",
                        "/ego/heathcliff/280px-Fell_Bullet_Heathcliff.webp",
                        TETH,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "전봇대",
                        "/ego/heathcliff/280px-Telepole_Heathcliff.webp",
                        HE,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "공즉시색",
                        "/ego/heathcliff/280px-Ya_Śūnyatā_Tad_Rūpam_Heathcliff.webp",
                        HE,
                        LUST,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "쏠린 관성",
                        "/ego/heathcliff/280px-Asymmetrical_Inertia_Heathcliff.webp",
                        HE,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        HEATHCLIFF,
                        "구속",
                        "/ego/heathcliff/280px-Binds_Heathcliff.webp",
                        WAW,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "작살잡이",
                        "/ego/ishmael/280px-Snagharpoon_Ishmael.webp",
                        ZAYIN,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "분홍욕망",
                        "/ego/ishmael/280px-Roseate_Desire_Ishmael.webp",
                        TETH,
                        LUST,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        4
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "카포테",
                        "/ego/ishmael/280px-Capote_Ishmael.webp",
                        TETH,
                        WRATH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "지난 날",
                        "/ego/ishmael/280px-Bygone_Days_Ishmael.webp",
                        TETH,
                        GLOOM,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "홍염살",
                        "/ego/ishmael/280px-Ardor_Blossom_Star_Ishmael.webp",
                        HE,
                        WRATH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        4
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        1
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "날갯짓",
                        "/ego/ishmael/280px-Wingbeat_Ishmael.webp",
                        HE,
                        GLUTTONY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "크리스마스 악몽",
                        "/ego/ishmael/280px-Christmas_Nightmare_Ishmael.webp",
                        HE,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        ISHMAEL,
                        "맹목",
                        "/ego/ishmael/280px-Blind_Obsession_Ishmael.webp",
                        WAW,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "던져지는 것",
                        "/ego/rodion/280px-What_is_Cast_Rodion.webp",
                        ZAYIN,
                        PRIDE,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "얼음다리",
                        "/ego/rodion/280px-Rime_Shank_Rodion.webp",
                        TETH,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLOOM,
                                        5
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "들끓는 부식",
                        "/ego/rodion/280px-Effervescent_Corrosion_Rodion.webp",
                        TETH,
                        GLUTTONY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "4번째 성냥불",
                        "/ego/rodion/280px-4th_Match_Flame_Rodion.webp",
                        HE,
                        WRATH,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        1
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "집행",
                        "/ego/rodion/280px-Pursuance_Rodion.webp",
                        HE,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "저주못",
                        "/ego/rodion/280px-Hex_Nail_Rodion.webp",
                        HE,
                        ENVY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        4
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "핏빛욕망",
                        "/ego/rodion/280px-Sanguine_Desire_Rodion.webp",
                        WAW,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        RODION,
                        "지정 재판",
                        "/ego/rodion/280px-Indicant's_Trial_Rodion.webp",
                        WAW,
                        WRATH,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        7
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "지식나무의 가지",
                        "/ego/sinclair/280px-Branch_of_Knowledge_Sinclair.webp",
                        ZAYIN,
                        GLUTTONY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "낮은울음",
                        "/ego/sinclair/280px-Cavernous_Wailing_Sinclair.webp",
                        ZAYIN,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "다가올날",
                        "/ego/sinclair/280px-Impending_Day_Sinclair.webp",
                        TETH,
                        WRATH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "평생 스튜",
                        "/ego/sinclair/280px-Lifetime_Stew_Sinclair.webp",
                        TETH,
                        LUST,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        3
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        1
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "저주못",
                        "/ego/sinclair/280px-Hex_Nail_Sinclair.webp",
                        TETH,
                        ENVY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "초롱",
                        "/ego/sinclair/280px-Lantern_Sinclair.webp",
                        HE,
                        GLUTTONY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        SINCLAIR,
                        "9장 2절",
                        "/ego/sinclair/280px-9-2_Sinclair.webp",
                        HE,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        5
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        1
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "토 파토스 마토스",
                        "/ego/outis/280px-To_Páthos_Máthos_Outis.webp",
                        ZAYIN,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "공즉시색",
                        "/ego/outis/280px-Ya_Śūnyatā_Tad_Rūpam_Outis.webp",
                        TETH,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "여우비",
                        "/ego/outis/280px-Sunshower_Outis.webp",
                        TETH,
                        GLUTTONY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "검은줄기",
                        "/ego/outis/280px-Ebony_Stem_Outis.webp",
                        HE,
                        GLUTTONY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        4
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "홀리데이",
                        "/ego/outis/280px-Holiday_Outis.webp",
                        HE,
                        WRATH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "차원찢개",
                        "/ego/outis/280px-Dimension_Shredder_Outis.webp",
                        HE,
                        ENVY,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        1
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        4
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "마탄",
                        "/ego/outis/280px-Magic_Bullet_Outis.webp",
                        HE,
                        PRIDE,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        4
                                )
                        )
                ),
                new EGO(
                        OUTIS,
                        "구속",
                        "/ego/outis/280px-Binds_Outis.webp",
                        WAW,
                        PRIDE,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        1
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        4
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        4
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "어느날 갑자기",
                        "/ego/gregor/280px-Suddenly,_One_Day_Gregor.webp",
                        ZAYIN,
                        SLOTH,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        3
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        1
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "눈속임",
                        "/ego/gregor/280px-Legerdemain_Gregor.webp",
                        ZAYIN,
                        GLUTTONY,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        3
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "초롱",
                        "/ego/gregor/280px-Lantern_Gregor.webp",
                        TETH,
                        GLUTTONY,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        1
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        4
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "지난 날",
                        "/ego/gregor/280px-Bygone_Days_Gregor.webp",
                        TETH,
                        GLOOM,
                        PIERCE,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        4
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "AEDD",
                        "/ego/gregor/280px-AEDD_Gregor.webp",
                        HE,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        GLOOM,
                                        3
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        3
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "엄숙한 애도",
                        "/ego/gregor/280px-Solemn_Lament_Gregor.webp",
                        HE,
                        GLOOM,
                        BLUNT,
                        List.of(
                                new EGOUseCondition(
                                        LUST,
                                        1
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "크리스마스 악몽",
                        "/ego/gregor/280px-Christmas_Nightmare_Gregor.webp",
                        HE,
                        SLOTH,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                )
                        )
                ),
                new EGO(
                        GREGOR,
                        "가시화원",
                        "/ego/gregor/280px-Garden_of_Thorns_Gregor.webp",
                        WAW,
                        LUST,
                        SLASH,
                        List.of(
                                new EGOUseCondition(
                                        WRATH,
                                        2
                                ),
                                new EGOUseCondition(
                                        LUST,
                                        2
                                ),
                                new EGOUseCondition(
                                        SLOTH,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLUTTONY,
                                        2
                                ),
                                new EGOUseCondition(
                                        GLOOM,
                                        2
                                ),
                                new EGOUseCondition(
                                        PRIDE,
                                        2
                                ),
                                new EGOUseCondition(
                                        ENVY,
                                        2
                                )
                        )
                )
        );


        this.egoRepository.saveAll(egos);
    }

}
