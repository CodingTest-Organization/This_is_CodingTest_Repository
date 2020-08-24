/*
1이 될때 까지

어떠한 수N이 1이 될때까지 다음의 두과정중 하나를 반복적으로 선택하여 수행하려고 한다. 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.

 1. N에서 1을 뺀다.
 2. N을 K로 나눈다.

입력 조건
  - 첫째 줄에 N(2<=N<=100,000)과
     K(2<=K<=100,000)가 공백으로 구분되며 각각 자연수로 주어진다. 이때 입력으로 주어지는 N은 항상 K보다 크거나 같다.
출력 조건
  - 첫째 줄에 N이 1이 될때 까지 1번 혹은 2번의 과정을 수행해야하는 최솟값을 출력한다.

입력 예시
25 5
출력 예시
2
*/

#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n, k; cin >> n >> k;
    int answer = 0;

    while (n != 1) {
        // 나누어 떨어지면 나눔
        if (n % k == 0) n /= k;
        // 아니면 1 빼기
        else n--;
        answer++;
    }

    cout << answer << '\n';
}