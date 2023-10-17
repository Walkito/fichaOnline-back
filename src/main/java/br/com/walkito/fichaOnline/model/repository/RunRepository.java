package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.Run;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, Integer> {
}
