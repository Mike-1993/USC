import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

//import java.awt.GridLayout;
//import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class usc_main {

	JFrame frmUnifiedSoftwareCenter;
	private JTextField username;
	private JPanel panel;
	private JButton btnFirefox;
	private JButton btnKate;
	private JButton btnOffice;
	private JButton btnVlc;
	private JButton btnVirtualbox;
	private JButton btnEclipse;
	private JButton btnGimp;
	private JButton btnSolitaire;
	private JButton btnClementine;
	private JButton btnChangeuser;
	private JButton btnHost;
	private JButton btnFileManager;
	private JButton btnMinitube;
	private JButton btnTorrent;
	private JButton btnGolf;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				usc_main window = new usc_main();
				window.frmUnifiedSoftwareCenter.setVisible(true);
				window.frmUnifiedSoftwareCenter.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				window.frmUnifiedSoftwareCenter.setLocationRelativeTo(null);
				enterhost e = new enterhost();
				e.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				e.setVisible(true);
				e.setLocationRelativeTo(null);
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public usc_main() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnifiedSoftwareCenter = new JFrame();
		frmUnifiedSoftwareCenter.getContentPane().setBackground(Color.WHITE);
		frmUnifiedSoftwareCenter.getContentPane().setFont(new Font("Arial", Font.BOLD, 12));
		
		username = new JTextField();
		select1 tmp = new select1();
		
		if (tmp.username().equals("nil")){
			client_database cd = new client_database();
			cd.not_exist();
		}
		
		username.setText(tmp.username());
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Arial", Font.BOLD, 12));
		username.setBackground(Color.WHITE);
		username.setBorder(null);
		username.setEditable(false);
		//String uname = "veeraj";
		username.setColumns(10);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("Arial", Font.BOLD, 12));
		exit.setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.setBackground(Color.WHITE);
		
		btnChangeuser = new JButton("");
		btnChangeuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Username dialog = new Username();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		btnChangeuser.setToolTipText("Change User");
		btnChangeuser.setBackground(Color.WHITE);
		btnChangeuser.setIcon(new ImageIcon(usc_main.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
		
		btnHost = new JButton("Host");
		btnHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					host_detail dialog = new host_detail();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		btnHost.setToolTipText("Change Host Name and Host ID");
		btnHost.setFont(new Font("Arial", Font.BOLD, 12));
		btnHost.setBackground(Color.WHITE);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pswdchng dialog = new pswdchng();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frmUnifiedSoftwareCenter.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnHost, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnChangePassword)
									.addGap(40)
									.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(btnChangeuser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(exit, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(27))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnChangeuser, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnHost)
							.addComponent(username, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
							.addComponent(btnChangePassword)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(exit, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnFirefox = new JButton("Firefox");
		btnFirefox.setToolTipText("Browser");
		btnFirefox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("firefox");
			}
		});
		btnFirefox.setBackground(Color.WHITE);
		
		btnKate = new JButton("Kate");
		btnKate.setToolTipText("Text Editor");
		btnKate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("kate");
			}
		});
		btnKate.setBackground(Color.WHITE);
		
		btnOffice = new JButton("Libreoffice");
		btnOffice.setToolTipText("Office Suite");
		btnOffice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("libreoffice");
			}
		});
		btnOffice.setBackground(Color.WHITE);
		
		btnVlc = new JButton("VLC");
		btnVlc.setToolTipText("Movie Player");
		btnVlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("vlc");
			}
		});
		btnVlc.setIcon(null);
		btnVlc.setBackground(Color.WHITE);
		btnVlc.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnVirtualbox = new JButton("Virtualbox");
		btnVirtualbox.setToolTipText("Virtualization Tool");
		btnVirtualbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("virtualbox");
			}
		});
		btnVirtualbox.setBackground(Color.WHITE);
		btnVirtualbox.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnEclipse = new JButton("Eclipse");
		btnEclipse.setToolTipText("IDE");
		btnEclipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("eclipse");
			}
		});
		btnEclipse.setFont(new Font("Arial", Font.BOLD, 12));
		btnEclipse.setBackground(Color.WHITE);
		
		btnGimp = new JButton("GIMP");
		btnGimp.setToolTipText("Photo Editor");
		btnGimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("gimp");
			}
		});
		btnGimp.setBackground(Color.WHITE);
		btnGimp.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnSolitaire = new JButton("Solitaire");
		btnSolitaire.setToolTipText("Card Game");
		btnSolitaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("kpat");
			}
		});
		btnSolitaire.setBackground(Color.WHITE);
		btnSolitaire.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnClementine = new JButton("Clementine");
		btnClementine.setToolTipText("Music Player");
		btnClementine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("clementine");
			}
		});
		btnClementine.setFont(new Font("Arial", Font.BOLD, 12));
		btnClementine.setBackground(Color.WHITE);
		
		btnFileManager = new JButton("File Manager");
		btnFileManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("dolphin");
			}
		});
		btnFileManager.setBackground(Color.WHITE);
		btnFileManager.setToolTipText("Check my File System");
		
		btnMinitube = new JButton("Minitube");
		btnMinitube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("minitube");
			}
		});
		btnMinitube.setFont(new Font("Arial", Font.BOLD, 12));
		btnMinitube.setToolTipText("Youtube Video Player");
		btnMinitube.setBackground(Color.WHITE);
		
		btnTorrent = new JButton("Torrent");
		btnTorrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("qbittorrent");
			}
		});
		btnTorrent.setBackground(Color.WHITE);
		btnTorrent.setToolTipText("Bittorrent App");
		btnTorrent.setFont(new Font("Arial", Font.BOLD, 12));
		
		btnGolf = new JButton("Golf");
		btnGolf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client cli = new client();
				cli.cli_start("kolf");
			}
		});
		btnGolf.setToolTipText("Game");
		btnGolf.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnVlc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFirefox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOffice, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSolitaire, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGimp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEclipse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVirtualbox, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnTorrent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMinitube, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFileManager, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnClementine, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnGolf, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVlc)
						.addComponent(btnVirtualbox)
						.addComponent(btnClementine)
						.addComponent(btnGolf))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEclipse)
						.addComponent(btnFirefox)
						.addComponent(btnFileManager))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnKate)
						.addComponent(btnGimp)
						.addComponent(btnMinitube))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSolitaire, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTorrent)
						.addComponent(btnOffice))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmUnifiedSoftwareCenter.getContentPane().setLayout(groupLayout);
		frmUnifiedSoftwareCenter.setTitle("Unified Software Center");
		frmUnifiedSoftwareCenter.setBounds(100, 100, 703, 503);
		frmUnifiedSoftwareCenter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
