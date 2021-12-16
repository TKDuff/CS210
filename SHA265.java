import java.util.*;
import java.security.*;
import java.io.*;

public class SHA265{
    
    public static void main (String[] args){
    	Scanner in = new Scanner(System.in);
    	
    	int n = Integer.parseInt(in.nextLine());
    	
    	String[] wordArray = new String[n];
    	String[] array = new String[n];
    	
    	
    	for(int i = 0; i <n; i++) {
    		wordArray[i] = in.nextLine();
    		array[i] = sha256(wordArray[i]);
    		System.out.println(array[i]);
    	} 
       	
    	int highestCompare = 0;
    	int arrayNum = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			//System.out.println("array " + i + " compared to array " + j + " is " + compare(array[i], array[j]));
    			if(i != j && compare(array[i], array[j]) > highestCompare) {
    					highestCompare = compare(array[i], array[j]);
    					arrayNum = i;
    			}
    		}
    	}
    	System.out.println(wordArray[arrayNum]);
    }

    private static int compare(String s1, String s2) {
    	int count = 0;
    	int pos = 0;
    	while(pos <= 63) {
    		if ( s1.charAt(pos)  == s2.charAt(pos)) {
    			count++;
    		}
    		pos++;
    	}
    	return count;
    	
	}

	public static String sha256(String input){
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++){
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }catch(Exception e){
            return(e.toString());
        }
    }
}