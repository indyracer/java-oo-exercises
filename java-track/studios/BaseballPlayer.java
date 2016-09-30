
public class BaseballPlayer {
	//Fields
	private String name;
	private int playerNum;
	private String hitsFrom;
	
	/*
	 * record hits
	 * record RBIs
	 * record number of games played
	 * update season to date hits
	 * update season to date RBIs
	 */
	private int hits;
	private int rbi;
	private int gamesPlayed;
	private int stdHits;
	private int stdRbi;
	
	

	public BaseballPlayer(String name, int playerNum, String hitsFrom, int stdHits, int stdRbi, int gamesPlayed) {
		super();
		this.name = name;
		this.playerNum = playerNum;
		this.hitsFrom = hitsFrom;
		this.stdHits = stdHits;
		this.stdRbi = stdRbi;
		this.gamesPlayed = gamesPlayed;
	}



	public String getName() {
		return name;
	}



	public int getPlayerNum() {
		return playerNum;
	}
	
	public int getStdHits(){
		return stdHits;
	}
	
	public int getStdRbi(){
		return stdRbi;
	}
	
	
	public int getGamesPlayed(){
		return gamesPlayed;
	}
	
	
	public void updateHits(int gameHits){
		stdHits = stdHits + gameHits;
	}
	
	public void updateRbi(int gameRbi){
		stdRbi = stdRbi + gameRbi;
	}
	
	public void updateGamesPlayed(int playedGame){
		gamesPlayed = gamesPlayed + playedGame;
	}
	

	



	@Override
	public String toString() {
		return "BaseballPlayer [name=" + name + ", playerNum=" + playerNum + ", hitsFrom=" + hitsFrom + ", gamesPlayed="
				+ gamesPlayed + ", stdHits=" + stdHits + ", stdRbi=" + stdRbi + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballPlayer bob = new BaseballPlayer("Bob", 9, "Right", 10, 12, 2);
		System.out.println(bob);
		
		bob.updateGamesPlayed(1);
		bob.updateHits(2);
		bob.updateRbi(3);
		
		System.out.println(bob);
		
	}

}
