package com.fly.model;

import com.fly.entities.User;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {

    private DataSource dataSource;

    public static final String url = "jdbc:postgresql://localhost:5432/building_machinery";
    public static final String username = "Flyer";
    public static final String password = "CA59563";
    public static final int initialSize = 10;

    private DataSource init() {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setInitialSize(initialSize);
        return basicDataSource;
    }
    private User fillObject(ResultSet set) throws SQLException {
        User user = new User();
        user.setId(set.getLong("id"));
        user.setFirstName(set.getString("first_name"));
        user.setSecondName(set.getString("second_name"));
        user.setPhoneNumber(set.getString("phone_number"));
        user.setPassword(set.getString("password"));
        user.setPost(set.getString("post"));
        user.setActual(set.getBoolean("actual"));
        user.setDateOfDismiss(set.getDate("date_of_dissmiss"));
        return user;

    @Override
    public int save ( User user ) {
        return 0;
    }

    @Override
    public List <User> findAll () {
        return null;
    }

    @Override
    public User findUserByLogin (String login) {
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from m_users where login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User;
            if (resultSet.next()) user = fillObject(resultSet);


        } catch (SQLException | ClassNotFoundException e ){
        e.printStackTrace();}
        }
        if (user!=null) return user;
        else return null;
    }

    @Override
    public int isRegistered ( User user ) {
        return 0;
    }

    @Override
    public int upDateUser ( User user ) {
        return 0;
    }
}
