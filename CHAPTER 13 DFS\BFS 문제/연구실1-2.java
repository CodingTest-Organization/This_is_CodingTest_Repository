
import java.util.*;

public class Lab2 {
    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] maps;
    static int[][] copyMaps;
    static List<Position> walls = new ArrayList<>();
    static List<List<Position>> info = new ArrayList<>();
    static int cur[] = new int[3];

    static void combination(int depth, int index, int value) {
        if (depth == 3) {
            List<Position> temp = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                temp.add(walls.get(cur[i]));
            }
            info.add(temp);
            return;
        }
        cur[index] = value;
        if (value == walls.size()) {
            return;
        }

        combination(depth + 1, index + 1, value + 1);
        combination(depth, index, value + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maps = new int[n + 10][n + 10];
        copyMaps = new int[n+10][n+10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = sc.nextInt();
                if (maps[i][j] == 0) {
                    walls.add(new Position(i, j));
                }
            }
        }
        // 조합을 사용해서 풀기
        combination(0, 0, 0);
        int max = -1;
        for (List<Position> wall : info) {
            for (Position p : wall) {
                maps[p.x][p.y] = 1;
            }
            bfs();
            int cnt = 0;
            for(int i = 0; i<n;i++) {
                for(int j = 0; j <n;j++) {
                    if (copyMaps[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            max = Math.max(max,cnt);
            for (Position p : wall) {
                maps[p.x][p.y] = 0;
            }
        }
        System.out.println(max);
    }

    static int[] dy = {0,0,-1,1};
    static int[] dx = {1,-1,0,0};
    private static void bfs() {
        Queue<Position> q = new LinkedList<>();

        for(int i = 0; i<n;i++) {
            for(int j = 0; j<n;j++) {
                copyMaps[i][j] = maps[i][j];
                if (copyMaps[i][j] == 2) {
                    q.offer(new Position(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Position prev = q.poll();
            for(int k = 0; k<4;k++) {
                int nx = prev.x + dx[k];
                int ny = prev.y + dy[k];
                if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
                if (copyMaps[nx][ny] != 0) continue;
                copyMaps[nx][ny] = 2;
                q.offer(new Position(nx,ny));
            }
        }
    }
}
