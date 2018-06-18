import java.lang.NumberFormatException;
import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;

public class Driver{
    public static void main(String[] args){
        if(args.length == 3){
	    MyArrayList arrLst = new MyArrayList();
	    Results results = new Results(args[1]);
	
            FileProcessor data = new FileProcessor(args[0]);
            String line = data.readLine();
            while(line != null)
            {
                try
                {
                    int currNum = Integer.parseInt(line);
                    arrLst.insertSorted(currNum);
                }
                catch(NumberFormatException e)
                {
                    e.printStackTrace();
                }
                line = data.readLine();
            }

	    MyArrayListTest test = new MyArrayListTest();
	    results = test.testMe(new MyArrayList(), results);
	    results.storeNewResult("sum", "The sum of all the values in the array list is: "
			       + arrLst.sum());
	    results.printResults();
	    results.close();
	}
	else
	{
	    System.out.println("Incorrect number of arguments (2 expected)");
	    System.exit(0);
	}
    }
}
