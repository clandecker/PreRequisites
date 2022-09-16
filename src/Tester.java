

import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {
		Blob b = new Blob ("/Users/meeraburghardt/eclipse-workspace/Git Prereq/something.txt");
	System.out.println(b.encryptThisString("abcdefg"));
		Index i = new Index();
		i.init();
		i.addBlob("/Users/meeraburghardt/eclipse-workspace/Git Prereq/something.txt");
		i.removeBlob("/Users/meeraburghardt/eclipse-workspace/Git Prereq/something.txt");
	}

}