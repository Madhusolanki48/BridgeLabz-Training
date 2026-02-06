package functional_interface;

//interface for report export
interface ReportExporter {
	void exportToCSV();
	void exportToPDF();

	//new default method for JSON export
	default void exportToJSON() {
		System.out.println("Exporting report to JSON");
	}
}

//existing exporter
class SalesReport implements ReportExporter {
	public void exportToCSV() {
		System.out.println("Exporting CSV");
	}

	public void exportToPDF() {
		System.out.println("Exporting PDF");
	}
}

public class DataExportFeature {
	public static void main(String[] args) {
		ReportExporter report = new SalesReport();
		report.exportToJSON();
	}
}
