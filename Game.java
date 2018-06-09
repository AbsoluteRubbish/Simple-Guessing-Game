import util.KeyboardReader;
import java.util.*;

public class Game
{
	private Random r = new Random();	
	private int range;
	private static int answer;
	private static char level;
	
	//empty constructor
	public Game () {}
	
	//constructor with char
	//switch difficulty levels 
	public Game(char level)
	 {
		switch (level)
		{
			default:
				System.out.println("Obviously your intelligence is not high\n"
						+ "So we are going with Beginner level\n"
						+ "For your sake as well as mine...");
			case 'b':
			case 'B':
				range = 10;
				break;
			case 'I':
			case 'i':
				range = 100;
				break;
			case 'A':
			case 'a':
				range = 1000;
				break;
		} 
		answer = r.nextInt(range) + 1;
	 }
	
	
	// play() answer prompts 
	public void play()
	{
		int guess;
		guess = KeyboardReader.getPromptedInt("Enter a number 1 - " + range + ": ");
		
		if (guess < range || guess > range)
		{
			System.out.println("Are you illiterate and innumeratc?\n I thought you could at least read numbers...");
			System.out.println("The answer was: " + answer);
		}
		
		else if (guess < answer) 
		{
			System.out.println("Too low");
			System.out.println("The answer was: " + answer);
		}
		else if (guess > answer)
		{
			System.out.println("Too high");
			System.out.println("The answer was: " + answer);
		}
		else  //(guess == answer)
		{
			System.out.println("Correct!");
		}
		
	}
	
	//pick level
	public static void main(String[] args)
	{
		level = KeyboardReader.getPromptedChar(
				"What difficulty level? \n"
				+ " Type B for Beginner(1-10)\n"
				+ " Type I for Intermediate(1-100)\n"
				+ " Type A for Advance(1-1000): ");
		new Game(level).play();
			
	}
	
}