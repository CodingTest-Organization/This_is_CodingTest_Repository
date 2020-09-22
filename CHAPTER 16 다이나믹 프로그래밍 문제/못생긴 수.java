public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int next2 = 0,next3 = 0,next5 = 0;
        int i2 = 2, i3 =3,i5 = 5;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1;i<n;i++) {
            dp[i] = Math.min(i2,Math.min(i3,i5));
           if (dp[i] == i2) {
               next2++;
               i2 = dp[next2] * 2;
           }

           if (dp[i] == i3) {
               next3++;
               i3 = dp[next3] * 3;
           }

           if (dp[i] == i5) {
               next5++;
               i5 = dp[next5] * 5;
           }

        }
        System.out.println(dp[n-1]);
}
