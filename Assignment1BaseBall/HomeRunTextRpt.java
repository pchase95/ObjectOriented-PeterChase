import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeRunTextRpt {
	protected String m_dataFile;
	protected String m_reportFile;
	
	public HomeRunTextRpt(String dataFile, String reportFile) {
		m_dataFile = dataFile;
		m_reportFile = reportFile;
	}
	
	public List<DataPair> loadData() {
		List<DataPair> dataList = new ArrayList<>();
		try {
			Scanner reader = new Scanner(new File(m_dataFile));
			while (reader.hasNextLine()) {
				String[] tokens = reader.nextLine().split(",");
				if (tokens.length >= 2)
					dataList.add(new DataPair(tokens[0], Integer.parseInt(tokens[1])));
				else
					dataList.add(new DataPair(tokens[0], -1));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.printf("\"%s\" could not be found\n", m_dataFile);
			System.exit(420);
		}
		
		return dataList;
	}
	
	public void generateReport(List<DataPair> data) {
		try {
			PrintWriter writer = new PrintWriter(new File(m_reportFile));
			for (DataPair dp : data) {
				if (dp.getStat() != -1)
					writer.printf("Name: %s, Stat: %d\n", dp.getName(), dp.getStat());
				else
					writer.printf("Name: %s, Stat: N/A\n", dp.getName());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Could not write to \"%s\"\n", m_reportFile);
			System.exit(421);
		}
	}
}
