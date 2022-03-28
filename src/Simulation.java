import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.lang.model.type.PrimitiveType;



public class Simulation {

	public static void main(String[] args) {
						
			boolean vectorsNotReadyToCompute = true;
			List<Vector> vectorList = new ArrayList<Vector>();	
			
			// check if they are all same length
			
			while(vectorsNotReadyToCompute) {
				
					try {
						vectorList =  createVectors();
						checkVectorLengths(vectorList); // if this throws exception, process is repeated.
						vectorsNotReadyToCompute = false;
						
					} catch (DifferentVectorsLengthException e) {
						
						System.out.println(e.getMessage());
						e.PrintDifferentVectorsLengthException();
					
					}
			}
			
			
			
			Vector additionVector = vectorList.get(0);
			
		
				
			for(int i = 1 ; i < vectorList.size(); i++) {
						
					
							
						additionVector.addVectors(vectorList.get(i));
					
						
						
			} 
			
			writeResultToFile(additionVector);
		
				
}

	private static void writeResultToFile(Vector additionVector) {
		try {
			
			additionVector.writeToTxtFile();
		} catch (Exception e) {
			System.out.print("Exception occured while writing the summation vector to the file");
		}
	}
 
	static boolean checkVectorLengths(List<Vector> vectorList) throws DifferentVectorsLengthException {
		
		int firstLength = vectorList.get(0).getSize();
		for(int i = 1; i < vectorList.size() ; i++) {
			if(firstLength == vectorList.get(i).getSize()) {
				continue;
			}
			else { 
				String errMessageString = "Given vectors are not equal in length.";
				throw new DifferentVectorsLengthException(errMessageString,vectorList);
			
			}
		}
		return true;
	}

	private static List<Vector> createVectors() {
		
		// create 3 empty vectors and add to the returnlist.
		Vector vec1 = new Vector();
		Vector vec2 = new Vector();
		Vector vec3 = new Vector();
		List<Vector> returnList = new ArrayList<Vector>();
		returnList.add(vec1);
		returnList.add(vec2);
		returnList.add(vec3);
		
			
		// read from console.
		Scanner scanner = new Scanner(System.in);
		String readString = scanner.nextLine();
		
		int enterCount = 0;
		while(enterCount < 3) {
			List<Integer> tempVector = new ArrayList<Integer>();
		   
		    // trim the given vectors by the spaces and create an array of them.
		    String[] splitStr = readString.trim().split("\\s+");
		    List<String> entryList = Arrays.asList(splitStr);  
		    
		    parseEntryAndCreateTemporaryVector(tempVector, entryList);
		    
		    for(int i = 0; i < tempVector.size(); i++) {
		    	returnList.get(enterCount).addElement(tempVector.get(i));
		    	
		    }
		 
		    if (readString.isEmpty()) {
		        System.out.println("No vector given");
		    }
		    
		    

		    if (scanner.hasNextLine()) {
		        readString = scanner.nextLine();
		        enterCount++;
		    } else {
		        readString = null;
		    }
		    
		}
		
		return returnList; 
	}

	private static void parseEntryAndCreateTemporaryVector(List<Integer> tempVector, List<String> entryList) {
		for(int i = 0 ; i < entryList.size() ; i++) {
			
			
		 	try {
		       
		 		// try parsing to integer, if failed, continue to the other entries.
		    	int currentEntry = Integer.parseInt(entryList.get(i));
		    	tempVector.add(currentEntry);
		    	
			} catch (NumberFormatException e) {
		    	continue;
			}
		
		 	

		}
	}

}
