package com.qa.repository;

import com.qa.models.PlayerCharacters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacters, Long>{
}
