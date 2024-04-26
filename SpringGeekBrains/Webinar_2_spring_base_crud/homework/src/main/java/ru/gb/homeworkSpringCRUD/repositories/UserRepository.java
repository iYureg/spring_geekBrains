package ru.gb.homeworkSpringCRUD.repositories;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.homeworkSpringCRUD.aspect.ToLog;
import ru.gb.homeworkSpringCRUD.config.DbQueries;
import ru.gb.homeworkSpringCRUD.model.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;

    private final DbQueries dbQueries;

    @ToLog
    public List<User> findAll() {
        return jdbc.query(dbQueries.getFindAll(), userRowMapper);
    }

    RowMapper<User> userRowMapper = (r, i) -> {
        User rowObject = new User();
        rowObject.setId(r.getInt("id"));
        rowObject.setFirstName(r.getString("firstName"));
        rowObject.setLastName(r.getString("lastName"));
        return rowObject;
    };

    @Transactional
    @ToLog
    public User save(User user) {
        jdbc.update(dbQueries.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    //public void deleteById(int id)
    // "DELETE FROM userTable WHERE id=?"

    @Transactional
    public void deleteById(int id) {
        jdbc.update(dbQueries.getDelete(), id);
    }

    // get one user by id
    @ToLog
    public User getUserById(int id){
        return jdbc.query(dbQueries.getGet(), new Object[]{id}, userRowMapper).get(0);
    }
    // update user

    @Transactional
    public void updateUser(User user) {
        String sql = "UPDATE userTable set firstName=?, lastName=? WHERE id=?";
        jdbc.update(dbQueries.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }
}
