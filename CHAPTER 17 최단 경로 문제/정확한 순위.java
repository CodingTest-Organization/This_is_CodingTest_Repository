static final int INF = (int) 1e9;
    static int n, m;
    static int[][] graph = new int[600][600];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[k][j] + graph[i][k]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != INF || graph[j][i] != INF)  {
                    count++;
                }
            }

            if (count == n) {
                result++;
            }
        }

        System.out.println(result);

    }
