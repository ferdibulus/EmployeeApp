import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CalisanIslemleri {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	public ArrayList<Calisan> calisanlariGetir(){
		ArrayList<Calisan> cikti = new ArrayList<Calisan>();
		try {
			statement = connection.createStatement();
			String sorgu = "Select * From calisanlar";
			ResultSet rs = statement.executeQuery(sorgu);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String departman = rs.getString("departman");
				String maas = rs.getString("maas");
				
				cikti.add(new Calisan(id,ad,soyad,departman,maas));
			}
			return cikti;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public CalisanIslemleri() {
		String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Driver bulunamadi");
		}
		try {
			connection = DriverManager.getConnection(url,Database.kullanici_adi,Database.parola);
			
			System.out.println("Baglanti saglandi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 e.printStackTrace();
		}
	}

	public boolean girisYap(String kullanici_adi,String parola) {
		
		String sorgu = "Select * From adminler where username = ? and password = ? ";
		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, kullanici_adi);
			preparedStatement.setString(2, parola);
			
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
//			if(rs.next()== false) {
//				return false;
//			}
//			else {
//				return true;
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void calisanEkle(String ad, String soyad, String departman, String maas) {
		// TODO Auto-generated method stub
		String sorgu = "Insert Into calisanlar (ad,soyad,departman,maas) VALUES(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, ad);
			preparedStatement.setString(2, soyad);
			preparedStatement.setString(3, departman);
			preparedStatement.setString(4, maas);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void calisanGuncelle(int id, String ad, String soyad, String departman, String maas) {
		// TODO Auto-generated method stub
		String sorgu = "Update calisanlar set ad = ? ,soyad = ?,departman = ? ,maas = ? where id = ?";
		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setString(1, ad);
			preparedStatement.setString(2, soyad);
			preparedStatement.setString(3, departman);
			preparedStatement.setString(4, maas);
			
			preparedStatement.setInt(5, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void calisanSil(int id) {
		// TODO Auto-generated method stub
		String sorgu = "Delete From calisanlar where id = ?";
		try {
			preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
