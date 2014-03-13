import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class host_detail extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtone;
	private JTextField txttwo;
	private JTextField textHostName;
	private JTextField textHostIp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			host_detail dialog = new host_detail();
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
	public host_detail() {
		setTitle("Remote Machine");
		setFont(new Font("Arial", Font.BOLD, 12));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		txtone = new JTextField();
		txtone.setBorder(null);
		txtone.setBackground(Color.WHITE);
		txtone.setFont(new Font("Arial", Font.BOLD, 12));
		txtone.setEditable(false);
		txtone.setText("Host Name:");
		txtone.setColumns(10);
		
		txttwo = new JTextField();
		txttwo.setBorder(null);
		txttwo.setBackground(Color.WHITE);
		txttwo.setFont(new Font("Arial", Font.BOLD, 12));
		txttwo.setEditable(false);
		txttwo.setText("Host IP:");
		txttwo.setColumns(10);
		
		textHostName = new JTextField();
		textHostName.setBackground(Color.WHITE);
		textHostName.setFont(new Font("Arial", Font.BOLD, 12));
		textHostName.setColumns(10);
		select1 tmp = new select1();
		String hname = tmp.host();
		textHostName.setText(hname);
		
		textHostIp = new JTextField();
		textHostIp.setBackground(Color.WHITE);
		textHostIp.setFont(new Font("Arial", Font.BOLD, 12));
		textHostIp.setColumns(10);
		String hip = tmp.ip();
		textHostIp.setText(hip);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txttwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textHostIp))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textHostName, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textHostName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txttwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textHostIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Change");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						replace tmp = new replace();
						tmp.hostname(textHostName.getText());
						tmp.ipaddress(textHostIp.getText());
						dispose();
					}
				});
				okButton.setFont(new Font("Arial", Font.BOLD, 12));
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
