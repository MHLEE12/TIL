package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // sequence는 key값 생성해주는 것

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 그냥 store.get(id)를 반환하면 null값이 반환될 수 있으니 optional로 감싸서 반환한다.
    }

    @Override
    public Optional<Member> findByName(String name) { // 람다 사용.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 이것의 결과가 Optional로 반환된다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // store의 values는 Member들. Member들 반환됨.
    }

    public void clearStore() {
        store.clear();
        // 저장된 것을 지움
    }

}
