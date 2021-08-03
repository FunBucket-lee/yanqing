package classname;

import java.io.*;

public class ClassNames {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\励峰\\考勤表.xlsx"));
        BufferedReader reader = new BufferedReader (new InputStreamReader(bis));
        String i = reader.readLine();
        while (i != null) {
            System.out.print(i);
            i = reader.readLine();
        }
    }

}
