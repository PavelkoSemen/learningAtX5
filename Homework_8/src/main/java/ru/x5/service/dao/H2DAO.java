package ru.x5.service.dao;

import ru.x5.service.accountservice.Account;

import java.sql.*;
import java.util.ResourceBundle;

public class H2DAO implements DAO<Account> {
    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ACCOUNTS(ID INT PRIMARY KEY, " +
            "HOLDER VARCHAR(50), " +
            "AMOUNT INT);";
    private final String GET = "SELECT * FROM ACCOUNTS WHERE ID = ?;";
    private final String INSERT = "INSERT INTO ACCOUNTS (ID, HOLDER, AMOUNT) VALUES (?, ?, ?);";
    private final String UPDATE = "UPDATE ACCOUNTS SET HOLDER = ?, AMOUNT = ? WHERE ID = ?;";
    private final String DELETE = "DELETE FROM ACCOUNTS WHERE ID = ?;";
    private final String COUNT = "SELECT COUNT(*) FROM ACCOUNTS;";

    public H2DAO() {
        createTable();
        if (countRows() == 0) {
            addRows(10);
        }
    }

    @Override
    public Account get(int id) {
        Account account = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getInt("ID"),
                        resultSet.getString("HOLDER"),
                        resultSet.getDouble("AMOUNT"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return account;
    }

    @Override
    public void save(Account account) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getHolder());
            preparedStatement.setDouble(3, account.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {
            preparedStatement.setString(1, account.getHolder());
            preparedStatement.setDouble(2, account.getAmount());
            preparedStatement.setDouble(3, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Account account) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE);) {
            preparedStatement.setDouble(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int countRows() {
        int countRows = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(COUNT);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countRows = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return countRows;
    }

    private void addRows(int countRows) {
        try (Connection connection = getConnection(false)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                Savepoint savePoint = connection.setSavepoint("savePointInsert");
                String holder;
                double amount;
                for (int i = 0; i < countRows; i++) {
                    holder = "holder_" + i;
                    amount = (i + 1) * 1000;
                    preparedStatement.setInt(1, i + 1);
                    preparedStatement.setString(2, holder);
                    preparedStatement.setDouble(3, amount);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                try {
                    connection.commit();
                } catch (SQLException ex) {
                    connection.rollback(savePoint);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void createTable() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return getConnection(true);
    }

    private Connection getConnection(boolean isAutoCommit) throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String userBD = resource.getString("db.userName");
        String passwordBD = resource.getString("db.password");
        Connection connection = DriverManager.getConnection(url, userBD, passwordBD);
        connection.setAutoCommit(isAutoCommit);
        return connection;
    }
}
