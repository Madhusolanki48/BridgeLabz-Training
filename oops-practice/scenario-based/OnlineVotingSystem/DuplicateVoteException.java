package OnlineVotingSystem;
//custom exception
public class DuplicateVoteException extends Exception{
	public DuplicateVoteException(String message) {
		super(message);
	}

}
