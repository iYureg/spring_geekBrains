package ru.gb.example1_sem5.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.example1_sem5.model.Account;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(Long id, BigDecimal amount);
}
