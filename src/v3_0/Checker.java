package v3_0;

public class Checker {
	public static String checkHand(int[] hand) {
		if ((hand[0] / 4 == hand[1] / 4 && hand[1] / 4 == hand[2] / 4 && hand[2] / 4 != hand[3] / 4
				&& hand[3] / 4 == hand[4] / 4) || 
			(hand[0] / 4 == hand[1] / 4 && hand[1] / 4 != hand[2] / 4 && hand[2] / 4 == hand[3] / 4
				&& hand[3] / 4 == hand[4] / 4)) { // フルハウスかどうか
			return "フルハウス";
		} else if (hand[0] % 4 == hand[1] % 4 && hand[1] % 4 == hand[2] % 4 && hand[2] % 4 == hand[3] % 4
				&& hand[3] % 4 == hand[4] % 4) { // フラッシュかどうか
			return "フラッシュ";
		} else if (hand[0] / 4 + 1 == hand[1] / 4 && hand[1] / 4 + 1 == hand[2] / 4 && hand[2] / 4 + 1 == hand[3] / 4
				&& hand[3] / 4 + 1 == hand[4] / 4) { // ストレートかどうか
			return "ストレート";
		} else {
			return "ブタ";
		}
	}

	public static void main(String[] args) {
		int[] testData = { 1, 2, 3, 6, 7 }; // フルハウス

		System.out.println(checkHand(testData) + "です");
	}
}
