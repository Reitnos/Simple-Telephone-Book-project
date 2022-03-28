import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Vector {

	List<Integer> vectorList = new ArrayList<Integer>(); 
	
	public void addElement(int newEntry) {
		vectorList.add(newEntry);
	}
	
	public int getElement(int index)
	{
		return vectorList.get(index);
	}
	public int getSize() {
		return vectorList.size();
	}
	
	 
	  public void addVectors(Vector otherVector) { 
		 
		  
		  if(getSize() == otherVector.getSize()) {  // check if two vectors have the same length
			  
			  for(int i = 0; i < getSize() ; i++) {
			     vectorList.set(i, vectorList.get(i) + otherVector.getElement(i));
				
			  }
		  } 
		  
		  
	  } 
	  
	  public void writeToTxtFile() throws IOException{ // write the final result to the local file
			String directoryString = "C:\\Users\\kocak\\Desktop\\Vector.txt";
			
			File file = new File(directoryString);
			FileWriter fWriter = new FileWriter(file);
			PrintWriter pWriter = new PrintWriter(fWriter);
		
			
				pWriter.println("Summation of the vectors: " );
				for(int i = 0; i< vectorList.size() ; i++) {
					
					pWriter.print(vectorList.get(i) + " ");
				}
			
			   
				pWriter.close();
		} 
	 
}
