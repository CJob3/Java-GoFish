public class Card
{
	private int suit; // Suit of the card
	private int rank; // Value of the card
	final static String[ ] SUIT = { "Hearts", "Diamonds", "Clubs", "Spades" };
	final static String[ ] RANK = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	public Deck Deck;

	public Card() // Default Constructor
	{
		suit = 0;
		rank = 0;
	}

	public Card(int suite, int rank) // Second Constructor
	{
		super ( );
		this.suit = suite;
		this.rank = rank;
	}

	/***********************
	 * compareTo compares the rank of the first card to the second card and outputs the greater valued card
	 * 
	 * parameters is taking in another card object to print
	 * 
	 * returns returnValue letting us know if the card is greater, less than, or equal to the previous card
	 * 
	 ***********************
	 */
	public int compareTo( Card card2 )// Compares the values of two cards.
	{
		int returnValue;
		if ( this.rank < card2.rank )
		{
			returnValue = -1;
		}
		else if ( this.rank > card2.rank )
		{
			returnValue = 1;
		}
		else
		{
			returnValue = 0;
		}

		return returnValue;

	}

	public int compareTo( int wish )
	{
		int returnVal;
		if ( this.rank < wish )
		{
			returnVal = -1;
		}
		else if ( this.rank > wish )
		{
			returnVal = 1;
		}
		else
		{
			returnVal = 0;
		}
		return returnVal;
	}

	// Getters and Setters
	public int getSuit( )
	{
		return suit;
	}

	public String getSuitName( )
	{
		return SUIT[suit];
	}

	public void setSuit( int suit )
	{

		this.suit = suit;
	}

	public int getRank( )
	{
		return rank;
	}

	public String getRankName( )
	{
		return RANK[rank];
	}

	public void setRank( int rank )
	{
		this.rank = rank;
	}

	// @Override
	public String toString( )// outputs the organized deck of cards.
	{

		return "Card [suite = " + SUIT[suit] + ", rank = " + RANK[rank] + "]";
		// return Card[52];
	}

} // End of Card Class