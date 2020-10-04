static int n,m;
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
            return this.distance - o.distance;
        }
    }

    static public int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }


    static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    static List<Node> edges = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] parent = new int[n+1];

        for(int i = 1;i<=n;i++) {
            parent[i] = i;
        }
        for(int i = 0; i<m;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Node(a,b,c));
        }

        Collections.sort(edges);

        int result = 0;
        int max = -1;
        for(Node next : edges) {
            int cost = next.distance;
            int a = next.x;
            int b = next.y;

            if (findParent(parent,a) != findParent(parent,b)) {
                unionParent(parent,a,b);
                result += cost;
                max = Math.max(max,cost);
            }
        }

        System.out.println(result - max);

    }
