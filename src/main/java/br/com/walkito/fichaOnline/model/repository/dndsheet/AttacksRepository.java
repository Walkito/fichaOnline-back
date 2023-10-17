package br.com.walkito.fichaOnline.model.repository.dndsheet;

import br.com.walkito.fichaOnline.model.entities.dndsheet.Attacks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttacksRepository extends JpaRepository<Attacks, Integer> {
}
