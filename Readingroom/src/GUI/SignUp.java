package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ReadingRoom.Member;
import ReadingRoom.Seat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp extends JFrame {
	Seat seat = new Seat(0, false);
	
	private JPanel contentPane;
	private JTextField inputName;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField numInput;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action_2 = new SwingAction_3();

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//뒤로가기
		JButton backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		backButton.setAction(action_1);
		backButton.setBorderPainted(false);
		backButton.setIcon(new ImageIcon("./image/icon/back.png"));
		backButton.setBounds(14, 12, 71, 70);
		backButton.setBackground(new Color(166, 214, 205));
		contentPane.add(backButton);
		
		//이름 입력란
		inputName = new JTextField();
		inputName.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 40));
		inputName.setBounds(283, 219, 241, 50);
		contentPane.add(inputName);
		inputName.setColumns(10);
		
		//남성
		maleButton = new JRadioButton(" 남성");
		maleButton.setHideActionText(true);
		buttonGroup.add(maleButton);
		buttonGroup.add(maleButton);
		maleButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 33));
		maleButton.setBackground(new Color(166, 214, 205));
		maleButton.setBounds(283, 328, 126, 45);
		contentPane.add(maleButton);
		//여성
		femaleButton = new JRadioButton(" 여성");
		femaleButton.setHideActionText(true);
		buttonGroup.add(femaleButton);
		buttonGroup.add(femaleButton);
		femaleButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 33));
		femaleButton.setBackground(new Color(166, 214, 205));
		femaleButton.setBounds(432, 328, 170, 45);
		contentPane.add(femaleButton);
		
		//생년월일 값 지정
		String year[] = new String[101];
		String month[] = new String[12];
		String day[] = new String[31];
		for(int i=0; i<101; i++) {
			year[i] = Integer.toString(i+1919);
		}
		for(int j=0; j<12; j++) {
			month[j] = Integer.toString(j+1);
		}
		for(int k=0; k<31; k++) {
			day[k] = Integer.toString(k+1);
		}
		//생년
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(year));
		comboBox.setFont(new Font("굴림", Font.BOLD, 30));
		comboBox.setBounds(283, 424, 107, 50);
		contentPane.add(comboBox);
		//생월
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("굴림", Font.BOLD, 30));
		comboBox_1.setModel(new DefaultComboBoxModel(month));
		comboBox_1.setBounds(471, 424, 67, 50);
		contentPane.add(comboBox_1);
		//생일
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(day));
		comboBox_2.setFont(new Font("굴림", Font.BOLD, 30));
		comboBox_2.setBounds(616, 424, 67, 50);
		contentPane.add(comboBox_2);
		
		JLabel label_1 = new JLabel("년");
		label_1.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 40));
		label_1.setBounds(404, 424, 62, 60);
		contentPane.add(label_1);
		JLabel label_2 = new JLabel("\uC6D4");
		label_2.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 40));
		label_2.setBounds(552, 424, 62, 60);
		contentPane.add(label_2);
		JLabel label_3 = new JLabel("\uC77C");
		label_3.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 40));
		label_3.setBounds(697, 424, 62, 60);
		contentPane.add(label_3);
		
		//번호 입력란
		numInput = new JTextField();
		numInput.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField)ke.getSource();
				if(src.getText().length() >= 6) ke.consume();
			}
		});
		numInput.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 40));
		numInput.setColumns(10);
		numInput.setBounds(382, 515, 301, 50);
		contentPane.add(numInput);
		
		JButton button = new JButton("");
		button.setAction(action_2);
		button.setBorderPainted(false);
		button.setPressedIcon(new ImageIcon("./image/button/doublecheck2.png"));
		button.setIcon(new ImageIcon("./image/button/doublecheck1.png"));
		button.setBounds(697, 506, 136, 66);
		contentPane.add(button);
		
		//등록버튼
		JButton signUp = new JButton("");
		signUp.setAction(action);
		signUp.setPressedIcon(new ImageIcon("./image/button/get2.png"));
		signUp.setIcon(new ImageIcon("./image/button/get1.png"));
		signUp.setBounds(424, 598, 100, 51);
		contentPane.add(signUp);
		
		JLabel label_4 = new JLabel("*회원번호는 6자리 숫자로만 작성해주세요");
		label_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 15));
		label_4.setBounds(382, 568, 377, 18);
		contentPane.add(label_4);
		
		//배경이미지
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/member.png"));
		label.setBounds(0, 0, 960, 720);
		contentPane.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "등록");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				BufferedWriter w1 = new BufferedWriter(new FileWriter("./data/member_data.txt", true));
				w1.write(inputName.getText()+"\t");
				if(maleButton.isSelected()==true) {
					w1.write(maleButton.getText()+"\t");
				}
				if(femaleButton.isSelected()==true){
					w1.write(femaleButton.getText()+"\t");
				}
				w1.write(comboBox.getSelectedItem().toString()+"\t");
				w1.write(comboBox_1.getSelectedItem().toString()+"\t");
				w1.write(comboBox_2.getSelectedItem().toString()+"\t");
				w1.write(numInput.getText()+"\t");
				w1.write("false\t0\n");
				w1.flush();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			MainScreen screen = new MainScreen();
			try {
				screen.main(null);
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
			putValue(SHORT_DESCRIPTION, "중복확인");
		}
		public void actionPerformed(ActionEvent e) {
			String s;
			String[] arr;
			boolean found = false;
			BufferedReader bos;
			try {
				bos = new BufferedReader(new FileReader("./data/member_data.txt"));
				while((s=bos.readLine()) != null) {
					arr=s.split("\t");
					if(numInput.getText().equals(arr[5])) {
						found = true;
						Error02 e1 = new Error02();
						e1.main(null);
					}
				}
				if(found == false && numInput.getText().length() == 6) {
					memberOk m = new memberOk();
					m.main(null);
				}
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
