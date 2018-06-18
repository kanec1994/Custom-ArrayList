package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest{

   /**
    * Calls all test cases for MyArrayList. Stores result in
    * results object.
    *
    * @return Results - test results for printing
    */
    public Results testMe(MyArrayList myArrayList, Results results)
    {
	results.storeNewResult("insertTest", increasingTest(myArrayList));
	results.storeNewResult("sizeInsTest", sizeInsTest(myArrayList));
	results.storeNewResult("sizeRemTest", sizeRemTest(myArrayList));
	results.storeNewResult("sumTest", sumTest(myArrayList));
	results.storeNewResult("removeTest", removeTest(new MyArrayList()));
	results.storeNewResult("removeDupTest", removeDupTest(new MyArrayList()));
        results.storeNewResult("resizeTest", resizeTest(new MyArrayList()));
        results.storeNewResult("indexTest", indexTest(new MyArrayList()));
	results.storeNewResult("notFoundTest", notFoundTest(new MyArrayList()));
	results.storeNewResult("copyTest", copyTest(new MyArrayList()));
	return results;
    }

   /**                                                                                         
    * Ensure items inserted into list in non-increasing order
    * are ordered after insertion by comparing indices in array
    *
    * @return String - result of test
    */
    private String increasingTest(MyArrayList myArrayList)
    {
	myArrayList.insertSorted(350);
	myArrayList.insertSorted(100);
	myArrayList.insertSorted(200);
	if(myArrayList.indexOf(100) < myArrayList.indexOf(200) &&
	   myArrayList.indexOf(200) < myArrayList.indexOf(350))
	{
	    return "List Increasing Test: Passed";
	}
	return "List Increasing Test: Failed";
    }

   /**
    * Ensure the integer keeping track of array size changes on
    * insertion
    *
    * @return String - result of test 
    */
    private String sizeInsTest(MyArrayList myArrayList)
    {
	int initSize = myArrayList.size();
	for(int i=0; i<100; i++)
	{
	    myArrayList.insertSorted(i);
	}
	if(myArrayList.size() == (initSize+100))
	{
	    return "Size on Insert Test: Passed";
	}
	return "Size on Insert Test: Failed";
    }

   /**
    * Ensure integer keeping track of array size changes on 
    * removal
    *
    * @return String - result of test 
    */
    private String sizeRemTest(MyArrayList myArrayList)
    {
        for(int i=0; i<50; i++)
	{
	    myArrayList.insertSorted(10001);
	}
	int initSize = myArrayList.size();
	int success = myArrayList.removeValue(10001);
	if(myArrayList.size() == (initSize-50))
	{
	    return "Size on Remove Test: Passed";
	}
	return "Size on Remove Test: Failed";
    }	

   /**
    * Ensures sum changes on Insertion.
    *
    * @return String - result of test 
    */
    private String sumTest(MyArrayList myArrayList)
    {
	int initSum = myArrayList.sum();
	for(int i=0; i<100; i++)
	{
	    myArrayList.insertSorted(50);
	}
	if(myArrayList.sum() == (initSum+5000))
        {
	    return "Sum Test: Passed";
	}
	return "Sum Test: Failed";
    }

   /**
    * Ensures single numbers can be removed from MyArrayList
    *
    * @return String - result of test 
    */
    private String removeTest(MyArrayList myArrayList)
    {
	for(int i=0; i<100; i++)
	{
	    myArrayList.insertSorted(i);
        }
	int initSum = myArrayList.sum();
	int success = myArrayList.removeValue(50);
	if((success == 1) && (initSum == (myArrayList.sum()+50)))
	{
	    return "Remove Value Test: Passed";
	}
	return "Remove Value Test: Failed";
    }

   /**
    * Ensures MyArrayList can remove duplicates by checking if sum changes
    *
    * @return String - result of test 
    */
    private String removeDupTest(MyArrayList myArrayList)
    {
	for(int i=0; i<100; i++)
	{
	    if(i<20)
	    {
		myArrayList.insertSorted(10);
	    }
	    else
	    {
		myArrayList.insertSorted(i);
	    }
	}
	int initSum = myArrayList.sum();
	int success = myArrayList.removeValue(10);
	if((success == 1) && (initSum == (myArrayList.sum()+200)))
	{
	    return "Remove Duplicate Values Test: Passed";
	}
	return "Remove Duplicate Values Test: Failed";
    }

   /**
    * Ensures resize occurs without failing (resize happens
    * when inserting 51st element)
    *
    * @return String - result of test 
    */
    private String resizeTest(MyArrayList myArrayList)
    {
	for(int i=0; i<75; i++)
        {
	    myArrayList.insertSorted(i);
	}
	if(myArrayList.size() == 75)
	{
	    return "Resize Test: Passed";
	}
	return "Resize Test: Failed";
    }

   /**
    * Ensures indexOf works properly by checking if index changes
    * when list is sorted
    *
    * @return String - result of test 
    */
    private String indexTest(MyArrayList myArrayList)
    {
	 for(int i=50; i>0; i--)
	 {
	     myArrayList.insertSorted(i);
	 }
	 for(int i=0; i<50; i++)
	 {
	     if(myArrayList.indexOf(i+1) != i)
	     {
		 return "Index Test: Failed";
	     }
	 }
	 return "Index Test: Passed";
    }

   /**
    * Calls indexOf to determine if int is found in MyArrayList
    * Expects -1 on return
    *
    * @return String - result of test 
    */
    private String notFoundTest(MyArrayList myArrayList)
    {
	for(int i=0; i<50; i++)
	{
	    myArrayList.insertSorted(i);
	}
	if(myArrayList.indexOf(50) == -1)
	{
	    return "Not Found Test: Passed";
	}
	return "Not Found Test: Failed";
    }

   /**
    * Ensures values are copied properly by initializing
    * array with 50 ints (initial max size), inserting a
    * 51st element (resize occurs), and checking if all known
    * ints are still in myArrayList
    *
    * @return String - result of test 
    */
    private String copyTest(MyArrayList myArrayList)
    {
        for(int i=0; i<50; i++)
	{
	    myArrayList.insertSorted(i);
	}
	myArrayList.insertSorted(50);
	for(int i=0; i<myArrayList.size(); i++)
	{
	    if(myArrayList.indexOf(i) != i)
	    {
		return "Copy Test: Failed";
	    }
	}
	return "Copy Test: Passed";
    }
}
