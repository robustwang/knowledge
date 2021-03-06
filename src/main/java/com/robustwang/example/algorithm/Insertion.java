package com.robustwang.example.algorithm;

public class Insertion {

    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        Insertion insert = new Insertion();
        int[] a = new int[]{3, 2, 7, 4, 5, 1, 6};
        insert.insertionSort(a, 7);
    }
}
