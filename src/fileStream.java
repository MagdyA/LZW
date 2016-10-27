import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class fileStream {
	
	public void comp(String filePath){
		File file = new File(filePath+".txt");
		String data="";
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine())data+=in.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		lzw l = new lzw();
		ArrayList<Integer>arr = l.Compress(data);
		File f = new File("z-"+filePath+".txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter pw = new PrintWriter(f);
			for(int k :arr)pw.print(k+" ");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void decomp(String filePath){
		File file = new File(filePath+".txt");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			Scanner in = new Scanner(file);
			while(in.hasNext())
				arr.add(in.nextInt());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		lzw l = new lzw();
		String data = l.Decompress(arr);
		File f = new File("De-"+filePath+".txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.print(data);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
