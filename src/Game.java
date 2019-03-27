import java.util.Scanner;

public class Game {

	private Player[] p;
	private Course[] c;

	public Game(Player[] p, Course[] c) {
		this.p = p;
		this.c = c;
	}

	public void play() {
		Scanner sc = new Scanner(System.in);
		boolean isOnGreen = false;
		int course;
		int club;
		int power;

		System.out.println("Welcome to TTY Golf!\n");
		System.out.println("Please select a course:");
		System.out.println("1. Genesee Valley Park North Course");
		System.out.println("2. The Old Course at St. Andrews");
		System.out.print("Your choice [1-2]: ");
		course = sc.nextInt() - 1;

		for(int i = 0; i < p.length; i++) {
			p[i] = new Player(c[course].getHole(0), c[course].getHole(0).getDistance());
		}

		System.out.println("You are playing " + c[course].getCourseName() + ".\n");
		int holeNum = 0;

		int length = c[course].getHLength();
		int playerNumber = 0;
		while(holeNum < length) {
			p[playerNumber].setHole(c[course].getHole(holeNum));
			p[playerNumber].setBallDistance(c[course].getHole(holeNum).getDistance());
			p[playerNumber].setShotsOnHole(0);
			System.out.println("You are at " + c[course].getHole(holeNum));
			while(!isOnGreen) {
				System.out.println("Player " + (playerNumber + 1) + "'s turn.");
				System.out.print("Choose your club [1-10]: " );
				club = sc.nextInt() - 1;
				System.out.print("Power [1-10]: ");
				power = sc.nextInt();
				int distanceHit = Club.nextDistance(p[playerNumber].getClub(club).getMeanDistance(), p[playerNumber].getClub(club).getStdDev(), power);
				System.out.println("You hit the ball " + distanceHit + " yards. Nice!");
				p[playerNumber].incrementShots();
				p[playerNumber].decreaseBallDistance(distanceHit);
				System.out.println();
				if(Math.abs(p[playerNumber].getBallDistance()) <= 1/3.) {
					System.out.println("It's in the hole!");
					break;
				}
				if(p[playerNumber].getBallDistance() <= 20 && p[playerNumber].getBallDistance() >= -20) {
					isOnGreen = true;
					if(p[playerNumber].getBallDistance() < 0) {
						p[playerNumber].setBallDistance(-p[playerNumber].getBallDistance());}
				}
				else {
					if(p[playerNumber].getBallDistance() < 0) {
						p[playerNumber].setBallDistance(-p[playerNumber].getBallDistance());
					}
					System.out.println("You are in the fairway.");
					System.out.println(p[playerNumber].printShotNumber(p[playerNumber].getShotsOnHole()) + p[playerNumber].getBallDistance() + " yards to the hole.");
				}
			}
			p[playerNumber].setBallDistance(p[playerNumber].getBallDistance()*3);
			while(isOnGreen) {
				System.out.println("You are on the green.");

				System.out.println(p[playerNumber].printShotNumber(p[playerNumber].getShotsOnHole()) + p[playerNumber].getBallDistance() + " feet to the hole.");
				System.out.print("Putt power [1-10]: ");
				power = sc.nextInt();
				p[playerNumber].incrementShots();
				int distanceHit = p[playerNumber].putt(power);
				System.out.println("Your putt went " + distanceHit + " feet.");
				p[playerNumber].decreaseBallDistance(distanceHit);
				if(Math.abs(p[playerNumber].getBallDistance()) <= 1) {
					isOnGreen = false;
					System.out.println("It's in the hole!");
					System.out.println();
				}
				else if (p[playerNumber].getBallDistance() < -1){
					System.out.println("You overshot the hole!");
					System.out.println();
					p[playerNumber].setBallDistance(-p[playerNumber].getBallDistance());
				}
				else
					System.out.println();
			}


			System.out.println("Shots: " + p[playerNumber].getShotsOnHole());
			if(p[playerNumber].getShotsOnHole() == 1) {
				System.out.println("You shot an ace! Nice hole-in-one!");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == -3 && c[course].getHole(holeNum).getPar() != 3) {
				System.out.println("You shot an albatross! Good Job!");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == -2) {
				System.out.println("You shot an eagle! Nice!");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == -1) {
				System.out.println("You shot a birdie!");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == 0) {
				System.out.println("You shot par.");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == 1) {
				System.out.println("You shot a bogey.");
			}
			if(p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar() == 2) {
				System.out.println("You shot a double bogey.");
			}
			p[playerNumber].setTotalScore((p[playerNumber].getTotalScore()) + (p[playerNumber].getShotsOnHole() - c[course].getHole(holeNum).getPar()));

			System.out.println("Total Score: " + p[playerNumber].getTotalScore());
			System.out.println();

			playerNumber++;
			if(playerNumber > p.length - 1) {
				playerNumber = 0;
				holeNum ++;
				if(holeNum != c[course].getHLength()) {
					System.out.println("Enter the number of holes you want to skip, 0 to continue, or -1 to exit");
					int continuePlay = sc.nextInt();
					if(continuePlay <= -1) {
						break;
					}
					else if(continuePlay == 0) {
						continue;
					}
					else {
						holeNum += continuePlay;
					}
					System.out.println();
				}
			}
		}

	}

}

