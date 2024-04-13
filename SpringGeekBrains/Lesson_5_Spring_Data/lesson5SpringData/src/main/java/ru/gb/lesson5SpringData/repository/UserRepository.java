package ru.gb.lesson5SpringData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson5SpringData.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
