class FailRate implements Comparable<FailRate> {
        double rate;
        int stage;

        public FailRate(double rate, int stage) {
            this.rate = rate;
            this.stage = stage;
        }

        @Override
        public int compareTo(FailRate o) {
            return Double.compare(o.rate,this.rate);
        }
    }

    private int[] solution(int n, int[] stages) {
        // stage
       int total = stages.length;
        List<FailRate> rates = new ArrayList<>();
        for(int stage = 1; stage<n+1;stage++) {
            // 사람수
            int cnt = 0;
            for(int people : stages) {
                // 사람수랑 스테이지가 같으면 그..뭐냐...
                if (stage == people) {
                    cnt++;
                }
            }
            // 전체 인원 : total
            // 스테이지 별 인원 : cnt;
            double rate = 0;
            if (total >= 1) {
                rate = cnt / (double)total;
            }
            rates.add(new FailRate(rate,stage));
            total -= cnt;
        }

        Collections.sort(rates);

        int[] ans = new int[rates.size()];
        for(int i = 0; i<ans.length;i++) {
            ans[i] = rates.get(i).stage;
        }

        return ans;
    }
