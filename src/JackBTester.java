import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JackBTester {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path p = Paths.get("junit.txt");
        try {
            Files.writeString(p, "JackB Test", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Path p1 = Paths.get("junit1.txt");
        try {
            Files.writeString(p1, "junit1", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Path p2 = Paths.get("junit2.txt");
        try {
            Files.writeString(p2, "junit2", StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		File file= new File("junit.txt");
		file.delete();
	}

	@Test
	//ALL THINGS TESTING INDEX DON'T WORK
		void testIndex() {
				
				Index ind= new Index();
				
				File file=new File("index");
				assertTrue(file.exists());
				
				Path path=Paths.get("objects");
				assertTrue(Files.exists(path));
			}
	
	@Test
	void testBlob() throws IOException, NoSuchAlgorithmException {		
		Blob b=new Blob("junit.txt");
		
		File file=new File("objects/f85d527604444aa350aa09dfe93baefbd88f804c");// PUT IN SHA1 STRING
		assertTrue(file.exists());// this is returning false bc file never gets created
	}
	
	@Test
	void testGetSha() throws NoSuchAlgorithmException, IOException {
		Blob b=new Blob("junit.txt");
		assertTrue(b.getSha().equals("f85d527604444aa350aa09dfe93baefbd88f804c"));
		
	}
	
	@Test
	void testAddBlob() throws IOException, NoSuchAlgorithmException{
		Index ind=new Index();
		//add 3 blobs
		ind.addBlob("junit.txt");
		ind.addBlob("junit1.txt");
		ind.addBlob("junit2.txt");
		
		//check if files exists (they don't)
		File file_junit=new File("objects/f85d527604444aa350aa09dfe93baefbd88f804c");//PUT IN SHA1 STRING
		File file_junit1=new File("objects/6b6ea6dafb08754e3065aeb0250f792a3a677451");//PUT IN SHA1 STRING		
		File file_junit2=new File("objects/44e2550ac5ccbf014e9b01e5a43ee4395ab86623");//PUT IN SHA1 STRING
		assertTrue(file_junit.exists()&& file_junit1.exists()&& file_junit2.exists());
		
		//checks if index file contains correct lines (it doesn't)
		
		
		
		
	}
	@Test
	//THIS ISN'T CORRECT
	/*void testDeleteBlob() throws NoSuchAlgorithmException, IOException {
		//delets junit
		
		//check if file doesn't exist
		File f=new File("objects/f85d527604444aa350aa09dfe93baefbd88f804c");
		Index ind=new Index();
		ind.deleteBlob("junit.txt");
		assertTrue(!f.exists());
		
		//check if removes line from index
		try (BufferedReader br = new BufferedReader(new FileReader("index"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if (line.equals("junit.txt:f85d527604444aa350aa09dfe93baefbd88f804c")) {
		    	   assertTrue(false);
		       }
		    }
		    assertTrue(true);
		}
		
		
		
		
		//also how do u check that a hashmap doesn't have the key in it anymore
		//also that the file doesn't exist
		//also that the index file doesn't contain it???
		
	}*/

}
