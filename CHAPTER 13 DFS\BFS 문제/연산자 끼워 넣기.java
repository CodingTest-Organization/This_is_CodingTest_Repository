package _13.dfs.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Operator {
    static int n;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int add = sc.nextInt();
        int sub = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        solution(add, sub, mul, div, 0, arr[0]);

        list = list.stream()
                .sorted().collect(toList());
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    private static void solution(int add, int sub, int mul, int div, int index, int ans) {

        if (index == n-1) {
            list.add(ans);
            return;
        }

        if (add != 0) {
            solution(add-1, sub, mul, div, index + 1, ans + arr[index + 1]);
        }
        if (sub != 0) {
            solution(add, sub-1, mul, div, index + 1, ans - arr[index + 1]);
        }
        if (mul != 0) {
            solution(add, sub, mul-1, div, index + 1, ans * arr[index + 1]);
        }
        if (div != 0) {
            solution(add, sub, mul, div-1, index + 1, ans / arr[index + 1]);
        }
    }
}
