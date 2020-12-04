import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.TextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Admin extends JFrame {

	private JPanel contentPane;
	private Choice ed_choice;
	private JLayeredPane AdminScreen;
	private JPanel EditDonor;
	private JPanel Events;
	private JPanel ResetPassword;
	private JPanel SendMsg;
	private JPanel RegisterBloodBank;
	private JPanel AddAdmin;
	private JTextField rp_newpassword;
	private JTextField tu;
	private JTextField tp;
	private JTextField bb_name;
	private JTextField bb_rn;
	private JTextField bb_address;
	private JTextField bb_city;
	private JTextField bb_con;
	private TextArea notice;
	private JButton button;
	private JTextField dt;
	private JTextField con;
	public JLabel admin_name;
    public String a_name;
    private JTextField donor_id;
    private JTextField ed_name;
    private JTextField ed_mobile;
    private JTextField ed_city;
    private JTextField ed_id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				admin_name.setText(details.name.toUpperCase());
			}
		});

		setResizable(false);
		setTitle("Admin Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameOfAdmin = new JLabel("Hiii...");
		lblNameOfAdmin.setForeground(Color.WHITE);
		lblNameOfAdmin.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNameOfAdmin.setBounds(777, 13, 91, 42);
		contentPane.add(lblNameOfAdmin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setBounds(0, 87, 271, 609);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEditDoners = new JButton("Edit Doners");
		btnEditDoners.setForeground(Color.WHITE);
		btnEditDoners.setBackground(new Color(119, 136, 153));
		btnEditDoners.setBounds(12, 13, 247, 79);
		panel.add(btnEditDoners);
		btnEditDoners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ADD(EditDonor);
			}
		});
		btnEditDoners.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnEvents = new JButton("Events");
		btnEvents.setForeground(Color.WHITE);
		btnEvents.setBackground(new Color(119, 136, 153));
		btnEvents.setBounds(12, 105, 247, 89);
		panel.add(btnEvents);
		btnEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ADD(Events);
			}
		});
		btnEvents.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("Reset Password");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(119, 136, 153));
		btnNewButton_2.setBounds(12, 214, 247, 89);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ADD(ResetPassword);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("Send Msg");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(119, 136, 153));
		btnNewButton_1.setBounds(12, 316, 247, 79);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ADD(SendMsg);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Register Blood Bank");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(119, 136, 153));
		btnNewButton.setBounds(12, 408, 247, 87);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ADD(RegisterBloodBank);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnAddAdmin = new JButton("Add Admin");
		btnAddAdmin.setForeground(Color.WHITE);
		btnAddAdmin.setBackground(new Color(119, 136, 153));
		btnAddAdmin.setBounds(12, 508, 247, 86);
		panel.add(btnAddAdmin);
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ADD(AddAdmin);
			}
		});
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		AdminScreen = new JLayeredPane();
		AdminScreen.setBounds(283, 87, 785, 609);
		contentPane.add(AdminScreen);
		AdminScreen.setLayout(new CardLayout(0, 0));
		
		EditDonor = new JPanel();
		AdminScreen.add(EditDonor, "name_1454529127949");
		EditDonor.setLayout(null);
		
		JLabel lblEditDonor = new JLabel("Edit Donor");
		lblEditDonor.setForeground(Color.RED);
		lblEditDonor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEditDonor.setBounds(297, 13, 188, 56);
		EditDonor.add(lblEditDonor);
		
		JLabel lblDeleteDonor = new JLabel("Delete Donor");
		lblDeleteDonor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDeleteDonor.setBounds(45, 101, 176, 40);
		EditDonor.add(lblDeleteDonor);
		
		JLabel lblDeleteDonorBy = new JLabel("Delete Donor By Id");
		lblDeleteDonorBy.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDeleteDonorBy.setBounds(55, 164, 196, 42);
		EditDonor.add(lblDeleteDonorBy);
		
		donor_id = new JTextField();
		donor_id.setBounds(271, 167, 287, 45);
		EditDonor.add(donor_id);
		donor_id.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(donor_id.getText().compareTo("")==0)
				{
					JOptionPane.showMessageDialog(null,"Enter Id");
				}
				else
				{
					try
					{
							
						Connection cn=ConnectionClass.dbConnection();	
						Statement smt=cn.createStatement();
						ResultSet rr=smt.executeQuery("select * from donor where donor_id='"+donor_id.getText()+"'");
						if(rr.next())
						{
							smt.executeUpdate("DELETE FROM `donor` WHERE donor_id='"+donor_id.getText()+"'");
							JOptionPane.showMessageDialog(null, "Donor Deleted Sucessfully!!!");
							donor_id.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid ID!");
						}
							
					}
				  catch(SQLException e)
				  {
					  System.out.println(e);
				  }
				}
				
				
			}
		});
		btnDelete.setBounds(605, 160, 144, 56);
		EditDonor.add(btnDelete);
		
		JLabel lblUpdateDonor = new JLabel("Update Donor");
		lblUpdateDonor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpdateDonor.setBounds(45, 275, 196, 26);
		EditDonor.add(lblUpdateDonor);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(27, 342, 116, 31);
		EditDonor.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blood Group");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(503, 353, 129, 31);
		EditDonor.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(35, 441, 80, 31);
		EditDonor.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City /Village");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(35, 534, 129, 26);
		EditDonor.add(lblNewLabel_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
						
					Connection cn=ConnectionClass.dbConnection();	
					Statement smt=cn.createStatement();
					ResultSet rr=smt.executeQuery("select * from donor where donor_id='"+ed_id.getText()+"'");
					if(rr.next())
					{
						smt.executeUpdate("UPDATE `donor` SET `name`='"+ed_name.getText()+"',`blood_group`='"+ed_choice.getSelectedItem()+"',`mobile`='"+ed_mobile.getText()+"',`place`='"+ed_city.getText()+"' WHERE donor_id='"+ed_id.getText()+"'");
						JOptionPane.showMessageDialog(null, "Donor Data Updated Sucessfully!!!");
						ed_name.setText("");
						ed_mobile.setText("");
						ed_city.setText("");
						ed_id.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid ID");
					}
						
				}
			  catch(SQLException e)
			  {
				  System.out.println(e);
			  }
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnUpdate.setBounds(559, 495, 144, 65);
		EditDonor.add(btnUpdate);
		
		ed_name = new JTextField();
		ed_name.setBounds(150, 339, 293, 45);
		EditDonor.add(ed_name);
		ed_name.setColumns(10);
		
		ed_mobile = new JTextField();
		ed_mobile.setBounds(150, 436, 293, 48);
		EditDonor.add(ed_mobile);
		ed_mobile.setColumns(10);
		
		ed_city = new JTextField();
		ed_city.setBounds(164, 522, 279, 45);
		EditDonor.add(ed_city);
		ed_city.setColumns(10);
		
		 ed_choice = new Choice();
		ed_choice.setFont(new Font("Dialog", Font.PLAIN, 22));
		ed_choice.setBounds(651, 349, 112, 22);
		EditDonor.add(ed_choice);
		
		ed_choice.add("B+");
		ed_choice.add("O+");
		ed_choice.add("AB+");
		ed_choice.add("A-");
		ed_choice.add("B-");
		ed_choice.add("O-");
		ed_choice.add("AB-");
		
		Label label_1 = new Label("Donor id");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		label_1.setBounds(510, 419, 105, 31);
		EditDonor.add(label_1);
		
		ed_id = new JTextField();
		ed_id.setBounds(651, 410, 112, 42);
		EditDonor.add(ed_id);
		ed_id.setColumns(10);
		
		Events = new JPanel();
		AdminScreen.add(Events, "name_1460689187192");
		Events.setLayout(null);
		
		JLabel label = new JLabel("Blood camp Notice");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBounds(186, 13, 355, 53);
		Events.add(label);
		
		notice = new TextArea();
		notice.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		notice.setBounds(89, 155, 663, 199);
		Events.add(notice);
		
		button = new JButton("Post");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
						
					Connection cn=ConnectionClass.dbConnection();	
					Statement smt=cn.createStatement();
					String s=con.getText();
					if(validNumber(s))
					{
						con.setBackground(Color.white);
						smt.executeUpdate("INSERT INTO `news`( `date`,`contact`, `address`) VALUES ('"+dt.getText()+"','"+con.getText()+"','"+notice.getText()+"')");
						JOptionPane.showMessageDialog(null, "Post Inserted Sucessfully!!!");
						dt.setText("");
						con.setText("");
						notice.setText("");
					}
					else
					{
						con.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Enter Valid Number!!!");
					}
					
				}
			  catch(SQLException e)
			  {
				  System.out.println(e);
			  }
			
			
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setBounds(530, 542, 154, 38);
		Events.add(button);
		
		dt = new JTextField();
		dt.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		dt.setBounds(401, 392, 263, 43);
		Events.add(dt);
		dt.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDate.setBounds(235, 406, 84, 29);
		Events.add(lblDate);
		
		JLabel lblContactNumber_1 = new JLabel("Contact Number");
		lblContactNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContactNumber_1.setBounds(126, 465, 233, 38);
		Events.add(lblContactNumber_1);
		
		con = new JTextField();
		con.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		con.setBounds(401, 465, 263, 38);
		Events.add(con);
		con.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Write Notice...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(89, 99, 206, 38);
		Events.add(lblNewLabel);
		
		ResetPassword = new JPanel();
		AdminScreen.add(ResetPassword, "name_1465842365458");
		ResetPassword.setLayout(null);
		
		JLabel label_3 = new JLabel("New Password");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(251, 206, 209, 48);
		ResetPassword.add(label_3);
		
		rp_newpassword = new JTextField();
		rp_newpassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rp_newpassword.setColumns(10);
		rp_newpassword.setBounds(179, 302, 413, 42);
		ResetPassword.add(rp_newpassword);
		
		JButton button_1 = new JButton("Reset");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection cn=ConnectionClass.dbConnection();	
				Statement smt;
				if(rp_newpassword.getText().compareTo("")==0)
				{
					JOptionPane.showMessageDialog(null,"Password is Empty!");
				}
				else
				{
					try {
						smt = cn.createStatement();
						smt.executeUpdate("UPDATE `admin` SET `upass`='"+rp_newpassword.getText()+"' WHERE uname='"+details.name+"'");
						JOptionPane.showMessageDialog(null, "Password Change Sucessfully!!!");
						rp_newpassword.setText("");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_1.setBounds(285, 424, 123, 43);
		ResetPassword.add(button_1);
		
		JLabel lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setForeground(Color.RED);
		lblResetPassword.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblResetPassword.setBounds(224, 61, 313, 56);
		ResetPassword.add(lblResetPassword);
		
		SendMsg = new JPanel();
		AdminScreen.add(SendMsg, "name_1602543506305");
		SendMsg.setLayout(null);
		
		JLabel lblSendMsg = new JLabel("Send Msg");
		lblSendMsg.setForeground(Color.RED);
		lblSendMsg.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblSendMsg.setBounds(315, 13, 165, 60);
		SendMsg.add(lblSendMsg);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(112, 146, 595, 225);
		SendMsg.add(textArea_1);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 25));
		choice.setBounds(313, 433, 334, 22);
		SendMsg.add(choice);
		
		Label label_7 = new Label("Write Massege....");
		label_7.setFont(new Font("Dialog", Font.BOLD, 25));
		label_7.setBounds(116, 79, 234, 39);
		SendMsg.add(label_7);
		
		Label label_8 = new Label("Select City");
		label_8.setFont(new Font("Dialog", Font.BOLD, 25));
		label_8.setBounds(116, 438, 165, 24);
		SendMsg.add(label_8);
		
		Button button_3 = new Button("Send");
		button_3.setFont(new Font("Dialog", Font.PLAIN, 25));
		button_3.setBounds(338, 519, 116, 53);
		SendMsg.add(button_3);
		
		RegisterBloodBank = new JPanel();
		AdminScreen.add(RegisterBloodBank, "name_1607536847636");
		RegisterBloodBank.setLayout(null);
		
		JLabel label_6 = new JLabel("Blood Bank Register");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 32));
		label_6.setBounds(258, 28, 329, 47);
		RegisterBloodBank.add(label_6);
		
		JLabel lblBloodBankName = new JLabel("Blood Bank Name");
		lblBloodBankName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBloodBankName.setBounds(65, 130, 218, 47);
		RegisterBloodBank.add(lblBloodBankName);
		
		JLabel lblBloodBankRegistration = new JLabel("Blood Bank Registration Number");
		lblBloodBankRegistration.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBloodBankRegistration.setBounds(65, 215, 329, 35);
		RegisterBloodBank.add(lblBloodBankRegistration);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdress.setBounds(65, 296, 125, 35);
		RegisterBloodBank.add(lblAdress);
		
		JLabel lblVillagecityName = new JLabel("Village/City Name");
		lblVillagecityName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVillagecityName.setBounds(65, 383, 218, 47);
		RegisterBloodBank.add(lblVillagecityName);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblContactNumber.setBounds(65, 466, 198, 35);
		RegisterBloodBank.add(lblContactNumber);
		
		bb_name = new JTextField();
		bb_name.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bb_name.setBounds(358, 135, 329, 44);
		RegisterBloodBank.add(bb_name);
		bb_name.setColumns(10);
		
		bb_rn = new JTextField();
		bb_rn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bb_rn.setBounds(406, 213, 281, 47);
		RegisterBloodBank.add(bb_rn);
		bb_rn.setColumns(10);
		
		bb_address = new JTextField();
		bb_address.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bb_address.setBounds(258, 290, 429, 47);
		RegisterBloodBank.add(bb_address);
		bb_address.setColumns(10);
		
		bb_city = new JTextField();
		bb_city.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bb_city.setBounds(358, 387, 329, 47);
		RegisterBloodBank.add(bb_city);
		bb_city.setColumns(10);
		
		bb_con = new JTextField();
		bb_con.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bb_con.setBounds(358, 464, 329, 47);
		RegisterBloodBank.add(bb_con);
		bb_con.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Register");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection cn=ConnectionClass.dbConnection();	
				Statement smt;
				if(bb_name.getText().compareTo("")==0|| bb_rn.getText().compareTo("")==0||bb_address.getText().compareTo("")==0||bb_con.getText().compareTo("")==0||bb_city.getText().compareTo("")==0)
				{
					JOptionPane.showMessageDialog(null,"PLZ Enter Complete Information!!!");
				}
				else
				{
					if(validNumber(bb_con.getText()))
					{
						bb_con.setBackground(Color.white);
						try {
							smt = cn.createStatement();
							smt.executeUpdate("INSERT INTO `bloodbanks`(`bbname`, `bbrno`, `address`, `contact`, `city`) VALUES ('"+bb_name.getText()+"','"+bb_rn.getText()+"','"+bb_address.getText()+"','"+bb_con.getText()+"','"+bb_city.getText()+"')");
							JOptionPane.showMessageDialog(null, "Blood Bank Registered Sucessfully!!!");
							bb_name.setText("");
							bb_rn.setText("");
							bb_address.setText("");
							bb_con.setText("");
							bb_city.setText("");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						bb_con.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null, "Invalid Contact Number");
					}
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(291, 542, 154, 44);
		RegisterBloodBank.add(btnNewButton_3);
		
		AddAdmin = new JPanel();
		AdminScreen.add(AddAdmin, "name_1735362821451");
		AddAdmin.setLayout(null);
		
		JLabel label_4 = new JLabel("Admin's  Username ");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_4.setBounds(85, 189, 228, 43);
		AddAdmin.add(label_4);
		
		JLabel label_5 = new JLabel("Admin's  Password");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_5.setBounds(97, 317, 216, 26);
		AddAdmin.add(label_5);
		
		tu = new JTextField();
		tu.setColumns(10);
		tu.setBounds(385, 190, 314, 48);
		AddAdmin.add(tu);
		
		tp = new JTextField();
		tp.setColumns(10);
		tp.setBounds(385, 310, 314, 48);
		AddAdmin.add(tp);
		
		JButton button_2 = new JButton("ADD AS ADMIN");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection cn=ConnectionClass.dbConnection();	
				Statement smt = null;
				try {
					smt = cn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = smt.executeQuery("select * from admin where uname='"+tu.getText()+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if(rs.next())
					{
						tu.setBackground(Color.yellow);
						JOptionPane.showMessageDialog(null,"Username Exits!!!");
					}
					else
					{
						if(tu.getText().compareTo("")==0||tp.getText().compareTo("")==0)
						{
							JOptionPane.showMessageDialog(null,"Username or Password Empty!!");
						}
						else
						{
							try {
								
								smt.executeUpdate("INSERT INTO `admin`(`uname`, `upass`) VALUES ('"+tu.getText()+"','"+tp.getText()+"')");
								JOptionPane.showMessageDialog(null, "ADMIN Add Sucessfully!!!");
								tu.setText("");
								tp.setText("");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(268, 454, 178, 62);
		AddAdmin.add(button_2);
		
		JLabel lblAddAdmin = new JLabel("ADD ADMIN");
		lblAddAdmin.setForeground(Color.RED);
		lblAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAddAdmin.setBounds(280, 46, 211, 53);
		AddAdmin.add(lblAddAdmin);
		
		admin_name = new JLabel("Name");
		admin_name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		admin_name.setForeground(Color.RED);
		admin_name.setBounds(906, 18, 156, 36);
		contentPane.add(admin_name);
		
		JLabel lblAsDonor = new JLabel("Login as Donor");
		lblAsDonor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Index iobj=new Index();
				iobj.setVisible(true);
				dispose();
			}
		});
		lblAsDonor.setForeground(Color.WHITE);
		lblAsDonor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAsDonor.setBounds(42, 11, 156, 57);
		contentPane.add(lblAsDonor);
	}

	protected boolean validNumber(String s) {
		Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m=p.matcher(s);
		return (m.find() && m.group().equals(s));
		
	}

	protected void ADD(JPanel s) {
	AdminScreen.removeAll();
	AdminScreen.add(s);
	AdminScreen.repaint();
	AdminScreen.revalidate();
	}
}
