#include <iostream>
using namespace std;
int d[101];
int ant[101];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> ant[i];
	}

	d[0] = ant[0];
	d[1] = max(ant[0], ant[1]);
	for (int i = 2; i < n; i++) {
		d[i] = max(d[i - 1], d[i - 2] + ant[i]);
	}

	cout << d[n - 1] << '\n';
}

/*
D[N] = 식량 N개 최대값
(1) 선택 O -> D[N-1]
(2) 선택 X -> D[N-2] + ant[N]
-> max(1,2)
D[0] = ant[0]
D[1] = max(ant[0],ant[1])
*/