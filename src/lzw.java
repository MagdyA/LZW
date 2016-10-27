import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class lzw {
	
	private int index(String s,ArrayList<String> arr ){
		for(int i=0;i<arr.size();++i)
			if(arr.get(i).equals(s))return i;
			
		return -1;
	}
	
	public ArrayList<Integer> Compress(String DATA){
		String data=DATA;
		ArrayList<String> dic = new ArrayList<String>();
		ArrayList<Integer> com = new ArrayList<Integer>();
		
		
			for(char c=0; c < 128 ; ++c )dic.add(Character.toString(c));
			String buffer;
			int bufferSize = 0 , length=data.length();
			boolean flag = false;
			
			for(int i=0;i<length;++i){
				flag = false;
				bufferSize=1;
				buffer=data.substring(i,i+bufferSize);
				
				while(dic.contains(buffer)){
					if(i+bufferSize==length){
						
						flag  = true;
						buffer=data.substring(i,i+bufferSize);
						break;
					}
					bufferSize++;
					buffer=data.substring(i,i+bufferSize);
				}
				
				
				if(flag){
					com.add(dic.indexOf(buffer));
					break;
				}
				else{
					String temp=buffer.substring(0,buffer.length()-1);
					com.add(index(temp,dic));
					dic.add(buffer);
					if(buffer.length()-2 >= 0)
						i+=buffer.length()-2;
				}
			}
			for(int i=0;i<com.size();++i)com.set(i, com.get(i)+1);
			return com;
	}
	////////////////////////////////////////////////////////////////////////////
	
	public String Decompress(ArrayList<Integer> arr){
		
		
		ArrayList<String> words = new ArrayList<String>();
		for(char c = 0 ; c < 128 ; ++c )words.add(Character.toString(c));
		String data = "";
		int length=0;
		String last="" , w;
		
		
		for(int i=0;i<arr.size();++i){
			if(arr.get(i)>words.size())
				w=last+last.charAt(0);
			else
				 w = words.get((arr.get(i)-1)) ;
			
			data += w;
			last+=w.charAt(0);
			if(i!=0)
				words.add(last);
			last = w;
			}
		

return data;
}
}
