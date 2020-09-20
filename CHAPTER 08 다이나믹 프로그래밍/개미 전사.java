static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] arr = new int[n+10];
        int[] dp = new int[n+10];

        for(int i = 1;i<=n;i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];

        for(int i =2 ;i<=n;i++) {
            dp[i] = Math.max(arr[i],dp[i-2] + arr[i]);
        }

        System.out.println(dp[n]);

    }
