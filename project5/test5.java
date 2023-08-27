package project5;

import java.io.*;
import java.util.Scanner;

class Student {
    private String name;
    private int[] score = new int[4]; // 0~3

    public void setname(String sname) {
        name = sname;
    }

    public String getname() {
        return name;
    }

    // 各科分數
    public void setscore(int ch_score, int i) {
        score[i] = ch_score;
    }

    public int getscore(int i) {
        return score[i];
    }

    // 加總
    public void settotal() {
        score[3] = score[0] + score[1] + score[2];
    }

    public int gettotal() {
        return score[3];
    }
}

class printInfo { // 列印類別
    public void print(Student[] st, int num) {
        System.out.println("姓名 \t國文 \t數學 \t英文 \t總分 \t名次");
        for (int i = 0; i < num; i++) {
            System.out.print(st[i].getname() + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(st[i].getscore(j) + "\t");
            }
            System.out.println(st[i].gettotal() + "\t" + (i + 1));
        }
    }
}

public class test5 {
    public static void main(String[] args) throws IOException {
        // 列印類別
        printInfo print = new printInfo();

        // 檔案讀取------------------------------------------------------------
        File file = new File("D://file_input.csv");
        FileReader isr = new FileReader("D://file_input.csv");
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
            stufil[i].setname(item[0].trim()); // trim移除目前字串開頭和結尾的空白字元
            stufil[i].setscore(Integer.parseInt(item[1].trim()), 0); // 將字串變成整數
            stufil[i].setscore(Integer.parseInt(item[2].trim()), 1);
            stufil[i].setscore(Integer.parseInt(item[3].trim()), 2);
            stufil[i].settotal();
            i = i + 1;
        }
        // -----------------------------------------------------------------
        System.out.println("學生個數:" + lineCount);

        int s;
        Student tmp = new Student();
        do {
            Scanner sc4 = new Scanner(System.in);
            System.out.println("請輸入要排序的條件: (1) 國文 (2)數學 (3) 英文 (4) 總分 (5) 結束");
            s = sc4.nextInt();
            if (s != 5) {
                // 氣泡排序法
                for (i = 0; i < lineCount - 1; i++) {
                    for (int j = i + 1; j < lineCount; j++) {
                        if (stufil[i].getscore(s - 1) < stufil[j].getscore(s - 1)) {
                            // 資料交換
                            tmp = stufil[i];
                            stufil[i] = stufil[j];
                            stufil[j] = tmp;
                        }
                    }
                }
                // 印出排序後的結果
                print.print(stufil, lineCount);
            }
        } while (s != 5);
        System.out.println("系統結束");
    }
}
