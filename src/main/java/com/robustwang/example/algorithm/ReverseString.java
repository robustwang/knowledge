package com.robustwang.example.algorithm;

public class ReverseString {

    public static char[] reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
        return s;
    }


    public static void main(String[] args) {
        String test = "hello world";
        char[] chars = test.toCharArray();
        char[] charArray = ReverseString.reverseString(chars);
        for (char c : charArray) {
            System.out.println(c);
        }


    }
}
