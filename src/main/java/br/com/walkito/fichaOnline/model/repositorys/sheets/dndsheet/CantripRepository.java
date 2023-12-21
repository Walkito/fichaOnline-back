package br.com.walkito.fichaOnline.model.repositorys.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Cantrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantripRepository extends JpaRepository<Cantrip, Integer> {
}
