#include <iostream>
#include <string>
using namespace std;

string solution(string n) {
	int len = n.length();
	int half = len / 2;
	int sum = 0;

	for (int i = 0; i < half; i++) {
		sum += n[i] - '0';
	}
	for (int i = half; i < len; i++) {
		sum -= n[i] - '0';
	}

	return sum == 0 ? "LUCKY" : "READY";
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	string n; cin >> n;

	cout << solution(n) << '\n';
}