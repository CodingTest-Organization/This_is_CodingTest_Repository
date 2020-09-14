  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n-1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (arr[mid] == mid) {
                result = mid;
                break;
            }

            if (arr[mid] < mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
