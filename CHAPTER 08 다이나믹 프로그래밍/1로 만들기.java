public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+100];

        dp[1] = 0;

        for(int i = 2;i<=n;i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }

            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i],dp[i/5]+1);
            }
        }

        for(int i = 1; i<=n;i++) {
            System.out.println(dp[i]);
        }
    }
