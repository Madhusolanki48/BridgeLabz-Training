package FileBackupScheduler;
import java.util.Scanner;

public class FileBackupSystem {
	public static void main(String[] args) {
		System.out.println("------------ File Backup Scheduler ---------");
		BackupScheduler scheduler = new BackupScheduler();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("What would you like to do ?");
			System.out.println("\n1. Schedule Backup");
			System.out.println("2. Execute Backup");
			System.out.println("3. Show Pending Backups");
			System.out.println("4. Exit");
			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
			case 1:   //schedule backup
				try {
					System.out.print("Enter File Path: ");
					String path = sc.nextLine();

					System.out.print("Enter Priority (1-High, 2-Medium, 3-Low): ");
					int priority = sc.nextInt();
					sc.nextLine();

					scheduler.scheduleBackup(path, priority);

				} catch (InvalidBackupPathException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:    //execute backup
				scheduler.executeBackup();
				break;

			case 3:   //show pending backups
				scheduler.showPendingBackups();
				break;

			case 4:
				System.out.println("Exiting Backup Scheduler.");
				System.out.println("Thank you for using File Backup Scheduler!");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 4);
	}
}
