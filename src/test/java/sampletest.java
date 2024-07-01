import java.io.IOException;
import java.util.ArrayList;

public class sampletest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		datadriven d= new datadriven();
		ArrayList<String> arr2=d.getData("Create User");
		arr2.stream().forEach(System.out::println);
	ArrayList<String> arrV=datadrivenpractice.getTheData("Login");
		
		arrV.stream().forEach(System.out::println);
		
	}

}
