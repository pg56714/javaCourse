package guessList;

import java.util.*;

public class guessList {
    public static void main(String[] args) {
        int[] c = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        boolean aa = true;
        Scanner scanner = new Scanner(System.in);
        do {
            aa = true;
            // System.out.print("輸入整數a及b(以空白隔開):");
            String arrayString = Arrays.toString(c);
            System.out.println(arrayString);
            System.out.print("輸入整數d：");
            try {

                int d = scanner.nextInt();
                // int a = sc.nextInt();
                // int b = sc.nextInt();
                // System.out.println(a + "/" + b + "=" + (a / b));
                System.out.println(c[d]);

            }
            // catch只做一遍
            catch (InputMismatchException e) {
                System.out.println("發生例外的類別名稱或原因:" + e.toString());
                aa = false;
                // e.printStackTrace();
            } catch (ArithmeticException e) {
                System.out.println("發生例外的原因:" + e.getMessage());
                aa = false;
                // e.printStackTrace();
            } catch (Exception e) {
                System.out.println("類型:" + e.getMessage());
                aa = false;
                // e.printStackTrace();
            }
            /*
             * finally {
             * System.out.println("finally區塊內的敘述有執行到，且程式沒有異常中止.");
             * keyin.close();
             * }
             */
        } while (aa == false);
        scanner.close();
    }
}
