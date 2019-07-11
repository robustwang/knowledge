package com.robustwang.example.algorithm;

public class Bsearch {
    /**
     *123
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] bsArray = new int[]{3, 2, 6, 4, 5, 9, 8, 7};
        Bsearch bs = new Bsearch();
        int bsearch = bs.bsearch(bsArray, 8, 5);
        System.out.println(bsearch);
    }
}
