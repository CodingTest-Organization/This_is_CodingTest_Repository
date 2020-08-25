public class Bowling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

//        Collections.sort(list);

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            for(int j = i+1;j<list.size();j++) {
                int total = list.get(i) + list.get(j);
                if (total < m*2 && list.get(i) != list.get(j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
