package GUI;

import java.awt.BorderLayout;
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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Font;

public class ChoiceScreen extends JFrame {

	static Member mem;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		mem = MainScreen.mem;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoiceScreen frame = new ChoiceScreen(mem);
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
	public ChoiceScreen(Member mem) {
		//System.out.println(mem.getName()+mem.getSex()+mem.getbYear()+mem.getbMonth()+mem.getbDay()+mem.getNumber()+mem.isEntered()+mem.getSitNum());
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//뒤로가기
		JButton backButton = new JButton("");
		backButton.setAction(action_2);
		backButton.setIcon(new ImageIcon("./image/icon/back.png"));
		backButton.setBorderPainted(false);
		backButton.setBackground(new Color(166, 214, 205));
		backButton.setBounds(14, 12, 71, 70);
		contentPane.add(backButton);
		
		//입실 버튼
		JButton enter = new JButton("");
		enter.setAction(action);
		enter.setPressedIcon(new ImageIcon("./image/button/enter2.png"));
		enter.setIcon(new ImageIcon("./image/button/enter1.png"));
		enter.setBounds(661, 169, 149, 92);
		contentPane.add(enter);
		
		//퇴실 버튼
		JButton leave = new JButton("");
		leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(MainScreen.mem.isEntered() == true) {
					mem.setEntered(false);
					MainScreen.s[mem.getSitNum()].setAvailable(true);
					mem.setSitNum(0);
					Leaved l = new Leaved();
					l.main(null);
					setVisible(false);
					
					/* String dummy ="";
					String s;
					String[] arr;
					BufferedReader r1 = null;
					BufferedWriter w1 = null;
				
					try {
						w1 = new BufferedWriter(new FileWriter("./data/seat_data.txt", false));
						r1 = new BufferedReader(new FileReader("./data/seat_data.txt"));
						for(int i=0; i<mem.getSitNum(); i++) {
						    s = r1.readLine(); 
						    dummy += (s +"\n");
						    System.out.println(dummy);
						}
						while((s=r1.readLine()) != null) {
							dummy += (s +"\n");
						}
						w1.write(dummy);
						w1.flush();
					} catch (FileNotFoundException e1) {
						System.out.println("파일이 존재하지 않음");
					} catch (IOException e1) {
						System.out.println("파일이 존재하지 않음");
					} finally {
						try {
							w1.flush();
							w1.close();
							r1.close();
						} catch (IOException e1) {
							System.out.println("파일이 존재하지 않음");
						}
						
					} */
				}
				
			}
		});
		leave.setAction(action_1);
		leave.setPressedIcon(new ImageIcon("./image/button/leave2.png"));
		leave.setIcon(new ImageIcon("./image/button/leave1.png"));
		leave.setBounds(661, 304, 149, 92);
		contentPane.add(leave);
		
		//이동 버튼
		JButton move = new JButton("");
		move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mem.isEntered() == true) {
					MainScreen.s[mem.getSitNum()].setAvailable(true);
					SeatingChart chart;
					try {
						chart = new SeatingChart();
						chart.main(null);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		move.setAction(action_3);
		move.setPressedIcon(new ImageIcon("./image/button/move2.png"));
		move.setIcon(new ImageIcon("./image/button/move1.png"));
		move.setBounds(661, 434, 149, 92);
		contentPane.add(move);
		
		JLabel lblNewLabel = new JLabel(mem.getName()+" 님 반갑습니다");
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 37));
		lblNewLabel.setBounds(123, 108, 444, 275);
		contentPane.add(lblNewLabel);
		
		//배경이미지
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/choice.png"));
		label.setBounds(0, 0, 960, 720);
		contentPane.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "입실");
		}
		public void actionPerformed(ActionEvent e) {
			if(MainScreen.mem.isEntered() == false) {
				SeatingChart chart;
				try {
					chart = new SeatingChart();
					chart.main(null);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "퇴실");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "첫 화면으로 돌아가기");
		}
		public void actionPerformed(ActionEvent e) {
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
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "이동");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
