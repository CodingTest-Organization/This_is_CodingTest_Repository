#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

#define MAX 11 + 1
int num[MAX];
vector<int> op;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n; cin >> n;
	long long max_num = -1000000000, min_num = 1000000000;

	// 숫자 입력 
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	// 연산자 입력 
	for (int i = 0; i < 4; i++) {
		int num; cin >> num;
		for (int j = 0; j < num; j++) {
			op.push_back(i);
		}
	}
	// next_permutation : 순열을 만들어준다. 최종적으로 끝나면 다시 원래 순서대로 바꾼 뒤 false를 return 
	do {
		long long answer = num[0];
		int index = 1;
		for (int x : op) {
			switch (x)
			{
			case 0:
				answer += num[index];
				break;
			case 1:
				answer -= num[index];
				break;
			case 2:
				answer *= num[index];
				break;
			case 3:
				answer /= num[index];
				break;
			default:
				break;
			}
			index++;
		}
		max_num = max(max_num, answer);
		min_num = min(min_num, answer);
	} while (next_permutation(op.begin(), op.end()));
	cout << max_num << "\n" << min_num << "\n";
}