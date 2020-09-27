static final int INF = (int)(1e9);
    static int n,m;
    static int[][] graph = new int[200][200];
    static int k,x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i<=n;i++) {
            Arrays.fill(graph[i],INF);
        }

        for(int i = 1; i<=n;i++) {
            for(int j = 1; j<=n;j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        for(int i = 0; i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        k = sc.nextInt();
        x = sc.nextInt();

        for(int k = 1; k<=n;k++) {
            for(int i = 1; i<=n;i++) {
                for(int j = 1;j<=n;j++) {
                    graph[i][j] = Math.min(graph[i][j],graph[k][j] + graph[i][k]);
                }
            }
        }

        int result = graph[1][k] + graph[k][x];
        System.out.println((result >= INF) ? -1 : result);
    }
