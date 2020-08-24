private int solution(List<Integer> list) {
     Collections.sort(list, Collections.reverseOrder());

     int cnt = 0;
      for (int i = 0; i < list.size(); ) {
          cnt++;
          i += list.get(i);
      }
      return cnt;
}
