package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.domain.MenuOptionDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "menu_option_detail")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuOptionDetailEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 메뉴 옵션 상세 식별자
     */
    @Column(unique = true)
    private UUID menuOptionDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_option_id")
    private MenuOptionEntity menuOption;

    /**
     * 옵션 상세 명
     */
    private String menuOptionDetailName;

    /**
     * 가격
     */
    private double price;

    /**
     * 순서
     */
    private double orderNumber;

    public static MenuOptionDetailEntity mapToEntity(MenuOptionDetail menuOptionDetail, MenuOptionEntity menuOption) {
        MenuOptionDetailEntity entity = new MenuOptionDetailEntity();
        entity.menuOptionDetailId = UUID.randomUUID();
        entity.menuOption = menuOption;
        entity.menuOptionDetailName = menuOptionDetail.menuOptionDetailName();
        entity.price = menuOptionDetail.price();
        entity.orderNumber = menuOptionDetail.orderNumber();
        return entity;
    }

    public MenuOptionDetail mapToDomain() {
        return MenuOptionDetail.builder()
            .id(this.id)
            .menuOptionDetailId(this.menuOptionDetailId.toString())
            .menuOptionId(this.menuOption.getMenuOptionId().toString())
            .menuOptionDetailName(this.menuOptionDetailName)
            .price(this.price)
            .orderNumber(this.orderNumber)
            .createdBy(this.createdBy)
            .createdDate(this.createdDate)
            .updatedBy(this.updatedBy)
            .updatedDate(this.updatedDate)
            .build();
    }

}
