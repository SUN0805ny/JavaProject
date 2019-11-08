package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ReadingRoom.Seat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.Action;

public class SeatChose extends JFrame {
	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatChose frame = new SeatChose();
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
	public SeatChose() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./image/icon/book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 960, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Ȯ�� ��ư
		JButton okButton = new JButton("");
		okButton.setAction(action);
		okButton.setPressedIcon(new ImageIcon("./image/button/ok2.png"));
		okButton.setIcon(new ImageIcon("./image/button/ok1.png"));
		okButton.setBounds(422, 416, 101, 52);
		contentPane.add(okButton);
		
		//����̹���
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("./image/finish.png"));
		label.setBounds(0, 0, 960, 720);
		contentPane.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Ȯ��");
		}
		public void actionPerformed(ActionEvent e) {
			Seat seat = new Seat(0, false);
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
}
