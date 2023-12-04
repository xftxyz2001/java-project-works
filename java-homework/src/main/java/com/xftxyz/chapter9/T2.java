package com.xftxyz.chapter9;

public class T2 {

    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;

        System.out.println("The price-change percentage is " + stock.getChangePercent() + "%");
    }
}

class Stock {

    String symbol; // 股票代码
    String name; // 股票名称
    double previousClosingPrice; // 前一日收盘价
    double currentPrice; // 当前价格

    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }
}