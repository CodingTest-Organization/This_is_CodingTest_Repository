
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        List<Character> chars = new ArrayList<>();
        int num = 0;

        for(char c : str.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num += (c - '0');
            } else {
                chars.add(c);
            }
        }

        Collections.sort(chars);

        String temp = "";

        for(char c : chars) {
            temp += c;
        }
        System.out.println(temp+""+num);
    }
}
