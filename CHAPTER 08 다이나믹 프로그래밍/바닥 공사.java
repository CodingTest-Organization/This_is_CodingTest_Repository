public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dp[] = new int[n+100];

        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i<=n;i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i-1]*2) %796796;
            } else {
                dp[i] = ((dp[i-1] * 2) -1) % 796796;
            }
        }

        System.out.println(dp[n]);
    }
