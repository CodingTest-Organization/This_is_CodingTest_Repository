package codingTest;

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
public class Main03 {

	public static void main(String[] args) {
		int i = solution(8, 3);
		System.out.println(i);
	}

	private static int solution(int n, int k) {
		if(n == k)return 1;
		
		int count = 0;
		while(n != 1) {
			if(n % k == 0) {
				n = n/k;
			}else {
				n--;
			}
			count++;
		}
		return count;
	}

}
