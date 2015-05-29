package project.algorithms;

/**
 * Parent class of sorting algorithms
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public abstract class Sorting<AnyType extends Comparable<? super AnyType>>
{

	public abstract String sortAll(AnyType[] a);
	
}
