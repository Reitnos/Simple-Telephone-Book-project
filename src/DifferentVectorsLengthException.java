import java.util.ArrayList;
import java.util.List;

public class DifferentVectorsLengthException extends Exception {
	
	List<Vector> vectorList = new ArrayList<Vector>()  ;
	
	public DifferentVectorsLengthException() {
		
		super("No error message specified, an error occured");
		
		
	}
	public DifferentVectorsLengthException(String msg, List<Vector> vectors) {
		super(msg);
		
		for(int i = 0; i < vectors.size() ; i++) {
			vectorList.add(vectors.get(i));
		}
		
	}
	public void PrintDifferentVectorsLengthException() {
		
	
		for(int i = 0; i < vectorList.size(); i++) {
			
			System.out.print("Vector " + i + ", length: " + vectorList.get(i).getSize() + "\n");
		}
		
		System.out.println("Enter new vectors ...");
	}
}
 