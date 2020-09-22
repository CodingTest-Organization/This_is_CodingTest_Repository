public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] maps = new int[n+10];
        int[] dp = new int[n+10];

        for(int i = 0; i<n;i++) {
            maps[i] = sc.nextInt();
        }
        dp[0] = 1;
        int max = dp[0];
        for(int i = 1; i< n;i++) {
            dp[i] = 1;
            for(int j = 0; j <i;j++) {
                if (maps[i] < maps[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            max = Math.max(max,dp[i]);
        }

        System.out.println(n - max);
}
