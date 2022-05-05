package com.xftxyz.shoppingcart.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.xftxyz.shoppingcart.domain.Goods;

public class GoodFactory {
    private static ArrayList<Goods> goods = new ArrayList<Goods>();

    static {

        goods.add(new Goods("萝卜", new BigDecimal("1.30")));
        goods.add(new Goods("西红柿", new BigDecimal("4.40")));
        goods.add(new Goods("荷兰豆", new BigDecimal("9.50")));
        goods.add(new Goods("油麦菜", new BigDecimal("3.80")));
        goods.add(new Goods("茼蒿", new BigDecimal("3.80")));
        goods.add(new Goods("西兰花", new BigDecimal("5.50")));
        goods.add(new Goods("小白菜", new BigDecimal("1.80")));
        goods.add(new Goods("尖椒", new BigDecimal("2.50")));
        goods.add(new Goods("苦瓜", new BigDecimal("4.70")));
        goods.add(new Goods("香菇", new BigDecimal("5.50")));
        goods.add(new Goods("莴笋", new BigDecimal("2.80")));
        goods.add(new Goods("蒜薹", new BigDecimal("6.50")));
        goods.add(new Goods("香菜", new BigDecimal("4.80")));
        goods.add(new Goods("油菜", new BigDecimal("2.80")));
        goods.add(new Goods("菠菜", new BigDecimal("5.50")));
        goods.add(new Goods("生菜", new BigDecimal("4.50")));
        goods.add(new Goods("洋白菜", new BigDecimal("0.80")));
        goods.add(new Goods("豆角", new BigDecimal("5.50")));
        goods.add(new Goods("大蒜", new BigDecimal("4.00")));
        goods.add(new Goods("菜花", new BigDecimal("0.50")));
        goods.add(new Goods("胡萝卜", new BigDecimal("0.90")));
        goods.add(new Goods("茄子", new BigDecimal("3.20")));
        goods.add(new Goods("白萝卜", new BigDecimal("1.80")));
        goods.add(new Goods("大葱", new BigDecimal("3.30")));
        goods.add(new Goods("韭菜", new BigDecimal("3.30")));
    }

    public static void showAllGoods() {
        System.out.println("编号\t商品\t价格");
        for (int i = 0; i < goods.size(); i++) {
            System.out.println(i + "\t" + goods.get(i));
        }
    }

    public static Goods getGood(int index) {
        return goods.get(index);
    }

    public static int getSize() {
        return goods.size();
    }

}
