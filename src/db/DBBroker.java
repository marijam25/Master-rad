package db;

import DataTables.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBBroker {
    private static DBBroker instance;

    private String username;
    private String password;
    private String url;
    private Connection connection;

    private DBBroker() {
        this.setDbProperties();
    }

    public static DBBroker getInstance(){
        if(instance==null)
            instance = new DBBroker();
        return instance;
    }

    public void setDbProperties() {
        try {
            Properties properties = new Properties();
            String propertiesFileName = "config/db.properties";
            FileInputStream fileInputStream = new FileInputStream(propertiesFileName);

            properties.load(fileInputStream);

            this.url = properties.getProperty("url");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
            System.out.println(url + " " + username);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() throws Exception {
        try {
            System.out.println("Begin connection");
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB connection successful!");
        } catch (SQLException ex) {
            throw new Exception("DB connection unsuccessful!");
        }
    }

    public void disconnect() throws Exception {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("DB disconnected");
            } catch (SQLException ex) {
                throw new Exception("Error while disconnecting");
            }
        }
    }

    public void createTable(String tableName) throws Exception {
        if (connection == null || connection.isClosed()) {
            throw new Exception("No active database connection. Please connect to the database first.");
        }

        // SQL queries
        String dropTableSQL = "DROP TABLE IF EXISTS " + tableName + ";";
        String createTableSQL = "CREATE TABLE " + tableName + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "surname VARCHAR(255) NOT NULL, " +
                "age INT NOT NULL, " +
                "JMBG BIGINT NOT NULL UNIQUE, " +
                "gender VARCHAR(10), " +
                "city VARCHAR(255), " +
                "gpa DOUBLE, " +
                "indexNumber VARCHAR(255), " +
                "studyYear INT, " +
                "module VARCHAR(255), " +
                "phone BIGINT" +
                ");";


        try (Statement stmt = connection.createStatement()) {
            // Drop existing table if it exists
            stmt.executeUpdate(dropTableSQL);

            // Create new table
            stmt.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            throw new Exception("Error while creating table '" + tableName + "': " + e.getMessage());
        }
    }


    public void insert(String tableName, Student student) throws Exception {
        if (connection == null || connection.isClosed()) {
            throw new Exception("No active database connection. Please connect to the database first.");
        }

        // SQL query for inserting a student
        String insertSQL = "INSERT INTO " + tableName + " (name, surname, age, JMBG, gender, city, gpa, indexNumber, studyYear, module, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            // Set parameters for the query
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSurname());
            pstmt.setInt(3, student.getAge());
            pstmt.setLong(4, student.getJMBG());
            pstmt.setString(5, student.getGender());
            pstmt.setString(6, student.getCity());
            pstmt.setDouble(7, student.getGpa());
            pstmt.setString(8, student.getIndexNumber());
            pstmt.setInt(9, student.getStudyYear());
            pstmt.setString(10, student.getModule());
            pstmt.setLong(11, student.getPhone());

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully inserted into table '" + tableName + "'.");
            } else {
                System.out.println("No rows affected. Values were not inserted.");
            }
        } catch (SQLException e) {
            throw new Exception("Error while inserting values into table '" + tableName + "': " + e.getMessage());
        }
    }



}
