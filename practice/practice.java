package practice;

class Student { // 類別宣告開始
    private String name; // 成員變數 //有set就要有get
    public String address;
    public int age;

    Student() { // 定義初始值，如果沒有就不用寫
        address = "5555";
        age = 10;
    }

    public void setName(String Sname) {
        name = Sname;
    }

    public String getName() {
        return name;
    }

    public void printNameCard() { // 成員方法
        System.out.println("姓名：" + getName());
        System.out.println("地址：" + address);
        System.out.println("年齡：" + age);
    }
}// 類別宣告結束

public class practice {
    public static void main(String[] args) {
        Student a = new Student();
        a.setName("David");
        a.printNameCard();

        System.out.println();

        a.address = "12345";
        a.age = 50;
        a.printNameCard();
    }
}
