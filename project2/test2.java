package project2;

import java.util.*;

class StudentInfo {
    private String name;
    private int cscore;
    private int mscore;
    private int escore;

    // 姓名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 國文
    public int getcScore() {
        return cscore;
    }

    public void setcScore(int cscore) {
        this.cscore = cscore;
    }

    // 數學
    public int getmScore() {
        return mscore;
    }

    public void setmScore(int mscore) {
        this.mscore = mscore;
    }

    // 英文
    public int geteScore() {
        return escore;
    }

    public void seteScore(int escore) {
        this.escore = escore;
    }

    // 排序
    public void sort(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].getcScore() < stu[j + 1].getcScore() && stu[j].getmScore() < stu[j + 1].getmScore()
                        && stu[j].geteScore() < stu[j + 1].geteScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }

    public void print(StudentInfo[] stu, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(stu[i].getName() + " "
                    + stu[i].getcScore() + " "
                    + stu[i].getmScore() + " "
                    + stu[i].geteScore());
        }
    }
}

public class test2 {
    public static void main(String[] args) {
        StudentInfo info = new StudentInfo();
        StudentInfo[] stu = new StudentInfo[4];

        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入學生個數:");
        int count = sc.nextInt();
        int num = 0;
        Scanner scan = new Scanner(System.in);

        while (num < count) {
            System.out.println("請輸入第" + (num + 1) + "個學生的姓名和分數:");
            String strLine = scan.nextLine();
            String[] strLineArr = strLine.split(" ");
            StudentInfo st = new StudentInfo();
            st.setName(strLineArr[0]);
            st.setcScore(Integer.parseInt(strLineArr[1]));
            st.setmScore(Integer.parseInt(strLineArr[2]));
            st.seteScore(Integer.parseInt(strLineArr[3]));
            stu[num] = st;
            num++;
        }
        info.sort(stu, count);
        System.out.println("排序後的學生資訊為:");
        info.print(stu, count);
        sc.close();
        scan.close();
    }

}
