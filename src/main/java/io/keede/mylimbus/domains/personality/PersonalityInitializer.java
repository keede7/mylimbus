package io.keede.mylimbus.domains.personality;

import io.keede.mylimbus.domains.personality.entity.Personality;
import io.keede.mylimbus.domains.personality.entity.PersonalityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.keede.mylimbus.domains.personality.entity.PersonalityKeyword.*;

@Service
public class PersonalityInitializer {

    private final PersonalityRepository personalityRepository;

    public PersonalityInitializer(
            final PersonalityRepository personalityRepository
    ) {
        this.personalityRepository = personalityRepository;
    }

    @PostConstruct
    void init() {
        List<Personality> personalities = List.of(
                new Personality( "LCB 수감자 이상", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "검계 살수 이상", List.of(조직, 검계)),
                new Personality( "W사 3등급 정리 요원 이상", List.of(W사)),
                new Personality( "LCE E.G.O::초롱 이상", List.of(LCE, 림버스_컴퍼니)),
                new Personality( "남부 세븐 협회 6과 이상", List.of(해결사, 세븐_협회)),
                new Personality( "어금니 사무소 해결사 이상", List.of(해결사, 어금니_사무소)),
                new Personality( "피쿼드호 일등 항해사 이상", List.of(피쿼드호)),
                new Personality( "남부 디에치 협회 4과 이상", List.of(해결사, 디에치_협회)),
                new Personality( "개화 E.G.O::동백 이상", List.of(기술해방연합)),
                new Personality( "약지 점묘파 스튜던트 이상", List.of(조직, 약지)),
                new Personality( "로보토미 E.G.O::엄숙한 애도 이상", List.of(로보토미_본사)),
                new Personality( "LCB 수감자 파우스트", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "쥐는 자 파우스트", List.of(N사, N사_광신도)),
                new Personality( "남부 세븐 협회 4과 파우스트", List.of(해결사, 세븐_협회)),
                new Personality( "로보토미 E.G.O::후회 파우스트", List.of(로보토미_본사)),
                new Personality( "검계 살수 파우스트", List.of(조직, 검계)),
                new Personality( "워더링하이츠 버틀러 파우스트", List.of(해결사, 워더링하이츠)),
                new Personality( "멀티크랙 사무소 대표 파우스트", List.of(해결사, 멀티크랙_사무소)),
                new Personality( "LCE E.G.O::홍염살 파우스트", List.of(LCE, 림버스_컴퍼니)),
                new Personality( "살아남은 로보토미 직원 파우스트", List.of(로보토미_지부)),
                new Personality( "남부 츠바이 협회 4과 파우스트", List.of(해결사, 츠바이_협회)),
                new Personality( "W사 2등급 정리 요원 파우스트", List.of(W사)),
                new Personality( "LCB 수감자 돈키호테", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "W사 3등급 정리 요원 돈키호테", List.of(W사)),
                new Personality( "중지 작은 아우 돈키호테", List.of(조직, 중지)),
                new Personality( "검계 살수 돈키호테", List.of(조직, 검계)),
                new Personality( "T사 3등급 징수직 직원 돈키호테", List.of(T사)),
                new Personality( "라만차랜드 실장 돈키호테", List.of(제2권속, 혈귀, 라만차랜드)),
                new Personality( "동부 섕크 협회 3과 돈키호테", List.of(해결사, 섕크_협회)),
                new Personality( "N사 중간 망치 돈키호테", List.of(N사, N사_광신도)),
                new Personality( "로보토미 E.G.O::초롱", List.of(로보토미_본사)),
                new Personality( "남부 시 협회 5과 부장 돈키호테", List.of(해결사, 시_협회)),
                new Personality( "LCB 수감자 료슈", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "W사 3등급 정리 요원 료슈", List.of(W사)),
                new Personality( "남부 리우 협회 4화 료슈", List.of(해결사, 리우_협회)),
                new Personality( "에드가 가문 치프 버틀러 료슈", List.of(해결사, 에드가_가문)),
                new Personality( "로보토미 E.G.O::적안•참회 료슈", List.of(로보토미_본사)),
                new Personality( "흑수•묘 료슈", List.of(흑수, 흑수_묘)),
                new Personality( "남부 세븐 협회 6과 료슈", List.of(해결사, 세븐_협회)),
                new Personality( "LCCB 대리 료슈", List.of(LCCB, 림버스_컴퍼니)),
                new Personality( "흑운회 와카슈 료슈", List.of(조직, 흑운회)),
                new Personality( "료.고.파 주방장 료슈", List.of(뒷골목, 조직, 료고파)),
                new Personality( "20구 유로지비 료슈", List.of(조직, 유로지비)),
                new Personality( "LCB 수감자 뫼르소", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "남부 리우 협회 6과 뫼르소", List.of(해결사, 리우_협회)),
                new Personality( "중지 작은 아우 뫼르소", List.of(조직, 중지)),
                new Personality( "검계 우두머리 뫼르소", List.of(조직, 검계)),
                new Personality( "남부 디에치 협회 4과 부장 뫼르소", List.of(해결사, 디에치_협회)),
                new Personality( "서부 섕크 협회 3과 뫼르소", List.of(해결사, 섕크_협회)),
                new Personality( "R사 제4무리 코뿔소팀 뫼르소", List.of(R사)),
                new Personality( "N사 큰 망치 뫼르소", List.of(N사, N사_광신도)),
                new Personality( "W사 2등급 정리 요원 뫼르소", List.of(W사)),
                new Personality( "장미스패터 공방 해결사 뫼르소", List.of(해결사, 장미스패너_공방)),
                new Personality( "데드레빗츠 보스 뫼르소", List.of(조직, 데드레빗츠)),
                new Personality( "LCB 수감자 홍루", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "K사 3등급 적출직 직원 홍루", List.of(K사)),
                new Personality( "갈고리 사무소 해결사 홍루", List.of(해결사, 갈고리_사무소)),
                new Personality( "남부 디에치 협회 4과 홍루", List.of(해결사, 디에치_협회)),
                new Personality( "20구 유로지비 홍루", List.of(조직, 유로지비)),
                new Personality( "마침표 사무소 대표 홍루", List.of(해결사, 마침표_사무소)),
                new Personality( "W사 2등급 정리 요원 홍루", List.of(W사)),
                new Personality( "남부 리우 협회 5과 홍루", List.of(해결사, 리우_협회)),
                new Personality( "흑운회 와카슈 홍루", List.of(조직, 흑운회)),
                new Personality( "콩콩이파 두목 홍루", List.of(뒷골목, 조직, 콩콩이파)),
                new Personality( "LCB 수감자 히스클리프", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "R사 제4무리 토끼팀 히스클리프", List.of(R사)),
                new Personality( "남부 세븐 협회 4과 히스클리프", List.of(해결사, 세븐_협회)),
                new Personality( "피쿼드호 작살잡이 히스클리프", List.of(피쿼드호)),
                new Personality( "멀티크랙 사무소 해결사 히스클리프", List.of(해결사, 멀티크랙_사무소)),
                new Personality( "와일드헌트 히스클리프", List.of(워더링하이츠, 와일드헌트)),
                new Personality( "마침표 사무소 해결사 히스클리프", List.of(해결사, 마침표_사무소)),
                new Personality( "흑운회 와카슈 히스클리프", List.of(조직, 흑운회)),
                new Personality( "남부 시 협회 5과 히스클리프", List.of(해결사, 시_협회)),
                new Personality( "N사 작은 망치 히스클리프", List.of(N사, N사_광신도)),
                new Personality( "로보토미 E.G.O::여우비 히스클리프", List.of(로보토미_본사)),
                new Personality( "LCB 수감자 이스마엘", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "남부 리우 협회 4과 이스마엘", List.of(해결사, 리우_협회)),
                new Personality( "피쿼드호 선장 이스마엘", List.of(피쿼드호)),
                new Personality( "서부 츠바이 협회 3과 이스마엘", List.of(해결사, 츠바이_협회)),
                new Personality( "흑운회 부조장 이스마엘", List.of(조직, 흑운회)),
                new Personality( "R사 제4무리 순록팀 이스마엘", List.of(R사)),
                new Personality( "에드가 가문 버틀러 이스마엘", List.of(해결사, 에드가_가문)),
                new Personality( "LCCB 대리 이스마엘", List.of(LCCB, 림버스_컴퍼니)),
                new Personality( "남부 시 협회 5과 이스마엘", List.of(해결사, 시_협회)),
                new Personality( "로보토미 E.G.O::출렁임 이스마엘", List.of(로보토미_본사)),
                new Personality( "어금니 보트 센터 해결사 이스마엘", List.of(해결사, 어금니_사무소)),
                new Personality( "LCB 수감자 로쟈", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "T사 2등급 징수직 직원 로쟈", List.of(T사)),
                new Personality( "북부 제바찌 협회 3과 로쟈", List.of(해결사, 제바찌_협회)),
                new Personality( "라만차랜드 공주 로쟈", List.of(제2권속, 혈귀, 라만차랜드)),
                new Personality( "LCCB 대리 로쟈", List.of(LCCB, 림버스_컴퍼니)),
                new Personality( "N사 중간 망치 로쟈", List.of(N사, N사_광신도)),
                new Personality( "흑운회 와카슈 로쟈", List.of(조직, 흑운회)),
                new Personality( "장미스패너 공방 대표 로쟈", List.of(해결사, 장미스패너_공방)),
                new Personality( "남부 츠바이 협회 5과 로쟈", List.of(해결사, 츠바이_협회)),
                new Personality( "남부 리우 협회 4과 부장 로쟈", List.of(해결사, 리우_협회)),
                new Personality( "LCB 수감자 싱클레어", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "쥐어들 자 싱클레어", List.of(N사, N사_광신도)),
                new Personality( "남부 섕크 협회 4과 부장 싱클레어", List.of(해결사, 섕크_협회)),
                new Personality( "새벽 사무소 해결사 싱클레어", List.of(해결사, 새벽_사무소)),
                new Personality( "북부 제바찌 협회 3과 싱클레어", List.of(해결사, 제바찌_협회)),
                new Personality( "마리아치 보스 싱클레어", List.of(뒷골목, 조직, 마리아치)),
                new Personality( "검계 살수 싱클레어", List.of(조직, 검계)),
                new Personality( "남부 츠바이 협회 6과 싱클레어", List.of(해결사, 츠바이_협회)),
                new Personality( "중지 작은 아우 싱클레어", List.of(조직, 중지)),
                new Personality( "로보토미 E.G.O::홍적 싱클레어", List.of(로보토미_본사)),
                new Personality( "어금니 보트 센터 해결사 싱클레어", List.of(해결사, 어금니_사무소)),
                new Personality( "서부 츠바이 협회 3과 싱클레어", List.of(해결사, 츠바이_협회)),
                new Personality( "LCB 수감자 오티스", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "어금니 사무소 해결사 오티스", List.of(해결사, 어금니_사무소)),
                new Personality( "로보토미 E.G.O::마탄 오티스", List.of(로보토미_본사)),
                new Personality( "워더링하이츠 치프 버틀러 오티스", List.of(해결사, 워더링하이츠)),
                new Personality( "약지 점묘파 스튜던트 오티스", List.of(조직, 약지)),
                new Personality( "W사 3등급 정리 요원 팀장 오티스", List.of(W사)),
                new Personality( "라만차랜드 이발사 오티스", List.of(제3권속, 혈귀, 라만차랜드)),
                new Personality( "흑수•묘 오티스", List.of(흑수, 흑수_묘)),
                new Personality( "남부 섕크 협회 4과 오티스", List.of(해결사, 섕크_협회)),
                new Personality( "검계 살수 오티스", List.of(조직, 검계)),
                new Personality( "G사 부장 오티스", List.of(G사)),
                new Personality( "LCB 수감자 그레고르", List.of(LCB, 림버스_컴퍼니)),
                new Personality( "남부 리우 협회 6과 그레고르", List.of(해결사, 리우_협회)),
                new Personality( "쌍갈고리 해적단 부선장 그레고르", List.of(조직, 쌍갈고리_해적단)),
                new Personality( "에드가 가문 승계자 그레고르", List.of(에드가_가문)),
                new Personality( "라만차랜드 신부 그레고르", List.of(제3권속, 혈귀, 라만차랜드)),
                new Personality( "불주먹 사무소 생존자 그레고르", List.of(해결사)),
                new Personality( "G사 일등대리 그레고르", List.of(G사)),
                new Personality( "흑운회 부조장 그레고르", List.of(조직, 흑운회)),
                new Personality( "장미스패너 공방 해결사 그레고르", List.of(해결사, 장미스패너_공방)),
                new Personality( "남부 츠바이 협회 4과 그레고르",List.of(해결사, 츠바이_협회))
        );

        this.personalityRepository.saveAll(personalities);
    }

}
