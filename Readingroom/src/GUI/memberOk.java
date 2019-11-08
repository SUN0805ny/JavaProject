package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class memberOk extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberOk frame = new memberOk();
					frame.setTitle("�ȳ� �޽���");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);	//������� ����
					frame.setResizable(false);			//ȭ�� ũ�� ����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public memberOk() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 448, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/message/member_ok.png"));
		label.setBounds(0, 0, 442, 254);
		contentPane.add(label);
	}

}
