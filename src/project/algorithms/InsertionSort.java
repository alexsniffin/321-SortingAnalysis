package project.algorithms;

import java.util.Arrays;

/**
 * Insertion sort algorithm
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public class InsertionSort<AnyType extends Comparable<? super AnyType>> extends Sorting<AnyType>
{
	/**
	 * Simple insertion sort
	 * @param a an array of Comparable itmes0
	 * @return 
	 */
	@Override
	public String sortAll(AnyType[] a)
	{
		int j;
		
		for (int p = 1; p < a.length; p++)
		{
			AnyType tmp = a[p];
			for(j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--)
				a[j] = a[j-1];
			a[j] = tmp;
		}
		return Arrays.toString(a);
	}

}
