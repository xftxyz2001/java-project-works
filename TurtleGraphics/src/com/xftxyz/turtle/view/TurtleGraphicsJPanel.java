package com.xftxyz.turtle.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.xftxyz.turtle.service.XFDirection;
import static com.xftxyz.turtle.service.XFDirection.*;
import com.xftxyz.turtle.service.XFGlobal;

public class TurtleGraphicsJPanel extends JPanel {

	// 调用者
	private TurtleGraphicsView turtleGraphicsView;

	// 画笔状态：是否落下
	private boolean isPenDown;
	// 当前朝向
	private XFDirection currentDirection;

	// 移动步数
	private int pace = 1;

	// 场景状态
	private boolean[][] positions;

	// 龟头坐标
	private int row;
	private int column;

	// 构造函数
	public TurtleGraphicsJPanel(TurtleGraphicsView turtleGraphicsView) {
		this.turtleGraphicsView = turtleGraphicsView;
		// 初始化
		removeCurrentGraphics();
		setGraphicsViewDrawingStatusText("朝向已初始化为东");
	}

	// 处理用户指令
	public void turtleBehaviour(int cmd) {
		switch (cmd) {
		case 1: // 抬起画笔
			isPenDown = false;
			setGraphicsViewDrawingStatusText("画笔已抬起");
			break;
		case 2: // 落下画笔
			isPenDown = true;
			setGraphicsViewDrawingStatusText("画笔已落下");
			break;
		case 3:// 右转
			currentDirection = currentDirection.turnRight();
			setGraphicsViewDrawingStatusText("朝向已更改:已向右转");
			break;
		case 4:// 左转
			currentDirection = currentDirection.turnLeft();
			setGraphicsViewDrawingStatusText("朝向已更改:已向左转");
			break;
		case 5: // 向前移动
			forward();
			setGraphicsViewDrawingStatusText("已向前移动" + pace + "步");
			break;
		case 6: // 重新绘制
			break;
		case 7:// 擦除当前图形
			removeCurrentGraphics();
			setGraphicsViewDrawingStatusText("已擦除当前图形");
			break;
		case 8:// 退出程序
			setGraphicsViewDrawingStatusText("退出程序中");
			System.exit(0);
			break;

		}
		repaint();
	}

	// 向前移动
	private void forward() {
		switch (currentDirection) {
		case 东:
			if (isPenDown)
				for (int j = column; j < column + pace; j++)
					positions[row][j] = true;
			column += pace;
			break;
		case 西:
			if (isPenDown)
				for (int j = column; j > column - pace; j--)
					positions[row][j] = true;
			column -= pace;
			break;
		case 南:
			if (isPenDown)
				for (int i = row; i < row + pace; i++)
					positions[i][column] = true;
			row += pace;
			break;
		case 北:
			if (isPenDown)
				for (int i = row; i > row - pace; i--)
					positions[i][column] = true;
			row -= pace;
			break;
		}
	}

	// 重写paint方法，绘制图形
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// 横向偏移
		int hOffset = XFGlobal.MARGIN;
		// 纵向偏移
		int vOffset = XFGlobal.MARGIN;

		g2d.setColor(Color.blue);
		for (int i = 0; i < XFGlobal.MAP_WIDTH; i++) {
			// 打印绘图区列标
			g2d.drawString("" + (i + 1), i * XFGlobal.GRID_SIZE + hOffset + 6, vOffset - 10);
		}
		for (int i = 0; i < XFGlobal.MAP_WIDTH; i++) {
			// 打印绘图区行标
			g2d.drawString("" + (i + 1), hOffset - 17, i * XFGlobal.GRID_SIZE + vOffset + 14);
		}
		// 打印绘图区内容
		for (int i = 0; i < XFGlobal.MAP_WIDTH; i++) {
			for (int j = 0; j < XFGlobal.MAP_WIDTH; j++) {
				if (positions[i][j]) {
					g2d.fillRect(j * XFGlobal.GRID_SIZE + hOffset, i * XFGlobal.GRID_SIZE + vOffset, XFGlobal.GRID_SIZE,
							XFGlobal.GRID_SIZE);
				} else
					g2d.drawRect(j * XFGlobal.GRID_SIZE + hOffset, i * XFGlobal.GRID_SIZE + vOffset, XFGlobal.GRID_SIZE,
							XFGlobal.GRID_SIZE);
			}
		}

	}

	// 设置状态栏文本
	public void setGraphicsViewDrawingStatusText(String str) {
		turtleGraphicsView.setDrawingStatusText(
				String.format("当前位置: [%d, %d] 当前朝向: %s  --" + str, row + 1, column + 1, currentDirection));
	}

	// 擦除当前图形
	public void removeCurrentGraphics() {
		// 重置数组
		positions = new boolean[XFGlobal.MAP_WIDTH][XFGlobal.MAP_WIDTH];
		// 绘制空白画板
		repaint();
		// 重置画笔位置为画板左上角
		row = column = 0;
		currentDirection = 东;
		isPenDown = false;
	}

	public void setPace(String text) {
		try {
			pace = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "指令有误", "错误", JOptionPane.ERROR_MESSAGE);
			pace = 1;
		}
	}
}
