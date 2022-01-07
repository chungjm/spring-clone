package jongmin.jongminspring.repository;

import jongmin.jongminspring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제가 있어, 공유되는 변수일 때는 원래는 ConcurrentHashMap<>();
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제가 있어, 공유되는 변수일때 long 대신에 AtomicLong
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null 이 반환될 가능성이 있으면, Optional.ofNullable() 로 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
