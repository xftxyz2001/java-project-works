package com.xftxyz.util;

/**
 * Title: Class to Handle Large Numbers
 * 
 * Description:
 * 
 * Make a class that can handle large integer values. The user should be able to
 * enter a really large number (like the number of stars in our galaxy or in the
 * known universe) and the class should then be able to store that number as
 * well as allow two instances of this class to subtract, add, multiply or
 * divide values from one another. The result of one of these operations is
 * another instance of the large numbers class.
 * 
 * Tips:
 * 
 * One approach is to think of a large integer as a series of numbers much line
 * you would consider a string a series of characters. You can then work on each
 * of these numbers individually as you carry out the various operations. Try
 * working on the subtraction or addition methods first as these should be the
 * easiest to implement.
 * 
 * Added Difficulty:
 * 
 * Support some of the other operators such as modulus or see if you can apply
 * various types of formatting to the number via a “ToString” method.
 * 
 */
public class LargeNumber extends Number implements Comparable<LargeNumber> {

    /*
     * 创建一个可以处理大整数值的类。用户应该能够输入一个非常大的数字（比如我们银河系或已知宇宙中的恒星数量），然后该类应该能够存储该数字，
     * 并允许该类的两个实例相互减法、加法、乘法或除法。其中一个操作的结果是large numbers类的另一个实例。
     */
    // 不可变的两个属性
    // 符号，仅可从-1、0、1中取值，分别代表负数、0、正数
    final int sign;
    // 每位的数字
    final int[] num;

    // 构造方法：通过字符串
    public LargeNumber(String val) {
        // 当前处理到字符串的下标
        int valIndex = 0;
        // 字符串的长度
        final int valLength = val.length();

        // 如果字符串的长度为0
        if (valLength == 0) {
            throw new NumberFormatException("给定的字符串长度为0。");
        }

        // 处理符号
        // 默认给定的是个正数
        int sign = 1;
        // 负号下标
        int negativeSignIndex = val.lastIndexOf('-');
        // 正号下标
        int positiveSignIndex = val.lastIndexOf('+');
        if (negativeSignIndex >= 0) {
            // 如果字符串中有负号
            // 如果负号不在首位，或者存在负号的同时还存在正号
            if (negativeSignIndex != 0 || positiveSignIndex >= 0) {
                throw new NumberFormatException("非法的符号：negativeSignIndex" + negativeSignIndex);
            }
            // 除去不合法的情况，字符串中有负号认为是个负数
            sign = -1;
            // 处理下标向后移动（至第一个数字）
            valIndex = 1;

        } else if (positiveSignIndex >= 0) {
            // 字符串中没有负号，但是有正号
            // 如果正号不在首位
            if (positiveSignIndex != 0) {
                throw new NumberFormatException("非法的符号：positiveSignIndex" + positiveSignIndex);
            }
            // 除去不合法的情况，字符串中有正号认为是个正数，但是默认给定的是个正数，这里就不用修改了
            // sign = 1;
            // 同样：处理下标向后移动（至第一个数字）
            valIndex = 1;
        }

        // 如果去除符号后字符串的长度为0
        if (valIndex == valLength) {
            throw new NumberFormatException("非法的数值（仅包含符号）。");
        }

        // 跳过字符串中的前导零
        while (valIndex < valLength && Character.digit(val.charAt(valIndex), 10) == 0) {
            valIndex++;
        }
        // -00000123

        // 如果跳过字符串中的前导零后字符串的长度为0，说明给定的数字就是0
        if (valIndex == valLength) {
            // 标记0
            this.sign = 0;
            // 这里就给num初始化为空就好，通过sign判断0
            this.num = new int[0];
            // 没必要进行下面的操作了，使用return结束方法
            return;
        }

        // 明确符号
        this.sign = sign;
        // 计算数字的位数
        int numDigits = valLength - valIndex;
        // 为每位数字开辟空间
        int[] num = new int[numDigits];

        // 明确每位数字
        for (int numIndex = 0; numIndex < num.length; numIndex++, valIndex++) {
            num[numIndex] = Character.digit(val.charAt(valIndex), 10);
        }
        this.num = num;
    }

    private LargeNumber(int sign, int[] num) {
        this.sign = sign;
        this.num = num;
    }

    // 两者都不为0
    private int[] addIgnoreSign(int[] num) {
        int[] res = null;
        /*
         * java\.lang\.ArrayIndexOutOfBoundsException:&nbsp;Index&nbsp;3&nbsp;out&nbsp;
         * of&nbsp;bounds&nbsp;for&nbsp;length&nbsp;3
         * 
         * &nbsp;at&nbsp;com.xftxyz.util.LargeNumber.addIgnoreSign([LargeNumber.java:103
         * ](command:_java.test.openStackTrace?%5B%22%5Ctat%20com.xftxyz.util.
         * LargeNumber.addIgnoreSign(LargeNumber.java%3A103)%22%2C%
         * 22LargeNumber_40902635%22%5D))
         */
        // int carry = 0, ThisNumIndex = this.num.length - 1, NumIndex = num.length;
        int carry = 0, ThisNumIndex = this.num.length - 1, NumIndex = num.length - 1;

        if (this.num.length >= num.length) {
            res = this.num.clone();
            while (NumIndex >= 0) {
                // int bitTemp = res[ThisNumIndex] = num[NumIndex] + carry;
                int bitTemp = res[ThisNumIndex] + num[NumIndex] + carry;
                res[ThisNumIndex] = bitTemp % 10;
                carry = bitTemp / 10;
                ThisNumIndex--;
                NumIndex--;
            }
            while (ThisNumIndex >= 0 && carry != 0) {
                // res[ThisNumIndex] += (num[ThisNumIndex - 1] + carry) % 10;
                // carry = (num[ThisNumIndex - 1] + carry) / 10;
                // res[ThisNumIndex] += (res[ThisNumIndex - 1] + carry) % 10;
                // carry = (res[ThisNumIndex - 1] + carry) / 10;

                // ThisNumIndex--;
                int bitTemp = res[ThisNumIndex] + carry;
                res[ThisNumIndex] = bitTemp % 10;
                // carry = (num1[ThisNumIndex - 1] + carry) / 10;
                carry = bitTemp / 10;

                ThisNumIndex--;
            }
            // if (carry != 0) {
            // int[] temp = new int[res.length + 1];
            // temp[0] = carry;
            // for (int i = 0; i < res.length; i++) {
            // temp[i + 1] = res[i];
            // }
            // res = temp;
            // }
        } else {
            res = num.clone();
            // while (ThisNumIndex >= 0) {
            // res[NumIndex] += (num[ThisNumIndex] + carry) % 10;
            // carry = (num[ThisNumIndex] + carry) / 10;
            // NumIndex--;
            // ThisNumIndex--;
            // }
            // while (NumIndex >= 0 && carry != 0) {
            // res[NumIndex] += (num[NumIndex - 1] + carry) % 10;
            // carry = (num[NumIndex - 1] + carry) / 10;
            // NumIndex--;
            // }
            while (ThisNumIndex >= 0) {
                int bitTemp = res[NumIndex] + this.num[ThisNumIndex] + carry;
                res[NumIndex] = bitTemp % 10;
                carry = bitTemp / 10;
                NumIndex--;
                ThisNumIndex--;
            }
            while (NumIndex >= 0 && carry != 0) {
                // res[NumIndex] += (res[NumIndex - 1] + carry) % 10;
                // carry = (res[NumIndex - 1] + carry) / 10;
                // NumIndex--;
                int bitTemp = res[NumIndex] + carry;
                res[NumIndex] = bitTemp % 10;
                // carry = (num1[ThisNumIndex - 1] + carry) / 10;
                carry = bitTemp / 10;

                NumIndex--;
            }

        }
        if (carry != 0) {
            int[] temp = new int[res.length + 1];
            temp[0] = carry;
            for (int i = 0; i < res.length; i++) {
                temp[i + 1] = res[i];
            }
            res = temp;
        }

        return res;
    }

    // 将num2加到num1中
    private int[] addIgnoreSignChange(int[] num1, int[] num2) {
        int carry = 0, ThisNumIndex = num1.length - 1, NumIndex = num2.length - 1;
        if (num1.length == 0) {
            // return num2;
            return num2.clone();
        }
        while (NumIndex >= 0) {
            // num1[ThisNumIndex] += (num2[NumIndex] + carry) % 10;
            int bitTemp = num1[ThisNumIndex] + num2[NumIndex] + carry;
            num1[ThisNumIndex] = bitTemp % 10;
            carry = bitTemp / 10;
            ThisNumIndex--;
            NumIndex--;
        }
        // while (ThisNumIndex >= 0 && carry != 0) {
        while (ThisNumIndex >= 0 && carry != 0) {
            // num1[ThisNumIndex] += (num1[ThisNumIndex - 1] + carry) % 10;
            int bitTemp = num1[ThisNumIndex] + carry;
            num1[ThisNumIndex] = bitTemp % 10;
            // carry = (num1[ThisNumIndex - 1] + carry) / 10;
            carry = bitTemp / 10;

            ThisNumIndex--;
        }
        if (carry != 0) {
            int[] temp = new int[num1.length + 1];
            temp[0] = carry;
            for (int i = 0; i < num1.length; i++) {
                temp[i + 1] = num1[i];
            }
            num1 = temp;
        }
        return num1;
    }

    // bigOne > smallOne
    private int[] subIgnoreSign(int[] smallOne) {
        // int[] res = new int[this.num.length];
        int[] res = this.num.clone();
        // int carry = 0, bigNumIndex = this.num.length - 1, smallNumIndex =
        // this.num.length - 1;
        int carry = 0, bigNumIndex = this.num.length - 1, smallNumIndex = smallOne.length - 1;
        while (smallNumIndex >= 0) {
            // 对应位相减
            res[bigNumIndex] -= smallOne[smallNumIndex] + carry;
            // BUG:// 9999990362270
            carry = 0;
            // 结果小于零
            if (res[bigNumIndex] < 0) {
                // 向高位借1
                carry = 1;
                // 当作10
                res[bigNumIndex] += 10;
            }
            smallNumIndex--;
            bigNumIndex--;
        }
        while (bigNumIndex >= 0 && carry != 0) {
            res[bigNumIndex] -= carry;
            // BUG:// 9999990362270
            carry = 0;
            // 结果小于零
            if (res[bigNumIndex] < 0) {
                // 向高位借1
                carry = 1;
                // 当作10
                res[bigNumIndex] += 10;
            }
            bigNumIndex--;
        }
        // 去除前导0
        int resIndex = 0;
        while (res[resIndex] == 0) {
            resIndex++;
        }
        // 存在前导0
        if (resIndex != 0) {
            int[] temp = new int[res.length - resIndex];
            for (int i = 0; i < temp.length; i++, resIndex++) {
                temp[i] = res[resIndex];
            }
            res = temp;
        }

        return res;
    }

    public LargeNumber add(LargeNumber val) {
        // 0加上任何数，等于任何数
        if (this.sign == 0) {
            return val;
        }

        // 任何数加上0，等于本身
        if (val.sign == 0) {
            return this;
        }

        // 符号相同，绝对值相加
        if (this.sign == val.sign) {
            return new LargeNumber(this.sign, this.addIgnoreSign(val.num));
        }

        LargeNumber res = null;
        // if (this.sign == 1) {
        // // 正数 + 负数 = 正数 - (-负数)
        // // 结果的符号由正数的绝对值是否大于负数决定
        // int resSign = this.compareIgnoreSign(val);
        // switch (resSign) {
        // case 1:
        // res = new LargeNumber(1, subIgnoreSign(this.num, val.num));
        // break;
        // case -1:
        // res = new LargeNumber(-1, subIgnoreSign(val.num, this.num));
        // break;
        // }
        // } else if (val.sign == 1) {
        // // 负数 + 正数 = 正数 - (-负数)
        // int resSign = this.compareIgnoreSign(val);
        // switch (resSign) {
        // case 1:
        // res = new LargeNumber(1, subIgnoreSign(this.num, val.num));
        // break;
        // case -1:
        // res = new LargeNumber(-1, subIgnoreSign(val.num, this.num));
        // break;
        // }
        // }
        // 结果的符号由两者绝对值大小决定：谁的绝对值大，结果的符号就是谁的
        int resSign = this.compareIgnoreSign(val);
        switch (resSign) {
        case 1: // this的绝对值大
            res = new LargeNumber(this.sign, this.subIgnoreSign(val.num));
            break;
        case -1:// val的绝对值大
            res = new LargeNumber(val.sign, val.subIgnoreSign(this.num));
            break;
        case 0: // 两者的绝对值一样大
            res = new LargeNumber(0, new int[0]);
        }
        return res;
    }

    public LargeNumber subtract(LargeNumber val) {
        return add(new LargeNumber(-val.sign, val.num));
    }

    public LargeNumber multiply(LargeNumber val) {
        if (this.sign == 0 || val.sign == 0) {
            return new LargeNumber(0, new int[0]);
        }
        LargeNumber res = null;
        if (this.sign != val.sign) {
            res = new LargeNumber(-1, this.multiplyIgnoreSign(val.num));
        } else {
            res = new LargeNumber(1, this.multiplyIgnoreSign(val.num));
        }
        return res;

    }

    private int[] multiplyIgnoreSign(int[] num) {
        int ThisNumLength = this.num.length, NumLength = num.length;
        int[] result = new int[0];
        if (ThisNumLength >= NumLength) {
            for (int i = 0; i < NumLength; i++) {
                result = shiftLeft(result);
                for (int j = 0; j < num[i]; j++) {
                    // addIgnoreSignChange(result, this.num);
                    result = addIgnoreSignChange(result, this.num);
                }
            }
        } else {
            for (int i = 0; i < ThisNumLength; i++) {
                result = shiftLeft(result);
                for (int j = 0; j < this.num[i]; j++) {
                    // addIgnoreSignChange(result, num);
                    result = addIgnoreSignChange(result, num);
                }
            }
        }
        return result;
    }

    private int[] shiftLeft(int[] result) {
        if (result.length != 0) {
            int[] dest = new int[result.length + 1];
            System.arraycopy(result, 0, dest, 0, result.length);
            return dest;
        }
        return result;
    }

    public LargeNumber divide(LargeNumber val) {
        if (val.sign == 0) {
            throw new ArithmeticException("除数不能为零。");
        }

        // 被除数为0，或被除数绝对值比除数小
        if (this.sign == 0 || this.compareIgnoreSign(val) < 0) {
            return new LargeNumber(0, new int[0]);
        }

        LargeNumber res = null;
        if (this.sign != val.sign) {
            res = new LargeNumber(-1, this.divideIgnoreSign(val.num));
        } else {
            res = new LargeNumber(1, this.divideIgnoreSign(val.num));
        }
        return res;
        // return null;

    }

    private int[] divideIgnoreSign(int[] num) {
        int len = this.num.length - num.length;
        LargeNumber ThisIgnoreSign = new LargeNumber(1, this.num);
        LargeNumber quotient = null;
        if (len > 0) {
            int[] qq = new int[len];
            qq[0] = 1;
            quotient = new LargeNumber(1, qq);// 商;
        } else {
            quotient = new LargeNumber(0, new int[0]);// 商;
        }

        LargeNumber divisor = new LargeNumber(1, num);// 除数
        // while (divisor.multiply(quotient).compareTo(this) < 0) {
        while (divisor.multiply(quotient).compareTo(ThisIgnoreSign) <= 0) {
            // quotient.add(new LargeNumber(1, new int[] { 1 }));
            quotient = quotient.add(new LargeNumber(1, new int[] { 1 }));
        }
        quotient = quotient.subtract(new LargeNumber(1, new int[] { 1 }));
        return quotient.num;
    }

    public LargeNumber mod(LargeNumber val) {
        if (val.sign <= 0)
            throw new ArithmeticException("模数不为正");

        // N-N/M*M
        return this.subtract(this.divide(val).multiply(val));
        // return null;
    }

    public LargeNumber abs(LargeNumber val) {
        if (this.sign == -1) {
            return new LargeNumber(-val.sign, val.num);
        }
        return this;
    }

    @Override
    public String toString() {
        // 单独处理0，直接返回
        if (sign == 0) {
            return "0";
        }

        // 计算需要的字符串长度
        int numChars = sign > 0 ? num.length : num.length + 1;
        StringBuilder sb = new StringBuilder(numChars);

        // 为负数添加负号
        if (sign < 0) {
            sb.append('-');
        }

        // 逐位添加到StringBuilder中
        for (int numIndex = 0; numIndex < num.length; numIndex++) {
            sb.append(num[numIndex]);
        }

        // 返回StringBuilder对应的字符串
        return sb.toString();
    }

    @Override
    public int intValue() {
        return (int) longValue();
    }

    @Override
    public long longValue() {
        // 单独处理0，直接返回
        if (sign == 0) {
            return 0L;
        }
        // 存储结果的临时变量
        long res = 0L;
        for (int numIndex = 0; numIndex < num.length; numIndex++) {
            res = res * 10 + num[numIndex];
        }

        return res * sign;
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        // 单独处理0，直接返回
        if (sign == 0) {
            return 0;
        }
        // 存储结果的临时变量
        double res = 0;
        for (int numIndex = 0; numIndex < num.length; numIndex++) {
            res = res * 10 + num[numIndex];
        }

        return res * sign;
    }

    private int compareIgnoreSign(LargeNumber val) {
        // 位数不一样，
        if (this.num.length != val.num.length) {
            return this.num.length > val.num.length ? 1 : -1;
        }
        for (int numIndex = 0; numIndex < num.length; numIndex++) {
            if (this.num[numIndex] != val.num[numIndex]) {
                return this.num[numIndex] > val.num[numIndex] ? 1 : -1;
            }
        }
        return 0; // 相等
    }

    @Override
    public int compareTo(LargeNumber val) {
        // 符号不一样，直接比较符号
        if (this.sign != val.sign) {
            return this.sign > val.sign ? 1 : -1;
        }
        // 符号一样
        int res = 0;
        switch (this.sign) {
        case 1:
            // 都是正数，绝对值大的大
            res = this.compareIgnoreSign(val);
            break;
        case -1:
            // 都是负数，绝对值小的大
            res = val.compareIgnoreSign(this);
            break;
        default:
            break;
        }
        return res;
    }
}
