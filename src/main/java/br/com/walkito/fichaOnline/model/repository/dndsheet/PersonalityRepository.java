package br.com.walkito.fichaOnline.model.repository.dndsheet;

import br.com.walkito.fichaOnline.model.entities.dndsheet.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
}
