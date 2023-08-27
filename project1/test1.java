package project1;

import java.util.Scanner;

class StudentInfo {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void sort(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].getScore() < stu[j + 1].getScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }

    public void print(StudentInfo[] stu, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(stu[i].getName() + " " + stu[i].getScore());
        }
    }
}

public class test1 {
    public static void main(String[] args) {
        StudentInfo s = new StudentInfo();
        StudentInfo[] stu = new StudentInfo[20];
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入學生個數:");
        int count = input.nextInt();
        int num = 0;
        Scanner scan = new Scanner(System.in);

        while (num < count) {
            System.out.println("請輸入第" + (num + 1) + "個學生的姓名和分數:");
            String strLine = scan.nextLine();
            String[] strLineArr = strLine.split(" ");
            StudentInfo st = new StudentInfo();
            st.setName(strLineArr[0]);
            st.setScore(Integer.parseInt(strLineArr[1]));
            stu[num] = st;
            num++;
        }
        s.sort(stu, count);
        System.out.println("排序後的學生資訊為:");
        s.print(stu, count);
        input.close();
        scan.close();
    }
}
