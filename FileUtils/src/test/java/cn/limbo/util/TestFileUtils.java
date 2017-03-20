package cn.limbo.util;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Created by limbo on 2017/3/20.
 */
public class TestFileUtils {

	@Test
	public void testStaticRead(){
		String s = FileUtils.read("/Users/limbo/Documents/Project/Java/FileUtils/src/main/java/cn/limbo/util/FileUtils.java");
		System.out.println(s);
	}

	@Test
	public void testStaticWrite(){
		String s = FileUtils.read("/Users/limbo/Documents/Project/Java/FileUtils/src/main/java/cn/limbo/util/FileUtils.java");
		FileUtils.write("test.txt",s);
	}

	@Test
	public void testWrite(){
		FileUtils f = new FileUtils("test.txt");
		f.write("test2.txt");
	}

	@Test
	public void testSplit(){
		TreeSet<String> words = new TreeSet<>(new FileUtils("test.txt","\\W+"));
		System.out.println(words);
	}
}
