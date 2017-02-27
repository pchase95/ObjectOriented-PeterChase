
public class Builder {
	private static Builder instance;
	
	protected Builder() {}
	
	public IDecision buildWizard() {
		IDecision board1 = new Decision("Do you want to buy a snowboard?");
		IDecision board2 = new Decision("Have you snowboarded before?");
		IDecision board3 = new Decision("Are you an expert?");
		IDecision board4 = new Decision("Do you like to go fast?");
		
		IDecision ski1 = new Decision("Do you want to buy downhill skis?");
		IDecision ski2 = new Decision("Have you gone skiing before?");
		IDecision ski3 = new Decision("Are you an expert?");
		IDecision ski4 = new Decision("Do you like to jump?");
		
		// Snowboarding
		board1.setYes(board2);
		board1.setNo(ski1);
		
		board2.setYes(board3);
		board2.setNoTerminal("Buy the XG100 model.");
		
		board3.setYes(board4);
		String xg200 = "Buy the XG200 model.";
		board3.setNoTerminal(xg200);
		
		board4.setYesTerminal("Buy the XG300 model.");
		board4.setNoTerminal(xg200);
		
		
		// Skiing
		ski1.setYes(ski2);
		ski1.setNoTerminal("Recommend they try skiing someday.");
		
		ski2.setYes(ski3);
		ski2.setNoTerminal("Buy the ZR100 model.");
		
		ski3.setYes(ski4);
		String zr200 = "Buy the ZR200 model.";
		ski3.setNoTerminal(zr200);
		
		ski4.setYesTerminal("Buy the ZR300 model.");
		ski4.setNoTerminal(zr200);
		
		return board1;
	}
	
	public static Builder getInstance() {
		if (instance == null)
			instance = new Builder();
		
			return instance;
	}
}
