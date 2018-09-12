package mainPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.CardLayout;

public class Login {

	static Point mouseCoord;
	
	public JFrame loginWindow;
	private JTextField Username;
	private JPasswordField Password;
	private JLabel LoginErr;
	private JTextField UsernameR;
	private JPasswordField PasswordR;
	private JPasswordField ConfirmPasswordR;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the loginWindow.
	 */
	private void initialize() {
		loginWindow = new JFrame("Trit - Chat Application");
		loginWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/tritapp-icon.png")));
		loginWindow.setUndecorated(true);
		loginWindow.setBounds(100, 100, 450, 400);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel CustomTitleBar = new JPanel();
		CustomTitleBar.setBackground(new Color(153, 51, 255));
		loginWindow.getContentPane().add(CustomTitleBar, BorderLayout.NORTH);
		CustomTitleBar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point mouseCurrCoord = e.getLocationOnScreen();
				loginWindow.setLocation(mouseCurrCoord.x - mouseCoord.x, mouseCurrCoord.y - mouseCoord.y);
			}
		});
		CustomTitleBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseCoord = e.getPoint();
			}
			public void mouseReleased(MouseEvent e) {
				mouseCoord = null;
			}
		});
		
		JPanel TitleBg = new JPanel();
		TitleBg.setBackground(new Color(153, 51, 255));
		TitleBg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel TitleName = new JLabel("Trit");
		TitleName.setForeground(Color.WHITE);
		TitleName.setFont(new Font("Oswald SemiBold", Font.PLAIN, 20));
		TitleBg.add(TitleName);
		
		JLabel TitleDesc = new JLabel("- Chat Application");
		TitleDesc.setForeground(Color.WHITE);
		TitleBg.add(TitleDesc);
		
		JLabel AppMinimizeBtn = new JLabel("\u2212");
		AppMinimizeBtn.setForeground(Color.WHITE);
		AppMinimizeBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		AppMinimizeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Border borderBtnHvr = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
				AppMinimizeBtn.setBorder(borderBtnHvr);
			}
			public void mouseExited(MouseEvent arg0) {
				Border borderBtnHvr = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
				AppMinimizeBtn.setBorder(borderBtnHvr);
			}
			public void mouseClicked(MouseEvent e) {
				loginWindow.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel AppCloseBtn = new JLabel("\u00D7");
		AppCloseBtn.setForeground(Color.WHITE);
		AppCloseBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		AppCloseBtn.setBackground(Color.GRAY);
		AppCloseBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				Border borderBtnHvr = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
				AppCloseBtn.setBorder(borderBtnHvr);
			}
			public void mouseExited(MouseEvent arg0) {
				Border borderBtnHvr = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
				AppCloseBtn.setBorder(borderBtnHvr);
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		GroupLayout gl_CustomTitleBar = new GroupLayout(CustomTitleBar);
		gl_CustomTitleBar.setHorizontalGroup(
			gl_CustomTitleBar.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 500, Short.MAX_VALUE)
				.addGroup(gl_CustomTitleBar.createSequentialGroup()
					.addGap(23)
					.addComponent(TitleBg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
					.addComponent(AppMinimizeBtn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(AppCloseBtn)
					.addGap(28))
		);
		gl_CustomTitleBar.setVerticalGroup(
			gl_CustomTitleBar.createParallelGroup(Alignment.LEADING)
				.addGap(0, 53, Short.MAX_VALUE)
				.addGroup(gl_CustomTitleBar.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_CustomTitleBar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CustomTitleBar.createParallelGroup(Alignment.BASELINE)
							.addComponent(AppCloseBtn)
							.addComponent(AppMinimizeBtn))
						.addComponent(TitleBg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		CustomTitleBar.setLayout(gl_CustomTitleBar);
		
		JPanel BottomBorder = new JPanel();
		loginWindow.getContentPane().add(BottomBorder, BorderLayout.SOUTH);
		BottomBorder.setBackground(new Color(153, 51, 255));
		
		JPanel Panels = new JPanel();
		loginWindow.getContentPane().add(Panels, BorderLayout.CENTER);
		Panels.setLayout(new CardLayout(0, 0));
		
		JPanel LoginForm = new JPanel();
		Panels.add(LoginForm, "name_875503168516230");
		
		Username = new JTextField();
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102, 51, 255)));
		Username.setColumns(10);
		
		JLabel UsernameLbl = new JLabel("Username");
		UsernameLbl.setLabelFor(Username);
		
		JLabel PasswordLbl = new JLabel("Password");
		PasswordLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton LoginBtn = new JButton("Login");
		LoginBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				//LOGIN check start
				LoginErr.setText("");
				DBConn con = new DBConn();
				String username = Username.getText();
				ResultSet rs = con.RunQuery("SELECT * FROM TritApp_Users WHERE username = '"+username+"'");
				try {
					while(rs.next()) {
						
						String passFromDB = rs.getString(3);
						String pass = new String(Password.getPassword());
						if(pass.equals(passFromDB)) {
							MainChat mainChatWindow = new MainChat();
							mainChatWindow.mainWindow.setVisible(true);
							loginWindow.setVisible(false);
							MainChat.currentUser = username;
							MainChat.currentUserID = rs.getInt(1);
						}else {
							LoginErr.setText("Wrong password!");
						}
						break;
						
					}
					con.con.close();
				}catch(Exception e) {
					LoginErr.setText("Error retrieving data!");
				}
				con = null;
				if(LoginErr.getText().equals("") && !username.equals("")) {
					LoginErr.setText("This user does not exist!");
				}
				//LOGIN check end
			}
		});
		LoginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LoginBtn.setForeground(Color.WHITE);
		LoginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginBtn.setBackground(new Color(153, 51, 255));
		LoginBtn.setContentAreaFilled(false);
		LoginBtn.setOpaque(true);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(153, 51, 255));
		lblLogin.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		LoginErr = new JLabel("");
		LoginErr.setForeground(new Color(204, 0, 0));
		LoginErr.setHorizontalAlignment(SwingConstants.CENTER);
		
		Password = new JPasswordField();
		PasswordLbl.setLabelFor(Password);
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 51, 255)));
		
		JButton RegisterFormBtn = new JButton("Register");
		RegisterFormBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RegisterFormBtn.setContentAreaFilled(false);
		RegisterFormBtn.setOpaque(true);
		RegisterFormBtn.setForeground(Color.WHITE);
		RegisterFormBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RegisterFormBtn.setBackground(new Color(153, 51, 255));
		GroupLayout gl_LoginForm = new GroupLayout(LoginForm);
		gl_LoginForm.setHorizontalGroup(
			gl_LoginForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginForm.createSequentialGroup()
					.addGroup(gl_LoginForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LoginForm.createSequentialGroup()
							.addGap(195)
							.addComponent(lblLogin))
						.addGroup(gl_LoginForm.createSequentialGroup()
							.addGap(117)
							.addGroup(gl_LoginForm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_LoginForm.createSequentialGroup()
									.addComponent(PasswordLbl, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
									.addGap(163))
								.addComponent(Username, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addGroup(gl_LoginForm.createSequentialGroup()
									.addComponent(UsernameLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(163))
								.addComponent(Password, 211, 211, 211))))
					.addGap(122))
				.addGroup(gl_LoginForm.createSequentialGroup()
					.addGap(177)
					.addComponent(LoginBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(182))
				.addGroup(gl_LoginForm.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(LoginErr, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(gl_LoginForm.createSequentialGroup()
					.addGap(178)
					.addComponent(RegisterFormBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(181))
		);
		gl_LoginForm.setVerticalGroup(
			gl_LoginForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LoginForm.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(UsernameLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Username, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PasswordLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Password, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(LoginBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(LoginErr)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(RegisterFormBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		LoginForm.setLayout(gl_LoginForm);
		
		JPanel RegisterForm = new JPanel();
		Panels.add(RegisterForm, "name_875646975233815");
		
		JButton LoginRBtn = new JButton("Login");
		LoginRBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LoginRBtn.setContentAreaFilled(false);
		LoginRBtn.setOpaque(true);
		LoginRBtn.setForeground(Color.WHITE);
		LoginRBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LoginRBtn.setBackground(new Color(153, 51, 255));
		
		JLabel RegisterHead = new JLabel("Register");
		RegisterHead.setForeground(new Color(153, 51, 255));
		RegisterHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		JLabel PasswordRLbl = new JLabel("Password");
		PasswordRLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		UsernameR = new JTextField();
		UsernameR.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameR.setColumns(10);
		UsernameR.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102, 51, 255)));
		
		JLabel UsernameRLbl = new JLabel("Username");
		
		JButton RegisterBtn = new JButton("Register");
		RegisterBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RegisterBtn.setContentAreaFilled(false);
		RegisterBtn.setOpaque(true);
		RegisterBtn.setForeground(Color.WHITE);
		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RegisterBtn.setBackground(new Color(153, 51, 255));
		
		JLabel RegisterErr = new JLabel("");
		RegisterErr.setHorizontalAlignment(SwingConstants.CENTER);
		RegisterErr.setForeground(new Color(204, 0, 0));
		
		PasswordR = new JPasswordField();
		PasswordR.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordR.setColumns(10);
		PasswordR.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102, 51, 255)));
		
		JLabel ConfirmPasswordRLbl = new JLabel("Confirm Password");
		ConfirmPasswordRLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		ConfirmPasswordR = new JPasswordField();
		ConfirmPasswordR.setHorizontalAlignment(SwingConstants.CENTER);
		ConfirmPasswordR.setColumns(10);
		ConfirmPasswordR.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(102, 51, 255)));
		GroupLayout gl_RegisterForm = new GroupLayout(RegisterForm);
		gl_RegisterForm.setHorizontalGroup(
			gl_RegisterForm.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_RegisterForm.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_RegisterForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(UsernameR, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(PasswordRLbl, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addGap(163))
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(PasswordR, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(UsernameRLbl, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
							.addGap(239))
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(ConfirmPasswordR, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
							.addGap(76))
						.addGroup(gl_RegisterForm.createSequentialGroup()
							.addComponent(ConfirmPasswordRLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(201)))
					.addGap(43))
				.addGroup(gl_RegisterForm.createSequentialGroup()
					.addGap(181)
					.addComponent(LoginRBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(178))
				.addGroup(gl_RegisterForm.createSequentialGroup()
					.addGap(180)
					.addComponent(RegisterBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(179))
				.addGroup(gl_RegisterForm.createSequentialGroup()
					.addGap(189)
					.addComponent(RegisterHead, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(178))
				.addGroup(Alignment.LEADING, gl_RegisterForm.createSequentialGroup()
					.addGap(43)
					.addComponent(RegisterErr, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addGap(43))
		);
		gl_RegisterForm.setVerticalGroup(
			gl_RegisterForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RegisterForm.createSequentialGroup()
					.addContainerGap()
					.addComponent(RegisterHead, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(UsernameRLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(UsernameR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PasswordRLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PasswordR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ConfirmPasswordRLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ConfirmPasswordR, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(RegisterBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(RegisterErr, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LoginRBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		RegisterForm.setLayout(gl_RegisterForm);
		
		//Panels actions
		RegisterFormBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				LoginForm.setVisible(false);
				RegisterForm.setVisible(true);
				RegisterErr.setText("");
			}
		});
		LoginRBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LoginForm.setVisible(true);
				RegisterForm.setVisible(false);
			}
		});
		RegisterBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String username = UsernameR.getText();
				String password = new String(PasswordR.getPassword());
				String confirmPassword = new String(ConfirmPasswordR.getPassword());
				boolean userExists = false;
				if(!password.equals(confirmPassword)) {
					RegisterErr.setText("Passwords don't match!");
				}else if(username.equals("") || password.equals("") || confirmPassword.equals("")){
					RegisterErr.setText("All fields are required!");
				}else {
					DBConn con = new DBConn();
					ResultSet rs = con.RunQuery("SELECT username FROM TritApp_Users WHERE username = '"+username+"'");
					try {
						while(rs.next()) {
							if(username.equals(rs.getString(1))) {
								userExists = true;
								break;
							}
						}
						if(userExists) {
							RegisterErr.setText("This username is already taken!");
						}else {
							con.st.executeUpdate("INSERT INTO TritApp_Users (username, userpassword) VALUES ('"+username+"', '"+password+"')");
							RegisterErr.setText("New user registered!");
						}
					}catch(Exception e) {
						RegisterErr.setText("Error retrieving data!");
					}
				}
			}
		});
		//Panels actions END
	}
}
