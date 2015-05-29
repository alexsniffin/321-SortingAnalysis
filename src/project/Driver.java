package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import project.algorithms.InsertionSort;
import project.algorithms.QuickSort;
import project.algorithms.Shellsort;
import project.algorithms.ShellsortCustom;
import project.algorithms.Sorting;
import randomIntegers.Random_Sequencer;

/**
 * Driver class for sorting algorithm analysis program
 * 
 * @project 321_Project 3
 * @author Alexander Sniffin, Julian Wyatt
 * @date Apr 16, 2015
 */
public class Driver
{
	private static long startTime, endTime;
	
	/**
	 * @param args args[0] The exponent used for the input, and args[1] checks whether to use
	 * a semi-sorted or random value
	 */
	public static void main(String[] args)
	{
		//Sets the size of 10^n for input size
		int setSize = 0;
		//If 0 is random, 1 is semisorted
		int semiSorted = 0;
		
		try
		{
			setSize = Integer.parseInt(args[0]);	
		}
		catch (Exception e)
		{
			System.out.println("First command line argument" +
					" can only be an integer");
			System.exit(0);
		}
	
		try
		{
			semiSorted = Integer.parseInt(args[1]);
		}	
		catch (Exception e)
		{
			System.out.println("Second command line argument" +
					"can only be a boolean.");
			System.exit(0);
		}
		
		@SuppressWarnings("unused")
		Sorting<Integer> algorithm;
		
		sort(algorithm = new InsertionSort<Integer>(), setSize, semiSorted);
		sort(algorithm = new Shellsort<Integer>(), setSize, semiSorted);
		sort(algorithm = new ShellsortCustom<Integer>(), setSize, semiSorted);
		sort(algorithm = new QuickSort<Integer>(), setSize, semiSorted);	
	}
	
	/**
	 * Gets the inputed sequence and then records how long it takes to run the
	 * sorting algorithm three times.
	 * 
	 * @param algorithm Which algorithm to run
	 * @param size The size of the input sequence
	 * @param sorted Is the input sequence semi sorted?
	 */
	public static void sort(Sorting<Integer> algorithm, int size, int sorted)
	{
		for(int i = 0; i < 3; i++)
		{
			String arr;
			Integer[] tmpArray = readSequence((int) Math.pow(10,size),sorted);
		
			startTime = System.nanoTime();
			arr = algorithm.sortAll(tmpArray);
			endTime = System.nanoTime();
		
			//Prints time taken
			System.out.println(algorithm.getClass().getSimpleName() + " finished: " + ((double) (endTime - startTime)/Math.pow(10,  3)));
			//Prints the sorted sequence
			//System.out.println(arr);
		}
	}
	
	/**
     * Reads in the sequence from a file
     *
     * @param n
     * @return Array containing the sequence
     */
    private static Integer[] readSequence(int n,int t) {
            Integer[] sequence = new Integer[n];
            File file;
           
            if (new File("./seq/" + n + "_" + t).exists())
                    file = new File("./seq/" + n + "_" + t);
            else if(t == 0)
            {
                    System.err.println("Error! Input for file not found, will automatically create file.");
                    writeToFile(t, sequence = new Random_Sequencer().randomGen(n));
                    return sequence;
            }
            else
            {
                System.err.println("Error! Input for file not found, will automatically create file.");
                writeToFile(t, sequence = new Random_Sequencer().fivePercentRandom(n));
                return sequence;
            }
            
            try (Scanner stream = new Scanner(file)) {
                    int line, i = 0;
                   
                while (stream.hasNext()) {
                    line = stream.nextInt();
                    sequence[i++] = line;
                }
               
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sequence;
    }
   
    /**
     * Writes a random sequence to a file
     *
     * @param integer
     */
    private static void writeToFile(int t, Integer...integer) {
            try {
                    File file = new File("./seq/" + integer.length + "_" + t);
                    if (!file.exists()) {
                            file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                   
                    for (int i = 0; i < integer.length; i++)
                            bw.write(integer[i] + " ");
                   
                    bw.close();

                    System.out.println("Finished writing sequence to file!");
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

}
