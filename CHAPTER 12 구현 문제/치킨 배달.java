package _12.Implentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

class Position2 {
    int x;
    int y;

    public Position2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Combination2 {
    int max;
    int limit;

    public int[] now; // 현재 조합
    public List<List<Position2>> result; // 모든 조합
    private List<Position2> arr;

    public Combination2(List<Position2> arr, int max, int limit) {
        this.arr = arr;
        this.max = max;
        this.limit = limit;
        this.now = new int[limit];
        this.result = new ArrayList<>();
    }

    public void combination(int depth, int index, int target) {
        if (depth == limit) {
            ArrayList<Position2> temp = new ArrayList<>();
            for (int i : now) {
                temp.add(arr.get(i));
            }
            result.add(temp);
            return;
        }

        if (target == max) {
            return;
        }

        now[index] = target;
        combination(depth + 1, index + 1, target + 1);
        combination(depth, index, target + 1);
    }
}

public class Main {
    static int n, m;
    static int maps[][];

    static List<Position2> houses = new ArrayList<>();
    static List<Position2> chickens = new ArrayList<>();

    public static int getSum(List<Position2> candidate) {
        int sum = 0;
        for (Position2 house : houses) {
            int temp = (int) 1e9;
            for (Position2 chicken : candidate) {
                temp = min(temp,abs(house.x - chicken.x) + abs(house.y - chicken.y));
            }
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maps = new int[n + 10][n + 10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = sc.nextInt();
                if (maps[i][j] == 1) {
                    houses.add(new Position2(i, j));
                }
                if (maps[i][j] == 2) {
                    chickens.add(new Position2(i, j));
                }
            }
        }

        Combination2 comb = new Combination2(chickens, chickens.size(), m);
        comb.combination(0, 0, 0);
        List<List<Position2>> result = comb.result;

        int ans = (int)1e9;
        for (List<Position2> now : result) {
            ans = min(ans, getSum(now));
        }
        System.out.println(ans);
    }
}
