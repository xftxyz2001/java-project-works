package com.xftxyz.shoppingcart.view;

import com.xftxyz.shoppingcart.service.GoodFactory;
import com.xftxyz.shoppingcart.service.ShoppingCart;
import com.xftxyz.shoppingcart.service.ShoppingException;

public class ShopView {

    private ShoppingCart sc;

    public static void main(String[] args) {
        new ShopView().enterMainMenu();
    }

    public ShopView() {
        sc = new ShoppingCart();
    }

    private void enterMainMenu() {
        boolean loopFlag = true;
        char selected = 0;
        do {
            if (selected != '1') {
                listAllGoods();
            }
            System.out.print("1-查看购物车 2-添加商品 3-删除商品 4-退出 请选择(1-4):");
            selected = SCUtility.readMenuSelection();
            switch (selected) {
            case '1':
                showShoppingCat();
                break;
            case '2':
                addGoods();
                break;
            case '3':
                removeGoods();
                break;
            case '4':
                System.out.print("确认是否退出(Y/N):");
                char isExit = SCUtility.readConfirmSelection();
                loopFlag = 'Y' != isExit;
                // loopFlag = false;
                break;
            }
        } while (loopFlag);
    }

    private void removeGoods() {
        System.out.print("请输入产品编号：(0-" + (GoodFactory.getSize() - 1) + "):");
        int id = SCUtility.readInt(GoodFactory.getSize() - 1);
        int ga = sc.getGoodAomunt(GoodFactory.getGood(id));
        if (ga == 0) {
            System.out.println("购物车中没有该商品");
            return;
        }
        System.out.print("请输入删除数量：(0-" + ga + "):");
        int amount = SCUtility.readInt(99);
        try {
            sc.removeGoods(GoodFactory.getGood(id), amount);
        } catch (ShoppingException e) {
            System.out.println("移除失败，原因：" + e.getMessage());
        }
    }

    private void addGoods() {
        System.out.print("请输入产品编号：(0-" + (GoodFactory.getSize() - 1) + "):");
        int id = SCUtility.readInt(GoodFactory.getSize() - 1);
        System.out.print("请输入添加数量：(0-99):");
        int amount = SCUtility.readInt(99);
        sc.addGoods(GoodFactory.getGood(id), amount);
    }

    private void showShoppingCat() {
        System.out.println("--------------------------------当前购物车--------------------------------");
        System.out.println(sc);
    }

    private void listAllGoods() {
        GoodFactory.showAllGoods();
    }
}
