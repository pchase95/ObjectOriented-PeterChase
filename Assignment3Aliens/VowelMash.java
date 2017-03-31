
public class VowelMash implements ICrypto {
	public static VowelMash instance = null;
	
	private VowelMash() {}
	
	public static VowelMash getInstance() {
		if (instance == null)
			instance = new VowelMash();
		return instance;
	}

	@Override
	public String encrypt(String message) {
		IMessageParser parser = Factory.getInstance().createParser(message);
		String encrypted = "";
		for (int i = 0; i < parser.getCharCount(); i++) {
			char c = parser.getChar(i);
			switch (c) {
				case 'A':	c = 'E';
							break;
				case 'E':	c = 'I';
							break;
				case 'I':	c = 'O';
							break;
				case 'O':	c = 'U';
							break;
				case 'U':	c = 'A';
							break;
				default:	break;
			}
			encrypted += c;
		}
		
		return encrypted;
	}

	@Override
	public String decrypt(String message) {
		IMessageParser parser = Factory.getInstance().createParser(message);
		String decrypted = "";
		for (int i = 0; i < parser.getCharCount(); i++) {
			char c = parser.getChar(i);
			switch (c) {
				case 'E':	c = 'A';
							break;
				case 'I':	c = 'E';
							break;
				case 'O':	c = 'I';
							break;
				case 'U':	c = 'O';
							break;
				case 'A':	c = 'U';
							break;
				default:	break;
			}
			decrypted += c;
		}
		
		return decrypted;
	}
}
