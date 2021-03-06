package myArrayList.util;

import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
    private Map<String, String> results;
    private PrintWriter pWrite;

   /**
    * Constructor for Results class. Accepts string as parameter,
    * which indicates where the output file is to write to. Catches
    * IOException if generated by FileWriter. Also initializes data
    * structure used to store result strings
    * 
    * @return - no return value
    */
    public Results(String outFile)
    {
        results = new HashMap<String, String>();
        try
        {
            pWrite = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

   /**
    * Implements writeToStdout from StdoutDisplayInterface
    *
    * @return void - no return value
    */
    public void writeToStdout(String s)
    {
        System.out.println(results.get(s));
    }
	
   /**
    * Implements writeToFile for FileDisplayInterface
    *
    * @return void - no return value
    */
    public void writeToFile(String s)
    {
        pWrite.write(results.get(s)+'\n', 0, results.get(s).length()+1);
    }

   /**
    * Stores result string in Results Hashmap
    *
    * @return void - no return type
    */
    public void storeNewResult(String key, String result)
    {
        results.put(key, result);
    }

   /**
    * Prints all results in results based on key
    *
    * @return void - no return type
    */
    public void printResults()
    {
	writeToStdout("sum");
	writeToFile("sum");
	for(String key : results.keySet())
        {
            if(!key.equals("sum"))
	    {
	        writeToStdout(key);
	        writeToFile(key);
	    }
	}
    }
	
   /**
    * Closes PrintWriter to empty buffer and write to file
    *
    * @return void - no return type
    */
    public void close()
    {
        pWrite.close();
    }
}
