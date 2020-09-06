package _13.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab {
    static int n, m;
    static int[][] maps;
    static int[][] copyMaps;

    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        maps = new int[n][m];
        copyMaps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        int ans = -1;

        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                if (maps[x1][y1] != 0) continue;

                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < m; y2++) {
                        if (maps[x2][y2] != 0) continue;
                        if (x1 == x2 && y1 == y2) continue;


                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                if (maps[x3][y3] != 0) continue;
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                int cnt = 0;
                                maps[x1][y1] = 1;
                                maps[x2][y2] = 1;
                                maps[x3][y3] = 1;
                                bfs();

                                for (int i = 0; i < n; i++) {
                                    for (int j = 0; j < m; j++) {
                                        if (copyMaps[i][j] == 0) {
                                            cnt++;
                                        }
                                    }
                                }

                                ans = Math.max(ans, cnt);
                                maps[x1][y1] = 0;
                                maps[x2][y2] = 0;
                                maps[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMaps[i][j] = maps[i][j];

                if (copyMaps[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
                if (copyMaps[nx][ny] != 0) continue;
                copyMaps[nx][ny] = 2;
                q.offer(new Node(nx, ny));
            }
        }
    }
}
