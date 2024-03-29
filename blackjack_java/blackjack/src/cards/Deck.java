package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.SWTResourceManager;

import cards.Card.*;

public class Deck {
	public ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Card> dispose = new ArrayList<Card>();
	Random rand = new Random();
	
	public Deck() {
		String str_rank;
		for (Suits s : Suits.values()) {
			for (Ranks r: Ranks.values()) {
				int rank = r.ordinal() + 2;
				if (rank <= 10) {
					str_rank = String.valueOf(rank);
				}
				else {
					str_rank = r.toString();
				}
				String suit = s.toString().toLowerCase();
				Image img = SWTResourceManager.getImage(Deck.class, "/img/" + str_rank + "_of_" + suit + ".png");			
				Card tmp = new Card(r,s,resize(img,111,180));
				cards.add(tmp);
			}
		}
	}
	
	public void reset() {
		for (Card c : dispose) {
			cards.add(c);
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card deal() {
		Card tmp = cards.get(cards.size()-1);
		dispose.add(cards.remove(cards.size()-1));
		return tmp;	
	}
	
	public Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}

}
