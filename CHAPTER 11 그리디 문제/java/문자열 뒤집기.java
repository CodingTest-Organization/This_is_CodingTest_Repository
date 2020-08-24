private static void solution(String str) {
        int[] ints = getInts(str);

        int collect0 = 0;
        int collect1 = 0;
        if (ints[0] == 0) {
            collect0++;
        } else {
            collect1++;
        }

        for(int i = 0;i<ints.length-1;i++) {
            if (different(0,ints, i)) {
                collect0++;
            } else if (different(1,ints, i)) {
                collect1++;
            }
        }

        System.out.println(Math.min(collect0,collect1));
}

private static int[] getInts(String str) {
     return Arrays.stream(str.split(""))
                          .mapToInt(Integer::parseInt)
                           .toArray();
}

private static boolean different(int index, int[] ints, int i) {
     return  ints[i+1] == index && ints[i] != ints[i + 1];
}
