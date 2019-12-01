package daos;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        public static final String URL = "jdbc:mysql://localhost:3306/pixarscars";
        public static final String USER = "testuser";
        public static final String PASS = "testpass";
        /**
         * Get a connection to database
         * @return Connection object
         */
        public static ConnectionFactory getConnection()
        {
            try {
                DriverManager.registerDriver(new Driver());
                return (ConnectionFactory) DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException ex) {
                throw new RuntimeException("Error connecting to the database", ex);
            }
        }
        /**
         * Test Connection
         */
        public static void main(String[] args) {
            daos.ConnectionFactory connectionFactory = ConnectionFactory.getConnection();
        }
    }

