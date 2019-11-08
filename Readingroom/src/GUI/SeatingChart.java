package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ReadingRoom.Member;
import ReadingRoom.Seat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import java.awt.Font;

public class SeatingChart extends JFrame {
	
	private JPanel contentPane;
	private final Action action = new SwingAction();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatingChart frame = new SeatingChart();
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
	public SeatingChart() throws NumberFormatException, IOException {	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//뒤로가기
		JButton backButton = new JButton("");
		backButton.setAction(action);
		backButton.setIcon(new ImageIcon("./image/icon/back.png"));
		backButton.setBorderPainted(false);
		backButton.setBackground(new Color(166, 214, 205));
		backButton.setBounds(14, 12, 71, 70);
		contentPane.add(backButton);
		
		//좌석 1~36
		JButton seat01 = new JButton("\uC0AC\uC6A9\uC911");
		btnDesign(0, seat01);
		seat01.setHideActionText(true);
		seat01.setBounds(141, 78, 97, 64);
		contentPane.add(seat01);
		
		JButton seat02 = new JButton("\uC0AC\uC6A9\uC911");
		seat02.setHideActionText(true);
		btnDesign(1, seat02);
		seat02.setBounds(247, 78, 97, 64);
		contentPane.add(seat02);
		
		JButton seat03 = new JButton("\uC0AC\uC6A9\uC911");
		seat03.setHideActionText(true);
		btnDesign(2, seat03);
		seat03.setBounds(351, 78, 97, 64);
		contentPane.add(seat03);
		
		JButton seat04 = new JButton("\uC0AC\uC6A9\uC911");
		seat04.setHideActionText(true);
		btnDesign(3, seat04);
		seat04.setBounds(141, 149, 97, 64);
		contentPane.add(seat04);
		
		JButton seat05 = new JButton("\uC0AC\uC6A9\uC911");
		seat05.setHideActionText(true);
		btnDesign(4, seat05);
		seat05.setBounds(247, 149, 97, 64);
		contentPane.add(seat05);
		
		JButton seat06 = new JButton("\uC0AC\uC6A9\uC911");
		seat06.setHideActionText(true);
		btnDesign(5, seat06);
		seat06.setBounds(351, 149, 97, 64);
		contentPane.add(seat06);
		
		JButton seat07 = new JButton("\uC0AC\uC6A9\uC911");
		seat07.setHideActionText(true);
		btnDesign(6, seat07);
		seat07.setBounds(141, 262, 97, 64);
		contentPane.add(seat07);
		
		JButton seat08 = new JButton("\uC0AC\uC6A9\uC911");
		seat08.setHideActionText(true);
		btnDesign(7, seat08);
		seat08.setBounds(247, 262, 97, 64);
		contentPane.add(seat08);
		
		JButton seat09 = new JButton("\uC0AC\uC6A9\uC911");
		seat09.setHideActionText(true);
		btnDesign(8, seat09);
		seat09.setBounds(351, 262, 97, 64);
		contentPane.add(seat09);
		
		JButton seat10 = new JButton("\uC0AC\uC6A9\uC911");
		seat10.setHideActionText(true);
		btnDesign(9, seat10);
		seat10.setBounds(141, 333, 97, 64);
		contentPane.add(seat10);
		
		JButton seat11 = new JButton("\uC0AC\uC6A9\uC911");
		seat11.setHideActionText(true);
		btnDesign(10, seat11);
		seat11.setBounds(247, 333, 97, 64);
		contentPane.add(seat11);
		
		JButton seat12 = new JButton("\uC0AC\uC6A9\uC911");
		seat12.setHideActionText(true);
		btnDesign(11, seat12);
		seat12.setBounds(351, 333, 97, 64);
		contentPane.add(seat12);
		
		JButton seat13 = new JButton("\uC0AC\uC6A9\uC911");
		seat13.setHideActionText(true);
		btnDesign(12, seat13);
		seat13.setBounds(141, 446, 97, 64);
		contentPane.add(seat13);
		
		JButton seat14 = new JButton("\uC0AC\uC6A9\uC911");
		seat14.setHideActionText(true);
		btnDesign(13, seat14);
		seat14.setBounds(247, 446, 97, 64);
		contentPane.add(seat14);
		
		JButton seat15 = new JButton("\uC0AC\uC6A9\uC911");
		seat15.setHideActionText(true);
		btnDesign(14, seat15);
		seat15.setBounds(351, 446, 97, 64);
		contentPane.add(seat15);
		
		JButton seat16 = new JButton("\uC0AC\uC6A9\uC911");
		seat16.setHideActionText(true);
		btnDesign(15, seat16);
		seat16.setBounds(141, 517, 97, 64);
		contentPane.add(seat16);
		
		JButton seat17 = new JButton("\uC0AC\uC6A9\uC911");
		seat17.setHideActionText(true);
		btnDesign(16, seat17);
		seat17.setBounds(247, 517, 97, 64);
		contentPane.add(seat17);
		
		JButton seat18 = new JButton("\uC0AC\uC6A9\uC911");
		seat18.setHideActionText(true);
		btnDesign(17, seat18);
		seat18.setBounds(351, 517, 97, 64);
		contentPane.add(seat18);
		
		JButton seat19 = new JButton("\uC0AC\uC6A9\uC911");
		seat19.setHideActionText(true);
		btnDesign(18, seat19);
		seat19.setBounds(507, 78, 97, 64);
		contentPane.add(seat19);
		
		JButton seat20 = new JButton("\uC0AC\uC6A9\uC911");
		seat20.setHideActionText(true);
		btnDesign(19, seat20);
		seat20.setBounds(613, 78, 97, 64);
		contentPane.add(seat20);
		
		JButton seat21 = new JButton("\uC0AC\uC6A9\uC911");
		seat21.setHideActionText(true);
		btnDesign(20, seat21);
		seat21.setBounds(717, 78, 97, 64);
		contentPane.add(seat21);
		
		JButton seat22 = new JButton("\uC0AC\uC6A9\uC911");
		seat22.setHideActionText(true);
		btnDesign(21, seat22);
		seat22.setBounds(507, 149, 97, 64);
		contentPane.add(seat22);
		
		JButton seat23 = new JButton("\uC0AC\uC6A9\uC911");
		seat23.setHideActionText(true);
		btnDesign(22, seat23);
		seat23.setBounds(613, 149, 97, 64);
		contentPane.add(seat23);
		
		JButton seat24 = new JButton("\uC0AC\uC6A9\uC911");
		seat24.setHideActionText(true);
		btnDesign(23, seat24);
		seat24.setBounds(717, 149, 97, 64);
		contentPane.add(seat24);
		
		JButton seat25 = new JButton("\uC0AC\uC6A9\uC911");
		seat25.setHideActionText(true);
		btnDesign(24, seat25);
		seat25.setBounds(507, 262, 97, 64);
		contentPane.add(seat25);
		
		JButton seat26 = new JButton("\uC0AC\uC6A9\uC911");
		seat26.setHideActionText(true);
		btnDesign(25, seat26);
		seat26.setBounds(613, 262, 97, 64);
		contentPane.add(seat26);
		
		JButton seat27 = new JButton("\uC0AC\uC6A9\uC911");
		seat27.setHideActionText(true);
		btnDesign(26, seat27);
		seat27.setBounds(717, 262, 97, 64);
		contentPane.add(seat27);
		
		JButton seat28 = new JButton("\uC0AC\uC6A9\uC911");
		seat28.setHideActionText(true);
		btnDesign(27, seat28);
		seat28.setBounds(507, 333, 97, 64);
		contentPane.add(seat28);
		
		JButton seat29 = new JButton("\uC0AC\uC6A9\uC911");
		seat29.setHideActionText(true);
		btnDesign(28, seat29);
		seat29.setBounds(613, 333, 97, 64);
		contentPane.add(seat29);
		
		JButton seat30 = new JButton("\uC0AC\uC6A9\uC911");
		seat30.setHideActionText(true);
		btnDesign(29, seat30);
		seat30.setBounds(717, 333, 97, 64);
		contentPane.add(seat30);
		
		JButton seat31 = new JButton("\uC0AC\uC6A9\uC911");
		seat31.setHideActionText(true);
		btnDesign(30, seat31);
		seat31.setBounds(507, 446, 97, 64);
		contentPane.add(seat31);
		
		JButton seat32 = new JButton("\uC0AC\uC6A9\uC911");
		seat32.setHideActionText(true);
		btnDesign(31, seat32);
		seat32.setBounds(613, 446, 97, 64);
		contentPane.add(seat32);
		
		JButton seat33 = new JButton("\uC0AC\uC6A9\uC911");
		seat33.setHideActionText(true);
		btnDesign(32, seat33);
		seat33.setBounds(717, 446, 97, 64);
		contentPane.add(seat33);
		
		JButton seat34 = new JButton("\uC0AC\uC6A9\uC911");
		seat34.setHideActionText(true);
		btnDesign(33, seat34);
		seat34.setBounds(507, 517, 97, 64);
		contentPane.add(seat34);
		
		JButton seat35 = new JButton("\uC0AC\uC6A9\uC911");
		seat35.setHideActionText(true);
		btnDesign(34, seat35);
		seat35.setBounds(613, 517, 97, 64);
		contentPane.add(seat35);
		
		JButton seat36 = new JButton("\uC0AC\uC6A9\uC911");
		seat36.setHideActionText(true);
		btnDesign(35, seat36);
		seat36.setBounds(717, 517, 97, 64);
		contentPane.add(seat36);
		//배경이미지
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/seat.png"));
		label.setBounds(0, 0, 960, 720);
		contentPane.add(label);
	}
	
	//사용 가능 여부에 따라 디자인 변경
	public void btnDesign(int i, JButton seat) {
		Seat s=MainScreen.s[i];
		seat.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		if(s.isAvailable() == true) {
			seat.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
			seat.setText(Integer.toString(s.getNumber()));
			seat.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 0)));
			seat.setBackground(Color.WHITE);
			seat.setForeground(new Color(255, 0, 0));
			seat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sit s1 = new Sit(i+1);
					s1.main(null);
					setVisible(false);
				}
			});
		}else {
			seat.setEnabled(false);
			seat.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
			seat.setBackground(Color.WHITE);
			seat.setForeground(new Color(0, 0, 0));
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "뒤로가기");
		}
		public void actionPerformed(ActionEvent e) {
			Member mem = new Member();
			ChoiceScreen cScreen = new ChoiceScreen(mem);
			cScreen.main(null);
			setVisible(false);
		}
	}
}
