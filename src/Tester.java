

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Tester {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Blob b = new Blob ("/Users/meeraburghardt/eclipse-workspace/Git PreRequisites/Object.txt");
	System.out.println(b.encryptThisString("abcdefg"));
		Index i = new Index();
		i.init();
		i.addBlob("/Users/meeraburghardt/eclipse-workspace/Git PreRequisites/Object.txt");
		i.deleteBlob("/Users/meeraburghardt/eclipse-workspace/Git PreRequisites/Object.txt");
	}

}