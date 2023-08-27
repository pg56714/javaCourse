package guess1A2B;

import java.util.*;

public class guess1A2B {
    public static void main(String[] args) {
        int renew;
        int pwdans[] = new int[4];
        int gs;
        int pwd[] = new int[4];
        Scanner sc = new Scanner(System.in);
        try {
            do {
                Random random = new Random();
                int ans = random.nextInt(9000) + 1000;
                pwdans[0] = ans / 1000;
                pwdans[1] = (ans % 1000) / 100;
                pwdans[2] = (ans % 100) / 10;
                pwdans[3] = ans % 10;
                System.out.println(ans);
                renew = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (pwdans[i] == pwdans[j] && i != j) {
                            renew = 1;
                        }
                    }
                }
            } while (renew == 1);

            while (true) {
                do {
                    System.out.print("請輸入四位數：");
                    gs = sc.nextInt();
                    pwd[0] = gs / 1000;
                    pwd[1] = (gs % 1000) / 100;
                    pwd[2] = (gs % 100) / 10;
                    pwd[3] = gs % 10;
                    System.out.println("一位數：" + pwd[0]);
                    System.out.println("二位數：" + pwd[1]);
                    System.out.println("三位數：" + pwd[2]);
                    System.out.println("四位數：" + pwd[3]);
                    renew = 0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (pwd[i] == pwd[j] && i != j) {
                                renew = 1;
                            }
                        }
                    }
                    if (renew == 1) {
                        System.out.println("數字重複，請重新輸入");
                    }
                } while (renew == 1);

                int A = 0, B = 0;
                for (int i = 0; i < 4; i++) {
                    if (pwd[i] == pwdans[i]) {
                        A++;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (pwd[i] == pwdans[j] && i != j) {
                            B++;
                        }
                    }
                }

                if (A == 4) {
                    System.out.println("4A，已成功");
                    break;
                } else {
                    System.out.println(A + "A" + B + "B");
                }

            }
            sc.close();
        } catch (InputMismatchException a) {
            // System.out.println("型態不符" + a.toString());
            System.out.println("型態不符");
        } finally {

        }

    }
}
