package _13.dfs.bfs;

import java.util.Scanner;



public class Avoid {
    static int n;
    static char[][] maps;
    static int studentCnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maps = new char[n+10][n+10];
        for(int i = 0;i<n;i++) {
            for(int j = 0; j<n;j++) {
                maps[i][j] = sc.next().charAt(0);
                if (maps[i][j] == 'S') {
                    studentCnt++;
                }
            }
        }

        boolean collect = true;

        for(int x1 = 0; x1 < n;x1++) {
            for(int y1 = 0; y1 < n;y1++) {
                if (maps[x1][y1] != 'X') continue;
                for(int x2 = 0; x2 < n; x2++) {
                    for(int y2 = 0; y2 < n; y2++) {
                        if (x1 == x2 && y1 == y2) continue;
                        if (maps[x2][y2] != 'X') continue;
                        for(int x3 = 0;x3 <n;x3++) {
                            for(int y3 = 0;y3 <n;y3++) {
                                if (x1 == x3 && y1 == y3) continue;
                                if (x2 == x3 && y2 == y3) continue;
                                if (maps[x3][y3] != 'X') continue;

                                maps[x1][y1] = 'O';
                                maps[x2][y2] = 'O';
                                maps[x3][y3] = 'O';
                                if (!process()) {
                                    collect = process();
                                }
                                maps[x1][y1] = 'X';
                                maps[x2][y2] = 'X';
                                maps[x3][y3] = 'X';
                            }
                        }
                    }
                }
            }
        }

        System.out.println(collect?"NO":"YES");
    }

    private static boolean process() {
        for(int i = 0;i<n;i++) {
            for(int j = 0; j<n;j++) {
                if (maps[i][j] == 'T') {
                    for(int k = 0; k<4;k++) {
                        if (watch(i,j,k)) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    private static boolean watch(int x, int y, int direction) {

        if (direction == 0) {
            while (y >= 0) {
                if (maps[x][y] == 'S') {
                    return true;
                }

                if (maps[x][y] == 'O') {
                    return false;
                }
                y-=1;
            }
        }


        if (direction == 1) {
            while (y < n) {
                if (maps[x][y] == 'S') {
                    return true;
                }

                if (maps[x][y] == 'O') {
                    return false;
                }
                y+=1;
            }
        }

        if (direction == 2) {
            while (x >= 0) {
                if (maps[x][y] == 'S') {
                    return true;
                }

                if (maps[x][y] == 'O') {
                    return false;
                }
                x-=1;
            }
        }

        if (direction == 3) {
            while (x < n) {
                if (maps[x][y] == 'S') {
                    return true;
                }

                if (maps[x][y] == 'O') {
                    return false;
                }
                x+=1;
            }
        }
        return false;
    }

}
