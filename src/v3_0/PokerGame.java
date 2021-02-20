package v3_0;

import java.util.Scanner;

public class PokerGame {
	static final String[] suit = { "♠", "♡", "♢", "♣" }; // トランプのマーク
	static final String[] num = { " A", " 2", " 3", " 4", " 5", " 6", " 7",
			" 8", " 9", "10", " J", " Q", " K" }; // トランプの数字部分
	static final String[] card = new String[suit.length * num.length]; // トランプの表面
	static final int HAND_MAX = 5; // 手札は5枚

	public static void exec(Scanner in) { // Game1回分の処理
		// 初期化部
		init();
		int[] pile = new int[card.length]; // 山札
		pile = Shuffler.shuffle(pile);
		int[] hand = new int[HAND_MAX]; // 手札
		int next = 0; // 山札の次の場所

		// 処理部
		System.out.println(">>> Java Poker START <<<");
		// 手札を配る
		for (int i = 0; i < HAND_MAX; i++) {
			hand[i] = pile[next++]; // 山札の次の場所を手札にコピー
		}
		// 手札を並べ替える（バブルソート）
		for (int i = 0; i < hand.length; i++) { // 最小の手札（左端）から順に確定させる
			for (int j = hand.length - 1; j > i; j--) { // 大きい手札（右端）から比較を開始
				if (hand[j - 1] > hand[j]) { // 左側のカードが小さい場合
					// カードを入れ替え
					int tmp = hand[i];
					hand[i] = hand[j];
					hand[j] = tmp;
				}
			}
		}
		// 最初の手札を表示
		dispHand(hand);

		// 手札の交換を指示
		int[] ex = exchangeHand(in);

		// 手札を交換
		for (int e : ex) {
			hand[e] = pile[next++]; // 山札の次の場所を手札にコピー
		}
		// 手札を並べ替える（バブルソート）
		for (int i = 0; i < hand.length; i++) { // 最小の手札（左端）から順に確定させる
			for (int j = hand.length - 1; j > i; j--) { // 大きい手札（右端）から比較を開始
				if (hand[j - 1] > hand[j]) { // 左側のカードが小さい場合
					// カードを入れ替え
					int tmp = hand[i];
					hand[i] = hand[j];
					hand[j] = tmp;
				}
			}
		}

		// 交換後の手札を表示
		dispHand(hand);
		
		// 役の表示
		System.out.println(Checker.checkHand(hand) + "です。");
		System.out.println(">>> Java Poker  END  <<<");
	}

	// ゲームの初期化
	private static void init() {
		// トランプの表面を初期化
		for (int i = 0; i < num.length; i++) { // A,2,3,...,Q,Kの順で繰り返す
			for (int j = 0; j < suit.length; j++) { // ♠,♡,♢,♣の順で繰り返す
				card[i * suit.length + j] = suit[j] + num[i]; // 例）card[13] = card[3 * 4 + 1] = "♡ 4"
			}
		}
	}

	// 手札の交換
	private static int[] exchangeHand(Scanner in) {
		int change = 0;
		while (true) {
			System.out.print("何枚換えますか？（0-" + HAND_MAX + "）>");
			change = in.nextInt();
			if (0 <= change && change <= HAND_MAX) { // 0枚から5枚を選択すると抜けられる
				break;
			}
		}

		int[] ex = new int[change];
		for (int i = 0; i < ex.length; i++) {
			while (true) {
				System.out.print((i + 1) + "枚目？(1-" + HAND_MAX + ")>"); // 配列exは0番目から始まる
				ex[i] = in.nextInt() - 1; // 手札は0番目から始まる
				boolean result = true; // デフォルトで正常
				// 選択できる番号以外の場合、抜けられない
				if (ex[i] < 0 || HAND_MAX - 1 < ex[i]) { // 1番から5番（0から4）を選択していない
					result = false;
				}
				for (int j = 0; j < i; j++) { // 前に選択した番号と同じ
					if (ex[i] == ex[j]) {
						result = false;
					}
				}
				if (result) { // すべて条件をクリアしていれば、次の選択ができる
					break;
				}
			}
		}

		return ex;
	}

	// 手札の表示
	private static void dispHand(int[] hand) {
		for (int h : hand) {
			System.out.print("[" + card[h] + "]");
		}
		System.out.println();
		for (int i = 0; i < HAND_MAX; i++) {
			System.out.print("  " + (i + 1) + "  ");
		}
		System.out.println();
	}

	// 実験用ユーティリティ
	public static void main(String[] args) {
		exec(new Scanner(System.in));
	}
}
