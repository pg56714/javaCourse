package finalProject;

import java.io.*;
import java.util.*;

class Student {
    private String number;
    private float[] score = new float[7]; // 0~6

    // ID
    public void setnumber(String snumber) {
        number = snumber;
    }

    public String getnumber() {
        return number;
    }

    // 各科分數
    public void setscore(int ch_score, int i) {
        score[i] = ch_score;
    }

    public float getscore(int i) {
        return score[i];
    }

    // 加權數平均
    public void settotal() {
        score[6] = (score[0] * 2 + score[1] * 3 + score[2] * 2 + score[3] * 4 + score[4] * 3 + score[5] * 2) / 16;
    }

    public float gettotal() {
        return score[6];
    }
}

class printInfo { // 列印類別
    public void print(Student[] st, int num) {
        System.out.println("ID \t\t國文 \t數學 \t英文 \t程式設計 \t會計 \t經濟 \t平均 \t名次");
        for (int i = 0; i < num; i++) {
            System.out.print(st[i].getnumber() + "\t");
            for (int j = 0; j < 6; j++) {
                System.out.print((int) st[i].getscore(j) + "\t");
            }
            // 將平均轉為小數兩位
            String total = String.format("%.02f", st[i].gettotal());
            System.out.println(total + "\t" + (i + 1));
        }
    }
}

public class finalProject {
    public static void main(String[] args) throws IOException {
        // 列印類別
        printInfo print = new printInfo();

        // 檔案讀取------------------------------------------------------------
        File file = new File("D://studentData.csv");
        FileReader isr = new FileReader("D://studentData.csv");
        BufferedReader reader = new BufferedReader(isr);
        reader.mark((int) file.length() + 1); // 設定一個重複的點(最一開始)
        String line = null;
        int lineCount = 0;

        while ((line = reader.readLine()) != null) {
            lineCount++; // 數量
        }
        Student[] stufil = new Student[lineCount];
        int i = 0;
        for (i = 0; i < lineCount; i++) {
            stufil[i] = new Student(); // 類別陣列
        }
        i = 0;

        reader.reset(); // 重設reader
        while ((line = reader.readLine()) != null) { // 放入資料
            String item[] = line.split(",");
            stufil[i].setnumber(item[0].trim()); // trim移除目前字串開頭和結尾的空白字元
            stufil[i].setscore(Integer.parseInt(item[1].trim()), 0); // 將字串變成整數
            stufil[i].setscore(Integer.parseInt(item[2].trim()), 1);
            stufil[i].setscore(Integer.parseInt(item[3].trim()), 2);
            stufil[i].setscore(Integer.parseInt(item[4].trim()), 3);
            stufil[i].setscore(Integer.parseInt(item[5].trim()), 4);
            stufil[i].setscore(Integer.parseInt(item[6].trim()), 5);
            stufil[i].settotal();
            i = i + 1;
        }
        // -----------------------------------------------------------------

        // 印出讀檔資料---------------------------------------------------------
        // System.out.println("學生個數:" + lineCount);

        // System.out.println("ID \t\t國文 \t數學 \t英文 \t程式設計 \t會計 \t經濟 \t平均");
        for (int c = 0; c < lineCount; c++) {
            System.out.print(stufil[c].getnumber() + "\t");
            for (int j = 0; j < 6; j++) {
                System.out.print((int) stufil[c].getscore(j) + "\t"); // float to int 成績轉整數
            }
            System.out.println(stufil[c].gettotal());
        }
        // -----------------------------------------------------------------
        Student tmp = new Student();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("請輸入要排序的條件: (1) 國文 (2) 數學 (3) 英文 (4) 程式設計 (5) 會計 (6) 經濟 (7) 平均 (8) 結束");
            int s = sc.nextInt();
            if (s == 1) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 2) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 3) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 4) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 5) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 6) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 7) {
                // 插入排序
                for (int x = 1; x < lineCount; x++) {
                    for (int y = 0; y < x; y++) {
                        // 大到小
                        if (stufil[x].getscore(s - 1) > stufil[y].getscore(s - 1)) {
                            tmp = stufil[x];
                            stufil[x] = stufil[y];
                            stufil[y] = tmp;
                        }
                    }
                }
                print.print(stufil, lineCount);
            } else if (s == 8) {
                System.out.println("系統結束");
                break;
            } else {
                System.out.println("輸入錯誤，請重新輸入，輸入範圍為1~8");
            }
        }
        sc.close();
        // reader.close();
    }
}
