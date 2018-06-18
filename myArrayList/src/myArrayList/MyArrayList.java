package myArrayList;

public class MyArrayList{
    private int size, sum, maxSize;
    private int listData[];

   /**
    * Empty constructor which defines private data members
    * to default values (In this case only the int array).
    *
    * @return - no return type
    */
    public MyArrayList()
    {
        listData = new int[50];
        size = 0;
	sum = 0;
	maxSize = 50;
    }
    
   /**
    * Inserts specified variable into listData.
    *
    * If the parameter already exists in listData, the value
    * is stored before the first instance of the value in listData.
    *
    * If inserting the value exceeds the initial size of the 
    * array, the resizeArray is called before insertion.
    *
    * Updates sum and size integers
    *
    * @param newValue - the integer to be stored in the array.
    * @return void - nothing returned
    */
    public void insertSorted(int newValue)
    {
	sum += newValue;

	if(size == maxSize)
	{
	    resizeArray();
	}

	if(size == 0)
	{
	    listData[0] = newValue;
	    size++;
	}
	else
	{
	    for(int i = 0; i <= size; i++)
	    {
	        if(i == size)
	        {
		    listData[i] = newValue;		    
	        }
		else if(newValue <= listData[i])
		{
		    int tempVal = listData[i];
		    listData[i] = newValue;
		    newValue = tempVal;
		}
	    }
	    size++;
	}
    }
    
   /**
    * Removes values specified by User from listData.
    * Removes all existing values and moves the remaining
    * values in listData into ascending order.
    *
    * @param value - the integer to remove from listData
    * @return int - flag of whether value exists 
    */
    public int removeValue(int value)
    {
	int instances = 0;
        int found = 0;
	for(int i = 0; i < size; i++)
	{
	    if(value == listData[i])
	    {
		instances++;
		found = 1;
	    }
	    else if(instances > 0)
	    {
		listData[i-instances] = listData[i];
	    }
	}
        size -= instances;
        sum -= value*instances;
	return found;
    }
    
   /**
    * Returns the index of the first occurence of a value.
    * 
    * If the specified value does not exist, return -1.
    *
    * @param value - specifies which value to get the index of
    * @return int - returns the specified index.
    */
    public int indexOf(int value)
    {
	int index = 0;
	while(index != size && value != listData[index])
	{
	    index++;
	}
	
	if(index == size)
	{
	    return -1;
	}
	return index;
    }
    
   /**
    * Returns the total number of values stored in listData.
    *
    * @return int - size of listData
    */
    public int size()
    {
	return size;        
    }
    
   /**
    * Returns the sum of all values in listData
    *
    * @return int - sum of all values in listData
    */
    public int sum()
    {
	return sum;
    }

   /**
    * Resizes array by increasing capacity 50%.
    *
    * @return void - returns nothing
    */
    private void resizeArray()
    {
	maxSize += (maxSize / 2); 
	int tempArr[] = new int[maxSize];
	for(int i = 0; i < size; i++)
	{
	    tempArr[i] = listData[i];
	}
	listData = tempArr;
    }

   /**
    * Formats values of Array into String for printing
    *
    * @return - String of values in listData
    */ 
    public String toString()
    {
	String retStr = "Values in MyArrayList:";
	for(int i=0;i<size;i++)
        {
	    retStr = retStr + " " + Integer.toString(listData[i]);
	}
	return retStr;
    }
}
