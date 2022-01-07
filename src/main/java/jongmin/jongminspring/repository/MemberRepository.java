package jongmin.jongminspring.repository;

import jongmin.jongminspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 없으면 null 로 반환, null 을 optional 로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
