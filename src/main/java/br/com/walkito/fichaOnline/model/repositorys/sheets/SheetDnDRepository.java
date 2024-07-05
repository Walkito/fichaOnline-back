package br.com.walkito.fichaOnline.model.repositorys.sheets;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SheetDnDRepository extends JpaRepository<SheetDnD, Integer> {

    @Query("SELECT s FROM SheetDnD s WHERE s.id IN (:ids)")
    List<SheetDnD> findAllById(@Param("ids") List<Integer> ids);

}
