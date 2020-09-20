static int n,t[],p[],dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        t = new int[n+10];
        p = new int[n+10];
        dp = new int[n+10];

        for(int i = 0; i<n;i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int result = go(0,0);
        System.out.println(result);

    }

    private static int go(int day,int total) {
        if (day == n) {
            return total;
        }

        int over = day + t[day];
        if (over > n) {
            return total;
        }

      return Math.max(go(day+1,total),go(over, total+p[day]));
    }
