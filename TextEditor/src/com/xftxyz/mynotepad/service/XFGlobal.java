package com.xftxyz.mynotepad.service;

/**
 * XFGlobal
 */
public interface XFGlobal {

    String WORKSPACE = System.getProperty("user.dir");
    String BOOK_NAME = "无标题.txt";
    int WIDTH = 800;
    int HEIGHT = 600;
    int STATISTICS_WIDTH = 300;
    int STATISTICS_HEIGHT = 150;

    String HELP_CONTENT = "------------------------------------------------------------帮助文档------------------------------------------------------------\n键入文字以开始。\n文件选项卡提供新建、打开、保存、另存为和退出功能。\n在编辑中进行复制和粘贴。（注意：复制会将文本框中所有文本复制到系统剪贴板。粘贴会追加剪贴板的内容到文本框末尾）\n从视图-统计中可以得知当前键入的字符数目。\n\n提示：本文件可以编辑，并不会对本文档长生影响。";
}