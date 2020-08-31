import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String first = num.substring(0, num.length() / 2);
        String last = num.substring(num.length() / 2);

        int left = 0;
        for(int i = 0; i< first.length();i++) {
            left += (first.charAt(i) - '0');
        }

        int right = 0;
        for(int i = 0; i<last.length();i++) {
            right += (last.charAt(i) - '0');
        }


        if(left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
