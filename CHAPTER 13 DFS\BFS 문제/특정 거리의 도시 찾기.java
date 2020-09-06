package _13.dfs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class City {
    static int n,m,k,x;
    static List<List<Integer>> info = new LinkedList<>();
    static int[] move = new int[300001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        for(int i = 0; i<=n;i++) {
            info.add(new LinkedList<>());
            move[i] = -1;
        }

        for(int i = 0; i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            info.get(a).add(b);
        }

        // 시작
        move[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()) {
            int prev = q.poll();
            List<Integer> nextNode = info.get(prev);
            for(int i = 0; i<nextNode.size();i++) {
                int next = nextNode.get(i);
                if (move[next] != -1)  continue;

                move[next] = move[prev] + 1;
                q.add(nextNode.get(i));
            }
        }

        boolean check = false;
        for(int i = 1; i<=m;i++) {
            if (move[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);
    }
}
