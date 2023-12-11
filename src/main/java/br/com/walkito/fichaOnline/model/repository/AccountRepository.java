package br.com.walkito.fichaOnline.model.repository;

import br.com.walkito.fichaOnline.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE (a.user = :user OR a.email = :email) AND a.password = :password")
    public Account getLogin(@Param("user") String user,
                            @Param("email") String email,
                            @Param("password") String password);

    public Account findByEmail(String email);

    public Account searchById(int id);
}
