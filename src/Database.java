import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public static final String kullanici_adi = "root";
	public static final String parola = "12345678";
	public static final String db_ismi = "demo";
	public static final String host = "localhost";
	public static final int port = 3306;
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public Database() {
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Driver bulunamadi");
		}
		try {
			connection = DriverManager.getConnection(url,kullanici_adi,parola);
			
			System.out.println("Baglanti saglandi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		Database baglanti = new Database();
		
	}
}
