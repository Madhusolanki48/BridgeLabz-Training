package FileBackupScheduler;
import java.util.*;

//service class handling backup logic
public class BackupScheduler {
    PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();
    //method to add backup task
    public void scheduleBackup(String filePath, int priority)
            throws InvalidBackupPathException {

        if (filePath == null || filePath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }

        backupQueue.add(new BackupTask(filePath, priority));

        System.out.println("\nBackup Scheduled Successfully!");
        System.out.println("--------------------------------");
        System.out.println("Path     : " + filePath);
        System.out.println("Priority : " + priority);
        System.out.println("--------------------------------");
    }

    //method to execute backup
    public void executeBackup() {
        if (backupQueue.isEmpty()) {
            System.out.println("No backup tasks available!");
            return;
        }
        BackupTask task = backupQueue.poll();
        System.out.println("Executing -> " + task);
    }

    //method to show pending backups
    public void showPendingBackups() {
        if (backupQueue.isEmpty()) {
            System.out.println("No pending backups!");
            return;
        }

        System.out.println("\n----- Pending Backup Tasks -----");
        for (BackupTask task : backupQueue) {
            System.out.println(task);
        }
        System.out.println("--------------------------------");
    }
}
