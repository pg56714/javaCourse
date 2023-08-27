import java.util.Scanner;

public class rockPaperScissors {
    public static void main(String[] args) {
        int[] count = new int[3];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("請出拳：(1是剪刀、2是石頭、3是布)");
            int person = scanner.nextInt();
            int computer = (int) (Math.random() * 3 + 1); // Math.random() 取1(0+1)~3(2+1)之間的隨機數字
            String per = "玩家";
            String com = "電腦";
            int Win = 0;
            String again;
            switch (person) {
                case 1:
                    per = "剪刀";
                    break;
                case 2:
                    per = "石頭";
                    break;
                case 3:
                    per = "布";
                    break;
            }
            switch (computer) {
                case 1:
                    com = "剪刀";
                    break;
                case 2:
                    com = "石頭";
                    break;
                case 3:
                    com = "布";
                    break;
            }

            // 判斷勝負
            if (person == 1 && computer == 3 || person == 2 && computer == 1 || person == 3 && computer == 2) {
                System.out.println("玩家出(" + per + ")，電腦出(" + com + ")\n玩家獲勝");
                Win = 1;
            } else if (person == computer) {
                System.out.println("玩家出(" + per + ")，電腦出(" + com + ")\n平手");
                Win = 2;
            } else {
                System.out.println("玩家出(" + per + ")，電腦出(" + com + ")\n電腦獲勝");
                Win = 0;
            }
            count[Win]++;
            System.out.print("是否再玩一次？(案任意鍵繼續，按n結束)");
            again = scanner.next();
            if (again.equals("N") || again.equals("n")) {
                break;
            }
        }
        scanner.close();
        System.out.print("玩家贏了" + count[1] + "次\n平手" + count[2] + "次\n電腦贏了" + count[0] + "次");
    }
}
