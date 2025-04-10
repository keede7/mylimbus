package io.keede.mylimbus.domains.personality.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @author keede
 * Created on 2025/04/10
 */
@AllArgsConstructor
public enum PersonalityKeyword {
    림버스_컴퍼니("림버스 컴퍼니"),
    조직("조직"),
    LCE("LCE"),
    LCB("LCB"),
    LCD("LCD"),
    LCCB("LCCB"),
    로보토미_본사("로보토미 본사"),
    로보토미_지부("로보토미 지부"),
    기술해방연합("기술해방연합"),
    피쿼드호("피쿼드호"),
    해결사("해결사"),
    리우_협회("리우 협회"),
    세븐_협회("세븐 협회"),
    섕크_협회("섕크 협회"),
    디에치_협회("디에치 협회"),
    츠바이_협회("츠바이 협회"),
    제바찌_협회("제바찌 협회"),
    외우피_협회("외우피 협회"),
    시_협회("시 협회"),
    약지("약지"),
    중지("중지"),
    검계("검계"),
    뒷골목("뒷골목"),
    데드레빗츠("데드레빗츠"),
    마리아치("마리아치"),
    콩콩이파("콩콩이파"),
    새벽_사무소("새벽 사무소"),
    어금니_사무소("어금니 사무소"),
    마침표_사무소("마침표 사무소"),
    송곳니_사냥_사무소("송곳니 사냥 사무소"),
    멀티크랙_사무소("멀티크랙 사무소"),
    갈고리_사무소("갈고리 사무소"),
    유로지비("유로지비"),
    흑운회("흑운회"),
    쌍갈고리_해적단("쌍갈고리 해적단"),
    에드가_가문("에드가 가문"),
    제2권속("제2권속"),
    제3권속("제3권속"),
    혈귀("혈귀"),
    라만차랜드("라만차랜드"),
    흑수("흑수"),
    흑수_묘("흑수•묘"),
    료고파("료.고.파"),
    장미스패너_공방("장미스패너 공방"),
    G사("G사"),
    N사("N사"),
    N사_광신도("N사 광신도"),
    K사("K사"),
    T사("T사"),
    W사("W사"),
    R사("R사"),
    워더링하이츠("워더링하이츠"),
    와일드헌트("와일드헌트"),
    ;

    private final String name;

    public static PersonalityKeyword match(String word) {
        return Arrays.stream(values())
                .filter(keyword -> keyword.name.equals(word))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return this.name;
    }
}
