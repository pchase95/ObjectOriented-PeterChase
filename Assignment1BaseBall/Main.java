import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        new Main().go();
    }
    
    // Hey Mark, I changed the output file extensions for the classes that wrote html to ".html"
    public void go() throws IOException
    {
        List<HomeRunTextRpt> reports = new ArrayList<HomeRunTextRpt>();
        reports.add(new HomeRunTextRpt("players.txt", "r1.txt"));
        reports.add(new HomeRunHTMLRpt("players.txt", "r2.html"));
        reports.add(new RBITextRpt("players.txt", "r3.txt"));
        reports.add(new RBIHTMLRptA("players.txt", "r4.html"));
        reports.add(new RBIHTMLRptB("players.txt", "r5.html"));
        makeReports(reports);
    }
    
    private void makeReports(List<HomeRunTextRpt> reports) throws IOException
    {
        for (HomeRunTextRpt rpt : reports)
        {
            List<DataPair> data = rpt.loadData();
            rpt.generateReport(data);
        }
    }
}