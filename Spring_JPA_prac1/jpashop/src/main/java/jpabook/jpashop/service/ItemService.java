package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final이 있는 필드만 생성자를 만들어 줌
public class ItemService {
    // ItemService는 ItemRepository에 단순히 위임만 하는 class라서 단순하다.
    // 단순하기 때문에 강의에서 test는 생략함

    private final ItemRepository itemRepository;

    @Transactional // (readOnly = true)옵션을 쓰면 save가 안되니 어노테이션 따로 써줌
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
