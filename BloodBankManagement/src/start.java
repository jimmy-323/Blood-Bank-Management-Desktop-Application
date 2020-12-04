import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class start extends JFrame {

	private JPanel contentPane;
	public Timer t;
	private final JProgressBar pb = new JProgressBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
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
	public start() {
		setResizable(false);
		setTitle("BBMS");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				t=new Timer(100, new proces());
				t.start();
			}

			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pb.setOpaque(true);
		pb.setStringPainted(true);
		pb.setForeground(new Color(32, 178, 170));
		pb.setBounds(0, 347, 676, 36);
		contentPane.add(pb);
		
		JLabel lblBloodBankManagement = new JLabel("Blood Bank Management ");
		lblBloodBankManagement.setForeground(Color.RED);
		lblBloodBankManagement.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblBloodBankManagement.setBounds(24, 34, 640, 153);
		contentPane.add(lblBloodBankManagement);
	}

public class proces  implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int n=pb.getValue();
			if(n<=99) {
				n++;
				pb.setValue(n);
			}
			else
			{
				t.stop();
				Login ll=new Login();
				ll.setVisible(true);
				dispose();
			}
			
		}

	}
}
