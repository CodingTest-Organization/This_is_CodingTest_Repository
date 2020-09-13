static int n,m;
    static long[] list;
    static long max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new long[n];
        for(int i = 0; i<n;i++) {
            list[i] = sc.nextInt();
            max = Math.max(max,list[i]);
        }

        System.out.println(binary());
    }

    private static long binary() {
        long start = 1;
        long end = max;
        long result = -1;
        while (start <= end) {
            long sum = 0;
            long mid = (start + end ) /2;
            for(int i = 0; i<list.length;i++) {
                long slice = 0;
                if (mid < list[i]) {
                    slice = (list[i] - mid);
                }
                sum+= slice;
            }

            if (sum < m) {
                end = mid -1;
            } else {
                result = mid;
                start = mid + 1;
            }

        }
        return result;
    }
