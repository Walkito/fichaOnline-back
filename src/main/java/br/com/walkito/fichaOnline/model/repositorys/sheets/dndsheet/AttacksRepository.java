package br.com.walkito.fichaOnline.model.repositorys.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Attacks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttacksRepository extends JpaRepository<Attacks, Integer> {
}
