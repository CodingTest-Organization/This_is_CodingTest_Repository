    private static int solution(String s) {
        int ans = s.length();

        for(int step = 1; step < s.length()/2+1;step++) {
            String prev = s.substring(0,step);
            String compression = "";
            int cnt = 1;
            for(int i = step;i<s.length();i+=step) {
                String sub = "";
                for(int j = i; j < i+step && j < s.length();j++) {
                    sub+=s.charAt(j);
                }

                if (prev.equals(sub)) {
                    cnt++;
                } else {
                    compression += (cnt == 1) ? prev : cnt + prev;
                    cnt = 1;
                    prev = sub;
                }
            }
            compression += (cnt == 1) ? prev : cnt + prev;
            ans = Math.min(ans, compression.length());

        }
        return ans;
    }
