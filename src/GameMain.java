import java.util.Scanner;

import v1_0.PokerGame;

public class GameMain {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in); // 標準入出力を使用
		
		while ( true ) {
			System.out.println("開始→1、終了→0");
			System.out.print(">");
			
			int command = stdIn.nextInt();
			if (command == 0) {
				break;
			}
			/*
			 * ゲーム1回分の処理
			 */
			PokerGame.exec(stdIn);
		}
		
		System.out.println("終了しました。");
		stdIn.close(); // 標準入出力を解放
	}

}
