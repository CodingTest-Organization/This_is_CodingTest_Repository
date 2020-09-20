 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int maps[][] = new int[n + 10][n + 10];
        int dp[][] = new int[n + 10][n + 10];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                maps[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = maps[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + maps[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + maps[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + maps[i][j],dp[i - 1][j - 1] + maps[i][j]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
             max = Math.max(max,dp[i][j]);
            }
        }

        System.out.println(max);
    }
