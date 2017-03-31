import java.util.Arrays;
import java.util.List;

public class MessageParser implements IMessageParser {
		private List<String> m_words;
		private String m_msg;
		
		MessageParser(String message) {
			m_msg = message;
			m_words = Arrays.asList(message.split(" "));
		}
		
		@Override
		public int getCharCount() {
			return m_msg.length();
		}

		@Override
		public int getWordCount() {
			return m_words.size();
		}

		@Override
		public char getChar(int i) {
			return m_msg.charAt(i);
		}

		@Override
		public String word(int i) {
			return m_words.get(i);
		}

	}