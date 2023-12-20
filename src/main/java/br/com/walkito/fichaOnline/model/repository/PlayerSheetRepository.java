package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;

public interface PlayerSheetRepository extends JpaRepository<PlayerSheet, Integer>, JpaSpecificationExecutor<PlayerSheet> {

    public PlayerSheet searchById(int id);
}
