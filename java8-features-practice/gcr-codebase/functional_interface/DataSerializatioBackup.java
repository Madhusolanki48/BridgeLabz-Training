package functional_interface;

//marker interface
interface BackupSerializable {
}

//class marked for backup
class UserData implements BackupSerializable {
	String name = "Madhu";
	int id = 101;
}

//backup processor
class DataSerializationBackup {
	public static void main(String[] args) {
		UserData data = new UserData();

		//check marker
		if (data instanceof BackupSerializable) {
			System.out.println("Backup allowed");
		} else {
			System.out.println("Backup not allowed");
		}
	}
}
