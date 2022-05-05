package com.xftxyz.mynotepad.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import java.awt.datatransfer.StringSelection;

public class ClipboardUtil {

    // 获取剪切板的内容
    public static String getSystemClipboardText() {
        String res = "";
        Clipboard sysclip = Toolkit.getDefaultToolkit().getSystemClipboard();

        Transferable clipif = sysclip.getContents(null);

        if (clipif != null) {
            // 检查为文本类型
            if (clipif.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    res = (String) clipif.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return res;
    }

    // 设置剪切板的内容
    public static void setSystemClipboardText(String writeFile) {
        Clipboard sysclip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Transferable clipif = sysclip.getContents(writeFile);
        Transferable clipif = new StringSelection(writeFile);

        sysclip.setContents(clipif, null);
    }
}
