package com.foodexpress.menuservice.adapter.out.persistence;

import com.foodexpress.menuservice.domain.Menu;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menu")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuEntity extends UpdatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 메뉴 식별자
     */
    @Column(unique = true)
    private UUID menuId;

    /**
     * 상점 식별자
     */
    private String storeId;

    /**
     * 메뉴 명
     */
    private String menuName;

    /**
     * 메뉴 상세 설명
     */
    private String menuDescription;

    /**
     * 정렬
     */
    private double orderNumber;

    /**
     * 사용 여부
     */
    private boolean active;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<MenuOptionEntity> menuOptions = new ArrayList<>();

    public static MenuEntity mapToEntity(Menu menu) {
        MenuEntity entity = new MenuEntity();
        entity.storeId = menu.storeId();
        entity.menuId = UUID.randomUUID();
        entity.menuName = menu.menuName();
        entity.menuDescription = menu.menuDescription();
        entity.orderNumber = menu.orderNumber();
        if (menu.menuOptions() != null) {
            entity.menuOptions = menu.menuOptions().stream().map(m -> MenuOptionEntity.mapToEntity(m, entity)).toList();
        }
        entity.active = menu.active();
        entity.menuOptions = menu.menuOptions().stream().map(m -> MenuOptionEntity.mapToEntity(m, entity)).toList();
        return entity;
    }

    public Menu mapToDomain() {
        return Menu.builder()
            .id(this.id)
            .menuId(this.menuId.toString())
            .storeId(this.storeId)
            .menuName(this.menuName)
            .menuDescription(this.menuDescription)
            .menuOptions(this.menuOptions.stream().map(MenuOptionEntity::mapToDomain).toList())
            .orderNumber(this.orderNumber)
            .active(this.active)
            .createdBy(this.createdBy)
            .createdDate(this.createdDate)
            .updatedBy(this.updatedBy)
            .updatedDate(this.updatedDate)
            .build();
    }

    public void sync(Menu menu) {
        this.menuName = menu.menuName();
        this.menuDescription = menu.menuDescription();
        this.active = menu.active();
        this.orderNumber = menu.orderNumber();
    }

}
