package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class JavaDB {
 
	// Nazwa bazy
    public final static String baseName = "VehicleManager";
    
    //konstruktor bezparametrowy
    public JavaDB() {  }
    
    /**
     * Metoda odpowiedzialna za po³¹czenie z baz¹
     * jeœli bazy nie ma to zostaje utworzona
     * zwraca obiekt po³¹czenia
     */
    public static Connection connectToDB() {
        Connection connection = null;
        try {
            // Wskazanie jaki rodzaj bazy danych bêdzie wykorzystany, tu sqlite
            Class.forName("org.sqlite.JDBC");           
            // Po³¹czenie, wskazujemy rodzaj bazy i jej nazwê
            connection = DriverManager.getConnection("jdbc:sqlite:"+baseName+".db");
            System.out.println("Po³¹czy³em siê z baz¹ "+baseName);
        } catch (Exception e) {
            System.err.println("B³¹d w po³¹czeniu z baz¹: \n" + e.getMessage());
            return null;
        }
        return connection;
    }
    /**
     * metoda usuwaj¹ca wiersz o danym Id z danej tabeli
     * @param vehicleId
     * @param table
     */
    public static Boolean delete(int vehicleId, String table) {
        Connection connection = null;
        Statement stat = null;
        // Polecenie wyszukania
        String searchSQL = "DELETE FROM "+table + " WHERE  Id =='" + vehicleId + "';";
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + baseName + ".db");
            stat = connection.createStatement();
            stat.executeQuery(searchSQL);
            //stat.close();
            //connection.close();
            return true;
        } catch (Exception e) {
            System.out.println("Nie mogê wykonaæ akcji " + e.getMessage());
            return true;
        }

    }
}