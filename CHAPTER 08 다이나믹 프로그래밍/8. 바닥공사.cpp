#include <iostream>
using namespace std;

#define MOD 796796
int d[1002];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n; cin >> n;
	d[0] = d[1] = 1;
	for (int i = 2; i <= n; i++) {
		d[i] = d[i - 1] + 2 * d[i - 2];
		d[i] %= MOD;
	}

	cout << d[n] % MOD << '\n';
}

/*
D[N] = 2XN 직사각형을 채우는 방법의 수
D[N] = D[N-1] + 2*D[N-2]
D[0] = 1, D[1] = 1
*/