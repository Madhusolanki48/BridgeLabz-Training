package OnlineVotingSystem;
//candidate class
public class Candidate {
	//attributes
	private int candidateId;
	private String candidateName;
	private String candidateParty;
	//constructor
	public Candidate(int candidateId,String candidateName,String candidateParty) {
		this.candidateId=candidateId;
		this.candidateName=candidateName;
		this.candidateParty=candidateParty;
	}
	//getters
	public int getId() {
		return candidateId;
	}
	public String getName() {
		return candidateName;
	}
	public String getParty() {
		return candidateParty;
	}
	
	public String toString() {
		return "Candidate Details [ Id: "+candidateId+" | Name: "+candidateName+" | Party: "+candidateParty+" ]";
	}

}
