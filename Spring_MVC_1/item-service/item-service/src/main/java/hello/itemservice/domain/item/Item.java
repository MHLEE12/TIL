package hello.itemservice.domain.item;

import lombok.Data;

// @Data사용시 신중하게.. 문제 일으킬 수 있다.
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // 가격이 안들어갈 경우도 있다고 가정하므로 Integer사용!
    private Integer quantity; // int는 null이 안들어가니까!

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
