#include <iostream>
using namespace std;

int d[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n; cin >> n;
	d[1] = 0;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
			d[i] = d[i / 2] + 1;
		}
		if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
			d[i] = d[i / 3] + 1;
		}
		if (i % 5 == 0 && d[i] > d[i / 5] + 1) {
			d[i] = d[i / 5] + 1;
		}
	}
	cout << d[n] << '\n';
}

/*
D[n] = N을 1로 만드는 최소 연산 횟수
(1) D[n/5] + 1
(2) D[N/3] + 1
(3) D[N/2] + 1
(4) D[N-1] + 1
= min(1,2,3,4)
D[1] = 0
*/