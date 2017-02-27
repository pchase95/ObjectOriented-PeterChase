
public interface IDecision {
	public void setYes(IDecision yes);
	public void setNo(IDecision No);
	public void setYesTerminal(String terminal);
	public void setNoTerminal(String terminal);
	public IDecision ask();
}
