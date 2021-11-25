package com.mediga.ds;

import java.util.Base64;

class checkSmall {

    public static void main(String[] args) {
        int[] arr = {9,4,7,1,-2,6,5};
        findKSmallest(arr, 5);
    }

    public static int[] findKSmallest(int[] arr,int k) {

        int[] result = new int[k];
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) {
            minHeapify(arr, i, n);
        }

        for(int i = 0; i < k; i++) {
            result[i] = deleteMin(arr, n-i);
        }

        return result;
    }

    private static int deleteMin(int[] arr, int n) {
        int m = arr[0];
        arr[0] = arr[n-1];
        minHeapify(arr, 0, n-1);
        return m;
    }

    private static void minHeapify(int[] arr, int i, int n) {
        int s = i;
        while(i < n/2) {
            int l = (2*i)+1;
            int r = (2*i)+2;
            if(l < n && arr[l] < arr[i]) {
                s = l;
            }

            if(r < n && arr[r] < arr[s]) {
                s = r;
            }

            if(s == i) {
                break;
            }

            int t = arr[i];
            arr[i] = arr[s];
            arr[s] = t;
            i = s;
        }
    }
}