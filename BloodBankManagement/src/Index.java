import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JPanel HOME;
	private JPanel RegisterDonor;
	private JPanel FindBloodBank;
	private JPanel News;
	private JPanel AboutUs;
	private JLayeredPane screen;
	private JTextField dname;
	private JTextField dmobile;
	private JTextField dplace;
	private JPanel finddonor;
	private JLabel lblFindDonor;
	private Choice dgroup;
	private JTextField cty;
	private JTable n;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTable stable;
	private Choice grp;
	private JScrollPane scrollPane_1;
	private Choice choice;
	private JTable bloodbank_table;
	protected boolean c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				news();
			}
		});
		setTitle("BBM");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel SideMenu = new JPanel();
		SideMenu.setBackground(Color.RED);
		SideMenu.setBounds(3, 178, 249, 516);
		contentPane.add(SideMenu);
		SideMenu.setLayout(null);
		
		btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 load(HOME);
			}
		});
		btnNewButton.setBounds(12, 21, 224, 64);
		SideMenu.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Register Doner");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				load(RegisterDonor);
			}
		});
		btnNewButton_1.setBounds(12, 98, 224, 52);
		SideMenu.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Find Donor");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				load(finddonor);
			}
		});
		btnNewButton_2.setBounds(12, 163, 224, 52);
		SideMenu.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Find Blood Bank");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load(FindBloodBank);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(12, 228, 224, 58);
		SideMenu.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("News and Events");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load(News);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBounds(12, 299, 224, 58);
		SideMenu.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("About Us");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load(AboutUs);
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBounds(12, 370, 224, 58);
		SideMenu.add(btnNewButton_5);
		
		JPanel Nevigation = new JPanel();
		Nevigation.setBackground(Color.RED);
		Nevigation.setBounds(91, 0, 972, 117);
		contentPane.add(Nevigation);
		Nevigation.setLayout(null);
		
		JLabel lblBloodBank = new JLabel("Blood Bank Management System");
		lblBloodBank.setForeground(Color.WHITE);
		lblBloodBank.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblBloodBank.setBounds(253, 26, 686, 64);
		Nevigation.add(lblBloodBank);
		
		screen = new JLayeredPane();
		screen.setBounds(264, 130, 906, 577);
		contentPane.add(screen);
		screen.setLayout(new CardLayout(0, 0));
		
		HOME = new JPanel();
		screen.add(HOME, "name_288896131836");
		HOME.setBackground(Color.WHITE);
		HOME.setLayout(null);
		
		JLabel lblBloodBankManagement = new JLabel("Blood bank Management System");
		lblBloodBankManagement.setForeground(Color.RED);
		lblBloodBankManagement.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBloodBankManagement.setBounds(135, 30, 594, 60);
		HOME.add(lblBloodBankManagement);
		
		FindBloodBank = new JPanel();
		FindBloodBank.setBackground(Color.WHITE);
		screen.add(FindBloodBank, "name_3103790413076");
		FindBloodBank.setLayout(null);
		
		JLabel lblFindBloodBank = new JLabel("Find Blood Bank");
		lblFindBloodBank.setFont(new Font("Traditional Arabic", Font.BOLD, 35));
		lblFindBloodBank.setBounds(208, 13, 282, 42);
		FindBloodBank.add(lblFindBloodBank);
		
		choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 26));
		choice.setBounds(266, 96, 349, 22);
		FindBloodBank.add(choice);
		choice.add("Dhamangaon");
		choice.add("Amravti");
		choice.add("Yavatmal");
		choice.add("Wardha");
		choice.add("Nagpur");
		
		Label label = new Label("Village/ City");
		label.setFont(new Font("Traditional Arabic", Font.BOLD, 23));
		label.setBounds(57, 92, 148, 44);
		FindBloodBank.add(label);
		
		Button button = new Button("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
						
					Connection cnn=ConnectionClass.dbConnection();	
					Statement smt=cnn.createStatement();
					ResultSet rs=smt.executeQuery("select * from bloodbanks where city='"+choice.getSelectedItem()+"'");
					bloodbank_table.setModel(DbUtils.resultSetToTableModel(rs));
				    
				}
			  catch(SQLException e)
			  {
				  System.out.println(e);
			 }
			}
		});
		button.setBounds(655, 96, 79, 40);
		FindBloodBank.add(button);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 160, 844, 404);
		FindBloodBank.add(scrollPane_2);
		
		bloodbank_table = new JTable();
		scrollPane_2.setViewportView(bloodbank_table);
		
		News = new JPanel();
		News.setBackground(Color.WHITE);
		screen.add(News, "name_1730400798012");
		News.setLayout(null);
		
		JLabel lblNews = new JLabel("Blood Donation Camps");
		lblNews.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNews.setBounds(199, 13, 336, 47);
		News.add(lblNews);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 73, 855, 484);
		News.add(scrollPane);
		
		n = new JTable();
		n.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		n.setForeground(Color.RED);
		n.setRowHeight(80);
		n.setRowMargin(10);
		n.setRowSelectionAllowed(false);
		n.setShowVerticalLines(false);
		n.setShowGrid(false);
		scrollPane.setViewportView(n);
		n.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		n.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		AboutUs = new JPanel();
		AboutUs.setBackground(Color.WHITE);
		screen.add(AboutUs, "name_1876661150900");
		AboutUs.setLayout(null);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setForeground(new Color(255, 0, 0));
		lblAboutUs.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblAboutUs.setBounds(345, 26, 181, 63);
		AboutUs.add(lblAboutUs);
		
		RegisterDonor = new JPanel();
		screen.add(RegisterDonor, "name_2375444027516");
		RegisterDonor.setBackground(Color.WHITE);
		RegisterDonor.setLayout(null);
		
		JLabel lblRegisterDonor = new JLabel("Register Donor");
		lblRegisterDonor.setFont(new Font("Bell MT", Font.BOLD, 35));
		lblRegisterDonor.setBounds(267, 46, 271, 35);
		RegisterDonor.add(lblRegisterDonor);
		
		JLabel lblNamerequired = new JLabel("Full Name ");
		lblNamerequired.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNamerequired.setBounds(44, 142, 182, 47);
		RegisterDonor.add(lblNamerequired);
		
		JLabel lblNewLabel_3 = new JLabel("Blood Group");
		lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNewLabel_3.setBounds(44, 238, 215, 27);
		RegisterDonor.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile");
		lblNewLabel_5.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNewLabel_5.setBounds(47, 318, 250, 27);
		RegisterDonor.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Village/City");
		lblNewLabel_7.setFont(new Font("Traditional Arabic", Font.BOLD, 30));
		lblNewLabel_7.setBounds(47, 387, 250, 35);
		RegisterDonor.add(lblNewLabel_7);
		
		dname = new JTextField();
		dname.setBounds(309, 151, 404, 35);
		RegisterDonor.add(dname);
		dname.setColumns(10);
		
		dmobile = new JTextField();
		dmobile.setBounds(309, 317, 244, 35);
		RegisterDonor.add(dmobile);
		dmobile.setColumns(10);
		
		dplace = new JTextField();
		dplace.setBounds(309, 390, 244, 35);
		RegisterDonor.add(dplace);
		dplace.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("register");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
						
					if(dname.getText().compareTo("")==0 ||dgroup.getSelectedItem().compareTo("")==0||dmobile.getText().compareTo("")==0||dplace.getText().compareTo("")==0)
					  {
						JOptionPane.showMessageDialog(null,"Fill complete Form!!!");
					  }
					else
					  {
						Connection cnn=ConnectionClass.dbConnection();	
						Statement smt=cnn.createStatement();
						String s=dmobile.getText();
						
						  if( validNumber(s))
						  {
							   smt.executeUpdate("INSERT INTO `donor`(`name`, `blood_group`, `mobile`, `place`) VALUES ('"+dname.getText()+"','"+dgroup.getSelectedItem()+"','"+dmobile.getText()+"','"+dplace.getText().toLowerCase()+"')");
							   dname.setText(""); dmobile.setText(""); dplace.setText("");
								JOptionPane.showMessageDialog(null,"Donar Register!!");
								dmobile.setBackground(Color.white);
								dname.setText("");
								dmobile.setText("");
								dplace.setText("");
						  }
						  else
						  {
							  dmobile.setBackground(Color.yellow);
							  JOptionPane.showMessageDialog(null,"InValid Number");
						  }
					  }
								
				 }
			  catch(SQLException e)
			  {
				  System.out.println(e);
			  }
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_7.setBounds(272, 488, 123, 47);
		RegisterDonor.add(btnNewButton_7);
		
		dgroup = new Choice();
		dgroup.setFont(new Font("Dialog", Font.PLAIN, 20));
		dgroup.setBounds(309, 238, 188, 22);
		RegisterDonor.add(dgroup);
		dgroup.add("A+");
		dgroup.add("B+");
		dgroup.add("O+");
		dgroup.add("AB+");
		dgroup.add("A-");
		dgroup.add("B-");
		dgroup.add("O-");
		dgroup.add("AB-");
		
		
		finddonor = new JPanel();
		finddonor.setAutoscrolls(true);
		finddonor.setName("");
		finddonor.setBackground(Color.WHITE);
		screen.add(finddonor, "name_2286525968242");
		finddonor.setLayout(null);
		
		lblFindDonor = new JLabel("Find Donor");
		lblFindDonor.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblFindDonor.setBounds(281, 13, 179, 58);
		finddonor.add(lblFindDonor);
		
		JLabel lblNewLabel = new JLabel(" Blood Group");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(52, 88, 197, 37);
		finddonor.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Village/ City");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(64, 158, 197, 37);
		finddonor.add(lblNewLabel_1);
		
		cty = new JTextField();
		cty.setBounds(288, 159, 302, 43);
		finddonor.add(cty);
		cty.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Search");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
						
					Connection cnn=ConnectionClass.dbConnection();	
					Statement smt=cnn.createStatement();
					String s=cty.getText().toLowerCase();
					
					if(s.compareToIgnoreCase("")==0)
					{
						cty.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null,"Enter City!!");
						
					}
					else
					{
						cty.setBackground(Color.white);
						ResultSet rs=smt.executeQuery("select * from donor where blood_group='"+grp.getSelectedItem()+"' and place='"+cty.getText()+"'");
						stable.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
					
				    
				}
			  catch(SQLException e)
			  {
				  System.out.println(e);
			 }
			}
		});
		btnNewButton_8.setBounds(625, 115, 148, 49);
		finddonor.add(btnNewButton_8);
		
		grp = new Choice();
		grp.setBackground(Color.WHITE);
		grp.setFont(new Font("Dialog", Font.PLAIN, 23));
		grp.setBounds(288, 89, 302, 36);
		finddonor.add(grp);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 236, 854, 328);
		finddonor.add(scrollPane_1);
		
		stable = new JTable();
		stable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		stable.getColumnModel().getColumn(0).setMinWidth(30);
		stable.setName("Donor INFO");
		stable.setSize(new Dimension(20, 20));
		stable.setRowMargin(10);
		stable.setRowHeight(40);
		stable.setFont(new Font("Tahoma", Font.PLAIN, 23));
		scrollPane_1.setViewportView(stable);
		
		lblNewLabel_2 = new JLabel("Admin");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login lg=new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(1087, 74, 95, 43);
		contentPane.add(lblNewLabel_2);
		grp.add("A+");
		grp.add("B+");
		grp.add("O+");
		grp.add("AB+");
		grp.add("A-");
		grp.add("B-");
		grp.add("O-");
		grp.add("AB-");
	}

	

	protected boolean validNumber(String s) {
		Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m=p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	protected void news() {
       try
       {
    	   Connection cn=ConnectionClass.dbConnection();
    	   PreparedStatement smt=null;
    	   String sql="select * from news";
			smt=cn.prepareStatement(sql);
			ResultSet r=smt.executeQuery();
		    n.setModel(DbUtils.resultSetToTableModel(r));
    	   
       }
       catch(Exception e)
       {
    	   System.out.println(e);
       }
		
	}

	protected void load(JPanel J) {
		screen.removeAll();
		screen.add(J);
		screen.repaint();
		screen.revalidate();
		
	}
}
