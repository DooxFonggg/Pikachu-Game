/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author phong
 */

//tạo ma hiệu ứng button và động thời add ảnh qua chỉ số index từ class Controller 
public class ButtonEvent extends JPanel implements ActionListener {
	private int row;
	private int col;
	private int bound = 2;
	private int size = 50;
	private JButton[][] btn;
	private Controller controller;// liên quan đến thư mục controller
	private Color backGroundColor = Color.lightGray;
    private MainFrame frame;

	public ButtonEvent(MainFrame frame, int row, int col) {
        this.frame = frame;
		this.row = row;
		this.col = col;
                
		setLayout(new GridLayout(row, col, bound, bound)); // bound là khoảng cách giữa các thành phần
		setBackground(backGroundColor);
		setPreferredSize(new Dimension((size + bound) * col, (size + bound)
				* row));//  Cài đặt kích cỡ của khối Panel.
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setAlignmentY(JPanel.CENTER_ALIGNMENT);

		newGame();

	}

	public void newGame() {
		controller = new Controller(this.row, this.col);
		addArrayButton();

	}
// tạo ma trận nút nhấn với chỉ số hàng cột tương tự controller
	private void addArrayButton() {
		btn = new JButton[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				btn[i][j] = createButton(i + "," + j);// tạo button vị trí ô [i][j]
                                //hàm getIcon đã chứa index => khi nhét hình thì nhét đúng hình với chỉ số index đó 
				Icon icon = getIcon(controller.getMatrix()[i][j]);//dien icon vao vi tri [i][j]
				btn[i][j].setIcon(icon); // danh dau
				add(btn[i][j]);
			}
		}
	}

	private Icon getIcon(int index) {
		int width = 48, height = 48;
		Image image = new ImageIcon(getClass().getResource(
				"/icon/" + index + ".png")).getImage(); //tạo đường dẫn và chuyển thành ảnh
		Icon icon = new ImageIcon(image.getScaledInstance(width, height,
				image.SCALE_SMOOTH)); //css cho icon độ dài và rộng
		return icon;

	}
// hàm tạo từng button với trạng thái = action(nhấn or không nhấn)
	private JButton createButton(String action) {
		JButton btn = new JButton();
		btn.setActionCommand(action);
		btn.setBorder(null);
		btn.addActionListener(this); // lắng nghe nút nhấn
		return btn;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
