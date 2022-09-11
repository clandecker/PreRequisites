import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {
public static void main (String []args)  {
//	String a = "Object";
//	Blob blobby;
//	try {
//		blobby = new Blob (a);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println( Blob.encryptThisString(a));
	Path p = Paths.get("Object.txt");
	try{
	Files.writeString(p,"Tester", StandardCharsets.ISO_8859_1);
	} catch(IOException e) {
		e.printStackTrace();
	}
	
}
}
