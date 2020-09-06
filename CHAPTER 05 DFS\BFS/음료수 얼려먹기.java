import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Drink {
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int[][] maps;
    static int n,m;
    static boolean[][] visited = new boolean[2000][2000];

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()) {
            int[] next = q.poll();
            int xx = next[0];
            int yy = next[1];
            for(int i = 0; i< 4;i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;

                if (maps[nx][ny] == 1 || visited[nx][ny]) continue;

                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        maps = new int[n+10][m+10];
        for(int i = 0; i<n;i++) {
            for(int j = 0;j<m;j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i<n;i++) {
            for(int j = 0; j<m;j++) {
                if (maps[i][j] == 0 && !visited[i][j]) {
                    bfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
