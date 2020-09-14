#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool check(vector<int>& wifi, long long mid, int c) {
	int cnt = 1;
	int last = wifi[0];
	for (auto num : wifi) {
		// num - last : 와이파이의 거리
		// 거리가 크거나 같으면 개수 증가 + 기준 바꿔주기
		if (num - last >= mid) {
			cnt++;
			last = num;
		}
	}
	return cnt >= c;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, c; cin >> n >> c;
	vector<int> wifi(n);
	for (int i = 0; i < n; i++) {
		cin >> wifi[i];
	}
	sort(wifi.begin(), wifi.end());

	// 거리를 기준으로!
	// 개수가 c개 이상이면 가능
	long long l = 1, r = wifi[n - 1] - wifi[0];
	long long answer = l;

	while (l <= r) {
		long long mid = (r + l) / 2;
		if (check(wifi, mid, c)) {
			answer = max(answer, mid);
			l = mid + 1;
		}
		else {
			r = mid - 1;
		}
	}
	cout << answer << '\n';
}