import java.io.*;

public class fileReader {
    public static void main(String[] args) throws IOException {
        try {
            FileReader isr = new FileReader("D://file_input.csv");
            BufferedReader reader = new BufferedReader(isr);
            FileWriter fw = new FileWriter("D://file_output.csv");
            BufferedWriter bw = new BufferedWriter(fw); // 檔案輸出路徑
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                // 讀取
                String[] data = new String[item.length];
                for (int i = 0; i < item.length; i++) {
                    data[i] = item[i].trim(); // trim():移除目前字串開頭和結尾的所有空白字元
                    System.out.print(data[i] + "\t");
                }
                System.out.print("\n");
            }
            bw.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
