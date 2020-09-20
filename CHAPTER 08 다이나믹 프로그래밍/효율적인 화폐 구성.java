 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n+100];

        for(int i = 0; i<n;i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+100];

        for(int i = 0; i<n+100;i++) {
            dp[i] = 10010;
        }

        dp[0] = 0;

        for(int i = 0; i < n;i++) {
            for(int j = arr[i]; j <= m;j++) {
                dp[j] = Math.min(dp[j],dp[j-arr[i]] + 1);
            }
        }

        System.out.println(dp[m] == 10010? -1 : dp[m]);
    }
