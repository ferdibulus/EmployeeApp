import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalisanEkrani extends JFrame {

    private JPanel contentPane;
    
    private JTable table;
    
   
    private JTable tableCalisan; 
    DefaultTableModel dtm;
    CalisanIslemleri islemler = new CalisanIslemleri();
    private JTextField textFieldAramaCubugu;
    private JSeparator separator;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblDepart;
    private JLabel lblSalary;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldDepart;
    private JTextField textFieldSalary;
    private JButton btnUpdateEmployee;
    private JButton btnDeleteEmployee;
    public void calisanGoruntule() { 
    dtm.setRowCount(0);
    ArrayList<Calisan> calisanlar = new ArrayList<Calisan>();
    calisanlar = islemler.calisanlariGetir();
    if(calisanlar !=null) { 
    	for (Calisan calisan : calisanlar)
    	{ 
    		Object[] eklenecek = {calisan.getId(),calisan.getAd(),calisan.getSoyad(),calisan.getDepartman(),calisan.getMaas()};
    		dtm.addRow(eklenecek); 
    		} 
    	} 
    }

    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CalisanEkrani frame = new CalisanEkrani();
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
    public CalisanEkrani() {
        setTitle("Employees Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setBounds(310, 150, 1277, 841); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        Object[] title = {"Id", "Name", "Surname", "Department", "Salary"};
        dtm = new DefaultTableModel(); 
        dtm.setColumnIdentifiers(title);
        contentPane.setLayout(null);
        table = new JTable(dtm);
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int selectedRow = table.getSelectedRow();
        		textFieldName.setText(dtm.getValueAt(selectedRow, 1).toString());
        		textFieldSurname.setText(dtm.getValueAt(selectedRow, 2).toString());
        		textFieldDepart.setText(dtm.getValueAt(selectedRow, 3).toString());
        		textFieldSalary.setText(dtm.getValueAt(selectedRow, 4).toString());
        	}
        });
        table.setBounds(23, 55, 435, 217);
        table.setModel(dtm);
        //JScrollPane scroll = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(218, 426, 873, 365);
        table.setFillsViewportHeight(true);
        table.setForeground(Color.RED);
        table.setRowHeight(30);
        contentPane.add(scroll);
        
        textFieldAramaCubugu = new JTextField();
        textFieldAramaCubugu.setBounds(218, 11, 873, 29);
        textFieldAramaCubugu.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textFieldAramaCubugu.setText("Search..");
        textFieldAramaCubugu.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		
        		String ara = textFieldAramaCubugu.getText();
        		dinamikAra(ara);
        	}
        });
        contentPane.add(textFieldAramaCubugu);
        textFieldAramaCubugu.setColumns(10);
        
        separator = new JSeparator();
        separator.setBounds(228, 51, 851, 7);
        contentPane.add(separator);
        
        Panel panel = new Panel();
        panel.setBounds(218, 99, 873, 321);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblName = new JLabel("Name :");
        lblName.setFont(new Font("Myriad Pro Cond", Font.BOLD, 14));
        lblName.setBounds(26, 49, 74, 30);
        panel.add(lblName);
        
        lblSurname = new JLabel("Surname :");
        lblSurname.setFont(new Font("Myriad Pro Cond", Font.BOLD, 14));
        lblSurname.setBounds(26, 101, 74, 30);
        panel.add(lblSurname);
        
        lblDepart = new JLabel("Department :");
        lblDepart.setFont(new Font("Myriad Pro Cond", Font.BOLD, 14));
        lblDepart.setBounds(26, 150, 74, 30);
        panel.add(lblDepart);
        
        lblSalary = new JLabel("Salary :");
        lblSalary.setFont(new Font("Myriad Pro Cond", Font.BOLD, 14));
        lblSalary.setBounds(26, 211, 74, 30);
        panel.add(lblSalary);
        
        textFieldName = new JTextField();
        textFieldName.setBounds(110, 42, 306, 38);
        panel.add(textFieldName);
        textFieldName.setColumns(10);
        
        textFieldSurname = new JTextField();
        textFieldSurname.setColumns(10);
        textFieldSurname.setBounds(110, 97, 306, 38);
        panel.add(textFieldSurname);
        
        textFieldDepart = new JTextField();
        textFieldDepart.setColumns(10);
        textFieldDepart.setBounds(110, 146, 306, 38);
        panel.add(textFieldDepart);
        
        textFieldSalary = new JTextField();
        textFieldSalary.setColumns(10);
        textFieldSalary.setBounds(110, 207, 306, 38);
        panel.add(textFieldSalary);
        
        JLabel lblMesaj = new JLabel("");
        lblMesaj.setForeground(Color.RED);
        lblMesaj.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMesaj.setHorizontalTextPosition(SwingConstants.LEFT);
        lblMesaj.setBounds(42, 269, 362, 30);
        panel.add(lblMesaj);
        
        JButton btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblMesaj.setText("");
        		String ad = textFieldName.getText();
        		String soyad = textFieldSurname.getText();
        		String departman = textFieldDepart.getText();
        		String maas = textFieldSalary.getText();
        		
        		islemler.calisanEkle(ad,soyad,departman,maas);
        		calisanGoruntule();
        		lblMesaj.setText("New Employee :" + ad + " is added.");
        	}
        });
        btnAddEmployee.setBackground(new Color(50, 205, 50));
        btnAddEmployee.setForeground(Color.WHITE);
        btnAddEmployee.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnAddEmployee.setBounds(630, 65, 152, 38);
        panel.add(btnAddEmployee);
        
        btnUpdateEmployee = new JButton("Update Employee");
        btnUpdateEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblMesaj.setText("");
        		String ad = textFieldName.getText();
        		String soyad = textFieldSurname.getText();
        		String departman = textFieldDepart.getText();
        		String maas = textFieldSalary.getText();
        		int selectedRow = table.getSelectedRow();
        		if(selectedRow == -1) {
        			if(dtm.getRowCount() == 0) {
        				lblMesaj.setText("Employee table is empty now");
        			}
        			else {
        				lblMesaj.setText("Please select an employee");
        			}
        		}
        		else {
        			
        		}
        		int id = (int) dtm.getValueAt(selectedRow, 0);
        		islemler.calisanGuncelle(id, ad, soyad, departman, maas);
        		calisanGoruntule();
        		lblMesaj.setText("Employee :" + ad + " is updated.");
        	}
        });
        btnUpdateEmployee.setForeground(Color.WHITE);
        btnUpdateEmployee.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnUpdateEmployee.setBackground(new Color(255, 140, 0));
        btnUpdateEmployee.setBounds(630, 126, 152, 38);
        panel.add(btnUpdateEmployee);
        
        btnDeleteEmployee = new JButton("Delete Employee");
        btnDeleteEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblMesaj.setText("");
        		String ad = textFieldName.getText();
        		int selectedRow = table.getSelectedRow();
        		if(selectedRow == -1) {
        			if(dtm.getRowCount() == 0) {
        				lblMesaj.setText("Employee table is empty now");
        			}
        			else {
        				lblMesaj.setText("Please select an employee");
        			}
        		}
            	else {
            		int id = (int) dtm.getValueAt(selectedRow, 0);
            		islemler.calisanSil(id);
            		calisanGoruntule();
            		lblMesaj.setText("Employee :" + ad + " is deleted.");
            	}
        	}
        	
        });
        btnDeleteEmployee.setForeground(Color.WHITE);
        btnDeleteEmployee.setFont(new Font("Arial Black", Font.PLAIN, 11));
        btnDeleteEmployee.setBackground(new Color(220, 20, 60));
        btnDeleteEmployee.setBounds(630, 188, 152, 38);
        panel.add(btnDeleteEmployee);
        
        JLabel lblNewLabel = new JLabel("Add Employee :");
        lblNewLabel.setBounds(238, 69, 156, 24);
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        contentPane.add(lblNewLabel);
        
        // contentPane.add(table); //comment it...

        //dtm.addRow(title); doesn't required because already header is there...
        //pack();
        calisanGoruntule();
      
    }
    public void dinamikAra(String ara) {
    	TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
    	table.setRowSorter(tr);
    	
    	tr.setRowFilter(RowFilter.regexFilter(ara));
    }
   
}