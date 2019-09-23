package com.qa.service;

import com.qa.dto.InventoryDto;
import java.util.List;

public interface InventoryServiceInterface {

    List<InventoryDto> getInventories();

    InventoryDto addInventory(InventoryDto inventoryDto);

    InventoryDto getInventory(Long id);

    List<InventoryDto> getInventoryByPlayerId(Long playerId);

    InventoryDto deleteInventory(Long id);

    List<InventoryDto> deleteInventoryByPlayerId(Long playerId);

    InventoryDto updateInventory(Long id, InventoryDto inventoryDto);

    List<InventoryDto> updateInventoryByPlayerId(Long playerId, InventoryDto inventoryDto);

}
