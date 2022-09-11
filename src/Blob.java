import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Blob {
	//Path filePathToWrite = Paths.get (fileName);
	//try {
	//Files.writeString (filePathToWrite, stringToWrite, StandardCharSets.ISO_8859_1);
	//catch (IOException exception
	//System.out.println("Write failed for " + fileName);
	//}
		
	
	
	private String SHA;
	
	public Blob(String s) throws IOException {
		// create new file by telling it where to look "path class" Write to that Path
		SHA = encryptThisString(newFileString(s));
		File f= new File(SHA);
		PrintWriter p = new PrintWriter ("objects/" + f);
		p.append(newFileString(s));
		p.close();
		
	}
	
	public String getSha () {
		return SHA;
	}
	public static String encryptThisString(String input) {

        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
 
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
 
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
 
            // return the HashText
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	private String newFileString(String file) throws IOException{
		Path pathy = Path.of(file);
		return Files.readString(pathy);
	}
	
	
}