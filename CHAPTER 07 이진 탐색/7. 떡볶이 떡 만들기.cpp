#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 나무의 총합이 m개 이상인지 판단
bool check(vector<long long>& tree, long long mid, long long m) {
	int len = tree.size();
	long long cnt = 0;
	for (int i = 0; i < len; i++) {
		if (tree[i] - mid > 0) {
			cnt += tree[i] - mid;
		}
	}
	return cnt >= m;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m; cin >> n >> m;
	vector<long long> tree;
	long long r = 0, l = 0;
	long long answer = 0;

	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		tree.push_back(num);
		if (r < tree[i]) r = tree[i];
	}

	while (l <= r) {
		long long mid = (l + r) / 2;
		if (check(tree, mid, m)) {
			answer = max(answer, mid);
			l = mid + 1;
		}
		else {
			r = mid - 1;
		}
	}
	cout << answer << '\n';
}