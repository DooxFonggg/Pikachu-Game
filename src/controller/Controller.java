/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author phong
 */
/* tạo ma trận và gán stt hình ảnh vào từng mà trận với mỗi hình ảnh là 1 poin có tọa độ x y tương ứng row và col */
//với số ảnh luôn chẵn và số ảnh tối đa không quá 4 để tránh nhàm chán
public class Controller {
    	private int row;
	private int col;
	private int[][] matrix;
	public Controller(int row, int col) {
		this.row = row;
		this.col = col;
		System.out.println(row + "," + col);
		createMatrix();
                showMatrix();
	}
    public void showMatrix() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
	}
    private void createMatrix() {
		matrix = new int[row][col];
		Random rand = new Random();
		int imgCount = 21;
		int max = 4;
		int arr[] = new int[imgCount + 1];
		ArrayList<Point> listPoint = new ArrayList<Point>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				listPoint.add(new Point(i, j));
			}
		}
		int i = 0;
                do {
	           int index = rand.nextInt(imgCount) + 1;// 1-21
	           if (arr[index] < max) {// max = 4 
		       arr[index] += 2;
		       for (int j = 0; j < 2; j++) {
                            int size = listPoint.size();
                            int pointIndex = rand.nextInt(size);
                            matrix[listPoint.get(pointIndex).x]
                                  [listPoint.get(pointIndex).y] = index; // nhet index vao o trong ma tran
                            listPoint.remove(pointIndex);//danh dau da nhet vao
                       }
                   i++;
                   }
                } while (i < row * col / 2);
	}
     public int getRow() {
        return row;
    }

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
