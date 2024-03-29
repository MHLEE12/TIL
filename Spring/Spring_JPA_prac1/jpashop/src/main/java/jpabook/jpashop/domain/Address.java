package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// @Embeddable : JPA 내장타입
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    // 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만듦.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
