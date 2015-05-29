package randomIntegers;

/**
 * Class to generate both random Integers and
 * incrementally random Integers
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public class Random_Sequencer
{
	
	public Integer[] randomGen(Integer n)
	{
		Integer[] arr = new Integer[n];
		for (Integer i = 0; i < arr.length; i++)
		{
			arr[i] = (int) (Math.random() * n);
		}
		return arr;
	}
	
	public Integer[] fivePercentRandom(Integer n)
	{
		Integer [] arr = new Integer[n];
		for (Integer i = 0; i < arr.length; i++)
		{
			if(i%(n*.05) == 0)
			{
				arr[i] = (int) (Math.random() * n);
			}
			else
			{	
				arr[i] = i;
			}
			
		}
		return arr;
	}
}
