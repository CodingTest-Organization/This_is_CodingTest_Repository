public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        for(int i= 0; i<n;i++) {
            arr1[i] = sc.nextInt();
        }

        for(int i= 0; i<n;i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        int cnt = 0;
        for(int i = 0; i<n;i++) {
            if (cnt == m) {
                break;
            }
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
            cnt++;
        }

        int sum = 0;
        for(int i = 0; i<n;i++) {
            sum += arr1[i];
        }
        System.out.println(sum);
    }
