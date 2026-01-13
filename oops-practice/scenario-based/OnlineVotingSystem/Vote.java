package OnlineVotingSystem;
//vote class
public class Vote {
	//attributes
	private int voterId;
	private int candidateId;
	//constructor
	public Vote(int voterId,int candidateId) {
		this.voterId=voterId;
		this.candidateId=candidateId;
	}
	//getters
	public int getVoterId() {
		return voterId;
	}
	public int getCandidateId() {
		return candidateId;
	}

}
