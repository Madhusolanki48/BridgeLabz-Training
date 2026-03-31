package OnlineVotingSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineVotingSystem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//lists
		ArrayList<Voter> voterList=new ArrayList<>();
		ArrayList<Candidate> candidateList=new ArrayList<>();
		ArrayList<Vote> voteList=new ArrayList<>();
		//abstraction
		ElectionService service=new OnlineElectionService();
		System.out.println("-------  Welcome to Online Voting System  -------");
		while(true) {
			System.out.println("\n-----------------  Home Page  ----------------");
			System.out.println("1. Voter Registration");
			System.out.println("2. Add Candidate");
			System.out.println("3. View Candidates");
			System.out.println("4. Caste Vote");
			System.out.println("5. Result Declaration");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			int choice =sc.nextInt();
			if(choice==0) {
				System.out.println("---------  THANK YOU for Voting!  ---------");
				break;
			}
			switch(choice) {
			//CRUD Operations
			case 1:  //create -voter registration
				System.out.println("\nEnter Voter ID: ");
				int voterId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Voter Name: ");
				String voterName=sc.nextLine();
				System.out.println("Enter Voter Contact No.:");
				String voterPhone=sc.nextLine();
				Voter voter = new Voter(voterId, voterName, voterPhone, false);
				voterList.add(voter);
				System.out.println("Voter Registered Successfully!");
				break;
				
			case 2:  //create - candidate management
				System.out.print("\nEnter Candidate Id: ");
				int cid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Candidate Name: ");
				String cname = sc.nextLine();
				System.out.print("Enter Party Name: ");
				String party = sc.nextLine();
				Candidate candidate = new Candidate(cid, cname, party);
				candidateList.add(candidate);
				System.out.println("Candidate Added Successfully!");
				break;
				
			case 3:   //read candidates
				System.out.println("\n----- Candidate List -----");
				if (candidateList.size() == 0) {
					System.out.println("No candidates added yet!");
				} else {
					for (Candidate c : candidateList)
						System.out.println(c);
				}
				break;

			//vote Casting
			case 4:
				if (voterList.size() == 0 || candidateList.size() == 0) {
					System.out.println("\nPlease register voters and add candidates first!");
					break;
				}
				System.out.print("\nEnter Voter Id: ");
				int vId = sc.nextInt();
				Voter selectedVoter = null;
				for (Voter v : voterList) {
					if (v.getId() == vId) {
						selectedVoter = v;
						break;
					}
				}

				if (selectedVoter == null) {
					System.out.println("Invalid Voter Id!");
					break;
				}

				System.out.println("\n----- Candidates -----");
				for (Candidate c : candidateList)
					System.out.println(c);

				System.out.print("\nEnter Candidate Id to Vote: ");
				int voteCid = sc.nextInt();
				Candidate selectedCandidate = null;
				for (Candidate c : candidateList) {
					if (c.getId() == voteCid) {
						selectedCandidate = c;
						break;
					}
				}

				if (selectedCandidate == null) {
					System.out.println("Invalid Candidate Id!");
					break;
				}
				try {
					service.castVote(selectedVoter, selectedCandidate, voteList);
					System.out.println("Vote Cast Successfully!");
				} catch (DuplicateVoteException e) {
					System.out.println("Error: " + e.getMessage());
				}

				break;

			//result declaration
			case 5:
				service.declareResult(candidateList, voteList);
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
		
	}

}
