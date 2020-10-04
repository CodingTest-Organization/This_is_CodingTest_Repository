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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] parent = new int[n+1];

        for(int i = 0; i<=n;i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i<m;i++) {
            int op = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (op == 0) {
                unionParent(parent,a,b);
            }
            if (op == 1) {
                System.out.println(findParent(parent,b) == findParent(parent,a) ? "YES" : "NO");
            }
        }
    }
