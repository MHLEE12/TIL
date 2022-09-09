package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // spring이 여기에 엔티티매니저를 주입해줌

    public void save(Member member) {
        em.persist(member);
    }

    // id로 멤버 찾아서 반환
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 멤버 목록 조회
    public List<Member> findAll() {
//        (jpql, 반환타입)
//        jpql은 엔티티 객체를 대상으로 쿼리함. sql은 테이블을 대상으로 함.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 이름으로 멤버 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
