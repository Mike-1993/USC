import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class pswdchng extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCurrentPassword;
	private JTextField txtNewPassword;
	private JTextField txtRetypePassword;
	private JPasswordField cpswd;
	private JPasswordField npswd;
	private JPasswordField rpswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			pswdchng dialog = new pswdchng();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public pswdchng() {
		setBounds(100, 100, 541, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtCurrentPassword = new JTextField();
		txtCurrentPassword.setBackground(Color.WHITE);
		txtCurrentPassword.setBorder(null);
		txtCurrentPassword.setEditable(false);
		txtCurrentPassword.setFont(new Font("Arial", Font.BOLD, 12));
		txtCurrentPassword.setText("Current password");
		txtCurrentPassword.setColumns(10);
		txtNewPassword = new JTextField();
		txtNewPassword.setBackground(Color.WHITE);
		txtNewPassword.setBorder(null);
		txtNewPassword.setFont(new Font("Arial", Font.BOLD, 12));
		txtNewPassword.setEditable(false);
		txtNewPassword.setText("New password");
		txtNewPassword.setColumns(10);
		txtRetypePassword = new JTextField();
		txtRetypePassword.setBackground(Color.WHITE);
		txtRetypePassword.setBorder(null);
		txtRetypePassword.setEditable(false);
		txtRetypePassword.setFont(new Font("Arial", Font.BOLD, 12));
		txtRetypePassword.setText("Retype password");
		txtRetypePassword.setColumns(10);
		
		cpswd = new JPasswordField();
		
		npswd = new JPasswordField();
		
		rpswd = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtCurrentPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cpswd, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(npswd, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtRetypePassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rpswd, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCurrentPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(npswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRetypePassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rpswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						String current = cpswd.getText();
						String newp = npswd.getText();
						String retype = rpswd.getText();
						
						select1 tmp = new select1();
						if (current.equals(tmp.password()))
						{
							if(newp.equals(retype))
							{	
								send cp = new send();
								select1 s1 = new select1();
								if(cp.chngpass(s1.username(), retype)){
									replace tmp1 = new replace();
									tmp1.password(retype);
									dispose();
								}
								else{
									try {
										error dialog = new error("Connection to server not possible, Try again later!");
										dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
										dialog.setVisible(true);
										dialog.setLocationRelativeTo(null);
										dispose();
									} catch (Exception es) {
										es.printStackTrace();
									}									
								}
							}
							else
							{
								try {
									error dialog = new error("Your Passwords did not match, Try again!");
									dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									dialog.setVisible(true);	
									dialog.setLocationRelativeTo(null);
								} catch (Exception es) {
									es.printStackTrace();
								}
								cpswd.setText("");
								npswd.setText("");
								rpswd.setText("");
							}
							
						}
						else
						{
							try {
								error dialog = new error("Please enter your correct current password, Try again!");
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setVisible(true);	
								dialog.setLocationRelativeTo(null);
							} catch (Exception es) {
								es.printStackTrace();
							}
							cpswd.setText("");
							npswd.setText("");
							rpswd.setText("");
						}						
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
