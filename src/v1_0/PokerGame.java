package v1_0;

import java.util.Scanner;

public class PokerGame {
	public static void exec(Scanner in) { // Game1回分の処理
		// 初期化部
		int[] pile = new int[52]; // 山札
		int[] hand = new int[ 5]; // 手札
		String[] card = new String[52]; // トランプの表面
		String[] suit = {"♠", "♡", "♢", "♣"}; // トランプのマーク
		String[] num  = {" A", " 2", " 3", " 4", " 5", " 6", " 7",
						 " 8", " 9", "10", " J", " Q", " K"}; // トランプの数字部分
		
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				card[i * 4 + j] = suit[j] + num[i];
			}
		}
		for (int i = 0; i < 52; i++) {
			pile[i] = i;
		}
		
		// 処理部
		System.out.println(">>> Java Poker START <<<");
		
		for (int i = 0; i < 5; i++) {
			hand[i] = pile[i];
		}
		
		System.out.println("[" + card[ hand[0] ] + "]" + 
		                   "[" + card[ hand[1] ] + "]" + 
				           "[" + card[ hand[2] ] + "]" + 
		                   "[" + card[ hand[3] ] + "]" + 
				           "[" + card[ hand[4] ] + "]");
		System.out.println("  1    2    3    4    5  ");
		System.out.print("何枚替えますか？（0-5）>");
		in.nextInt();
		
		System.out.println(">>> Java Poker  END  <<<");
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
