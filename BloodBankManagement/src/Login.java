import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JPasswordField pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.WHITE);
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLogin.setBounds(144, 13, 129, 49);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsername.setBounds(38, 107, 129, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(38, 199, 118, 36);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(192, 107, 210, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login As Admin");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)  {
				Connection lcn=ConnectionClass.dbConnection();
				try {
					Statement smt=lcn.createStatement();
					details.name=textField.getText();
					@SuppressWarnings("deprecation")
					ResultSet rs=smt.executeQuery("select * from admin where uname='"+textField.getText()+"' and upass='"+pswd.getText()+"'");
					
					
					if(rs.next())
					{
							JOptionPane.showMessageDialog(null,"sucessfull Login!!!");
							
							Admin ad=new Admin();
							ad.setVisible(true);
						    dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Error !!!! Username or Password are Incorrect");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(144, 269, 129, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(144, 300, 8, 36);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Login As Donor");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Index i=new Index();
				i.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(167, 306, 134, 28);
		contentPane.add(lblNewLabel_2);
		
		pswd = new JPasswordField();
		pswd.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		pswd.setBounds(192, 199, 210, 36);
		contentPane.add(pswd);
	}
}
