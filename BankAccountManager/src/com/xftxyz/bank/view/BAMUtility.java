package com.xftxyz.bank.view;

import java.util.*;

import com.xftxyz.bank.service.BankException;

public class BAMUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection2() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2') {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return c;
    }

    public static char readMenuSelection3() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3') {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return c;
    }

    public static char readMenuSelection4() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return c;
    }

    public static char readMenuSelection5() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return c;
    }

    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }

    public static int readInt() {
        int n;
        for (;;) {
            String str = readKeyBoard(9, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    public static char readConfirmSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn)
                    return line;
                else
                    continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }

    public static int readPIN() {
        int pin;
        for (;;) {
            String pwd = String.valueOf(System.console().readPassword());
            System.out.print("请确认PIN(再次输入):");
            String pwd2 = String.valueOf(System.console().readPassword());
            if (!pwd.equals(pwd2)) {
                System.out.print("两次输入的密码不一致，请重新输入：");
                continue;
            }
            if (pwd.length() != 6) {
                System.out.print("密码长度（6位）错误，请重新输入：");
                continue;
            }
            try {
                pin = Integer.parseInt(pwd);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return pin;

    }

    public static int readPINLogin() {
        int pin;
        for (;;) {
            String pwd = String.valueOf(System.console().readPassword());
            if (pwd.length() != 6) {
                System.out.print("密码长度（6位）错误，请重新输入：");
                continue;
            }
            try {
                pin = Integer.parseInt(pwd);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return pin;

    }

    public static double readDouble() throws BankException {
        double n;
        for (;;) {
            String str = readKeyBoard(10, false);
            try {
                n = Double.parseDouble(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        if (n <= 0) {
            throw new BankException("存取款金额须大于0");
        }
        return n;
    }

}
