#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int ball[11] = { 0, };

// 입력 
// 8 5
// 1 2 2 3 4 4 5 5 
// ball = [1, 2, 1, 2, 2]
// 조합의 느낌?

int solution(int n, int m) {
	int answer = 0;
	for (int i = 1; i < m; i++) {
		n -= ball[i];
		answer += ball[i] * n;
	}
	// 1 * 7 = 7
	// 2 * 5 = 10
	// 1 * 4 = 4
	// 2 * 2 = 4
	return answer;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n, m; cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int num; cin >> num;
		ball[num]++;
	}

	cout << solution(n, m) << '\n';
}