static class Node implements Comparable<Node>{
        private int index;
        private int distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return o.distance - this.distance;
        }
    }

    static final int INF = (int)1e9;
    static int n,m,c;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance = new int[30002];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for(int i = 0; i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new Node(y,z));
        }
        Arrays.fill(distance,INF);
        go(c);

        int count = 0;
        int max = INF * -1;
        for(int d : distance) {
            if (d != INF) {
                count+=1;
                max = Math.max(max,d);
            }
        }

        System.out.println(count-1 + " " + max);
    }

    private static void go(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node shortest = pq.poll();
            int dist = shortest.distance;
            int now = shortest.index;

            if (distance[now] < dist) {
                continue;
            }

            for(int i = 0; i<graph.get(now).size();i++) {
                int cost = dist + graph.get(now).get(i).distance;

                if (cost < distance[graph.get(now).get(i).index]) {
                    distance[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index,cost));
                }
            }
        }
    }
