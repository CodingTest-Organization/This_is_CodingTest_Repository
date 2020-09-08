#include <string>
#include <vector>
#include <iostream>
using namespace std;

// 올바른 괄호 문자열 체크하기 맞 true 틀 false
bool check(string u) {
	int len = u.size();
	int chk = 0;
	for (int i = 0; i < len; i++) {
		if (u[i] == '(') {
			chk++;
		}
		else {
			if (chk == 0) {
				return false;
			}
			else {
				chk--;
			}
		}
	}
	if (chk != 0) return false;
	else return true;
}

// u,v 나누기 -> index 반환 
int div(string w) {
	int chk = 0, index = 0;
	int len = w.size();
	for (int i = 0; i < len; i++) {
		if (w[i] == '(') chk++;
		else chk--;
		if (chk == 0) {
			index += i;
			break;
		}
	}
	return index;
}

// u문자 만들어주기
string solution(string w) {
	string u = "", v = "";
	string answer = "";
	string tmp = "";

	// break문
	if (w == "") return answer;

	// 2. 문자열 분리 
	int index = div(w);
	u = w.substr(0, index + 1);
	v = w.substr(index + 1);
	int len = u.size();
	// 3. u가 올바른 문자열 
	if (check(u) == true) {
		answer += u;
		answer += solution(v);
	}
	// 4. u가 올바르지 않은 문자열 
	else {
		// 4-1
		answer += "(";
		// 4-2
		answer += solution(v);
		// 4-3
		answer += ")";
		// 4-4
		for (int i = 1; i < len - 1; i++) {
			if (u[i] == '(') tmp += ")";
			else tmp += "(";
		}
		answer += tmp;
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	string w; cin >> w;
	cout << solution(w) << '\n';
}