import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class RBIHTMLRptB extends RBITextRpt {
	public RBIHTMLRptB(String dataFile, String reportFile) {
		super(dataFile, reportFile);
	}
	
	@Override
	public void generateReport(List<DataPair> data) {
		try {
			PrintWriter writer = new PrintWriter(new File(m_reportFile));
			writer.println("<!DOCTYPE html>");
			writer.println("<html>");
			writer.println("<head><title>Home Run Report</title></head>");
			writer.println("<body><table border=\"1\">");
			writer.println("<tr><td><b>Name</b></td><td><b>Stat</b></td></tr>");
			for (DataPair dp : data) {
				writer.println("<tr>");
				if (dp.getStat() != -1)
					writer.printf("<td>%s</td><td>%d</td>\n", dp.getName(), dp.getStat());
				else
					writer.printf("<td>%s</td><td>N/A</td>\n", dp.getName());
				writer.println("</tr>");
			}
			writer.println("</table></body>");
			writer.println("</html>");
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Could not write to \"%s\"\n", m_reportFile);
			System.exit(421);
		}
	}
}
