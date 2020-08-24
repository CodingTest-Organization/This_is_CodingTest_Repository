#include <iostream>
#include <string>
using namespace std;

long long solution(string s) {
	int len = s.size();
	long long answer = 0;
	for (int i = 0; i < len; i++) {
		// value가 0일때는 넘어감
		if (s[i] == '0') continue;
		// 1일 때는 더해주기
		else if (s[i] == '1') answer += 1;
		else {
			// 1보다 작거나 같을 때는 더해주는게 이득
			if (answer <= 1) answer += (s[i] - '0');
			// 아니라면 곱해주기!
			else answer *= (s[i] - '0');
		}
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	string s; cin >> s;
	cout << solution(s) << '\n';
}