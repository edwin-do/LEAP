package gui;

import java.util.ArrayList;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import cards.Card;

public class GameState {
	boolean win_state = false;
	int player_points;
	int dealer_points;
	int balance = 100;
	int bet;
	
	public GameState(){	
	}
	
	public boolean checkState() {
		//false -lose
		//true - win
		if (player_points > 21) {
			return false;
		}
		else if (dealer_points > 21) {
			return true;
		}
		else if (dealer_points > player_points) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean checkBust() {
		//true - bust
		//false - no bust
		if (player_points > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkBet() {
		if (this.bet > this.balance) {
			return false;
		}
		else if (this.bet == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void get_player_points(ArrayList<Card> d) {
		int points = 0;
		for (Card c: d) {
			points += c.get_rank();
		}
		this.player_points = points;
	}
	
	public void get_dealer_points(ArrayList<Card> d) {
		int points = 0;
		for (Card c: d) {
			points += c.get_rank();
		}
		this.dealer_points = points;
	}
	
	public void display_win(MessageBox m, Shell s) {
		balance += (bet*2);
		m.setMessage("You win");
		m.open();
	}
	
	public void display_lose(MessageBox m, Shell s) {
		m.setMessage("You lose");
		m.open();
	}
}
