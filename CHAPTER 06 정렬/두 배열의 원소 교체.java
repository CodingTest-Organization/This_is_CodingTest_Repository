package sort;

import java.util.Arrays;
import java.util.Scanner;

/*
        CHAPTER 06 정렬
        두 배열의 원소 교체
        동빈이는 두 개의 배열 A와 B를 가지고 있다. 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다. 동빈이는 최대 K번의 바꿔치기 연산을 수행할 수 있는데, 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다. 동빈이는 최종 목표는 배열 A의 모든 원소의 합이 최대 가 되도록 하는 것이며, 여러분은 동빈이를 도와야 한다.

        N,K, 그리고 배열 A와 B의 값의 정보가 주어졌을때, 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최대값을 출력하는 프로그램을 작성하시오.

        배열 A = [1,2,5,4,3]
        배열 B = [5,5,6,6,5]
        연산 1) 베열 A 원소 1, 배열 B 6 바꾸기

        연산 2) 베열 A 원소 2, 배열 B 5 바꾸기

        연산 3) 베열 A 원소 3, 배열 B 6 바꾸기

        배열 A = [6,6,5,4,5] 합 = 26
        배열 B = [3,5,1,2,5]
        입력 조건

        첫 번째 줄에는 N,K가 공백으로 구분되어 입력된다. (1<=N <=100,000, 0<= K <=N)
        두 번째 줄에는 배열 A의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 작은 자연수이다.
        세 번째 줄애는 B의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 작은 자연수입니다.
        출력 조건

        최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력한다.
        입력 예시                               출력 예시

        5 3
        1 2 5 4 3
        5 5 6 6 5                                26
*/
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] first = new int[n];
        int[] second = new int[n];

        for(int i=0; i<n; i++){
            first[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            second[i] = sc.nextInt();
        }

        Arrays.sort(first);
        Arrays.sort(second);

        int sum = 0;
        for(int i=1; i<=k; i++){
            sum += Math.max(first[i-1], second[second.length - i]);
        }
        for(int i=(n-k)+1; i<n; i++){
            sum += first[i];
        }
        System.out.println(sum);
    }

}
























