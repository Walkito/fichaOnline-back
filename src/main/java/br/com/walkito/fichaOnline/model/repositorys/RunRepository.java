package br.com.walkito.fichaOnline.model.repositorys;

import br.com.walkito.fichaOnline.model.entities.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RunRepository extends JpaRepository<Run, Integer> {
    public Run searchById(int id);

    @Query( value = "SELECT DISTINCT r.* FROM runs r " +
            "INNER JOIN runs_accounts ra ON ra.runs_id = r.id AND ra.accounts_id = :accountID " +
            "WHERE r.status IN (:status)",nativeQuery = true)
    public List<Run> findAllRunsFilter(@Param("status") List<String> status,
                                       @Param("accountID") int accountID);
}
