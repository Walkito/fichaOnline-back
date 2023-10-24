package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.Account;
import br.com.walkito.fichaOnline.model.entities.AccountRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRunRepository extends JpaRepository<AccountRun, Integer> {

    @Query("SELECT ar FROM AccountRun ar WHERE ar.account.id = :id")
    public Iterable<AccountRun> findAllByAccountId(@Param("id") int id);

    public AccountRun findByAccount_IdAndRun_Id(int accountId, int runId);
}
