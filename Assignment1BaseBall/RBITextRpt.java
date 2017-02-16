import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RBITextRpt extends HomeRunTextRpt {
	public RBITextRpt(String dataFile, String reportFile) {
		super(dataFile, reportFile);
	}
	
	@Override
	public List<DataPair> loadData() {
		List<DataPair> dataList = new ArrayList<>();
		try {
			Scanner reader = new Scanner(new File(m_dataFile));
			while (reader.hasNextLine()) {
				String[] tokens = reader.nextLine().split(",");
				if (tokens.length >= 3)
					dataList.add(new DataPair(tokens[0], Integer.parseInt(tokens[2])));
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
}
