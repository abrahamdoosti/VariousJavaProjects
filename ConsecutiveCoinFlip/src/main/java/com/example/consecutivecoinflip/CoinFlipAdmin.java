package com.example.consecutivecoinflip;

import java.util.Random;

import com.example.consecutivecoinflip.enums.HeadTail;
import com.example.consecutivecoinflip.enums.Winner;

public class CoinFlipAdmin {
	/**
	 * Source: instagram @mathletters 
	 * If you flip a coin two times there are four
	 * possibilities (HH,HT,TT,TH) There are two playing betting by picking one of
	 * the four outcomes, and you flip the coin until one of the players choice
	 * occur in a raw. The question is does your choice from the above four matter?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int p1Wins = 0;
		int p2Wins = 0;
		// out of the 16 possible combinations these are the unique ones.
		String[][] plays = { { "TT", "TH" }, { "TT", "HT" }, { "TT", "HH" }, { "TH", "HT" }, { "TH", "HH" },
				{ "HT", "HH" }, { "HH", "HT" } };
		for (int j = 0; j < plays.length; j++) {
			for (int i = 0; i < 100; i++) {
				Winner winner = playGame(plays[j][0], plays[j][1]);
				if (winner == Winner.P1) {
					p1Wins++;
				} else if (winner == Winner.P2) {
					p2Wins++;
				}
			}
			System.out.println("p1 " + plays[j][0] + " wins=" + p1Wins);
			System.out.println("p2 " + plays[j][1] + " wins=" + p2Wins);
			System.out.println();
			p1Wins = 0;
			p2Wins = 0;

		}

	}

	public static Winner playGame(String p1, String p2) {
		StringBuilder sb = new StringBuilder();

		while (true) {
			sb.append(flipCoin());
			Winner winner = checkWinner(p1, p2, sb);
			if (winner == Winner.P1) {
				// System.out.println("p1 "+p1+" won!");
				return Winner.P1;
			} else if (winner == Winner.P2) {
				// System.out.println("p2 "+p2+ " won!");
				return Winner.P2;
			}

		}
	}

	/**
	 * returns p1 if p1 wins, p2 if p2 wins, NoWinner if none of them have won yet.
	 * 
	 * @param p1
	 * @param p2
	 * @param sb
	 */
	private static Winner checkWinner(String p1, String p2, StringBuilder sb) {
		// TODO Auto-generated method stub
		if (sb.length() < 2) {
			return Winner.No_WINNER;
		}
		if (sb.charAt(sb.length() - 2) == p1.charAt(p1.length() - 2)
				&& sb.charAt(sb.length() - 1) == p1.charAt(p1.length() - 1)) {
			return Winner.P1;
		} else if (sb.charAt(sb.length() - 2) == p2.charAt(p2.length() - 2)
				&& sb.charAt(sb.length() - 1) == p2.charAt(p2.length() - 1)) {
			return Winner.P2;
		} else {
			return Winner.No_WINNER;
		}

	}

	public static String flipCoin() {
		Random r = new Random();
		int rand = r.nextInt(2);
		return rand == 0 ? HeadTail.H.toString() : HeadTail.T.toString();
	}

}
