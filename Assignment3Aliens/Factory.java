
public class Factory {
	private static Factory instance = null;
	
	private Factory() {}
	
	public IMessageParser createParser(String text) {
		return new MessageParser(text);
	}
	
	public static Factory getInstance() {
		if (instance == null)
			instance = new Factory();
		return instance;
	}
	
}


