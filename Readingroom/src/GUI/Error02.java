package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Error02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error02 frame = new Error02();
					frame.setTitle("오류 메시지");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);	//정가운데서 실행
					frame.setResizable(false);			//화면 크기 고정
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Error02() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/warning.png"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 447, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경이미지
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/message/member_error.png"));
		label.setBounds(0, 0, 441, 253);
		contentPane.add(label);
	}

}
