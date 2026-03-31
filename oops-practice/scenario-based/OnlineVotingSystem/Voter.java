package OnlineVotingSystem;
//voter class
public class Voter {
	//attributes
	private int voterId;
	private String voterName;
	private String voterPhone;
	private boolean hasVoted;
	//constructor
	public Voter(int voterId,String voterName,String voterPhone,boolean hasVoted) {
		this.voterId=voterId;
		this.voterName=voterName;
		this.voterPhone=voterPhone;
		this.hasVoted=false;
	}
	//getters
	public int getId() {
		return voterId;
	}
	public String getNam() {
		return voterName;
	}
	public String getPhone() {
		return voterPhone;
	}
	public boolean hasVoted() {
		return hasVoted;
	}
	//setter
	public void setVoted(boolean voted) {
		this.hasVoted = voted;
	}
	
	public String toString() {
		return " Voter Details [ Id: "+voterId+" | Name: "+voterName+" | Phone: "+voterPhone+" | Voted: "+hasVoted+" ]";
	}

}
