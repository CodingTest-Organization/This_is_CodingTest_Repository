private int solution(List<Integer> list) {
        Collections.sort(list);
        int target = 1;

        for(int i : list) {
            if (target < i) {
                break;
            }

            target += i;
        }
        return target;
}
