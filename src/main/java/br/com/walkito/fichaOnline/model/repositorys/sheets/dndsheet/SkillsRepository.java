package br.com.walkito.fichaOnline.model.repositorys.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.dndsheet.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}