#include <iostream>
#include <string>
#include <cctype>
#include <algorithm>
using namespace std;

string solution(string s) {
	int index = 0;
	int sum = 0;
	string answer = "";
	int len = s.length();

	sort(s.begin(), s.end());

	// 숫자의 합과 문자가 시작하는 index 구하기 
	for (int i = 0; i < len; i++) {
		if (isdigit(s[i])) {
			sum += s[i] - '0';
		}
		else {
			index = i;
			break;
		}
	}

	// 문자열을 index부터 끝까지 잘라준 뒤 뒤에 sum을 붙여준다.
	answer = s.substr(index, len - index + 1) + to_string(sum);
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	string s; cin >> s;
	cout << solution(s) << '\n';
}