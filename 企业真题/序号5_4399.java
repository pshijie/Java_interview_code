import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * @author psj
 * @date 2022/9/14 11:53
 * @File: 序号5_4399.java
 * @Software: IntelliJ IDEA
 */
public class 序号5_4399 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int preY = sc.nextInt();
            int preM = sc.nextInt();
            int preD = sc.nextInt();
            int lastY = sc.nextInt();
            int lastM = sc.nextInt();
            int lastD = sc.nextInt();
            String pre = preY + "-" + preM + "-" + preD;
            String last = lastY + "-" + lastM + "-" + lastD;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date preDate = simpleDateFormat.parse(pre);
            Date lastDate = simpleDateFormat.parse(last);
            long preTime = preDate.getTime();
            long lastTime = lastDate.getTime();
            if ((lastTime - preTime) % (604800000) == 0) {//注意是毫秒
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
