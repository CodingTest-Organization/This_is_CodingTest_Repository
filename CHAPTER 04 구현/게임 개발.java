public class Game {
    static int maps[][];
    static boolean visit[][];
    static int dy[] = {0,1,0,-1};
    static int dx[] = {-1,0,1,0};
    static int direction;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        maps = new int[n][m];
        visit = new boolean[n][m];

        int x = sc.nextInt();
        int y = sc.nextInt();

        visit[x][y] = true;

        direction = sc.nextInt();

        for(int i = 0; i<n;i++) {
            for(int j = 0; j <m;j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        int turn_cnt = 0;
        int ans = 1;

        while(true) {
            // 회전
            rotate();
            int nx = dx[direction] + x;
            int ny = dy[direction] + y;

            if (!visit[nx][ny] && maps[nx][ny] == 0) {
                visit[nx][ny] = true;
                ans++;
                turn_cnt = 0;
                x = nx;
                y = ny;
                continue;
            } else {
                turn_cnt++;
            }

            if (turn_cnt == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if (maps[nx][ny] == 1) {
                    break;
                }
                x = nx;
                y = ny;
                turn_cnt = 0;
            }
        }

        System.out.println(ans);
    }

    static void rotate() {
        direction = (--direction < 0) ? 3 : direction--;
    }
}
