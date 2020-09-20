 static int[][] maps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            maps = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maps[i][j] = sc.nextInt();
                }
            }
            int result = solution(n, m);
            System.out.println(result);
        }
    }

    private static int solution(int n, int m) {
        int dp[][] = new int[n][m];
        // 초기 dp는 j열이 0일때만 들어가면 된다.
        // 즉,
        for (int i = 0; i < n; i++) {
            dp[i][0] = maps[i][0];
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j - 1]) + maps[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]) + maps[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1],
                            Math.max(dp[i - 1][j - 1],
                                    dp[i + 1][j - 1])) + maps[i][j];
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i][m-1]);
        }
        return max;
    }
