/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author phong
 */

//hàm làm màn hình chính của game
public class MainFrame extends JFrame implements ActionListener, Runnable {
	private int row = 8;
	private int col = 8;
	private int width = 700;
	private int height = 500;
	private ButtonEvent graphicsPanel;
	private JPanel mainPanel;
      
	public MainFrame() {
		add(mainPanel = createMainPanel());
		setTitle("Pokemon Game");
		setResizable(false);//Cài đặt không cho phép phóng to màn hình.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cài đặt tắt chương trình khi ấn vào dấu X ở góc phải.
		setSize(width, height);
		setLocationRelativeTo(null);//Chương trình khi chạy sẽ hiển thị ở chính giữa màn hình.
		setVisible(true);// hiển thị khung
                
	}
// css cho thằng ma trận chứa button thôi
	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createGraphicsPanel(), BorderLayout.CENTER);
		return panel;
	}
// hàm này chỉ để tạo button
	private JPanel createGraphicsPanel() {
		graphicsPanel = new ButtonEvent(this, row, col);//tạo button và nhét icon vào
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		panel.add(graphicsPanel);
		return panel;
	}
    @Override
	public void actionPerformed(ActionEvent e) {   
	}


	@Override
	public void run() {
	}
}
