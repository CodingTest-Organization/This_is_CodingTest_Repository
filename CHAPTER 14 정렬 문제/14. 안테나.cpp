#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> antenna, int n) {
	// 결국 중간값이 이득
	return antenna[(n - 1) / 2];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<int> antenna;
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		antenna.push_back(num);
	}

	sort(antenna.begin(), antenna.end());
	cout << solution(antenna, n) << '\n';
}
