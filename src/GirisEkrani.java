import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GirisEkrani extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordFieldPassword;
	CalisanIslemleri calisanIslemleri = new  CalisanIslemleri();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GirisEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(730, 210, 454, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(64, 187, 129, 31);
		contentPane.add(lblUserName);
		
		JLabel lblParola = new JLabel("Password :");
		lblParola.setForeground(Color.WHITE);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParola.setBounds(64, 244, 129, 31);
		contentPane.add(lblParola);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(192, 192, 147, 24);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(192, 249, 147, 24);
		contentPane.add(passwordFieldPassword);
		
		JLabel lblUyari = new JLabel("");
		lblUyari.setForeground(Color.RED);
		lblUyari.setBounds(64, 286, 274, 31);
		contentPane.add(lblUyari);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUyari.setText("");
				String kullanici_adi = textFieldUserName.getText();
				String parola = new String(passwordFieldPassword.getPassword());
				boolean giris_basarili = calisanIslemleri.girisYap(kullanici_adi, parola);
				
				if(giris_basarili) {
					CalisanEkrani  calisanEkrani = new CalisanEkrani();
					setVisible(false);
					calisanEkrani.setVisible(true);
					
					
				}
				else {
					lblUyari.setText("Login is unsuccesful,Please try again");
				}
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(142, 328, 122, 42);
		contentPane.add(btnLogin);
		
		JLabel lblMember = new JLabel("MEMBER LOGIN");
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember.setBackground(Color.CYAN);
		lblMember.setForeground(new Color(255, 255, 255));
		lblMember.setFont(new Font("OCR A Extended", Font.BOLD, 26));
		lblMember.setBounds(10, 11, 418, 67);
		contentPane.add(lblMember);
	}
}
