package com.qa.repository;

import com.qa.models.Inventories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventories, Long>{

}
