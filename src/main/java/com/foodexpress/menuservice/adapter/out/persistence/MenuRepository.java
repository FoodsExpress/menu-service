package com.foodexpress.menuservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuEntity, Long>, MenuRepositoryQuerydsl {

    Optional<MenuEntity> findByMenuId(UUID menuId);

}
