package br.com.walkito.fichaOnline.model.repository.dndsheet;

import br.com.walkito.fichaOnline.model.entities.dndsheet.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}
