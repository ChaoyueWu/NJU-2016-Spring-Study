import java.util.ArrayList;

/**
 * 
 * @author zicong
 * 
 * Record who goes first(man/computer) and each step of a man
 *
 */
public class GameRecord {
	// start index (first player will be human or computer)
    // i = 0 or 1
	private int firstPlayer;
	// all steps of a player
	private ArrayList<Integer> steps = new ArrayList<Integer>();
	
	public GameRecord(int firstPlayer , ArrayList<Integer> steps){
		this.firstPlayer = firstPlayer;
		this.steps = steps;
	}

	public int getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(int firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public ArrayList<Integer> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Integer> steps) {
		this.steps = steps;
	}
	
	
}
