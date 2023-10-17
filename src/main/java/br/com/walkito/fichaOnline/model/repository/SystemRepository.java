package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.System;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemRepository extends JpaRepository<System, Integer> {
}
