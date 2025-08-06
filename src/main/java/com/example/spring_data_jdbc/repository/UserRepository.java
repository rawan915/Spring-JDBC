package com.example.spring_data_jdbc.repository;

import com.example.spring_data_jdbc.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;



    private RowMapper<User> rowMapper = ((rs, Num) -> {

        User user1 = User.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .userName(rs.getString("user_name"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .phoneNumber(rs.getString("phone_number"))
                .build();
        return user1;
    });

    public int addNewUser(User user) {
        String sql = """
                INSERT INTO users (first_name , last_name , user_name ,password , email ,phone_number ) VALUES (?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(sql ,
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber()
                );
    }

    public int deleteUser(long id) {
        String sql = """
                DELETE FROM users WHERE id=?
                """;
        return jdbcTemplate.update(sql, id);
    }


    public List<User>findall(){
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, rowMapper);

    }

    public User findById(long id) {
        String sql = """
                SELECT * FROM users WHERE id=?
                """;
        return jdbcTemplate.queryForObject(sql ,rowMapper ,id);
    }
    public User findByUserName(String userName) {
        String sql = """
            SELECT * FROM users WHERE user_name=?
                    """;
        return jdbcTemplate.queryForObject(sql ,rowMapper , userName);
    }

    public int updateUser(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, password = ?, email = ?, phone_number = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getId()
        );
    }
    public User login(String userName, String password) {
        String sql = """
SELECT * FROM users WHERE user_name=? AND password=?
""";
        return jdbcTemplate.queryForObject(sql , rowMapper,userName , password);
    }



}
