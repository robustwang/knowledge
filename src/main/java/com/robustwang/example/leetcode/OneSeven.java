package com.robustwang.example.leetcode;

/**
 * @ClassName OneSeven
 * @Description TODO
 * @Date 2020/5/12 18:34
 * @Version 1.0
 **/

public class OneSeven {

    public void printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {  // 将str初始化为n个'0'字符组成的字符串
            str.append('0');
        }
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }

    public boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {

            char c = str.charAt(i);

            char s = (char) (c + 1);

            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        OneSeven os = new OneSeven();
        os.printNumbers(2);
//
//        String test ="abc";
//        char c = test.charAt(1);
//
//        char c1 = test.charAt(2);
//
//        if(c1<c){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//        }
//        System.out.println(c);


//        String aa = "00";
//        char t = aa.charAt(1);
//        System.out.println(t);
    }
}