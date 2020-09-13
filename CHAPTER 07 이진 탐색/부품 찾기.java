static int n;
    static int[] array;
    static int m;
    static int[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new int[n];
        for(int i = 0; i<n;i++) {
            array[i] = sc.nextInt();
        }
        m = sc.nextInt();
        list = new int[m];
        for(int i = 0; i<m;i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(array);
        for(int i = 0; i<m;i++) {
            String result = binary(list[i]);
            System.out.print(result+" ");
        }

    }

    private static String binary(int target) {
        int start = 0;
        int end = array.length-1;

        while(start <= end) {
            int mid = (start + end) /2;
            if (array[mid] == target) {
                return "yes";
            }

            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        return "no";
    }
