package br.com.walkito.fichaOnline.model.repositorys;

import br.com.walkito.fichaOnline.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.email = :email AND a.id != :id")
    public Optional<Account> searchByEmail(@Param("email") String email,
                                 @Param("id") int id);

    public Optional<Account> findByUser(String user);

    @Query("SELECT a FROM Account a WHERE (a.user = :user OR a.email = :user)")
    public Optional<UserDetails> searchByUser(@Param("user") String user);

    public Account searchById(int id);
}
