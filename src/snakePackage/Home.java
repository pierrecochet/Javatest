package snakePackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 153));
		frame.setBackground(new Color(102, 153, 153));
		frame.getContentPane().setForeground(new Color(102, 153, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 299, 450, 1);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				GamePanel GamePanel = new GamePanel();
	            GamePanel.pack();
	            GamePanel.setLocationRelativeTo(null);
	            GamePanel.setVisible(true);
	            
			}
		});
		btnPlay.setBackground(SystemColor.controlHighlight);
		btnPlay.setBounds(127, 165, 202, 59);
		frame.getContentPane().add(btnPlay);
		
		JLabel lbldSnake = new JLabel("2D Snake");
		lbldSnake.setForeground(SystemColor.text);
		lbldSnake.setFont(new Font("Dialog", Font.BOLD, 30));
		lbldSnake.setBounds(146, 55, 174, 42);
		frame.getContentPane().add(lbldSnake);
		frame.setLocationRelativeTo(null);
	}
}
