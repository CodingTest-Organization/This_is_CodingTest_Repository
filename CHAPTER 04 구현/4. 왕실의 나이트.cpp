#include <iostream>
#include <string>
using namespace std;

#define MAX_SIZE 8

int dx[] = { -2,-2,-1,-1,1,1,2,2 };
int dy[] = { -1,1,-2,2,-2,2,-1,1 };

int solution(int x, int y) {
	int answer = 0;
	for (int i = 0; i < MAX_SIZE; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (0 < nx && nx <= MAX_SIZE && 0 < ny && ny <= MAX_SIZE) {
			answer++;
		}
	}
	return answer;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	string now; cin >> now;
	int x = now[1] - '0';
	int y = now[0] - 'a' + 1;

	cout << solution(x, y) << '\n';
}