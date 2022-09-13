package uz.pdp.libraryapp2.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp2.model.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public List<User> getALlUsersFromDb() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, (resultSet, row) ->
                User.builder()
                        .id(resultSet.getInt(1))
                        .full_name(resultSet.getString(2))
                        .phone_number(resultSet.getString(3))
                        .isAdmin(resultSet.getBoolean(4))
                        .password(resultSet.getString(5))
                        .build()
        );
    }

    public void addNewUser(User user) {
        String sql = "insert into users(full_name,phone_number,is_admin,password)" +
                " VALUES ('"+user.getFull_name()+"','"+user.getPhone_number()+"','"+user.isAdmin()+"','"+user.getPassword()+"');";
        int update = jdbcTemplate.update(sql);
    }

    public void editUser(User user) {
        String sql = "update users set full_name='"+user.getFull_name()+"',phone_number='"+user.getPhone_number()+"'," +
                "is_admin='"+user.isAdmin()+"',password='"+user.getPassword()+"'Where id="+user.getId()+";";
                int update = jdbcTemplate.update(sql);
    }

    public void deleteUserById(Integer id) {
        String sql = "delete from users where id="+id+";";
        jdbcTemplate.update(sql);
    }

    public User getUserById(Integer id) {
        String sql = "select * from users where id="+id+";";
        User user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
        return user;

    }

}
