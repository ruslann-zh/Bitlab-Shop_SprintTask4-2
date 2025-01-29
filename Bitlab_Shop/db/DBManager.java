package Bitlab_Shop.db;

import Bitlab_Shop.Item;
import Bitlab_Shop.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universitet",
                    "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Item> getitems() {
        List<Item> itemList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM universitet.public.items");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));

                itemList.add(item);
            }
            resultSet.close();
            return itemList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Users> getUsers() {
        List<Users> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM universitet.public.users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));

                userList.add(user);
            }
            resultSet.close();
            return userList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Users getUserByEmail(String email) {
        Users user = new Users();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM universitet.public.users WHERE email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
