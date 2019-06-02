package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class JavaDB {
 
	// Nazwa bazy
    final static String baseName = "VehicleManager";
    
    //konstruktor bezparametrowy
    public JavaDB() {  }
    
    /**
     * Metoda odpowiedzialna za po³¹czenie z baz¹
     * jeœli bazy nie ma to zostaje utworzona
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
     * Metoda odpowiedzialna za dodawanie danych do bazy
     * @param takson
     * @param baza
     *//*
    public static void addDataToDB(Takson takson) {

        Connection connection = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + baseName + ".db");

            stat = connection.createStatement();
            String dodajSQL = "INSERT INTO " + baseName + " (ID, RODZAJ, GATUNEK, N2, X, UWAGI) "
                    + "VALUES ("
                    + takson.getId() + ","
                    + "'" + takson.getRodzaj() + "',"
                    + "'" + takson.getGatunek() + "',"
                    + takson.getN2() + ","
                    + takson.getX() + ","
                    + "'" + takson.getUwagi() + "'" 
                    + "  );";
            stat.executeUpdate(dodajSQL);
            stat.close();
            connection.close();
            // Komunikat i wydrukowanie koñcowej formy polecenia SQL
            System.out.println("Polecenie: \n" + dodajSQL + "\n wykonane.");
        } catch (Exception e) {
            System.out.println("Nie mogê dodaæ danych " + e.getMessage());
        }
    }*/
    /**
     * metoda odpowiedzialna za wyszukiwanie danych w bazie
     * @param baza
     * @param pole
     * @param wartosc
     */
    public static void search(String pole, String wartosc, String table) {
        Connection connection = null;
        Statement stat = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + baseName + ".db");
            stat = connection.createStatement();
            // Polecenie wyszukania
            String searchSQL = "SELECT * FROM " + baseName+"."+table
                    + " WHERE " + pole + "=='" + wartosc + "';";

            ResultSet result = stat.executeQuery(searchSQL);
            System.out.println("wynik polecenia:\n" + searchSQL);

            while (result.next()) {
                int id = result.getInt("id");
                System.out.println("ID:       " + id);
                System.out.println("Rodzaj:   " + result.getString("rodzaj"));
                System.out.println("Gatunek:  " + result.getString("gatunek"));
                System.out.println("2n:       " + result.getString("N2"));
                System.out.println("x:        " + result.getString("X"));
                System.out.println("Uwagi:    " + result.getString("UWAGI"));
                System.out.println(" ---------------------- ");
            }
            result.close();
            stat.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Nie mogê wyszukaæ danych " + e.getMessage());
        }

    }
}