static final int[] dy = {0,0,1,-1};
    static final int[] dx = {1,-1,0,0};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return o.distance - this.distance;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc -- >  0) {
            int n = sc.nextInt();

            int maps[][] = new int[n+10][n+10];

            for(int i = 0; i<n;i++) {
                for(int j = 0; j<n;j++) {
                    maps[i][j] = sc.nextInt();
                }
            }

            graph(maps,n);
        }
    }
    static final int INF = (int)(1e9);
    private static void graph(int[][] maps, int n) {
        int dp[][] = new int[n+10][n+10];

        for(int i = 0; i<n;i++) {
            Arrays.fill(dp[i],INF);
        }
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,maps[0][0]));

        while(!pq.isEmpty()) {
            Node prev = pq.poll();
            int dist = prev.distance;
            int x = prev.x;
            int y= prev.y;
            if (dp[x][y] < dist) continue;

            for(int k = 0; k<4;k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;

                int cost = dist + maps[nx][ny];

                if (cost < dp[nx][ny]) {
                    dp[nx][ny] = cost;
                    pq.offer(new Node(nx,ny,cost));
                }
            }
        }


        System.out.println(dp[n-1][n-1]);

    }
