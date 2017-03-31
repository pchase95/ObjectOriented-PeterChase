
public class Main {
	public static void main(String[] args) {
		String msg1 = "MY FEVUROTI THONG EBUAT IERTH OS FRINCH FROIS";
		String msg2 = "KCIR DLEIFGNIRPS SI YM ETIROVAF GNIDROCER TSITRA";
		
		System.out.println("Decrypting message 1 using Vowel Mash:");
		ICrypto c = VowelMash.getInstance();
		System.out.println(c.decrypt(msg1));
		
		System.out.println("Decrypting message 1 using Word Reverse:");
		c = WordReverse.getInstance();
		System.out.println(c.decrypt(msg1));
		
		System.out.println("Decrypting message 2 using Vowel Mash:");
		c = VowelMash.getInstance();
		System.out.println(c.decrypt(msg2));
		
		System.out.println("Decrypting message 2 using Word Reverse:");
		c = WordReverse.getInstance();
		System.out.println(c.decrypt(msg2));
		
		String msg3 = "WE ARE PEACEFUL ALWAYS WEAR YOUR SUNGLASSES AT NIGHT";
		System.out.println(msg3);
		System.out.println("Encrypting message 3 using Vowel Mash:");
		c = VowelMash.getInstance();
		System.out.println(c.decrypt(msg3));
		
		System.out.println("Encrypting message 3 using Word Reverse:");
		c = WordReverse.getInstance();
		System.out.println(c.decrypt(msg3));
	}
}
