package br.com.walkito.fichaOnline.model.repositorys.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
}
