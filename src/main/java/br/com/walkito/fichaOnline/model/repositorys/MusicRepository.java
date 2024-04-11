package br.com.walkito.fichaOnline.model.repositorys;

import br.com.walkito.fichaOnline.model.entities.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
}
