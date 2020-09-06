package _05.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
    static int n, m;
    static int[][] maps;
    static int[][] move;
    static boolean[][] visit;

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maps = new int[n][m];
        visit = new boolean[n][m];
        move = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }
        visit[0][0] = true;
        move[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] prev = q.poll();
            int x = prev[0];
            int y = prev[1];
            for(int i = 0; i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || n <= nx || 0 > ny || ny >= m) continue;
                if (visit[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;
                visit[nx][ny] = true;
                move[nx][ny] = move[x][y] + 1;
                q.add(new int[]{nx,ny});

            }
        }

        System.out.println(move[n-1][m-1]);
    }
}
