package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
        CHAPTER 07 부품 찾기
        부품 찾기
        동빈이네 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다. 어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다. 동빈이는 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야 한다. 이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.

        이때 손님이 요청한 부품의 번호의 순서대로 부품을 확인해 부품이 있으면 yes,없으면 no를 출력한다. 구분은 공백으로 한다.

        입력 조건

        첫째 줄에 정수 N이 주어진다. ( 1<=N <=10,000,000)
        둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다. 이때 정수는 1보다 크고, 1,000,000 이하이다.
        셋째 줄에는 정수 M이 주어진다.( 1<= M <= 100,000)
        넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다. 이때 정수는 1보다 크고 10억 이하이다.
        출력 조건

        첫째 줄에는 공백으로 구분하여 각 부품이 존재하면 yes를, 없으면 no를 출력한다.
        입력예시              출력 예시
        5
        8 3 7 9 2
        3
        5 7 9
*/
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }

        // m
        int m = sc.nextInt();
        String answer = "yes";
        for(int i=0; i<m; i++){
          if(!list.contains(sc.nextInt())){
              answer = "no";
              break;
          }
        }
        sc.nextLine();
        System.out.println(answer);
    }

}
























