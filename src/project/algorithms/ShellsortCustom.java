package project.algorithms;

import java.util.Arrays;

/**
 * Hibbard Shellsort
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public class ShellsortCustom<AnyType extends Comparable<? super AnyType>> extends Sorting<AnyType>
{
	/**
	 * ShellsortCustom, uses 2k - 1 as gap
	 * @param a an array of integer items
	 */
	@Override
	public String sortAll(AnyType[] a)
	{
		
		int j;
		int gap = 0;
		for(int k = 0; k < a.length; gap = (int) ((Math.pow(2, k++))-1))
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
