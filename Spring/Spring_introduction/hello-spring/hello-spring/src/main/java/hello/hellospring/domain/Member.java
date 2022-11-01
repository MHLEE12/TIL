package hello.hellospring.domain;

import javax.persistence.*;

// jpa가 관리하는 엔티티 표시
@Entity
public class Member {

    // DB가 알아서 id생성해주는 경우이므로 Identity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 시스템 저장 아이디

    // DB 컬럼명과 맵핑 하는 것
//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
