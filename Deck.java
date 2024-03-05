import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Deck
{
	private int deckLocation;
	Scanner input = new Scanner ( System.in );
	public Card[ ] deckArray;// Initializes deckArray

	public Deck() // Default Constructor - Entire Deck
	{
		deckArray = new Card[52];
		deckLocation = deckArray.length;
		int index = 0; // How many cards have been created
		for ( int i = 0; i < 4; i++ )// Loop through Suit
		{
			for ( int j = 1; j < 14; j++ )// Loop through Rank
			{
				deckArray[index] = new Card ( i, j );
				index++;
			}

		}
	}

	public Deck(int numCards) // Second Constructor - Hand
	{
		deckArray = new Card[numCards];
		int index = 0; // How many cards have been created
		for ( int i = 0; i < 4 && index < numCards; i++ )// Loop through Suit
		{
			for ( int j = 1; j < 14 && index < numCards; j++ )// Loop through Rank
			{
				deckArray[index] = new Card ( i, j );
				index++;
				// System.out.println ( index );
			}
		}
	}

	public Card[ ] getDeck( )
	{

		return deckArray;
	}

	public void setDeck( Card[ ] deck )
	{
		this.deckArray = deck;
	}

	@Override
	public String toString( )
	{
		String returnValue = "";
		for ( int i = 0; i < deckArray.length; i++ )
		{
			returnValue = returnValue + deckArray[i].toString ( );
			returnValue = returnValue + "\n";
		}
		return returnValue;
	}

	// public static void cardSearch( Card deckArray, String input )//Trying to find a location for a wanted card.
	// {
	//
	// System.out.println (" what card do you want to search for?");
	// String search = input;//???
	// for(int i = 0; i < 52; i++)
	// {
	// if(search == deckArray.getRankName())
	// {
	// System.out.println ("Location" + i);
	// }
	// }
	// }

	public void shuffle( )
	{

		Random random = new Random ( );
		for ( int i = 0; i < deckArray.length; i++ )
		{
			int mix = i + random.nextInt ( 52 - i );
			Card hold = deckArray[i];
			deckArray[i] = deckArray[mix];
			// deckArray[i] = hold;
			deckArray[mix] = hold;
		}

	}

	public void sortRank( )
	{
		int index = 0; // How many cards have been created
		for ( int j = 1; j < 14; j++ )// Loop through Rank

		{
			for ( int i = 0; i < 4; i++ )// Loop through Suit
			{
				deckArray[index] = new Card ( i, j );
				index++;
			}

		}
	}

	public int searchDeck( Card card )
	{
		int index = -1;
		for ( int i = 0; i < deckArray.length; i++ )
		{
			if ( deckArray[i].getRank ( ) == card.getRank ( ) && deckArray[i].getSuit ( ) == card.getSuit ( ) )
			{
				index = i;
			}

		}
		return index;
	}

	public Card returnCard( int index )
	{
		return deckArray[index];
	}

	public void dealCards( int num, Hand hand1, Hand hand2 )
	{

		deckLocation = deckArray.length - 1;

		for ( int i = num; i > 0; i-- )
		{

			hand1.addCard ( deckArray[deckLocation] );
			deckLocation--;
			hand2.addCard ( deckArray[deckLocation] );
			deckLocation--;

		}

	}

	public Card drawCard( )
	{
		Card card = deckArray[deckLocation];
		deckLocation--;
		return card;
	}

}