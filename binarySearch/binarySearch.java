package binarySearch;

import java.util.*;

public class binarySearch {
    public static void main(String[] args) {
        // int list[] = new int[15];
        Scanner sc = new Scanner(System.in);

        int list[] = { 10, 80, 60, 50, 24, 58, 97, 32, 15, 18, 66, 77, 20, 64, 85 };
        Arrays.sort(list);
        String arrayString = Arrays.toString(list);
        System.out.println(arrayString);

        System.out.print("請輸入一數：");
        int number = sc.nextInt();
        int b = 0;

        boolean c = true;
        for (int i = 0; i < list.length; i++) {
            b = list[i];
            if (number == b) {
                System.out.println("位置" + Arrays.binarySearch(list, b) + "、數字" + b);
                break;
            }
        }
        if (c == (number != b)) {
            System.out.println("無");
        }

        System.out.println();

        Scanner scc = new Scanner(System.in);
        int listt[] = { 10, 80, 60, 50, 24, 58, 97, 32, 15, 18, 66, 77, 20, 64, 85 };
        int i, j, tmp;
        for (i = 0; i < 15; i++) {
            for (j = i + 1; j < 15; j++) {
                if (listt[i] > listt[j]) {
                    tmp = listt[i];
                    listt[i] = listt[j];
                    listt[j] = tmp;
                }
            }
        }
        for (i = 0; i < 15; i++) {
            System.out.print(listt[i] + " ");
        }
        System.out.print("請輸入一數A：");
        int numberA = scc.nextInt();

        int L = 0, R = 15, m;
        do {
            m = (L + R) / 2;
            System.out.println("L:" + L + "R:" + R);
            if (numberA == list[m]) {
                System.out.println("位置:" + m);
                break;
            } else {
                if (numberA > list[m]) {
                    L = m + 1;
                } else {
                    R = m - 1;
                }
            }
        } while (L <= R);
        System.out.println("End");
    }
}
