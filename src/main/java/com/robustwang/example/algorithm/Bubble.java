package com.robustwang.example.algorithm;

public class Bubble {

    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public void bubbleSort2(int[] a, int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j]= a[j+1];
                    a[j+1]= temp;
                }
            }
        }
        int [] result = a;
    }


    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] a = new int[]{3, 2, 7, 4, 5, 1, 6};
        bubble.bubbleSort2(a, 7);
    }
}
