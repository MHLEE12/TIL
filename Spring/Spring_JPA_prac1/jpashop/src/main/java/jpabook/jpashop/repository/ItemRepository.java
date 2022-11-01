package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // final이 있는 필드만 생성자를 만들어 줌
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {
            em.persist(item); // 신규 등록
        } else {
            // 병합 사용 : 병합은 준영속 상태의 엔티티를 영속 상태로 변경할 때 사용하는 기능이다.
            // merge는 필드에서 쓰지 않는 것으로 알아둘 것.(다 바뀌는 것이라 위험하다!)
            em.merge(item); // update와 비슷
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
