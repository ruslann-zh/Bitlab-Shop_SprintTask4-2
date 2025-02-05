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



//    public static Users getUserById(Long id) {
//        Users user = new Users();
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "SELECT * FROM universitet.public.users WHERE id=?");
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                user.setId(resultSet.getLong("id"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setFullName(resultSet.getString("full_name"));
//            }
//            return user;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public static boolean additem(Item item) {
//        int row = 0;
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "INSERT INTO universitet.public.items (name, price, amount) VALUES (?, ?, ?)");
//            statement.setString(1, item.getName());
//            statement.setDouble(2, item.getPrice());
//            statement.setInt(3, item.getAmount());
//
//            row = statement.executeUpdate();
//            if (row > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static Item getitemById(Long id) {
//        Item item = new Item();
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "SELECT * FROM universitet.public.items WHERE id=?");
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                item.setId(resultSet.getLong("id"));
//                item.setName(resultSet.getString("name"));
//                item.setPrice(resultSet.getDouble("price"));
//                item.setAmount(resultSet.getInt("amount"));
//            }
//            return item;
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static boolean saveitem(Item item) {
//        int row = 0;
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "UPDATE universitet.public.items SET name=?, price=?, amount=? WHERE id=?");
//            statement.setString(1, item.getName());
//            statement.setDouble(2, item.getPrice());
//            statement.setInt(3, item.getAmount());
//            statement.setLong(4, item.getId());
//
//            row = statement.executeUpdate();
//            if (row > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void deleteitem(Long id) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(
//                    "DELETE FROM universitet.public.items WHERE id=?");
//            statement.setLong(1, id);
//            statement.execute();
//            statement.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
