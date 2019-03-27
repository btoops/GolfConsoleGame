/**
 * Brandon Toops, Patrick Phillips
 * btoops       , pphill10
 * Project 02
 * MW 2:00 pm - 3:15 pm
 * 
 * Oct 10, 2017
 */
import java.util.Scanner;

public class MainMethod {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Course[] c = {new Course("Genesee Valley Park North Course"), new Course("The Old Course at St. Andrews")};
		System.out.print("Enter the number of players: ");
		System.out.println();
		int numPlayers = sc.nextInt();
		Player[] p = new Player[numPlayers];
		Game g = new Game(p, c);
		g.play();




	}

}
