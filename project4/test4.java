import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class StudentInfo { // 儲存學生資訊
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
}

class sortInfo { // 排序類別
    // 國文排序
    public void sortc(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].getcScore() < stu[j + 1].getcScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }

    // 數學排序
    public void sortm(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].getmScore() < stu[j + 1].getmScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }

    // 英文排序
    public void sorte(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].geteScore() < stu[j + 1].geteScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }

    // 加總排序
    public void sortsum(StudentInfo[] stu, int count) {
        StudentInfo temp;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (stu[j].getcScore() + stu[j].getmScore() + stu[j].geteScore() < stu[j + 1].getcScore()
                        + stu[j + 1].getmScore() + stu[j + 1].geteScore()) {
                    temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
    }
}

class printInfo { // 列印類別
    public void print(StudentInfo[] stu, int count) {
        System.out.println("姓名 \t國文 \t數學 \t英文 \t總分 \t名次");
        for (int i = 0; i < count; i++) {
            int sum = stu[i].getcScore() + stu[i].getmScore() + stu[i].geteScore();
            System.out.println(stu[i].getName() + "\t"
                    + stu[i].getcScore() + "\t"
                    + stu[i].getmScore() + "\t"
                    + stu[i].geteScore() + "\t"
                    + sum + "\t"
                    + (i + 1));
        }
    }
}

public class test4 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 檔案讀取------------------------------------------------------------
        File file = new File("D://file_input.csv");
        FileReader isr = new FileReader("D://file_input.csv");
        BufferedReader reader = new BufferedReader(isr);

        try {

            sortInfo sort = new sortInfo(); // 排序類別
            printInfo print = new printInfo(); // 列印類別

            reader.mark((int) file.length() + 1);
            String line = null;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++; // 數量
            }

            System.out.print(lineCount);
            System.out.print("\n");
            StudentInfo[] stufil = new StudentInfo[lineCount];
            int i = 0;
            for (i = 0; i < lineCount; i++) {
                stufil[i] = new StudentInfo(); // 類別陣列
            }
            i = 0;

            reader.reset();
            while ((line = reader.readLine()) != null) { // 放入資料
                String item[] = line.split(",");
                stufil[i].setName(item[0].trim());
                stufil[i].setcScore(Integer.parseInt(item[1].trim()));
                stufil[i].setmScore(Integer.parseInt(item[2].trim()));
                stufil[i].seteScore(Integer.parseInt(item[3].trim()));
                i = i + 1;
            }

            // -----------------------------------------------------------------

            System.out.println("讀取學生個數:" + lineCount);
            // int count=sc.nextInt(); //學生個數
            // StudentInfo[] stu = new StudentInfo[count];
            int num = 0;
            while (num < lineCount) {
                System.out.print("選擇排序(1:國文 2:數學 3:英文 4:總成績 5:結束):");
                int s = sc.nextInt(); // 選擇排序
                if (s == 1) {
                    sort.sortc(stufil, lineCount);
                    print.print(stufil, lineCount);
                } else if (s == 2) {
                    sort.sortm(stufil, lineCount);
                    print.print(stufil, lineCount);
                } else if (s == 3) {
                    sort.sorte(stufil, lineCount);
                    print.print(stufil, lineCount);
                } else if (s == 4) {
                    sort.sortsum(stufil, lineCount);
                    print.print(stufil, lineCount);
                } else if (s == 5) {
                    System.out.println("結束");
                    break;
                }
            }

        } catch (InputMismatchException e) // 輸入錯誤的資料型態
        {
            System.out.println("發生例外的類別名稱或原因" + e.toString());
        }
        sc.close();
        reader.close();

    }
}

/*
 * 試設計一支程式,流程如下:
 * 1. 先輸入學生人數後,開始輸入每位學生的姓名、國文成績、數學成績與英文成績。
 * 
 * 2. 輸入完所有學生的資料後,提供選項進行成績排序。
 * 當按下 1,則排序國文成績;
 * 按下 2,則排序數學成績;
 * 按下 3,則排序英文成績;
 * 按下 4,則按照三科總分排序;
 * 按下 5,則結束程式。
 * 
 * 3. 當使用者按下 1、2、3、4 後,排序順序為由大到小,並印出排序後的結果。
 * 其中,結果須呈現每位學生的所有資料(姓名、國文、數學、英文、總分)及排序後的名次。
 * 
 * 需使用:
 * 1. 類別與物件
 * 2. 陣列
 * 3. 迴圈
 * 4. 判斷
 * 5. 輸出輸入
 * 6. 例外處理
 * 其他要求:
 * 1. 程式註解
 */