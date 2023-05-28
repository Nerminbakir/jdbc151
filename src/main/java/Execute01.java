import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. Adım: Driver'a kaydol ==> JDBC 4 sonrasında bunu yapmaya gerek yoktur.
       Class.forName("org.postgresql.Driver");

        // 2. Adım: Database'e baglan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","Annem300717");

        // 3. Adım: Statement Olustur
        Statement statement = connection.createStatement();

        //4. Adım: Query calıstır
        
        /*
        1) Eger execute() methodu DDL (create, drop, alter table) ile kullanılırsa her zaman false döner.
        2) Eger execute() methodu DQL (select) ile kullanılırsa data dönerse true, data dönmezse false döner.
        NOT : execute() methodu DQL (select) ile kullanılmaz. Eger data cagiracaksak o data üzerinde işlem
        yapacagız demektir. Bu yuzden executeOuery() methodu kullanmak daha dogrudur.
        */

        //execute() methodu parametre olarak girilen String SQL komutunu bağlı olduğu database üzerinde uygular.

        //1. Örnek: workers adında bir table olusturunuz
        //CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);
        boolean sql1 = statement.execute("CREATE TABLE workers(worker_id VARCHAR(20), worker_name VARCHAR (20), worker_salary INT);");
        System.out.println("sql1 = " + sql1);

        //2. Örnek: workers table'ına worker_address sütunu ekleyiniz
        String sqlQuery1 = "ALTER TABLE workers ADD worker_address VARCHAR(100);";
        boolean sql2 = statement.execute(sqlQuery1);
        System.out.println("sql2 = " + sql2);

        //3. Örnek: workers table'ı siliniz
        String sqlQuery2 = "DROP TABLE workers";
        boolean sql3 = statement.execute(sqlQuery2);
        System.out.println("sql3 = " + sql3);

        //5. Adım: Baglantıyı kapat
        connection.close();
        statement.close();

    }

}
