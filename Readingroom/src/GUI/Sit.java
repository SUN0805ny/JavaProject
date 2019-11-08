package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ReadingRoom.Member;
import ReadingRoom.Seat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sit extends JFrame {
	static int i;

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sit frame = new Sit(i);
					frame.setTitle("독서실 이용 프로그램");
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
	public Sit(int i) {
		this.i=i;
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//뒤로가기
		JButton backButton = new JButton("");
		backButton.setAction(action_1);
		backButton.setIcon(new ImageIcon("./image/icon/back.png"));
		backButton.setBorderPainted(false);
		backButton.setBackground(new Color(166, 214, 205));
		backButton.setBounds(14, 12, 71, 70);
		contentPane.add(backButton);
		
		//좌석 번호
		JLabel sNum = new JLabel(Integer.toString(i));
		sNum.setFont(new Font("나눔바른고딕", Font.PLAIN, 59));
		sNum.setHorizontalAlignment(SwingConstants.CENTER);
		sNum.setBounds(532, 289, 94, 63);
		contentPane.add(sNum);
		
		//확인 버튼
		JButton okButton = new JButton("");
		okButton.setAction(action);
		okButton.setPressedIcon(new ImageIcon("./image/button/ok2.png"));
		okButton.setIcon(new ImageIcon("./image/button/ok1.png"));
		okButton.setBounds(422, 416, 101, 52);
		contentPane.add(okButton);
		
		//배경이미지
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./image/seatnext.png"));
		lblNewLabel.setBounds(0, 0, 960, 720);
		contentPane.add(lblNewLabel);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "확인");
		}
		public void actionPerformed(ActionEvent e) {
			Member mem = MainScreen.mem;
			Seat s = MainScreen.s[i-1];
			s.setAvailable(false);
			mem.setSitNum(i);
			
			MainScreen m = new MainScreen();
			try {
				m.main(null);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "뒤로가기");
		}
		public void actionPerformed(ActionEvent e) {
			SeatingChart s1;
			try {
				s1 = new SeatingChart();
				s1.main(null);
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
	}
}
