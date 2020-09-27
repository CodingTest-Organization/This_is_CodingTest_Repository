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
    static int n,m;
    static int[] distance = new int[200001];
    static List<List<Node>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Node(b,1));
            graph.get(b).add(new Node(a,1));
        }

        Arrays.fill(distance,INF);
        go(1);

        int max = -INF;
        int index = 0;
        List<Integer> count = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            if (max < distance[i]) {
                max = distance[i];
                index = i;
            } else if (max == distance[i]) {
                count.add(i);
            }
        }


        System.out.println(index + " " + max + " " + count.size());
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

            for(int i = 0; i < graph.get(now).size();i++) {
                int cost = dist + graph.get(now).get(i).distance;

                if (cost < distance[graph.get(now).get(i).index]) {
                    distance[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index,cost));
                }
            }
        }
    }
