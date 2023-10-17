package br.com.walkito.fichaOnline.model.repository.dndsheet;

import br.com.walkito.fichaOnline.model.entities.dndsheet.Cantrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantripRepository extends JpaRepository<Cantrip, Integer> {
}
