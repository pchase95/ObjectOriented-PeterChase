
public class WordReverse implements ICrypto {
	public static WordReverse instance = null;
	
	private WordReverse() {}
	
	public static WordReverse getInstance() {
		if (instance == null)
			instance = new WordReverse();
		return instance;
	}

	@Override
	public String encrypt(String message) {
		return decrypt(message);
	}

	@Override
	public String decrypt(String message) {
		IMessageParser parser_message = Factory.getInstance().createParser(message);
		String decrypted = "";
	
		for (int i = 0; i < parser_message.getWordCount(); i++) {
			IMessageParser parser_word = Factory.getInstance().createParser(parser_message.word(i));
			char[] chars = parser_message.word(i).toCharArray();
	        for (int j = 0; j < parser_word.getCharCount() / 2; j++) {
	            char temp = parser_word.getChar(j);
	            chars[j] = chars[chars.length - 1 - j];
	            chars[chars.length - 1 - j] = temp;
	        }
	        decrypted += new String(chars);
	        decrypted += " ";
		}

		return decrypted;
	}
}
