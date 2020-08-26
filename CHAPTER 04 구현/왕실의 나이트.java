package implement;

import java.util.Scanner;

// 왕실의 나이트
public class Main02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("");
		sc.close();
		
		int x = str[0].charAt(0) - 'a';   // 열
		int y = Integer.parseInt(str[1]) - 1; // 행
		
		// ------------------------------------------------------ 1번 방법
		Knight knight = new Knight(x, y);
		System.out.println(knight.move());
		
		// ------------------------------------------------------ 2번 방법
		
		// 8가지의 경우의 수 식
		int[][] moving = {  
				{ 2,  1} , { 2, -1},
				{-2,  1} , {-2, -1},
				{ 1,  2} , {-1,  2},
				{ 1, -2} , {-1, -2}
		};
		int count = 0;
		int movedX, movedY; // 이동 후의 x,y 좌표
		
		// 나이트의 위치에 8개의 경우의 수를 모두 비교
		for(int i=0; i<moving.length; i++) {
			movedX = x + moving[i][0];
			movedY = y + moving[i][1];
			
			if( (movedX >= 0 && movedX <= 8) && (movedY >= 0 && movedY <= 8) ) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}

}

// 행 열 둘다 8을 넘지 않으면 된다.
class Knight{
	int x; // 나이트의 x좌표
	int y; // 나이트의 y좌표
	int count; // 나이트가 움직일 수 있는 경우의 수.
	
	public Knight(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 움직여보기
	public int move() {
		down();
		up();
		right();
		left();
		
		return count;
	}
	
	// 움직일 수 있는 경우의 수
	private void setCount(int x, int y) {
		// 움직일 수 있는 경우의 수인지.
		if( (x >= 0 && x <= 8) && (y >= 0 && y <= 8) ) {
			count++;
		}
	}
	
	// 8가지 경우의 수
	public void down() {
		setCount(this.x + 2, this.y + 1); // 아래로 2칸 오른쪽으로 1칸
		setCount(this.x + 2, this.y - 1); // 아래로 2칸 왼쪽으로 1칸
	}
	
	public void up() {
		setCount(this.x - 2, this.y + 1); // 위로 2칸 오른쪽으로 1칸
		setCount(this.x - 2, this.y - 1); // 위로 2칸 왼쪽으로 1칸
	}
	
	public void right() {
		setCount(this.x + 1, this.y + 2); // 오른쪽으로 2칸 아래로 1칸
		setCount(this.x - 1, this.y + 2); // 오른쪽으로 2칸 위로 1칸
	}
	
	public void left() {
		setCount(this.x + 1, this.y - 2); // 왼쪽으로 2칸 아래로 1칸
		setCount(this.x - 1, this.y - 2); // 왼쪽으로 2칸 위로 1칸
	}

}
