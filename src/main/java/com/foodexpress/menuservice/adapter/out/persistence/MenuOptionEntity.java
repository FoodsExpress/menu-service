package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.domain.ChoiceType;
import com.foodexpress.menuservice.domain.MenuOption;
import com.foodexpress.menuservice.domain.MenuOptionDetail;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "menu_option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class MenuOptionEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID menuOptionId;

    /**
     * 필수 여부
     */
    private boolean required;

    /**
     * 선택 가능 개수
     */
    private int choiceCount;

    /**
     * 선택 유형
     */
    @Enumerated(EnumType.STRING)
    private ChoiceType choiceType;

    /**
     * 옵션 명
     */
    private String optionName;

    /**
     * 정렬 순서
     */
    private double orderNumber;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    @OneToMany(mappedBy = "menuOption", fetch = FetchType.LAZY)
    private List<MenuOptionDetailEntity> menuOptionDetails;

    public static MenuOptionEntity mapToEntity(MenuOption menuOption, MenuEntity menu) {
        MenuOptionEntity entity = new MenuOptionEntity();
        entity.menuOptionId = UUID.randomUUID();
        entity.required = menuOption.required();
        entity.menu = menu;
        entity.choiceCount = menuOption.choiceCount();
        entity.menuOptionDetails =
            menuOption.menuOptionDetails().stream().map(mo -> MenuOptionDetailEntity.mapToEntity(mo, entity)).toList();
        entity.choiceType = menuOption.choiceType();
        entity.optionName = menuOption.optionName();
        entity.orderNumber = menuOption.orderNumber();
        return entity;
    }

    public MenuOption mapToDomain() {
        return mapToDomain(this.menuOptionDetails.stream().map(MenuOptionDetailEntity::mapToDomain).toList());
    }

    public void sync(MenuOption menuOption) {
        this.required = menuOption.required();
        this.choiceCount = menuOption.choiceCount();
        this.choiceType = menuOption.choiceType();
        this.optionName = menuOption.optionName();
        this.orderNumber = menuOption.orderNumber();
    }

    public MenuOption mapToDomain(List<MenuOptionDetail> menuOptionDetailList) {
        return MenuOption.builder()
            .id(this.id)
            .menuId(this.menu.getMenuId().toString())
            .menuOptionId(this.menuOptionId.toString())
            .required(this.required)
            .choiceCount(this.choiceCount)
            .choiceType(this.choiceType)
            .optionName(this.optionName)
            .orderNumber(this.orderNumber)
            .menuOptionDetails(menuOptionDetailList)
            .createdBy(this.createdBy)
            .createdDate(this.createdDate)
            .updatedBy(this.updatedBy)
            .updatedDate(this.updatedDate)
            .build();
    }

}
