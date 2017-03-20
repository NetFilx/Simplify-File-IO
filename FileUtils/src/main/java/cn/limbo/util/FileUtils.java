package cn.limbo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Simplify File I/O operations
 * Created by limbo on 2017/3/20.
 */
public class FileUtils extends ArrayList<String>{

	/**
	 * Read a file as a single string
	 * @param filePath file path
	 * @return file content
	 */
	public static String read(String filePath) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(filePath).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	/**
	 * Write a single file in one method call
	 * @param filePath file path
	 * @param text the content you want to write in
	 */
	public static void write(String filePath, String text){
		try{
			PrintWriter out =  new PrintWriter(new File(filePath).getAbsoluteFile());
			try{
				out.print(text);
			}finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Read a file , split by any regular expression
	 * @param filePath file path
	 * @param splitter splitter
	 */
	public FileUtils(String filePath,String splitter){
		super(Arrays.asList(read(filePath).split(splitter)));
		if(get(0).equals(""))
			remove(0);
	}

	/**
	 * Normally read by line
	 * @param filePath
	 */
	public FileUtils(String filePath){
		this(filePath,"\n");
	}

	public void write(String filePath){
		try{
			PrintWriter out =  new PrintWriter(new File(filePath).getAbsoluteFile());
			try{
				for(String item : this)
					out.println(item);
			}finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
