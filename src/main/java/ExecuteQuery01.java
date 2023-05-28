import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","Annem300717");
        Statement statement = connection.createStatement();

        //1. Örnek: region_id'si 1 olan country name degerlerini cagırın
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1); //true ==>DQL ile data döndü

        // Satırları görmek için executeQuery methodunu kullanmalıyız. execute() methodu sadece true ya da false döner.

        ResultSet resultSet = statement.executeQuery(sql1);

        while (resultSet.next()){
            System.out.println(resultSet.getString("country_name"));
        }

        System.out.println("\n=======  2. Örnek: ==============\n");

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2 = "SELECT country_id, country_name FROM countries WHERE region_id > 2";
        ResultSet resultSet2 = statement.executeQuery(sql2);

        while (resultSet2.next()){//ResultSet son satıra gelip false verdikten sonra kapanır. Kapalı ResultSet üzerinde işlem yapılırsa exception atar.
            System.out.println(resultSet2.getString(1)+"-- "+resultSet2.getString(2)); //1. ve 2. sütunlar
        }


        System.out.println("\n=======  3. Örnek: ==============\n");
        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3 ="SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet3 = statement.executeQuery(sql3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getInt("company_id")+"--"+resultSet3.getString("company")+"--"+resultSet3.getInt("number_of_employees"));
        }


        connection.close();
        statement.close();

    }



















    }

