package mainPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;

public class MainChat {
	
	public static String currentUser;
	public static int currentUserID;
	public static String chatUser;
	public static int chatUserID;
	public static int currentGroupID;
	
	static Point mouseCoord; //For moving the undecorated

	JFrame mainWindow;
	private JTextField GroupNameField;
	private JTextField NewUsername;
	private JPasswordField CurrentPassword;
	private JPasswordField NewPassword;

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
					MainChat window = new MainChat();
					Login loginWindow = new Login();
					window.mainWindow.setVisible(false);
					loginWindow.loginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the mainWindow.
	 */
	private void initialize() {
		mainWindow = new JFrame("Trit - Chat Application");
		mainWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(MainChat.class.getResource("/images/tritapp-icon.png")));
		//Making the window undecorated with custom Title Bar
		mainWindow.setUndecorated(true);
		mainWindow.setBounds(100, 100, 450, 300);
		mainWindow.setSize(500, 600);
		
		JPanel CustomTitleBar = new JPanel();
		CustomTitleBar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point mouseCurrCoord = e.getLocationOnScreen();
				mainWindow.setLocation(mouseCurrCoord.x - mouseCoord.x, mouseCurrCoord.y - mouseCoord.y);
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
		CustomTitleBar.setBackground(new Color(153, 51, 255));
		
		JPanel TitleBg = new JPanel();
		TitleBg.setBackground(new Color(153, 51, 255));
		
		JLabel TitleName = new JLabel("Trit");
		TitleName.setForeground(Color.WHITE);
		TitleName.setFont(new Font("Oswald SemiBold", Font.PLAIN, 20));
		
		JLabel TitleDesc = new JLabel("- Chat Application");
		TitleDesc.setForeground(Color.WHITE);
		TitleBg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		TitleBg.add(TitleName);
		TitleBg.add(TitleDesc);
		
		JLabel AppMinimizeBtn = new JLabel("\u2212");
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
				mainWindow.setState(JFrame.ICONIFIED);
			}
		});
		AppMinimizeBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		AppMinimizeBtn.setForeground(Color.WHITE);
		
		JLabel AppCloseBtn = new JLabel("\u00D7");
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
		mainWindow.getContentPane().setLayout(new BorderLayout(0, 0));
		AppCloseBtn.setForeground(Color.WHITE);
		AppCloseBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_CustomTitleBar = new GroupLayout(CustomTitleBar);
		gl_CustomTitleBar.setHorizontalGroup(
			gl_CustomTitleBar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_CustomTitleBar.createSequentialGroup()
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
		mainWindow.getContentPane().add(CustomTitleBar, BorderLayout.NORTH);
		
		JPanel Body = new JPanel();
		mainWindow.getContentPane().add(Body, BorderLayout.CENTER);
		
		JPanel TopMenu = new JPanel();
		
		JLabel GroupsIcon = new JLabel("Groups");
		GroupsIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/user-group.png")));
		GroupsIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel PeopleIcon = new JLabel("People");
		PeopleIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/people.png")));
		PeopleIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel SettingsIcon = new JLabel("Settings");
		SettingsIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		SettingsIcon.setHorizontalAlignment(SwingConstants.CENTER);
		SettingsIcon.setToolTipText("");
		SettingsIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/settings-icon.png")));
		SettingsIcon.setVerticalTextPosition(JLabel.BOTTOM);
		SettingsIcon.setHorizontalTextPosition(JLabel.CENTER);
		SettingsIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		GroupLayout gl_TopMenu = new GroupLayout(TopMenu);
		gl_TopMenu.setHorizontalGroup(
			gl_TopMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TopMenu.createSequentialGroup()
					.addGap(29)
					.addComponent(GroupsIcon)
					.addGap(18)
					.addComponent(PeopleIcon)
					.addGap(226)
					.addComponent(SettingsIcon)
					.addGap(21))
		);
		gl_TopMenu.setVerticalGroup(
			gl_TopMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TopMenu.createSequentialGroup()
					.addGroup(gl_TopMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TopMenu.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_TopMenu.createParallelGroup(Alignment.BASELINE)
								.addComponent(GroupsIcon)
								.addComponent(PeopleIcon)))
						.addGroup(gl_TopMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(SettingsIcon)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		TopMenu.setLayout(gl_TopMenu);
		
		JPanel Panels = new JPanel();
		GroupLayout gl_Body = new GroupLayout(Body);
		gl_Body.setHorizontalGroup(
			gl_Body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Body.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_Body.createParallelGroup(Alignment.TRAILING)
						.addComponent(Panels, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(TopMenu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_Body.setVerticalGroup(
			gl_Body.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Body.createSequentialGroup()
					.addGap(5)
					.addComponent(TopMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(Panels, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
		);
		Panels.setLayout(new CardLayout(0, 0));

		JPanel PeoplePanel = new JPanel();
		PeoplePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Panels.add(PeoplePanel, "name_270599942480481");
		
		JButton OpenChatBtn = new JButton("Open Chat");
		OpenChatBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OpenChatBtn.setContentAreaFilled(false);
		OpenChatBtn.setBorder(null);
		OpenChatBtn.setOpaque(true);
		OpenChatBtn.setForeground(Color.WHITE);
		OpenChatBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OpenChatBtn.setBackground(new Color(153, 51, 255));
		
		JLabel People = new JLabel("People");
		People.setHorizontalAlignment(SwingConstants.CENTER);
		People.setForeground(new Color(153, 51, 255));
		People.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		JLabel PeopleErr = new JLabel("");
		PeopleErr.setHorizontalAlignment(SwingConstants.CENTER);
		PeopleErr.setForeground(new Color(204, 0, 0));
		
		JLabel PeopleRefreshIcon = new JLabel("Refresh People");
		PeopleRefreshIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PeopleRefreshIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/refresh-icon.png")));
		
		JScrollPane PeopleListScroll = new JScrollPane();
		PeopleListScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		GroupLayout gl_PeoplePanel = new GroupLayout(PeoplePanel);
		gl_PeoplePanel.setHorizontalGroup(
			gl_PeoplePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PeoplePanel.createSequentialGroup()
					.addGap(66)
					.addComponent(PeopleErr, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addGap(69))
				.addGroup(gl_PeoplePanel.createSequentialGroup()
					.addGap(219)
					.addComponent(People, GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(PeopleRefreshIcon)
					.addGap(60))
				.addGroup(gl_PeoplePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(PeopleListScroll, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_PeoplePanel.createSequentialGroup()
					.addGap(203)
					.addComponent(OpenChatBtn, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(205))
		);
		gl_PeoplePanel.setVerticalGroup(
			gl_PeoplePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PeoplePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PeoplePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(People, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_PeoplePanel.createSequentialGroup()
							.addGap(6)
							.addComponent(PeopleRefreshIcon)))
					.addGap(18)
					.addComponent(PeopleListScroll, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addGap(9)
					.addComponent(PeopleErr)
					.addGap(9)
					.addComponent(OpenChatBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);

		DefaultListModel<String> usersListModel = new DefaultListModel<String>();
		JList<String> PeopleList = new JList<String>(usersListModel);
		PeopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PeopleList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PeopleList.setBorder(new EmptyBorder(7, 7, 7, 7));
		PeopleListScroll.setViewportView(PeopleList);
		PeoplePanel.setLayout(gl_PeoplePanel);
		
		
		JPanel GroupsPanel = new JPanel();
		Panels.add(GroupsPanel, "name_270622455540948");
		
		JLabel GroupsHead = new JLabel("Groups");
		GroupsHead.setHorizontalAlignment(SwingConstants.CENTER);
		GroupsHead.setForeground(new Color(153, 51, 255));
		GroupsHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		JLabel RefreshGroupsIcon = new JLabel("Refresh Groups");
		RefreshGroupsIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RefreshGroupsIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/refresh-icon.png")));
		
		JScrollPane GroupsScroll = new JScrollPane();
		GroupsScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JButton OpenGroupChat = new JButton("Open Group");
		OpenGroupChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		OpenGroupChat.setContentAreaFilled(false);
		OpenGroupChat.setOpaque(true);
		OpenGroupChat.setForeground(Color.WHITE);
		OpenGroupChat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OpenGroupChat.setBorder(null);
		OpenGroupChat.setBackground(new Color(153, 51, 255));
		
		JLabel CreateGroupIcon = new JLabel("Create Group");
		CreateGroupIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CreateGroupIcon.setIcon(new ImageIcon(MainChat.class.getResource("/images/add-icon.png")));
		
		JLabel GroupsErr = new JLabel("");
		GroupsErr.setHorizontalAlignment(SwingConstants.CENTER);
		GroupsErr.setForeground(new Color(204, 0, 0));
		GroupLayout gl_GroupsPanel = new GroupLayout(GroupsPanel);
		gl_GroupsPanel.setHorizontalGroup(
			gl_GroupsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GroupsPanel.createSequentialGroup()
					.addGap(64)
					.addComponent(CreateGroupIcon, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(GroupsHead, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(RefreshGroupsIcon, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
				.addGroup(gl_GroupsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(GroupsScroll, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_GroupsPanel.createSequentialGroup()
					.addGap(204)
					.addComponent(OpenGroupChat, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(204))
				.addGroup(gl_GroupsPanel.createSequentialGroup()
					.addGap(65)
					.addComponent(GroupsErr, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addGap(70))
		);
		gl_GroupsPanel.setVerticalGroup(
			gl_GroupsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GroupsPanel.createSequentialGroup()
					.addGroup(gl_GroupsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GroupsPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(CreateGroupIcon, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GroupsPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_GroupsPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_GroupsPanel.createSequentialGroup()
									.addGap(6)
									.addComponent(RefreshGroupsIcon, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(GroupsHead, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(GroupsScroll, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(GroupsErr, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(OpenGroupChat, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(21))
		);
		
		DefaultListModel<String> GroupsListModel = new DefaultListModel<String>();
		JList<String> GroupsList = new JList<String>(GroupsListModel);
		GroupsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GroupsList.setBorder(new EmptyBorder(7, 7, 7, 7));
		GroupsList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupsScroll.setViewportView(GroupsList);
		GroupsPanel.setLayout(gl_GroupsPanel);
		
		JPanel ChatPanel = new JPanel();
		Panels.add(ChatPanel, "name_270285323052499");
		
		JScrollPane MessageBoxScroll = new JScrollPane();
		MessageBoxScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JLabel SendBtn = new JLabel("");
		SendBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SendBtn.setIcon(new ImageIcon(MainChat.class.getResource("/images/send-icon.png")));
		
		JScrollPane ChatBoxScroll = new JScrollPane();
		ChatBoxScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JLabel ChatPersonLbl = new JLabel("Chat");
		ChatPersonLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ChatPersonLbl.setForeground(new Color(153, 51, 255));
		ChatPersonLbl.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		JLabel RefreshChatBtn = new JLabel("Refresh Chat");
		RefreshChatBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RefreshChatBtn.setIcon(new ImageIcon(MainChat.class.getResource("/images/refresh-icon.png")));
		GroupLayout gl_ChatPanel = new GroupLayout(ChatPanel);
		gl_ChatPanel.setHorizontalGroup(
			gl_ChatPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ChatPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ChatPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addComponent(ChatBoxScroll, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addComponent(MessageBoxScroll, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(SendBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addGap(84)
							.addComponent(ChatPersonLbl, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(RefreshChatBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(64))))
		);
		gl_ChatPanel.setVerticalGroup(
			gl_ChatPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ChatPanel.createSequentialGroup()
					.addGroup(gl_ChatPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addGap(17)
							.addComponent(RefreshChatBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(ChatPersonLbl, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(ChatBoxScroll, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_ChatPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(MessageBoxScroll, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ChatPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(SendBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JTextPane ChatBox = new JTextPane();
		ChatBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChatBox.setText("Messages will appear here...");
		ChatBox.setEditable(false);
		ChatBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		ChatBoxScroll.setViewportView(ChatBox);
		
		JTextArea MessageBox = new JTextArea();
		MessageBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(MessageBox.getText().equals("Type your message here...")) {
					MessageBox.setText("");
				}
			}
		});
		MessageBox.setText("Type your message here...");
		MessageBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		MessageBox.setLineWrap(true);
		MessageBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		MessageBoxScroll.setViewportView(MessageBox);
		ChatPanel.setLayout(gl_ChatPanel);
		
		JPanel CreateGroupPanel = new JPanel();
		Panels.add(CreateGroupPanel, "name_525574480955584");
		
		JLabel CreateGroupHead = new JLabel("Create Group");
		CreateGroupHead.setHorizontalAlignment(SwingConstants.CENTER);
		CreateGroupHead.setForeground(new Color(153, 51, 255));
		CreateGroupHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		GroupNameField = new JTextField();
		GroupNameField.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)), new EmptyBorder(4, 4, 4, 4)));
		GroupNameField.setColumns(10);
		
		JLabel GroupNameLbl = new JLabel("Group Name");
		
		JScrollPane AddPeopleScroll = new JScrollPane();
		AddPeopleScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JLabel AddPeople = new JLabel("Add People");
		
		JButton CreateGroupBtn = new JButton("Create Group");
		CreateGroupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CreateGroupBtn.setContentAreaFilled(false);
		CreateGroupBtn.setOpaque(true);
		CreateGroupBtn.setForeground(Color.WHITE);
		CreateGroupBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreateGroupBtn.setBorder(null);
		CreateGroupBtn.setBackground(new Color(153, 51, 255));
		
		JLabel CreateGroupErr = new JLabel("");
		CreateGroupErr.setHorizontalAlignment(SwingConstants.CENTER);
		CreateGroupErr.setForeground(new Color(204, 0, 0));
		GroupLayout gl_CreateGroupPanel = new GroupLayout(CreateGroupPanel);
		gl_CreateGroupPanel.setHorizontalGroup(
			gl_CreateGroupPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CreateGroupPanel.createSequentialGroup()
					.addGap(181)
					.addComponent(CreateGroupHead, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(172))
				.addGroup(gl_CreateGroupPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_CreateGroupPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GroupNameField, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(GroupNameLbl))
					.addGap(18)
					.addGroup(gl_CreateGroupPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddPeople, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(AddPeopleScroll, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_CreateGroupPanel.createSequentialGroup()
					.addGap(59)
					.addComponent(CreateGroupErr, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addGap(76))
				.addGroup(gl_CreateGroupPanel.createSequentialGroup()
					.addGap(194)
					.addComponent(CreateGroupBtn, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(207))
		);
		gl_CreateGroupPanel.setVerticalGroup(
			gl_CreateGroupPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CreateGroupPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(CreateGroupHead, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(gl_CreateGroupPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(GroupNameLbl)
						.addComponent(AddPeople))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_CreateGroupPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GroupNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AddPeopleScroll, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(CreateGroupErr, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CreateGroupBtn, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(18))
		);

		DefaultListModel<String> AddPeopleListModel = new DefaultListModel<String>();
		JList<String> AddPeopleList = new JList<String>(AddPeopleListModel);
		AddPeopleList.setBorder(new EmptyBorder(7, 7, 7, 7));
		AddPeopleScroll.setViewportView(AddPeopleList);
		CreateGroupPanel.setLayout(gl_CreateGroupPanel);
		
		JPanel GroupChatPanel = new JPanel();
		Panels.add(GroupChatPanel, "name_844507550101046");
		
		JScrollPane GroupChatScroll = new JScrollPane();
		GroupChatScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JScrollPane GroupMessageBoxScroll = new JScrollPane();
		GroupMessageBoxScroll.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)));
		
		JLabel GroupSendBtn = new JLabel("");
		GroupSendBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupSendBtn.setIcon(new ImageIcon(MainChat.class.getResource("/images/send-icon.png")));
		
		JLabel GroupChatName = new JLabel("Chat");
		GroupChatName.setHorizontalAlignment(SwingConstants.CENTER);
		GroupChatName.setForeground(new Color(153, 51, 255));
		GroupChatName.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		JLabel GroupChatRefreshBtn = new JLabel("Refresh Chat");
		GroupChatRefreshBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GroupChatRefreshBtn.setIcon(new ImageIcon(MainChat.class.getResource("/images/refresh-icon.png")));
		GroupLayout gl_GroupChatPanel = new GroupLayout(GroupChatPanel);
		gl_GroupChatPanel.setHorizontalGroup(
			gl_GroupChatPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 499, Short.MAX_VALUE)
				.addGroup(gl_GroupChatPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GroupChatPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GroupChatPanel.createSequentialGroup()
							.addComponent(GroupChatScroll, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_GroupChatPanel.createSequentialGroup()
							.addComponent(GroupMessageBoxScroll, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(GroupSendBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_GroupChatPanel.createSequentialGroup()
							.addComponent(GroupChatName, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(GroupChatRefreshBtn, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(64))))
		);
		gl_GroupChatPanel.setVerticalGroup(
			gl_GroupChatPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GroupChatPanel.createSequentialGroup()
					.addGroup(gl_GroupChatPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GroupChatPanel.createSequentialGroup()
							.addGap(17)
							.addComponent(GroupChatRefreshBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GroupChatPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(GroupChatName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(GroupChatScroll, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_GroupChatPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GroupMessageBoxScroll, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_GroupChatPanel.createSequentialGroup()
							.addGap(20)
							.addComponent(GroupSendBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		
		JTextArea GroupMessageBox = new JTextArea();
		GroupMessageBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(GroupMessageBox.getText().equals("Type your message here...")) {
					GroupMessageBox.setText("");
				}
			}
		});
		GroupMessageBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupMessageBox.setText("Type your message here...");
		GroupMessageBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		GroupMessageBoxScroll.setViewportView(GroupMessageBox);
		
		JTextPane GroupChatBox = new JTextPane();
		GroupChatBox.setEditable(false);
		GroupChatBox.setText("Messages will appear here...");
		GroupChatBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupChatBox.setBorder(new EmptyBorder(7, 7, 7, 7));
		GroupChatScroll.setViewportView(GroupChatBox);
		GroupChatPanel.setLayout(gl_GroupChatPanel);
		
		JPanel SettingsPanel = new JPanel();
		Panels.add(SettingsPanel, "name_868808556467068");
		
		JLabel SettingsHead = new JLabel("Settings");
		SettingsHead.setHorizontalAlignment(SwingConstants.CENTER);
		SettingsHead.setForeground(new Color(153, 51, 255));
		SettingsHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 25));
		
		NewUsername = new JTextField();
		NewUsername.setColumns(10);
		NewUsername.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)), new EmptyBorder(4, 4, 4, 4)));
		
		JLabel ChangeUsernameHead = new JLabel("Change Username");
		ChangeUsernameHead.setHorizontalAlignment(SwingConstants.CENTER);
		ChangeUsernameHead.setForeground(new Color(153, 51, 255));
		ChangeUsernameHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 20));
		
		JLabel CurrentUsernameLbl = new JLabel("Current: ");
		CurrentUsernameLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		CurrentUsernameLbl.setForeground(new Color(153, 51, 255));
		
		JLabel CurrentUsername = new JLabel("CurrentUsername");
		
		CurrentPassword = new JPasswordField();
		CurrentPassword.setColumns(10);
		CurrentPassword.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)), new EmptyBorder(4, 4, 4, 4)));
		
		JLabel CurrentPasswordLbl = new JLabel("Current Password");
		
		JLabel NewPasswordLbl = new JLabel("New Password");
		
		NewPassword = new JPasswordField();
		NewPassword.setColumns(10);
		NewPassword.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 51, 255)), new EmptyBorder(4, 4, 4, 4)));
		
		JLabel ChangePasswordHead = new JLabel("Change Password");
		ChangePasswordHead.setHorizontalAlignment(SwingConstants.CENTER);
		ChangePasswordHead.setForeground(new Color(153, 51, 255));
		ChangePasswordHead.setFont(new Font("Oswald SemiBold", Font.PLAIN, 20));
		
		JButton ChangeUsernameBtn = new JButton("Change Username");
		ChangeUsernameBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ChangeUsernameBtn.setContentAreaFilled(false);
		ChangeUsernameBtn.setOpaque(true);
		ChangeUsernameBtn.setForeground(Color.WHITE);
		ChangeUsernameBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChangeUsernameBtn.setBorder(null);
		ChangeUsernameBtn.setBackground(new Color(153, 51, 255));
		
		JButton ChangePasswordBtn = new JButton("Change Password");
		ChangePasswordBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ChangePasswordBtn.setContentAreaFilled(false);
		ChangePasswordBtn.setOpaque(true);
		ChangePasswordBtn.setForeground(Color.WHITE);
		ChangePasswordBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChangePasswordBtn.setBorder(null);
		ChangePasswordBtn.setBackground(new Color(153, 51, 255));
		
		JLabel ChangeUsernameErr = new JLabel("");
		ChangeUsernameErr.setHorizontalAlignment(SwingConstants.CENTER);
		ChangeUsernameErr.setForeground(Color.RED);
		
		JLabel ChangePasswordErr = new JLabel("");
		ChangePasswordErr.setHorizontalAlignment(SwingConstants.CENTER);
		ChangePasswordErr.setForeground(Color.RED);
		GroupLayout gl_SettingsPanel = new GroupLayout(SettingsPanel);
		gl_SettingsPanel.setHorizontalGroup(
			gl_SettingsPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_SettingsPanel.createSequentialGroup()
					.addGap(181)
					.addComponent(SettingsHead, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(172))
				.addGroup(gl_SettingsPanel.createSequentialGroup()
					.addGap(165)
					.addGroup(gl_SettingsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(CurrentUsernameLbl, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CurrentUsername, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(NewUsername, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addComponent(ChangeUsernameHead, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(149))
				.addGroup(gl_SettingsPanel.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_SettingsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addComponent(NewPasswordLbl, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(96))
						.addComponent(NewPassword, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addComponent(CurrentPasswordLbl, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(96))
						.addComponent(CurrentPassword, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addComponent(ChangePasswordHead, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(4))
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(ChangePasswordBtn, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
							.addGap(25)))
					.addGap(148))
				.addGroup(gl_SettingsPanel.createSequentialGroup()
					.addGroup(gl_SettingsPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(ChangePasswordErr, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SettingsPanel.createSequentialGroup()
							.addGap(136)
							.addGroup(gl_SettingsPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_SettingsPanel.createSequentialGroup()
									.addGap(56)
									.addComponent(ChangeUsernameBtn, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
									.addGap(53))
								.addComponent(ChangeUsernameErr, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))))
					.addGap(121))
		);
		gl_SettingsPanel.setVerticalGroup(
			gl_SettingsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SettingsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(SettingsHead, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(ChangeUsernameHead)
					.addGap(10)
					.addGroup(gl_SettingsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(CurrentUsernameLbl)
						.addComponent(CurrentUsername))
					.addGap(11)
					.addComponent(NewUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(ChangeUsernameBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(ChangeUsernameErr, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ChangePasswordHead, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(CurrentPasswordLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CurrentPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(NewPasswordLbl)
					.addGap(6)
					.addComponent(NewPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ChangePasswordBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ChangePasswordErr, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		SettingsPanel.setLayout(gl_SettingsPanel);
		Body.setLayout(gl_Body);
		Body.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{TopMenu, GroupsIcon, PeopleIcon, SettingsIcon}));
		
		JPanel BottomBorder = new JPanel();
		BottomBorder.setBackground(new Color(153, 51, 255));
		mainWindow.getContentPane().add(BottomBorder, BorderLayout.SOUTH);
		
		//Panel icons actions
		GroupsIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ChatPanel.setVisible(false);
				PeoplePanel.setVisible(false);
				GroupsPanel.setVisible(true);
				CreateGroupPanel.setVisible(false);
				GroupChatPanel.setVisible(false);
				SettingsPanel.setVisible(false);
			}
		});
		PeopleIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ChatPanel.setVisible(false);
				GroupsPanel.setVisible(false);
				PeoplePanel.setVisible(true);
				CreateGroupPanel.setVisible(false);
				GroupChatPanel.setVisible(false);
				SettingsPanel.setVisible(false);
				PeopleErr.setText("");
				//Getting usernames from DB
				usersListModel.clear();
				ResultSet rs = getUsers();
				try {
					while(rs.next()) {
						if(!currentUser.equals(rs.getString(1))) {
							usersListModel.addElement(rs.getString(1));
						}
					}
				}catch(Exception e) {
					PeopleErr.setText("Error retrieving data!");
				}
			}
		});
		OpenChatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//Shift to chat panel
				ChatBox.setText("");
				if(PeopleList.getSelectedValue() == null) {
					PeopleErr.setText("Select a user!");
					return;
				}
				MainChat.chatUser = PeopleList.getSelectedValue();
				DBConn con = new DBConn();
				ResultSet rs = con.RunQuery("SELECT userid from TritApp_Users WHERE username = '"+chatUser+"'");
				try {
					while(rs.next()) {
						MainChat.chatUserID = rs.getInt(1);
					}
					con.con.close();
				}catch(Exception e) {
					PeopleErr.setText("Error retrieving data!");
				}
				con = null;
				insertUserChat(ChatBox);
				if(ChatBox.getText().equals(""))
					ChatBox.setText("Messages will appear here...");
				ChatPersonLbl.setText(MainChat.chatUser);
				//Setting visibilty of other elements
				PeoplePanel.setVisible(false);
				GroupsPanel.setVisible(false);
				ChatPanel.setVisible(true);
				CreateGroupPanel.setVisible(false);
				GroupChatPanel.setVisible(false);
				SettingsPanel.setVisible(false);
			}
		});
		SendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String message = MessageBox.getText();
				if(!message.equals("")) {
					ChatBox.setText("");
					MessageBox.setText("");
					DBConn con = new DBConn();
					try {
						con.st.executeUpdate("INSERT INTO TritApp_Chats (senderID, receiverID, message_time, message) VALUES ("+MainChat.currentUserID+", "+MainChat.chatUserID+", SYSDATE, '"+message+"')");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error retrieving data!");
					}
					insertUserChat(ChatBox);
				}
				
			}
		});
		RefreshChatBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ChatBox.setText("");
				insertUserChat(ChatBox);
				if(ChatBox.getText().equals(""))
					ChatBox.setText("Messages will appear here...");
			}
		});
		PeopleRefreshIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//Getting usernames from DB
				usersListModel.clear();
				ResultSet rs = getUsers();
				try {
					while(rs.next()) {
						if(!MainChat.currentUser.equals(rs.getString(1))) {
							usersListModel.addElement(rs.getString(1));
						}
					}
				}catch(Exception e) {
					People.setText("Error retrieving data!");
				}
			}
		});
		CreateGroupIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				PeoplePanel.setVisible(false);
				GroupsPanel.setVisible(false);
				ChatPanel.setVisible(false);
				CreateGroupPanel.setVisible(true);
				GroupChatPanel.setVisible(false);
				SettingsPanel.setVisible(false);
				AddPeopleListModel.clear();
				CreateGroupErr.setText("");
				//Populating CreateGroup fields
				ResultSet rs = getUsers();
				try {
					while(rs.next()) {
						if(!MainChat.currentUser.equals(rs.getString(1)))
							AddPeopleListModel.addElement(rs.getString(1));
					}
				}catch(Exception e) {
					CreateGroupErr.setText("Error retrieving data!");
				}
			}
		});
		CreateGroupBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CreateGroupErr.setText("");
				String groupName = GroupNameField.getText().trim();
				if(!groupName.equals("") && (AddPeopleList.getSelectedIndices().length > 1)) {
					String groupMembers = AddPeopleList.getSelectedValuesList().toString();
					groupMembers = groupMembers.substring(1, groupMembers.length()-1);
					String[] groupMembersArr = groupMembers.split(", ");
					int[] groupMembersIDs = getUserIDs(groupMembersArr);
					groupMembers = "";
					for(int i=0; i<groupMembersIDs.length; i++) {
						groupMembers += String.valueOf(groupMembersIDs[i]) + ", ";
					}
					groupMembers = MainChat.currentUserID + ", " + groupMembers.substring(0, groupMembers.length()-2);
					DBConn con = new DBConn();
					try {
						con.st.executeUpdate("INSERT INTO TritApp_Groups (GroupName, GroupMembers) VALUES ('"+groupName+"', '"+groupMembers+"')");
						CreateGroupErr.setText("New group created!");
					}catch(Exception e1) {
						CreateGroupErr.setText("Error retrieving data!");
					}
				}else {
					CreateGroupErr.setText("Group Name and Multiple People are required!");
				}
			}
		});
		RefreshGroupsIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GroupsErr.setText("");
				GroupsListModel.clear();
				DBConn con = new DBConn();
				ResultSet rs = con.RunQuery("SELECT * FROM TritApp_Groups");
				String currentUser = String.valueOf(MainChat.currentUserID);
				try {
					while(rs.next()) {
						java.util.List<String> groupMembers = Arrays.asList(rs.getString(3).split(", "));
						if(groupMembers.contains(currentUser))
							GroupsListModel.addElement(rs.getString(1) + "   " + rs.getString(2));
					}
				}catch(Exception e1){
					GroupsErr.setText("Error retrieving data!");
				}
			}
		});
		OpenGroupChat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GroupChatBox.setText("");
				MainChat.currentGroupID = Integer.parseInt(GroupsList.getSelectedValue().split("   ")[0]);
				String groupName = "GroupChat";
				ResultSet rsGChatName = new DBConn().RunQuery("SELECT GroupName FROM TritApp_Groups WHERE GroupID = "+MainChat.currentGroupID);
				try {
					while(rsGChatName.next()) {
						groupName = rsGChatName.getString(1);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error retrieving data!");
				}
				insertGroupChat(GroupChatBox);
				if(GroupChatBox.getText().equals(""))
					GroupChatBox.setText("Messages will appear here...");
				GroupChatName.setText(groupName);
				//Setting visibility of other panels
				PeoplePanel.setVisible(false);
				GroupsPanel.setVisible(false);
				ChatPanel.setVisible(false);
				CreateGroupPanel.setVisible(false);
				GroupChatPanel.setVisible(true);
				SettingsPanel.setVisible(false);
			}
		});
		GroupChatRefreshBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GroupChatBox.setText("");
				insertGroupChat(GroupChatBox);
				if(GroupChatBox.getText().equals(""))
					GroupChatBox.setText("Messages will appear here...");
			}
		});
		GroupSendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				GroupChatBox.setText("");
				String message = GroupMessageBox.getText();
				if(!message.equals("")) {
					GroupChatBox.setText("");
					GroupMessageBox.setText("");
					DBConn con = new DBConn();
					try {
						con.st.executeUpdate("INSERT INTO TritApp_GroupChats (groupID, senderID, message_time, message) VALUES ("+MainChat.currentGroupID+", "+MainChat.currentUserID+", SYSDATE, '"+message+"')");
						con = null;
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error retrieving data!");
					}
					insertGroupChat(GroupChatBox);
				}
			}
		});
		SettingsIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				PeoplePanel.setVisible(false);
				GroupsPanel.setVisible(false);
				ChatPanel.setVisible(false);
				CreateGroupPanel.setVisible(false);
				GroupChatPanel.setVisible(false);
				SettingsPanel.setVisible(true);
				CurrentUsername.setText(MainChat.currentUser);
				ChangeUsernameErr.setText("");
				ChangePasswordErr.setText("");
			}
		});
		ChangeUsernameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ChangeUsernameErr.setText("");
				String newUsername = NewUsername.getText();
				if(!newUsername.equals("")) {
					boolean userExists = false;
					DBConn con = new DBConn();
					ResultSet rs = con.RunQuery("SELECT username FROM TritApp_Users");
					try {
						while(rs.next()) {
							if(newUsername.equals(rs.getString(1))) {
								ChangeUsernameErr.setText("This username already exists!");
								userExists = true;
								break;
							}
						}
						if(!userExists) {
							con.st.executeUpdate("UPDATE TritApp_Users SET username = '"+newUsername+"' WHERE username = '"+MainChat.currentUser+"'");
							ChangeUsernameErr.setText("Username updated!");
							MainChat.currentUser = newUsername;
							CurrentUsername.setText(newUsername);
						}
					}catch(Exception e) {
						ChangeUsernameErr.setText("Error retrieving data!");
					}
					con = null;
				}else {
					ChangeUsernameErr.setText("New username is required!");
				}
				NewUsername.setText("");
			}
		});
		ChangePasswordBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String currentPassword = new String(CurrentPassword.getPassword());
				String newPassword = new String(NewPassword.getPassword());
				boolean passwordMatch = false;
				if(!newPassword.equals("")) {
					DBConn con = new DBConn();
					ResultSet rs = con.RunQuery("SELECT userpassword FROM TritApp_Users WHERE username = '"+MainChat.currentUser+"'");
					try {
						while(rs.next()) {
							if(currentPassword.equals(rs.getString(1))) {
								passwordMatch = true;
							}
						}
						if(passwordMatch) {
							con.st.executeUpdate("UPDATE TritApp_Users SET userpassword = '"+newPassword+"' WHERE username = '"+MainChat.currentUser+"'");
							ChangePasswordErr.setText("Password updated!");
							CurrentPassword.setText("");
							NewPassword.setText("");
						}else {
							ChangePasswordErr.setText("Current password is incorrect!");
						}
					}catch(Exception e) {
						ChangePasswordErr.setText("Error retrieving data!");
					}
				}else {
					ChangePasswordErr.setText("New password is required!");
				}
			}
		});
		//Panel icons actions END
	}
	
	ResultSet getChat(int user1ID, int user2ID) {
		DBConn con = new DBConn();
		ResultSet rs = con.RunQuery("SELECT * FROM TritApp_Chats WHERE (senderID = "+user1ID+" AND receiverID = "+user2ID+") OR (senderID = "+user2ID+" AND receiverID = "+user1ID+") ORDER BY message_time");
		con = null;
		return rs;
	}
	
	ResultSet getUsers() {
		DBConn con = new DBConn();
		ResultSet rs = con.RunQuery("SELECT username, userid FROM TritApp_Users");
		con = null;
		return rs;
	}
	
	int[] getUserIDs(String[] usernames) {
		DBConn con = new DBConn();
		String usernamesQ = String.join("', '", usernames);
		ResultSet rs = con.RunQuery("SELECT userid FROM TritApp_Users WHERE username IN ('"+usernamesQ+"')");
		ArrayList<Integer> userIDs = new ArrayList<>();
		try {
			while(rs.next()) {
				userIDs.add(rs.getInt(1));
			}
			int[] userIDsArr = new int[userIDs.size()];
			for(int i=0; i<userIDs.size(); i++) {
				userIDsArr[i] = userIDs.get(i).intValue();
			}
			con = null;
			return userIDsArr;
		}catch(Exception e) {
			int[] x = {-1};
			con = null;
			return x;
		}
	}
	
	String getUserName(int userID) {
		DBConn con = new DBConn();
		ResultSet rs = con.RunQuery("SELECT username FROM TritApp_Users WHERE userid = "+userID);
		try {
			String username = "";
			while(rs.next()) {
				username = rs.getString(1);
			}
			con = null;
			return username;
		}catch(Exception e) {
			String x = "-1";
			con = null;
			return x;
		}
	}
	
	ResultSet getGroupChat(int groupID) {
		DBConn con = new DBConn();
		ResultSet rs = con.RunQuery("SELECT * FROM TritApp_GroupChats WHERE GroupID = "+groupID+" ORDER BY message_time");
		con = null;
		return rs;
	}
	
	void insertGroupChat(JTextPane chatBox) {
		StyledDocument doc = chatBox.getStyledDocument();
		//Adding styles to textPane
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		Style regular = doc.addStyle("regular", def);
		Style s = doc.addStyle("small", regular);
		StyleConstants.setFontSize(s, 10);
		StyleConstants.setForeground(s, new Color(153, 51, 255));
		s = doc.addStyle("chatUserName", regular);
		StyleConstants.setBold(s, true);
		StyleConstants.setForeground(s, new Color(153, 51, 255));
		//Adding styles to textPane END
		ResultSet rsGChat = getGroupChat(MainChat.currentGroupID);
		try {
			String messageTime = "";
			while(rsGChat.next()) {
				//Rearrange message time
				messageTime = rsGChat.getString(3).substring(11, 16) + " AM";
				int messageHrs = Integer.parseInt(messageTime.substring(0, 2));
				if(messageHrs > 12) {
					messageTime = messageTime.replace(""+messageHrs, ""+(messageHrs-12));
					messageTime = messageTime.replace("AM", "PM");
				}
				//Rearrange message time END
				if(rsGChat.getInt(2) == MainChat.currentUserID) {
					doc.insertString(doc.getLength(), messageTime, doc.getStyle("small"));
					doc.insertString(doc.getLength(), "  You:"+"\n", doc.getStyle("chatUserName"));
					doc.insertString(doc.getLength(), rsGChat.getString(4)+"\n"+"\n", doc.getStyle("regular"));
				}else {
					doc.insertString(doc.getLength(), messageTime, doc.getStyle("small"));
					doc.insertString(doc.getLength(), "  "+getUserName(rsGChat.getInt(2))+":\n", doc.getStyle("chatUserName"));
					doc.insertString(doc.getLength(), rsGChat.getString(4)+"\n"+"\n", doc.getStyle("regular"));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error retrieving data!");
		}
	}
	
	void insertUserChat(JTextPane chatBox) {
		StyledDocument doc = chatBox.getStyledDocument();
		//Adding styles to textPane
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		Style regular = doc.addStyle("regular", def);
		Style s = doc.addStyle("small", regular);
		StyleConstants.setFontSize(s, 10);
		StyleConstants.setForeground(s, new Color(153, 51, 255));
		s = doc.addStyle("chatUserName", regular);
		StyleConstants.setBold(s, true);
		StyleConstants.setForeground(s, new Color(153, 51, 255));
		//Adding styles to textPane END
		ResultSet rsChat = getChat(MainChat.currentUserID, MainChat.chatUserID);
		try {
			String messageTime = "";
			while(rsChat.next()) {
				//Rearrange message time
				messageTime = rsChat.getString(3).substring(11, 16) + " AM";
				int messageHrs = Integer.parseInt(messageTime.substring(0, 2));
				if(messageHrs > 12) {
					messageTime = messageTime.replace(""+messageHrs, ""+(messageHrs-12));
					messageTime = messageTime.replace("AM", "PM");
				}
				//Rearrange message time END
				if(rsChat.getInt(1) == MainChat.currentUserID) {
					doc.insertString(doc.getLength(), messageTime, doc.getStyle("small"));
					doc.insertString(doc.getLength(), "  You:"+"\n", doc.getStyle("chatUserName"));
					doc.insertString(doc.getLength(), rsChat.getString(4)+"\n"+"\n", doc.getStyle("regular"));
				}else {
					doc.insertString(doc.getLength(), messageTime, doc.getStyle("small"));
					doc.insertString(doc.getLength(), "  "+MainChat.chatUser+"\n", doc.getStyle("chatUserName"));
					doc.insertString(doc.getLength(), rsChat.getString(4)+"\n"+"\n", doc.getStyle("regular"));
				}
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error retrieving data!");
		}
	}
}
