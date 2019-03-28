
package flashcards;
import java.nio.file.*;
import java.io.*;
public class FlashCards 
{

    public static void main(String[] args) 
    {
        Path inFiles = Paths.get("C:\\Java\\FlashCardsIn.txt");
        Path outFiles = Paths.get("C:\\Java\\FlashCardsOut.txt");
        
        String[] questionArray = new String[10];
        String[] answerArray = new String[10];
        int questionCount = 0;
        int answerCount = 0;
        int count = 0;
        String s; 
        
        try
        {
            InputStream input = Files.newInputStream(inFiles);
            BufferedReader reader = new 
                BufferedReader(new InputStreamReader(input));
            OutputStream output = new
                    BufferedOutputStream(Files.newOutputStream(outFiles));
            BufferedWriter writer = new
                    BufferedWriter(new OutputStreamWriter(output));
            s = reader.readLine();
            
            while(s != null)
            {
                if(count % 2 == 1)
                {
                    questionArray[questionCount] = s;
                    writer.write(s, 0, s.length());
                    writer.write(System.getProperty( "line.separator" ));
                    s = reader.readLine();
                    questionCount++;
                }
                else
                {
                    answerArray[answerCount] = s;
                    writer.write(s + "\n", 0, s.length());
                    writer.write(System.getProperty( "line.separator" ));
                    s = reader.readLine();
                    answerCount++;
                }
                count++;
            }
        writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
