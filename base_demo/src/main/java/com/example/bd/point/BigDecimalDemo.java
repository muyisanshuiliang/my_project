package com.example.bd.point;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Author: yl Created by IntelliJ IDEA
 * DateTime: 2020/3/25 15:25
 * version:
 * description:
 */
public class BigDecimalDemo {
    public static void main(String[] args) {

        testInstance();

//        testReservedDigits(123.444);

        DecimalFormat df = new DecimalFormat("###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String format = df.format(0.45453);
        System.out.println(format);

        df = new DecimalFormat("000.0000000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);

        df = new DecimalFormat("000,000,000,000.0000000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(1934658556.564654);
        System.out.println(format);

        df = new DecimalFormat("-000,000,000,000.0000000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(1934658556.564654);
        System.out.println(format);

        df = new DecimalFormat("0;0000000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(1934658556.564654);
        System.out.println(format);

        df = new DecimalFormat("00E000");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(1934658556.564654);
        System.out.println(format);

        df = new DecimalFormat("%###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);

        df = new DecimalFormat("'#'###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);
        df = new DecimalFormat("''###.##''");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);

        df = new DecimalFormat("\u2030###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);

        df = new DecimalFormat("\u00A4###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);
        df = new DecimalFormat("¤###.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        format = df.format(0.45453);
        System.out.println(format);
    }

    private static void getBigDecimal() {
        /*推荐获取对象的方式*/
        BigDecimal a = BigDecimal.valueOf(123.45);
        BigDecimal b = new BigDecimal("123.45");
        /*不推荐获取的方式*/
        BigDecimal c = new BigDecimal(123.44);
    }

    private static void testInstance() {
        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append("0.");
            sb.append(i);
            sb.append("5");
            BigDecimal bdx = new BigDecimal(sb.toString());
            System.out.println(sb + " " + bdx.setScale(1, RoundingMode.HALF_EVEN));
        }

        System.out.println("==================");
        for (int i = 0; i < 10; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append("0.");
            sb.append(i);
            sb.append("5");
            BigDecimal bdx = BigDecimal.valueOf(Double.valueOf(sb.toString()));
            System.out.println(sb + " " + bdx.setScale(1, RoundingMode.HALF_EVEN));
        }
    }

    private static void testReservedDigits(double value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        System.out.println("RoundingMode.CEILNG，向正无限大方向舍入的舍入模式：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.CEILING));
        System.out.println("RoundingMode.DOWN，向零方向舍入的舍入模式：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.DOWN));
        System.out.println("RoundingMode.FLOOR，向负无限大方向舍入的舍入模式：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.FLOOR));
        System.out.println("RoundingMode.HALF_DOWN，五舍六入：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println("RoundingMode.HALF_UP，四舍五入：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.HALF_UP));
        System.out.println("RoundingMode.UP，远离零方向舍入的舍入模式：" + value + " ==> " + bigDecimal.setScale(2, RoundingMode.UP));
        System.out.println("RoundingMode.HALF_EVEN，" +
                "（1）、向最接近数字方向舍入的舍入模式，如果与两个相邻数字的距离相等，则向相邻的偶数舍入；" +
                "（2）、如果舍弃部分左边的数字为奇数，则舍入行为同 RoundingMode.HALF_UP（四舍五入）；" +
                "（3）、如果为偶数，则舍入行为同 RoundingMode.HALF_DOWN（五舍六入）；" +
                value + " ==> " + bigDecimal.setScale(2, RoundingMode.UP));
        System.out.println("RoundingMode.UNNECESSARY，用于断言请求的操作具有精确结果的舍入模式，因此不需要舍入：" + value + " ==> " + bigDecimal.setScale(3, RoundingMode.UNNECESSARY));
    }
}
