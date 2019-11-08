package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ReadingRoom.Member;
import ReadingRoom.Seat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MainScreen extends JFrame {
	String preNum = "";
	static int win = 0;
	static Seat[] s = new Seat[36];
	static Member mem;
	static int cnt;
	private JPanel contentPane;
	private final Action toChoice = new SwingAction();
	private final Action toSignUp = new SwingAction_1();

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		if(win == 0) {//�¼� ����
			int i=0;
			String ss;
			String[] arr;
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader("./data/seat_data.txt"));
				while((ss=reader.readLine()) != null) {
					arr=ss.split("\t");
					s[i] = new Seat(Integer.parseInt(arr[0]), Boolean.valueOf(arr[1]).booleanValue());
					//System.out.println(ss);
					//System.out.println(s[i].getNumber()+""+s[i].isAvailable());
					i++;
				}i=0;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				reader.close();
			}
			win++;
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setTitle("������ �̿� ���α׷�");
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
	public MainScreen() {
		Seat seat = new Seat(0, false);
		cnt = seat.getCount();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���� �¼� ��
		JLabel lblNewLabel = new JLabel(Integer.toString(cnt));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("�����ٸ����", Font.PLAIN, 55));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(678, 145, 107, 61);
		contentPane.add(lblNewLabel);
		
		//��ȣ �Է¶�
		JTextField inputNum = new JTextField();
		inputNum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField)ke.getSource();
				if(src.getText().length() >= 6) ke.consume();
			}
		});
		inputNum.setMargin(new Insets(6, 2, 2, 2));
		inputNum.setFont(new Font("�����ٸ����", Font.BOLD, 30));
		inputNum.setBounds(92, 271, 297, 58);
		contentPane.add(inputNum);
		inputNum.setColumns(10);
		
		//Ȯ�ι�ư
		JButton okayButton = new JButton("");
		okayButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		okayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(inputNum.getText().equals(preNum)) {
					mem = new Member(mem.getName(), mem.getSex(), mem.getbYear(), mem.getbMonth(), mem.getbDay(), mem.getNumber(), mem.isEntered(), mem.getSitNum());
				}else {
					String s;
					String[] arr;
					boolean found = false;
					BufferedReader reader = null;
					try {
						reader = new BufferedReader(new FileReader("./data/member_data.txt"));
						while((s=reader.readLine()) != null) {
							arr=s.split("\t");
							if(inputNum.getText().equals(arr[5])) {
								found = true;
								mem = new Member(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Boolean.valueOf(arr[6]).booleanValue(), Integer.parseInt(arr[7]));
								//System.out.println(mem.getName()+mem.getSex()+mem.getbYear()+mem.getbMonth()+mem.getbDay()+mem.getNumber()+mem.isEntered()+mem.getSitNum());
								ChoiceScreen choice = new ChoiceScreen(mem);
								choice.main(null);
								setVisible(false);
								preNum = inputNum.getText();
							}
						}if(found == false) {
							Error01 error1 = new Error01();
							error1.main(null);
						}
					} catch (FileNotFoundException e) {
						System.out.println("������");
					} catch (IOException e) {
						System.out.println("������");
					} finally {
						try {
							reader.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		okayButton.setAction(toChoice);
		okayButton.setIcon(new ImageIcon("./image/button/okay1.png"));
		okayButton.setBounds(408, 275, 100, 51);
		okayButton.setPressedIcon(new ImageIcon("./image/button/okay2.png"));
		getContentPane().add(okayButton);
		
		//��Ϲ�ư
		JButton getButton = new JButton("");
		getButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUpScreen = new SignUp();
				signUpScreen.main(null);
				setVisible(false);
			}
		});
		getButton.setAction(toSignUp);
		getButton.setIcon(new ImageIcon("./image/button/get1.png"));
		getButton.setBounds(537, 275, 100, 51);
		getButton.setPressedIcon(new ImageIcon("./image/button/get2.png"));
		contentPane.add(getButton);
		
		//����̹���
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/main.png"));
		label.setBounds(0, 0, 960, 720);
		contentPane.add(label);
	}
	
	//Ȯ�� ��ư ���� ��
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Ȯ��");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	//��� ��ư ���� ��
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "���");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
