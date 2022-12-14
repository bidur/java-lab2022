import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipRetrive{
	
	public static void main(String args[]){
	
		try {
		    // Open the ZIP file
		    String inFilename = "outfile.zip";
		    ZipInputStream in = new ZipInputStream(new FileInputStream(inFilename));
			ZipFile zf= new ZipFile(inFilename);
			int a=0;
			OutputStream out=null;
			for (Enumeration em = zf.entries(); em.hasMoreElements();) {
				
				String outFilename = em.nextElement().toString();
				// Get the  entry
			    ZipEntry entry = in.getNextEntry();

			   // Open the output file
			   
			    out = new FileOutputStream(outFilename);

			 // Transfer bytes from the ZIP file to the output file
			    byte[] buf = new byte[1024];
			    int len;
			    while ((len = in.read(buf)) > 0) {
			        out.write(buf, 0, len);
			    }
				a=a+1;
			}

		    if(a>0)
				System.out.println("Files Unzipped");

		    // Close the streams
		    out.close();
		    in.close();
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

}
