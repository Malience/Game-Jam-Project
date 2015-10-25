package game;

import java.util.Random;

public class Food {

	private Random rand;
	private int taken = 0;
	private int[] plate = { 0, 0, 0, 0, 0, 0 }; // [sPizza,sCookie,sOrange,sFires,sIceCream,sSpecial]
	private int[] weights = { 0, 0, 0, 0, 0, 0 }; // [sPizza,sCookie,sOrange,sFires,sIceCream,sSpecial]
	private int carryCap = 0;

	public Food() {

	}

	public void action(char act, int station, int took) {
		taken = took;

		switch (station) {
		case 1:
			stationPizza(act);
			break;
		case 2:
			stationCookie(act);
			break;
		case 3:
			stationOrange(act);
			break;
		case 4:
			stationFries(act);
			break;
		case 5:
			stationIceCream(act);
			break;
		case 6:
			stationSpecial(act);
			break;
		default:
			break;
		}
	}

	private void stationPizza(char act) {
		// first food station (pizza)
		char play = act;

		// num of pizza out (start)
		rand = new Random(25);
		// % for checking
		Random rndcheck = new Random(11);

		// gen for # brought out
		int out = rand.nextInt();
		int chance = 0;

		// taken
		if (play == 't') {
			if (validCap(weights[0])) {
				out -= taken;
				plate[0] += taken;
			} else {
				tooMuch();
			}
		}

		// check (2 left)
		if (out <= 2) {
			chance = rndcheck.nextInt();

			if (chance >= 6) {
				if (chance <= 2) {
					out += 8;
				} else if (chance <= 4) {
					out += 16;
				} else if (chance <= 6) {
					out += 24;
				}
			}
		}

		// added (none left)
		if (out == 0) {
			out += 8;
		}

	} // end station 1

	private void stationCookie(char act) {
		// second food station (cookies)
		char play = act;

		// num of cookies
		rand = new Random(5);
		int out = rand.nextInt() + 36;

		// taken
		if (play == 't') {
			// if npc
			// Random takes = new Random(4);
			// out -= takes.nextInt() + 1;

			// if player
			if (validCap(weights[1])) {
				out -= taken;
				plate[1] += taken;
			} else {
				tooMuch();
			}
		}

		// added
		if (out == 0) {
			out += rand.nextInt() + 36;
		}
	} // end station 2

	private void stationOrange(char act) {
		// third food station (orange)
		char play = act;
		// num of oranges
		rand = new Random();
		int out = rand.nextInt(15) + 1;

		// taken
		if (play == 't') {
			if (validCap(weights[2])) {
				out -= taken;
				plate[2] += taken;
			} else {
				tooMuch();
			}
		}

		// added
		if (out == 1) {
			out = 15;
		}
	} // end station 3

	private void stationFries(char act) {
		// fourth food station (fries)
		char play = act;

		// num of fries (pack)
		rand = new Random();
		int out = rand.nextInt(10) + 1;

		Random rndcheck = new Random(11);
		int chance = 0;

		// taken
		if (play == 't') {
			if (validCap(weights[3])) {
				out -= taken;
				plate[3] += taken;
			} else {
				tooMuch();
			}
		}

		// check
		if (out <= 2) {
			chance = rndcheck.nextInt();

			if (chance >= 6) {
				if (chance <= 2) {
					out += 2;
				} else if (chance <= 4) {
					out += 4;
				} else if (chance <= 6) {
					out += 6;
				}
			}
		} // end check if
	} // end station 4

	private void stationIceCream(char act) {
		// five food station (ice cream)
		char play = act;
		// num of ice creams
		rand = new Random();
		int out = rand.nextInt(5) + 1;

		Random rndcheck = new Random(11);
		int chance = 0;

		// taken
		if (play == 't') {
			if (validCap(weights[4])) {
				out -= taken;
				plate[4] += taken;
			} else {
				tooMuch();
			}
		}

		// check
		if (out == 0) {
			chance = rndcheck.nextInt();

			if (chance >= 6) {
				if (chance <= 2) {
					out += 3;
				} else if (chance <= 4) {
					out += 4;
				} else if (chance <= 6) {
					out += 5;
				}
			}
		} // end check if
	}

	private void stationSpecial(char act) {
		// five food station (special)
		char play = act;
		// num of special
		rand = new Random();
		int out = rand.nextInt(5) + 1;

		Random rndcheck = new Random(11);
		int chance = 0;

		// taken
		if (play == 't') {
			if (validCap(weights[5])) {
				out -= taken;
				plate[4] += taken;
			} else {
				tooMuch();
			}
		}

		// check
		if (out == 0) {
			chance = rndcheck.nextInt();

			if (chance >= 6) {
				if (chance <= 2) {
					out += 3;
				} else if (chance <= 4) {
					out += 4;
				} else if (chance <= 6) {
					out += 5;
				}
			}
		} // end check if
	}

	public void clearPlate() {
		for (int i = 0; i < plate.length; i++) {
			plate[i] = 0;
		}

		carryCap = 0;
	}

	private boolean validCap(int weight) {
		if ((carryCap + weight) > 100) {
			return false;
		} else {
			carryCap += weight;
			return true;
		}
	}

	private void tooMuch() {
		// suspicion up
	}
}
