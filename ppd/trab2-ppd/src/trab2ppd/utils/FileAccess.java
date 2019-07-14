package trab2ppd.utils;


import java.io.*;



/**
 * All file access from this solution is handled by this class.
 */
public class FileAccess
{
	/**
	 * Loads the a file and returns its lines as a String[].
	 * @param filename is the path to the desired read location.
	 * @throws IOException failed to read file from disk.
	 */
	public static String[] readLines (String filename) throws IOException
	{
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String[] lines = br.lines().toArray(String[]::new);
		
		br.close();
		return lines;
	}

	/**
	 * Loads the a file and returns its contents as a byte[].
	 * @param filename is the path to the desired read location. 
	 * @throws IOException failed to read file from disk.
	 */
	public static byte[] readFile(String filename) throws IOException 
	{

		File file = new File(filename);
		InputStream is = new FileInputStream(file);
		long length = file.length();

		  //creates array (assumes file length<Integer.MAX_VALUE)
		byte[] data = new byte[(int)length];

		int offset = 0;
		int count = 0;

		while((offset < data.length) && (count = is.read(data, offset, data.length-offset)) >= 0 ){
			offset += count;
		}
		is.close();
		return data;
	}

	/**
	 * Saves byte data into a file.
	 * @param filename is the path to the desired save location. 
	 * @param data is the content to be stored into file.
	 * @throws IOException failed to read file from disk.
	 */
	public static void saveFile(String filename, byte[] data) throws IOException 
	{

		FileOutputStream out = new FileOutputStream(filename);
		out.write(data);
		out.close();

	}
	
	
	public static boolean byteArrayContains(byte[] outerArray, byte[] smallerArray) {
    	for(int i = 0; i < outerArray.length - smallerArray.length+1; ++i) {
    		boolean found = true;
    		for(int j = 0; j < smallerArray.length; ++j) {
    			if (outerArray[i+j] != smallerArray[j]) {
    				found = false;
    				break;
    			}
    		}
    		if (found) return true;
    	}
    	return false;
    }  

}