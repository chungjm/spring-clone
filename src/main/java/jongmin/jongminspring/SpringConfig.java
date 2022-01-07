package jongmin.jongminspring;

import jongmin.jongminspring.repository.MemberRepository;
import jongmin.jongminspring.repository.MemoryMemberRepository;
import jongmin.jongminspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
