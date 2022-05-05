package com.xftxyz.turtle.service;

public interface XFGlobal {

    // 全局配置
    // 窗口宽度
    int WIDTH = 900;
    // 窗口高度
    int HEIGHT = 700;
    // 网格大小
    int GRID_SIZE = 15;
    // 地图宽度
    int MAP_WIDTH = 36;
    // Margins
    int MARGIN = 20;
    // 帮助信息
    String HELP_CONTENT = "<html><body><h3>" + "<font color=\"#0000FF\">绘图指令：</font></h3><br>"
            + "<font color=\"#090\">1：抬起画笔<br>" + "2：落下画笔<br>" + "3：右转<br>" + "4：左转<br>"
            + "5：画笔向前移动n步<br>  (首次移动时默认为向右移动)<br>" + "6：刷新面板<br>" + "7：擦除图形<br>" + "8：退出程序<br></font></body></html>";
    // "<html><body>使用本程序绘图的小技巧：<br> 1. 使用Excel辅助图形设计（帮助获取正确的指令）<br> 2.
    // 推荐的绘图顺序：向前移动前，先确定正确的前进方向，然后再设置画笔状态（抬起或落下）<br> 3.
    // 如果画板（棋盘）上某个位置为空，则应该在离开该位置向前移动到其他位置前，将画笔设置为抬起（输入指令1）。反之亦反。</body></html>";

}
