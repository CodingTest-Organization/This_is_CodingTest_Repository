#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> a;
vector<int> b;

int solution(int n, int k) {
	int answer = 0;
	sort(a.begin(), a.end());
	sort(b.begin(), b.end());
	for (int i = k; i < a.size(); i++) {
		answer += a[i];
	}
	for (int i = k - 1; i < b.size(); i++) {
		answer += b[i];
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, k; cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		a.push_back(num);
	}
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		b.push_back(num);
	}

	cout << solution(n, k) << '\n';
}