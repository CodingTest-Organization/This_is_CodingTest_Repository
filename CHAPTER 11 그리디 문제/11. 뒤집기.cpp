#include <iostream>
#include <string>
using namespace std;

int solution(string s) {
	int len = s.length();
	int cnt = 1;
	// 문자가 달라질 때마다 cnt 증가
	for (int i = 1; i < len; i++) {
		if (s[i] != s[i - 1]) cnt++;
	}
	// 나눈 그룹의 반만 바꿔주면 된다
	return cnt / 2;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	string s; cin >> s;
	cout << solution(s) << '\n';
}