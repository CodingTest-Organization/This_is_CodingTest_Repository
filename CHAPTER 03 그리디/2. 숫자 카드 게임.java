package codingTest;

import java.util.Arrays;
import java.util.Scanner;

/*
 숫자 카드 게임
숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드를 한장 뽑는 게임이다.
단 게임의 룰을 지키며 카드를 뽑아야 하고, 룰은 다음과 같다.

1. 숫자가 쓰인 카드들이 N x M 형태로 놓여 있다. 이때 N행은 행의 개수를 의미하며, M은 열의 갯수를 의미한다.
2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
3. 그 다음 선택된 행에 포함된 카들들 중 가장 낮은 카드를 뽑아야한다.
4. 따라서 처음에 카드를 골라낼 행 을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

입력 조건 
  - 첫째 줄에 숫자 카들들이 놓인 행의 갯수 N과 열의 개수 M이 공백을 기분으로 하여 각각 자연수로 주어진다.(1<=N,M<=100)
  - 둘째 줄부터 N개의 줄에 걸처 각 카드가 적힌 숫자가 주어진다. 각 숫자는 1이상 10,000이하의 자연수다.

출력 조건
   - 첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.

입력예시
3 3
3 1 2
4 1 4
2 2 2    
출력예시 2

2 4
7 3 1 8
7 3 3 4  
출력 예시 3
*/

public class Main02 {

	public static void main(String[] args) {

		int i = solution(new int[][] {{ 3, 1, 2 }, 
									  { 4, 1, 4 }, 
								      { 2, 2, 2 } });
		System.out.println(i); // 2

		System.out.println();

		i = solution(new int[][] { { 7, 3, 1, 8 }, 
							       { 7, 3, 3, 4 } });
		System.out.println(i); // 3
	}

	private static int solution(int[][] array) {
		
		for (int i = 0; i < array.length; i++) {
			Arrays.sort(array[i]);
		}
		
		int max = 0;
		for(int i=0; i<array.length; i++) {
			max = Math.max(max, array[i][0]);
		}
		return max;

	}

}
