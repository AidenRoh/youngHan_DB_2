package hello.itemservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity // JPA로 관리할 객체
//@Table(name = "item") 객체 명과 같으면 해당 애너테이션 생략 가능
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity 전략은 DB에서 값을 넣어주는 전략
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    //@Column을 생략한 경우, 필드의 이름을 테이블 컬럼 이름으로 사용한다.
    private Integer price;
    private Integer quantity;

    //JPA는 public 또는 protected의 기본 생성자가 필수이다!
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
