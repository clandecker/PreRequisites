import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

public class TreeObject {
	ArrayList<String> arr= new ArrayList<String>();
	String arrayContents="";
	String sha1="";
	//adding array contents to a string
	public TreeObject(ArrayList<String> a) throws IOException{
		arr=a;
		int len = arr.size();
	      for (int i = 0; i < len; i++) {
	         arrayContents+=arr.get(i);
	      }	
	
	//getting sha1
	sha1=generateSHA1(arrayContents);
	
	//create file
	Path p = Paths.get("objects/index");
	
	//
		
	}
	
	public static void main (String[]args) throws IOException {
		System.out.println(TreeObject.generateSHA1("hello"));
		
	}
	
	public static String generateSHA1(String st) throws IOException {
		String str=st;
		String SHA="";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(str.getBytes("utf8"));
	        SHA = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return SHA;
		
    }
	
	public String getSHA1() {
		return sha1;
	}
	
	public void add(ArrayList<String> a) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

		//putting into file
		BufferedWriter bf=null;
		String current="";
		try {
			bf=new BufferedWriter(new FileWriter("/objects/index"));
			int len = arr.size();
		      for (int i = 0; i < len; i++) {
		         current=arr.get(i);		
               bf.write(current); 
               // new line
               bf.newLine();
			}
		}
		catch (IOException e) {
            e.printStackTrace();
        }
        finally { 
            try {
  
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
		
	}
	

}
