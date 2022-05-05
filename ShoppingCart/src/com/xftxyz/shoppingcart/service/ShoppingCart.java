package com.xftxyz.shoppingcart.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.xftxyz.shoppingcart.domain.Goods;

public class ShoppingCart {
    private TreeMap<Goods, Integer> goods;

    public ShoppingCart() {
        goods = new TreeMap<Goods, Integer>();
    }

    public void addGoods(Goods good) {
        goods.put(good, goods.getOrDefault(good, 0) + 1);
    }

    public void addGoods(Goods good, Integer amount) {
        goods.put(good, goods.getOrDefault(good, 0) + amount);
    }

    public void removeGoods(Goods good) throws ShoppingException {
        Integer g = goods.get(good);
        if (g == null) {
            throw new ShoppingException("购物车中没有该商品了。" + good);
        }
        if (g == 1) {
            goods.remove(good);
        } else {
            goods.put(good, g - 1);
        }
    }

    public void removeGoods(Goods good, Integer amount) throws ShoppingException {
        Integer g = goods.get(good);
        if (g == null) {
            throw new ShoppingException("购物车中没有该商品。" + good);
        }
        if (g <= amount) {
            goods.remove(good);
        } else {
            goods.put(good, g - amount);
        }
    }

    public BigDecimal getAmountOfMoney() {
        Set<Entry<Goods, Integer>> entrySet = goods.entrySet();
        Iterator<Entry<Goods, Integer>> iterator = entrySet.iterator();
        BigDecimal amount = BigDecimal.ZERO;
        while (iterator.hasNext()) {
            Entry<Goods, Integer> next = iterator.next();
            BigDecimal nextPrice = next.getKey().getPrice();
            BigDecimal nextCount = new BigDecimal(next.getValue());
            amount.add(nextPrice.multiply(nextCount));
        }
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("商品\t价格\t数量\t小计\n");
        Set<Entry<Goods, Integer>> entrySet = goods.entrySet();
        Iterator<Entry<Goods, Integer>> iterator = entrySet.iterator();
        BigDecimal amount = BigDecimal.ZERO;
        while (iterator.hasNext()) {
            Entry<Goods, Integer> next = iterator.next();
            BigDecimal nextPrice = next.getKey().getPrice();
            BigDecimal nextCount = new BigDecimal(next.getValue());
            BigDecimal nextAmount = nextPrice.multiply(nextCount);
            sb.append(next.getKey().toString());
            sb.append("\t");
            sb.append(next.getValue());
            sb.append("\t");
            sb.append(nextAmount);
            sb.append("\n");
            amount = amount.add(nextAmount);
        }
        sb.append("\n\t\t\t\t总计：");
        sb.append(amount.toString());
        return sb.toString();
    }

    public int getGoodAomunt(Goods good) {
        Integer integer = goods.get(good);
        if (integer != null) {
            return integer;
        }
        return 0;
    }
}
