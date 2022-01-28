package mypackages;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMeClass 
{

	static final String projectfilePath = "D:\\SimpliLearn Java\\LockedMe Files";
	static final String errorMessage = "Some error occurs, Please contact : admin@lockedme.com";
	static final Scanner obj = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		int ch;
		do
		{
			displayMenu();
			System.out.println("Enter you choice:");
			ch=Integer.parseInt(obj.nextLine());
			
		switch(ch)
			{
				case 1:getallfile();
				break;
				case 2:creatallfile();
				break;
				case 3:deletefile();
				break;
				case 4:searchfile();
				break;
				case 5:System.exit(0);
				break;
				default:System.out.println("Invalid Option");
				break;
			}
		}
		while(ch>0);
		obj.close();
	}
	public static void displayMenu() 
	{
		 System.out.println("==================================================");
		 System.out.println("\t\tWelcome To LockedMe.com ");
		 System.out.println("\t\tDesigned by - Tejas Supe");
		 System.out.println("==================================================");
		 System.out.println("\t\t1. Display all The files");
		 System.out.println("\t\t2. Add a new file");
		 System.out.println("\t\t3. Delete a file");
		 System.out.println("\t\t4. Search a file");
		 System.out.println("\t\t5. Exit");
	}
	
	/**
	*This function will return all the files from the project directory
	*/
	public static void getallfile()
	{
		try
		{
			File folder = new File(projectfilePath);
			File[] listofFiles = folder.listFiles();
			
			if(listofFiles.length==0)
				System.out.println("No files exist in the directory");
			else
		
			for(File l:listofFiles) 
			{
				System.out.println(l.getName());
			}
		}
		catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
	}
	/**
	 * This method will help to create files in the directory
	 */
	public static void creatallfile()
	{
		try
		{
			String fileName;
			
				System.out.println("Enter file name:");
			 fileName = obj.nextLine();
			
			int linesCount;
				System.out.println("Enter how many lines in the file");
				linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter myWriter = new FileWriter(projectfilePath+ "\\"+ fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the file line:");
				myWriter.write(obj.nextLine()+"\n");
			}
				System.out.println("File created successfully");
				myWriter.close();
		}
		catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
	}
	/**
	* This method will delete the file based on provided file name
	*/
	public static void deletefile() 
	{
		try 
		{
			String fileName;
			
				System.out.println("Enter the file name to be deleted:");
			
			fileName = obj.nextLine();
			
			File file = new File(projectfilePath+ "\\"+ fileName);
			
			if(file.exists())
			{
				file.delete();
				System.out.println("File deleted successfully : "+fileName);
			}
			else
				System.out.println("File do not exist");
		}
		catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
	}
	/**
	* This method will search the file from directory
	*/
	public static void searchfile() 
	{
		try 
		{
			String fileName;
			
				System.out.println("Enter the file name to be searched:");
			
			fileName = obj.nextLine();
			
			File folder = new File(projectfilePath);
			File[] listofFiles = folder.listFiles();
			
			LinkedList<String> filenames = new LinkedList<String>();
			
			for(File l:listofFiles)
				filenames.add(l.getName());
			
			if(filenames.contains(fileName))
				System.out.println("File is available");
			else
				System.out.println("File is not available");
			
		}
		catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
	}
	/**
	 * This method will exit from directory
	 */
	public static void exit() 
	{
				
	}
}
