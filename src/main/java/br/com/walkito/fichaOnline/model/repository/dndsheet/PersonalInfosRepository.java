package br.com.walkito.fichaOnline.model.repository.dndsheet;

import br.com.walkito.fichaOnline.model.entities.dndsheet.PersonalInfos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfosRepository extends JpaRepository<PersonalInfos, Integer> {
}
