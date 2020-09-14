package search;

import java.util.Scanner;

/*
CHAPTER 15 이진 탐색 문제
고정점 찾기
시간 제한 1초 | 메모리 제한 128MB | 기출 Amazon 인터뷰

고정점이란, 수열의 원소 중에서 그 값이 인덱스와 동일한 원소를 의미합니다. 예를 들어 수열 a = [-15,-4,2,8,13]이 있을 때, a[2] = 2이므로, 고정점은 2가 됩니다. 하아의 수열이 N개의 서로 다른 원소를 포함하고 있으며, 모든 원소가 오름차순으로 정렬되어 있습니다. 이때 이 수열에서 고정점이 있다면, 고정점을 출력하는 프로그램을 작성하시오. 만약 고정점이 없다면 -1을 출력합니다.

제한 사항

O(logN)으로 알고리즘을 설계하지 않으면 시간초과 판정을 받습니다.
입력 조건

첫째 줄에 N이 입력됩니다. (1 <=N<= 1,000,000)
둘째 줄에 N개의 원소가 정수의 형태로, 공백으로 구분되어 입력됩니다. (-10^9 <= 각 원소의 값 <= 10^9) 출력 조건
고정점을 출력한다. 고정점이 없다면 -1을 출력합니다.
입력 예시1	        출력 예시1
5
-15 -6 1 3 7	    3
입력 예시2	        출력 예시2
7
-15 -4 2 8 9 13 15	2
입력 예시3	        출력 예시3
7
-15 -4 3 8 9 13 15	-1
*/
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }

        int mid = 0;
        int left = 0;
        int right = array.length-1;
        int answer = -1;
        while(right >= left){
            mid = (left+right)/2;
            if (mid == array[mid]) {
                answer = mid;
                break;
            }

            if (mid < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }
}
