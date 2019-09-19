package com.qa.persistence.repository;

import com.qa.persistence.models.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long>{
}
