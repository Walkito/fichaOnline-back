package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSheetRepository extends JpaRepository<PlayerSheet, Integer> {
}
