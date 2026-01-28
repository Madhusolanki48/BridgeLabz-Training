package FileBackupScheduler;

//represents a backup task
public class BackupTask implements Comparable<BackupTask> {
    //attributes
    String filePath;
    int priority;

    //constructor
    BackupTask(String filePath, int priority) {
        this.filePath = filePath;
        this.priority = priority;
    }
    //higher priority executes first
    @Override
    public int compareTo(BackupTask other) {
        return this.priority - other.priority; 
    }

    @Override
    public String toString() {
        return "Backup: " + filePath + " | Priority: " + priority;
    }
}
