package com.xftxyz.bank.view;

import java.math.BigDecimal;

import com.xftxyz.bank.domain.Account;
import com.xftxyz.bank.domain.CheckingAccount;
import com.xftxyz.bank.domain.SavingsAccount;
import com.xftxyz.bank.service.AccountService;
import com.xftxyz.bank.service.BankException;
import com.xftxyz.bank.utils.XFConstant;

public class BankView {

    private AccountService as;
    private Account a;

    public static void main(String[] args) {
        BankView bankView = new BankView();
        bankView.as = AccountService.getInstance();
        bankView.enterMainMenu();

    }

    private void enterMainMenu() {
        boolean loopFlag = true;
        char selected = 0;
        do {
            System.out.println("--------------------------------银行账户管理软件--------------------------------");
            System.out.print("1-登录 2-注册 3-存款 4-取款 5-退出 请选择(1-5):");
            selected = BAMUtility.readMenuSelection5();
            switch (selected) {
            case '1':
                Login();
                break;
            case '2':
                Register();
                break;
            case '3':
                Deposit();
                break;
            case '4':
                Withdraw();
                break;
            case '5':
                System.out.print("确认是否退出(Y/N):");
                char isExit = BAMUtility.readConfirmSelection();
                if (!(loopFlag = 'Y' != isExit)) {
                    this.a = null;
                }
                break;
            }
        } while (loopFlag);
        as.saveAccounts();
    }

    private void Withdraw() {
        System.out.println("----------------------------------------取款----------------------------------------");
        if (this.a == null) {
            System.out.println("请先登录");
            return;
        }
        System.out.print("请输入取款金额：");
        double d = 0;
        try {
            d = BAMUtility.readDouble();
        } catch (BankException e) {
            System.out.println("出错了，原因:" + e.getMessage());
            return;
        }
        BigDecimal bg = new BigDecimal(d);
        try {
            a.withdraw(bg);
            System.out.println("取款成功，当前账户余额：" + a.getBalance());
        } catch (BankException e) {
            System.out.println("取款失败，原因：" + e.getMessage());
        }

    }

    private void Deposit() {
        System.out.println("----------------------------------------存款----------------------------------------");
        if (this.a == null) {
            System.out.println("请先登录");
            return;
        }
        System.out.print("请输入存款金额：");
        double d = 0;
        try {
            d = BAMUtility.readDouble();
        } catch (BankException e) {
            System.out.println("出错了，原因:" + e.getMessage());
            return;
        }
        BigDecimal bg = new BigDecimal(d);
        try {
            a.deposit(bg);
            System.out.println("存款成功，当前账户余额：" + a.getBalance());
        } catch (BankException e) {
            System.out.println("存款失败，原因：" + e.getMessage());
        }
    }

    private void Register() {
        System.out.println("----------------------------------------注册----------------------------------------");
        System.out.print("请输入账户类型1-CheckingAccount 2-SavingsAccount 请选择(1-2):");
        int type = Character.digit(BAMUtility.readMenuSelection2(), 10);

        System.out.print("请输入账户ID(1-9位数字):");
        int id = BAMUtility.readInt();
        System.out.print("请输入账户PIN(6位数字):");
        int pin = BAMUtility.readPIN();

        try {
            switch (type) {
            case XFConstant.CHECKING_ACCOUNT:
                as.addAccount(new CheckingAccount(id, pin, BigDecimal.ZERO));
                break;
            case XFConstant.SAVINGS_ACCOUNT:
                as.addAccount(new SavingsAccount(id, pin, BigDecimal.ZERO));
                break;
            }
            System.out.println("添加成功");
        } catch (BankException e) {
            System.out.println("添加失败,原因:" + e.getMessage());
        }
        BAMUtility.readReturn();
    }

    private void Login() {
        System.out.println("----------------------------------------登录----------------------------------------");

        System.out.print("请输入账户ID(1-9位数字):");
        int id = BAMUtility.readInt();
        System.out.print("请输入账户PIN(6位数字):");
        int pin = BAMUtility.readPINLogin();

        Account temp = as.getAccount(id);
        if (temp == null) {
            System.out.println("用户不存在，请检查账户ID输入是否正确，或注册账户。");
            return;
        }

        if (!temp.checkPin(pin)) {
            System.out.println("密码错误。");
        }
        this.a = temp;
        System.out.println("登陆成功，当前账户余额：" + this.a.getBalance());
    }
}
