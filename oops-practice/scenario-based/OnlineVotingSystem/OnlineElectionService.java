package OnlineVotingSystem;
import java.util.ArrayList;

//service class
public class OnlineElectionService extends ElectionService {
	//vote casting method
	@Override
	public void castVote(Voter voter, Candidate candidate, ArrayList<Vote> voteList)
			throws DuplicateVoteException {
		//checking duplicate vote
		if (voter.hasVoted()) {
			throw new DuplicateVoteException("Duplicate vote detected! Voter already voted.");
		}
		//store vote
		voteList.add(new Vote(voter.getId(), candidate.getId()));
		//set voted true
		voter.setVoted(true);
	}
	//result declaration method
	public void declareResult(ArrayList<Candidate> candidates, ArrayList<Vote> voteList) {
		System.out.println("\n----- Result Declaration -----");

		if (voteList.size() == 0) {
			System.out.println("No votes casted yet!");
			return;
		}
		Candidate winner = null;
		int maxVotes = 0;
		//count votes for each candidate
		for (Candidate c : candidates) {
			int count = 0;
			for (Vote v : voteList) {
				if (v.getCandidateId() == c.getId()) {
					count++;
				}
			}
			System.out.println(c.getName() + " (" + c.getParty() + ") : " + count + " votes");
			//check winner
			if (count > maxVotes) {
				maxVotes = count;
				winner = c;
			}
		}
		//print winner
		if (winner != null) {
			System.out.println("\nWinner is: " + winner.getName() + " (" + winner.getParty() + ")");
			System.out.println("Total Votes: " + maxVotes);
		}
	}
}
