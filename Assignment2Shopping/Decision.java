import java.util.Scanner;

public class Decision implements IDecision {
	private static Scanner scan = new Scanner(System.in);
	private String m_question;
	private IDecision m_yes;
	private IDecision m_no;
	private String m_yesTerminal;
	private String m_noTerminal;
	
	public Decision(String question) { m_question = question; }
	
	@Override
	public void setYes(IDecision yes) { m_yes = yes; }

	@Override
	public void setNo(IDecision no) { m_no = no; }

	@Override
	public void setYesTerminal(String terminal) { m_yesTerminal = terminal; }

	@Override
	public void setNoTerminal(String terminal) { m_noTerminal = terminal; }

	@Override
	public IDecision ask() {
		System.out.println(m_question);
		String answer = scan.nextLine();

		
		if (answer.equalsIgnoreCase("yes")) {
			if (m_yes == null)
				System.out.println(m_yesTerminal);
			return m_yes;
		} else if (answer.equalsIgnoreCase("no")) {
			if (m_no == null)
				System.out.println(m_noTerminal);
			return m_no;
		} else {
			System.out.println("Please answer \"yes\" or \"no\"\n Quitting...");
		}
		return null;
	}

}
