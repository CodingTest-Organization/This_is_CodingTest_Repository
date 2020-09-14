#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n; cin >> n;
	vector<int> num;
	for (int i = 0; i < n; i++) {
		int input; cin >> input;
		num.push_back(input);
	}

	int answer = -1;
	int l = 0, r = n - 1;
	while (l <= r) {
		int mid = (l + r) / 2;
		// 같으면 return mid
		if (num[mid] == mid) {
			answer = mid;
			break;
		}
		// value가 더 크면 오른쪽으로 이동
		else if (num[mid] < mid) {
			l = mid + 1;
		}
		// index가 더 크면 왼쪽으로 이동
		else {
			r = mid - 1;
		}
	}

	cout << answer << '\n';
}