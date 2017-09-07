/**
 * 
 */
package com.asc.bm.address.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

/**
 * @author skunchakuri
 *
 */
public class CopyFilesUtility {
	
	public static File[] listFilesMatching(File root, String regex) {
	    if(!root.isDirectory()) {
	        throw new IllegalArgumentException(root+" is no directory.");
	    }
	    final Pattern p = Pattern.compile(regex); // careful: could also throw an exception!
	    return root.listFiles(new FileFilter(){
	        @Override
	        public boolean accept(File file) {
	            return p.matcher(file.getName()).matches();
	        }
	    });
	}
	
	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//copy file conventional way using Stream
        long start = System.nanoTime();
        File source = new File("C:/Users/skunchakuri/Desktop/Screen shots/Validations/");
        File dest = new File("C:/Users/skunchakuri/Desktop/Screen shots/Validations1/");
        
        File[] files = listFilesMatching(source,"\\*.*");

        for (File newfile : files){
        	 //using Java 7 Files class
            source = new File("C:/Users/skunchakuri/Desktop/Screen shots/Validations/"+newfile.getName());
            dest = new File("C:/Users/skunchakuri/Desktop/Screen shots/Validations1/"+newfile.getName());
            start = System.nanoTime();
            copyFileUsingJava7Files(source, dest);
            System.out.println("Time taken by Java7 Files Copy = "+(System.nanoTime()-start));   
        }
            
    }
	

}
