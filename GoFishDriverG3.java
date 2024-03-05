import java.util.ArrayList;
import java.util.Scanner;

/* Author: Christian Jobe, Caleb Patterson-Szczawinski, and Eric Mendoza Gallardo
 * Project: Go Fish 2
 * Due Date: 11/10/22
 * Description: this program uses classes and methods to create a working card game, go fish
 * This is Group 3's project
 */

public class GoFishDriverG3
{
	static Scanner input = new Scanner ( System.in );

	public static void main( String[ ] args )
	{
		Deck deckOfCard = new Deck ( 52 );
		Hand hand1 = new Hand ( );
		Hand hand2 = new Hand ( );
		int score1 = 0, score2 = 0;
		int player = 1;

		deckOfCard.shuffle ( );// Shuffles the deck
		deckOfCard.dealCards ( 7, hand1, hand2 );

		while ( score1 + score2 < 13 )
		{
			System.out.println ( "PLAYER " + player );
			System.out.println ( "Hand:" );
			if ( player == 1 )
			{
				score1 = playerTurn ( hand1, hand2, score1, deckOfCard );
			}
			else
			{
				score2 = playerTurn ( hand2, hand1, score2, deckOfCard );
			}
			player = player % 2 + 1;
		}
		gameOverCheck ( score1, score2 );

	} // End of main Method

	public static int playerTurn( Hand playerHand, Hand oppHand, int score, Deck deckOfCard )
	{
		boolean wish = true;
		while ( wish == true )
		{
			wish = false;
			printHand ( playerHand );
			System.out.println ( "What card would you like?" );
			int cardChoice = input.nextInt ( );

			wish = playerHand.gotWish ( oppHand, cardChoice );
			if ( wish == false )
			{
				Card card = deckOfCard.drawCard ( );
				System.out.println ( "You drew a: " );
				printCard ( card );
				playerHand.addCard ( card );

				if ( card.compareTo ( cardChoice ) == 0 )
				{
					wish = true;
				}
				cardChoice = card.getRank ( );
			}

			if ( playerHand.checkBook ( cardChoice ) == true )
			{
				score++; 
				playerHand.popCard ( null );
			}
		}

		return score;
	}

	/***********************
	 * printCard outputs the rank and suit of the card
	 * 
	 * parameters is taking in another card object to print
	 * 
	 * returns nothing
	 * 
	 ***********************/
	public static void printCard( Card card )
	{
		System.out.print ( card.getRankName ( ) + " of " + card.getSuitName ( ) );
		System.out.println ( );
	}// End of printCard Method

	public static void printHand( Hand hand )
	{
		ArrayList<Card> playerHand = new ArrayList<Card> ( );
		playerHand = hand.getHand ( );
		for ( int i = 0; i < playerHand.size ( ); i++ )
		{
			printCard ( playerHand.get ( i ) );
		}
	}

	public static void gameOverCheck( int score1, int score2 )
	{
		if ( score1 > score2 )
		{
			System.out.println ( "Player 1 is the Winner!" );
		}
		else
		{
			System.out.println ( "Player 2 is the Winner!" );
		}

	}

}