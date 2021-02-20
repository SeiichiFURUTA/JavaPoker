package v3_0;

import java.util.Random;

public class Shuffler {
	public static int[] shuffle(int[] inData) {
		// 山札を初期化
		for (int i = 0; i < inData.length; i++) {
			inData[i] = i;
		}
		
		return defMethod(inData);
		//return fisherYates(inData);
	}
	
	private static int[] defMethod(int[] inData) {
		return inData;
	}
	
	// Riffle Shuffle：均等な２つの山にわけ、交互にカードを組み合わせる
	private static int[] riffle(int[] inData) {
		return inData;
	}
	
	// Cut Shuffle：ランダムな位置で山をわけ、上下を入れ替える
	private static int[] cut(int[] inData) {
		return inData;
	}
	
	// Pile Shuffle：均等な複数の山にわけ、それらを一つにまとめる
	private static int[] pile(int[] inData) {
		return inData;
	}
	
	private static int[] fisherYates(int[] inData) {
		/* Fisher Yates の乱数アルゴリズム */
		// 配列の並べ替え
		Random rand = new Random();
		for (int i = inData.length - 1; i > 0; i--) {
			// 取り替える位置（target）をランダムに選択
			int target = rand.nextInt(i); // 0からiまでの乱数を生成
			// targetと位置を取り替える
			int tmp = inData[i];
			inData[i] = inData[target];
			inData[target] = tmp;
		}
		
		return inData;
	}
	
	public static void main(String[] args) {
		int[] testData = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int i : testData) {
			System.out.print(" " +i);
		}
		System.out.println();
		
		testData = shuffle(testData);
		
		for (int i : testData) {
			System.out.print(" " +i);
		}
		System.out.println();
	}
}
