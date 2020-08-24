private int[] getInts(String str) {
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
}

private int solution(int[] ints) {
   int n = ints[0];

     for (int i = 1; i < ints.length; i++) {
        if (n <= 1) {
            n += ints[i];
            continue;
        }
          n *= ints[i];
     }
        return n;
 }
