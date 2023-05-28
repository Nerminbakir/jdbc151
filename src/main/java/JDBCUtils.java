import java.sql.*;

public class JDBCUtils {
    //Bu class'ta tekrarlı kullanılacak methodlar oluşturacağız.
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    //Database'e bağlanma methodu --> Connection return yapar
    public static Connection connectToDataBase() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Annem300717");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //  User connects to the database
    //  (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))
    // Medunna database'e baglanan method

    public static Connection connectToMedunnaDataBase() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }



    // Statement oluşturma methodu --> Statement return yapar
    public static Statement createStatement() {

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }

    //execute() methodu ile Query çalıştıran method
    public static boolean execute(String sql) {

        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //executeQuery() methodu ile Query çalıştıran method
    public static ResultSet executeQuery(String sql){

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    // Baglantıyı kapatan method
    public static void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }








}