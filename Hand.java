import java.util.ArrayList;
import java.util.Scanner;

public class Hand
{
	ArrayList<Card> hand = new ArrayList<Card> ( );
	static Scanner input;

	public Hand()
	{
		input = new Scanner ( System.in );
	}

	public void addHand( Hand otherHand )
	{
		hand.addAll ( otherHand.hand );
		otherHand.hand.removeAll ( hand );

	}

	public ArrayList<Card> getHand( )
	{
		return hand;
	}

	public void addCard( Card card )
	{
		hand.add ( card );
	}

	public void popCard( Card card )
	{
		hand.remove ( card );
	}

	public boolean isEmpty( Deck Deck )
	{
		boolean returnVal = true;
		if ( this.hand.isEmpty ( ) ) // if the hand has nothing in it
		{
			returnVal = false;

		}
		else
		{

		}
		return returnVal;
	}

	public boolean gotWish( Hand otherHand, int wish )
	{
		Card passCard;
		boolean found = false;

		for ( int i = 0; i < otherHand.hand.size ( ); i++ )
		{
			if ( otherHand.hand.get ( i ).compareTo ( wish ) == 0 )
			{
				found = true;
				passCard = otherHand.hand.get ( i );
				hand.add ( passCard );
				otherHand.hand.remove ( passCard );
			}
		}
		if ( found == false )
		{
			System.out.println ( "Go Fish!" );
		}

		// checkBook ( wish );// go to checkBook to see if there are all four cards needed for the set.
		return found;
	}

	public boolean checkBook( int num )
	{
		int match = 0;
		boolean returnVal = false;
		for ( int i = 0; i < this.hand.size ( ); i++ )
		{
			if ( this.hand.get ( i ).getRank ( ) == num )
			{
				match = match + 1;
			}
			if ( match == 4 )
			{
				returnVal = true;
			}
		}
		return returnVal;
		// Pseudo Code for checkBook
		// int bookCount = 0;//the number of cards from each set of 4 (ace diamond, ace heart, ace spade, ace club)
		// for (int j = 0; j <= this.hand.size ( ); j++ ) //looping through every instance in your hand to see if there
		// are all four cards in a rank.
		// {
		// for ( int i = 0; i < 4; i++ )//it might need different variables, but the idea is that it will add a variable
		// every time the wish is equal to a card in the hand
		// {
		// Hand Card[wish] = rankF;// making sure that the card becomes an int so that you can compare the card rank to
		// the int wish.
		//
		//
		// if(bookCount == this.hand.indexOf (wish) )// if the card is equal to the rank in the hand it will add one to
		// bookcount
		// {
		// bookCount = bookCount + 1;
		// rankF = Hand Card[wish];// deletes the card that it has already checked from the hand
		// }
		// if (bookCount == 4)//if there are all four of the card in the players hand it will return true and all four of
		// the cards will be deleted, and we need to store some form of count for points
		// {
		// //delete the 4 matching cards
		// return true;
		// }
		// }
	}

}
