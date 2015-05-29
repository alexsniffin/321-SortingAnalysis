package project.algorithms;

import java.util.Arrays;

/**
 * Shell's Shellsort algorithm
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public class Shellsort<AnyType extends Comparable<? super AnyType>> extends Sorting<AnyType>
{
	/**
	 * Shellsort, using Shell's (poor) increments.
	 * @param a an array of integer items
	 */
	@Override
	public String sortAll(AnyType[] a)
	{
		
		int j;
		
		for(int gap = a.length / 2 ;gap > 0; gap /= 2)
		{
			for( int i = gap; i < a.length; i++ )
			{		
				AnyType tmp = a[i];
				for( j = i; j >= gap 
						&& tmp.compareTo( a[j-gap]) < 0; j -= gap)
					a[j]=a[j-gap];
				a[j] = tmp;
			}
		}
		return Arrays.toString(a);
	}

}
