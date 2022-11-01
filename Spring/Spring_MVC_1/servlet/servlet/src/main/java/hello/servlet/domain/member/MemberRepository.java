package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // 아무리 MemberRepository 객체를 여러개 만들어도 static이므로 1개만 있음 but 여기서는 싱글톤이라서 static 안해도 된다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤으로 생성
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤이므로 아무나 생성하지 못하도록 private로 막음
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store의 모든 값들을 ArrayList에 담아서 보내줌.
        // store의 value에 변동이 없게 하기 위함.(store 자체를 보호)
        return new ArrayList<>(store.values());
    }

    public void clearStore() { // store값 날림
        store.clear();
    }

}
