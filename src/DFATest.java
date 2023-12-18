import java.util.Scanner;
import java.nio.file.*; //Libraries imported to read file and user input
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.*;
//Josahandi Cisneros
//CSC471
//Project1


public class DFATest<E> {

	
	public static void main(String[] args)
	
	{
		Scanner inputUser= new Scanner(System.in); 
		
		System.out.println( "Enter Name file containing NFA : " ); 
		String fileName;
		int ind=0;
		fileName =inputUser.nextLine();
		Path file = Paths.get(fileName); 
		String s = ""; 		 	//creates a string to read each line from text inputFile
		String ss = "";
		String  T_table ="";  	//To print out contents of Input File
		LinkedList obj[]= new LinkedList[10]; //Array of references to a linked list for each state in the NFA to be converted
		String cur = ""; 		//String used to print out new DFA states  
	 try 
		 { //Begins to read Text File 
			InputStream input = new BufferedInputStream(Files.newInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input)); 
			int index = 0 ; 		// To keep track of each line 
			s = reader.readLine();	// 1st line is read as String to get info to construct Adj List(graph)
			while( s != null)
			{  T_table += s + "\n";
				obj[index]= new LinkedList<Integer>(); //Creates a list at each index 
				obj[index].insert(s.charAt(0));       // each  char 0 of the string of each line is the index is pushed into the first items 
				ss += s.charAt(0);
			if(s.charAt(3)=='e') 		//checks if state does not have an outgoing arrowhead with ε
			{
				index++; 							  
				 s = reader.readLine();	//Skips to read next state
			}
				
			else 
			{
				for(int i = 3; i < (s.length()-1); i+=2)  //loop to process contents of file line by line
				{
					if(Character.isDigit(s.charAt(i))) //to insert the empty state
						{		
							obj[index].insert(s.charAt(i));
						}	
			 	}
				index++; 	
			 s = reader.readLine();	//loops again s is affected so loops again. 
			}} 
			

			System.out.println( "Text File was read as :  " ); 
			System.out.println(T_table); 
			System.out.println("State set of the equivalent DFA = {" );
			DFAStateSet( ss, ind, cur, ss.length());
			System.out.println("}" );
			getE(obj, ss.length()); //Gets the E(q) for each state


		 	} catch(Exception e) 
		 	{ 
		 		System.out.println("Message " + e); 
		 	} 
	
		
		
	}
	

//Function prints out all the subsets of DFA based on the number of NFA states read from txt file into string NFAstates	
static void DFAStateSet( String NFAstates, int index, String curr, int z)
{ 
	
	int n = NFAstates.length();
	if (index == n)
	{
		if(z == 0) 
			System.out.println("{" + curr + "empty}" );
		
		else 
		{
			System.out.println("{" + curr + "}," );
		}
	return ;
	}
	DFAStateSet( NFAstates, index + 1, curr  + NFAstates.charAt(index) + "," ,z--);
	DFAStateSet(NFAstates, index + 1, curr, z);	
}	
	


static void getE(LinkedList[] obj, int size)
{int b=1;	
	for(int i= 0;i<size;i++) 
	{
		System.out.println(" E(" + b + ") = { "+ obj[0].Eq_State(obj, obj[i]) + " }") ;
		b++;
	}
}
}
