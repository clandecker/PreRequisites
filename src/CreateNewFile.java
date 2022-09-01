import java.io.File;
import java.io.IOException;

public class CreateNewFile {

    public static void main(String[] args) {
        try {
            File file = new File("d:/sampleFile.txt");
            if(file.createNewFile())
                System.out.println("File creation successfull");
            else
                System.out.println("Error while creating File, file already exists in specified path");
        }
        catch(IOException io) {
            io.printStackTrace();
        }
    }

}