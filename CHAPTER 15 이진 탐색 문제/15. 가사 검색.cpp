#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

// ?로 시작 단어 : ? 시작 index를 return 
// ?로 끝나는 단어 : 알파벳의 시작 index를 return 
int find_index(string s) {
	int index = 0;
	int l = 0, r = s.length() - 1;
	if (s[0] != '?') {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (s[mid] != '?') {
				index = mid;
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
	}
	else {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (s[mid] != '?') {
				r = mid - 1;
			}
			else {
				index = mid;
				l = mid + 1;
			}
		}
	}
	return index + 1;
}

vector<int> solution(vector<string> words, vector<string> queries) {
	vector<int> answer;
	for (auto query : queries) {
		int cnt = 0;
		int index = find_index(query);
		for (auto keyword : words) {
			if (keyword.length() != query.length()) continue;
			if (query[0] == '?') {
				if (query.substr(index) == keyword.substr(index)) cnt++;
			}
			else {
				if (query.substr(0, index) == keyword.substr(0, index)) cnt++;
			}
		}
		answer.push_back(cnt);
	}
	return answer;
}

// 효율성 1,2,3 시간 초과
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	vector<string> words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
	vector<string> queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

	for (auto a : solution(words, queries)) {
		cout << a << " ";
	}
}