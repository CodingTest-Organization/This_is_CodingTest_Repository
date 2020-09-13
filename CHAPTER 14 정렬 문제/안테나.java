public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i<n;i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int len = array.length-1;

        System.out.println(array[len/2]);
    }
