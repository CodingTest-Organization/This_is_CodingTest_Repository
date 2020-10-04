static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree = new int[501];
    static int[] times = new int[501];

    static void topologySort() {
        int[] result = new int[501];
        for(int i = 1; i<=n;i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : graph.get(now)) {
                result[i] = Math.max(result[i], result[now] + times[i]);
                indegree[i] -= 1;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            times[i] = x;
            while (true) {
                x = sc.nextInt();
                if (x == -1) {
                    break;
                }
                indegree[i]++;
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
