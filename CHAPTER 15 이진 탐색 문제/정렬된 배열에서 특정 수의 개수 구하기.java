package search;

import java.util.Scanner;

/*
CHAPTER 15 이진 탐색 문제
정렬된 배열에서 특정 수의 개수 구하기
시간 제한 1초 | 메모리 제한 128MB | 기출 Zoho 인터뷰

N개의 원소를 포함하고 있는 수열이 오름차순으로 정렬되어 있습니다. 이때 이 수열에서 x가 등장하는 횟수를 계산하세요. 예를 들어 수열 [1,1,2,2,2,2,3]이 있을 때 x= 2이라면, 현재 수열에서 값이 2인 원소가 4개이므로 4를 출력합니다.

제한 사항

O(logN)으로 알고리즘을 설계하지 않으면 시간초과 판정을 받습니다.
입력 조건

첫째 줄에 N과 x의 정수 형태로, 공백으로 구분되어 입력됩니다. (1 <=N<= 1,000,000) (-10^9 <=x<=10^9) (10의 9승)
둘째 줄에 N개의 원소가 정수의 형태로, 공백으로 구분되어 입력됩니다. (-10^9 <= 각 원소의 값 <= 10^9) 출력 조건
수열의 원소 중에서 값이 x인 원소의 개수를 출력합니다. 단, 값이 x인 원소가 하나도 없다면 -1을 출력합니다.
입력 예시1	출력 예시1
7 2
1 1 2 2 2 2 3	4
입력 예시2	출력 예시2
7 4
1 1 2 2 2 2 3	-1
*/
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[sc.nextInt()]++;
        }
        int answer = array[x] == 0? -1 : array[x];
        System.out.println(answer);

    }
}
