import java.util.*;

public class Test {

    int mini(int[] arr) {
        int miniumim = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < miniumim) {
                miniumim = arr[i];
            }
        }
        return miniumim;
    }

    int maxi(int[] arr) {
        int maxiumim = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxiumim) {
                maxiumim = arr[i];
            }
        }
        return maxiumim;
    }

    boolean binarysearch(int[] arr, int x) {
        int first = 0;
        int last = arr.length - 1;
        int mid;
        while (first <= last) {
            mid = first + (last - first) / 2; // Recalculate mid
            if (x == arr[mid]) {
                return true;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else if (arr[mid] > x) {
                last = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test obj = new Test();
        int[] arr = {1, 2, 3, 4, 5, 11, 25, 30};

        if (obj.binarysearch(arr, 0)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println(obj.mini(arr));
        System.out.println(obj.maxi(arr));
    }
}
