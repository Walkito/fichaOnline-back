package br.com.walkito.fichaOnline.model.repositorys;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PlayerSheetRepository extends JpaRepository<PlayerSheet, Integer>, JpaSpecificationExecutor<PlayerSheet> {

    public PlayerSheet searchById(int id);
}
