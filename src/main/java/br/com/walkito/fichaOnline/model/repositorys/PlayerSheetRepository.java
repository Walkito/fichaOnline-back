package br.com.walkito.fichaOnline.model.repositorys;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlayerSheetRepository extends JpaRepository<PlayerSheet, Integer>, JpaSpecificationExecutor<PlayerSheet> {

    public PlayerSheet searchById(int id);

    public Optional<PlayerSheet> findBySheetDnDId(int id);
}
