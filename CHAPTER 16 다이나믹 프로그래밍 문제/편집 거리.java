public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] before = sc.next().toCharArray();
        char[] after = sc.next().toCharArray();
        int[][] dp = new int[6000][6000];

        for (int i = 0; i < before.length + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < after.length + 1; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i < before.length + 1; i++) {
            for (int j = 1; j < after.length + 1; j++) {
                if (before[i - 1] == after[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        System.out.println(dp[before.length][after.length]);
}
