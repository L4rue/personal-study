import java.io.*;
import java.math.BigInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        BigInteger int1 = BigInteger.valueOf(123);

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\public.gasstation_info.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\public.gasstation_info2.csv"));
        br.readLine();
        while (true) {

            String[] list = br.readLine().split(",");
            if (list != null && list.length > 1) {
                bw.write(br.readLine());
                bw.newLine();
            } else {
                break;
            }
        }
        br.close();
        bw.close();
    }
}