package OnlineVotingSystem;
import java.util.ArrayList;
//abstract class
public abstract class ElectionService {
	//abstract methods
	public abstract void castVote(Voter voter,Candidate candidate,ArrayList<Vote> voteList)
		throws DuplicateVoteException;
		public abstract void declareResult(ArrayList<Candidate> candidateList,ArrayList<Vote> voteList);

}
