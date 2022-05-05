package com.xftxyz.bank.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.xftxyz.bank.domain.Account;
import com.xftxyz.bank.domain.CheckingAccount;
import com.xftxyz.bank.domain.SavingsAccount;

public class MyFileReader {

    // 生成默认数据文件
    public static void write() {
        File file = new File(XFConstant.DATA_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("文件创建失败");
            }
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.print(XFConstant.DEFAULT_DATA);
        } catch (FileNotFoundException e) {
            System.err.println("文件异常。");
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static ArrayList<Account> read() {
        File file = new File(XFConstant.DATA_FILE);
        if (!file.exists()) {
            write();
        }
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            int accountNumber = sc.nextInt();
            ArrayList<Account> accounts = new ArrayList<Account>(accountNumber);
            for (int i = 0; i < accountNumber; i++) {
                int id = sc.nextInt();
                int pin = sc.nextInt();
                int type = sc.nextInt();
                String strBalance = sc.next();
                BigDecimal balance = new BigDecimal(strBalance);
                switch (type) {
                case XFConstant.CHECKING_ACCOUNT:
                    accounts.add(new CheckingAccount(id, pin, balance));
                    break;
                case XFConstant.SAVINGS_ACCOUNT:
                    accounts.add(new SavingsAccount(id, pin, balance));
                    break;
                }
            }
            return accounts;
        } catch (FileNotFoundException e) {
            System.err.println("文件异常");
            return null;
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

    public static void save(ArrayList<Account> accounts) {
        File file = new File(XFConstant.DATA_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("文件创建失败");
            }
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.println(accounts.size());
            for (Account account : accounts) {
                output.println(account.toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("文件异常。");
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
