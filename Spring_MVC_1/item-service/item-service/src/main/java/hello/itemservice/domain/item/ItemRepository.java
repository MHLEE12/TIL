package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // component scan의 대상이 된다.
public class ItemRepository {

    // 동시에 여러 쓰레드가 접근하는 환경이면 hashMap쓰면 안돼 -> ConcurrentHashMap 사용.
    private static final Map<Long, Item> store = new HashMap<>(); // static사용
    // 동시에 여러 쓰레드가 접근하는 환경이면 Long 말고, amomicLong 사용.
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        // 그냥 store.values() 로 반환해도 되지만, ArrayList로 한번 감싸서 반환하게 되면 store의 데이터를 보호할 수 있다.
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        // 원래는 item 클래스에서 id를 뺀 나머지를 따로 분리해서 클래스 만드는 것이 맞다.(여기서 id를 사용하지 않으니까)
        // 하지만 작은 프로젝트이니 이렇게 만듦
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear(); // store정보 날림. test용
    }

}
