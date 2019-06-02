package gui;

import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import cards.Card;
import cards.Deck;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Spinner;

public class Blackjack {

	protected Shell shell;
	
	private static int balance = 100;
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static ArrayList<Card> dealerCards = new ArrayList<Card>();

	
	public static Label lblPcard1;
	public static Label lblPcard2;
	public static Label lblPcard3;
	public static Label lblPcard4;
	public static Label lblPcard5;
	
	public static Label lblDcard1;
	public static Label lblDcard2;
	public static Label lblDcard3;
	public static Label lblDcard4;
	public static Label lblDcard5;
	
	public static Label lblPpoints;
	public static Label lblDpoints;
	
	public static Deck current_deck = new Deck();
	
	private static int player_points;
	private static int dealer_points;
	private Button btnBet;
	private Label lblBalance;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Blackjack window = new Blackjack();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private static void play() {
		current_deck.shuffle();
		deal("p",2);
		deal("d",1);
		displayCard(lblPcard1,playerCards.get(0).img);
		displayCard(lblPcard2,playerCards.get(1).img);
		displayCard(lblDcard1,dealerCards.get(0).img);
		lblDcard2.setImage(SWTResourceManager.getImage(Blackjack.class, "/img/" + "back_card.png"));
		get_player_points();
		get_dealer_points();
	}
	
	private static void deal(String user, int num) {
		if (user.equals("p")) {
			for (int i = 0; i < num; i++) {
				playerCards.add(current_deck.deal());
			}
		}
		else {
			dealerCards.add(current_deck.deal());
		}	
	}
	
	private static void displayCard(Label lb, Image i) {
		lb.setImage(i);
	}
	
	private static int get_player_points() {
		player_points = 0;
		for (Card c: playerCards) {
			player_points += c.get_rank();
		}
		lblPpoints.setText("Your Points:" + String.valueOf(player_points));
		return player_points;
	}
	
	private static int get_dealer_points() {
		dealer_points = 0;
		for (Card c: dealerCards) {
			dealer_points += c.get_rank();
		}
		lblDpoints.setText("Dealer Points:" + String.valueOf(dealer_points));
		return dealer_points;
	}
	
	private static boolean checkBust(int points) {
		if (points > 21) {
			return true;	
		}
		else {
			return false;
		}
		
	}
	
	private static boolean checkState() {
		//false -lose
		//true - win
		if (checkBust(get_player_points())) {
			return false;
		}
		else if (checkBust(get_dealer_points())) {
			return true;
		}
		else if (get_dealer_points() > get_player_points()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private static void hit(int extra) {
		if (extra == 0) {
			deal("p",1);
			displayCard(lblPcard3, playerCards.get(2).img);
			get_player_points();	
		}
		else if (extra == 1) {
			deal("p",1);
			displayCard(lblPcard4, playerCards.get(3).img);
			get_player_points();
		}
	}
	
	private static void hit_dealer(int num) {
		if (num == 0) {
			deal("d",1);
			displayCard(lblDcard2,dealerCards.get(1).img);
			get_dealer_points();
		}
		else if(num == 1) {
			deal("d",1);
			displayCard(lblDcard3,dealerCards.get(2).img);
			get_dealer_points();
		}
		else {
			deal("d",1);
			displayCard(lblDcard3,dealerCards.get(3).img);
			get_dealer_points();
		}
		
	}
	
	private static void display_win(MessageBox m, Shell s) {
		m.setMessage("You win");
		m.open();
	}
	
	private static void display_lose(MessageBox m, Shell s) {
		m.setMessage("You lose");
		m.open();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(797, 568);
		shell.setText("Blackjack");
		
		lblPcard1 = new Label(shell, SWT.NONE);
		lblPcard1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPcard1.setBounds(42, 63, 111, 182);
		
		lblPcard2 = new Label(shell, SWT.NONE);
		lblPcard2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPcard2.setBounds(159, 63, 111, 182);
		
		lblPcard3 = new Label(shell, SWT.NONE);
		lblPcard3.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPcard3.setBounds(276, 63, 111, 183);
		
		lblPcard4 = new Label(shell, SWT.NONE);
		lblPcard4.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPcard4.setBounds(393, 63, 111, 183);
		
		lblDcard1 = new Label(shell, SWT.NONE);
		lblDcard1.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDcard1.setBounds(42, 303, 111, 183);
		
		lblDcard2 = new Label(shell, SWT.NONE);
		lblDcard2.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDcard2.setBounds(159, 303, 111, 183);
		
		lblDcard3 = new Label(shell, SWT.NONE);
		lblDcard3.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDcard3.setBounds(276, 303, 111, 183);
		
		lblDcard4 = new Label(shell, SWT.NONE);
		lblDcard4.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDcard4.setBounds(393, 303, 111, 183);
		
		lblPpoints = new Label(shell, SWT.NONE);
		lblPpoints.setBounds(337, 32, 167, 25);
		lblPpoints.setText("Your Points:");
		
		lblDpoints = new Label(shell, SWT.NONE);
		lblDpoints.setText("Dealer Points:");
		lblDpoints.setBounds(337, 272, 167, 25);
		
		Button btnHit = new Button(shell, SWT.NONE);
		btnHit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int extra = 0;
				boolean hit = false;
				MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES| SWT.NO);
				MessageBox result = new MessageBox(shell);
				dialog.setMessage("Do you want another card?");
				hit = (SWT.YES == dialog.open());
				while (hit) {
					dialog.setMessage("Do you want another card?");
					hit(extra);
					extra+=1;
					if (checkBust(get_player_points())) {
						display_lose(result,shell);
						hit = false;
					}
					else {
						hit = (SWT.YES == dialog.open());
					}
				}
			}
		});
		btnHit.setBounds(584, 106, 105, 35);
		btnHit.setText("Hit");
		
		Button btnStay = new Button(shell, SWT.NONE);
		btnStay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int num = 0;
				MessageBox dialog = new MessageBox(shell);
				while (get_dealer_points() <= get_player_points()) {
					hit_dealer(num);
					num++;
				}
				if (checkState() == true) {
					display_win(dialog,shell);
				}
				else {
					display_lose(dialog,shell);
				}
			}
		});
		btnStay.setText("Stay");
		btnStay.setBounds(584, 167, 105, 35);
		
		lblBalance = new Label(shell, SWT.NONE);
		lblBalance.setAlignment(SWT.CENTER);
		lblBalance.setBounds(575, 32, 132, 25);
		lblBalance.setText("Balance: 100");
		
		Spinner spinnerBet = new Spinner(shell, SWT.BORDER);
		spinnerBet.setBounds(584, 311, 72, 31);
		
		btnBet = new Button(shell, SWT.NONE);
		btnBet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				balance -= spinnerBet.getSelection();
				lblBalance.setText("Bet: " + String.valueOf(balance));
				play();
			}
		});
		btnBet.setBounds(584, 231, 105, 35);
		btnBet.setText("Bet");

		

	}
}
