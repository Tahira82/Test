package org.extedo.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StringHelper {

	private BufferedReader br;

	public StringHelper(String filePath) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(new File(filePath)));
	}

	List<String> stringLst = new ArrayList<String>();
	List<String> commentLst = new ArrayList<String>();

	public List<String> getAllComents() {
		return commentLst;
	}

	public List<String> getAllStrings() {
		return stringLst;
	}
	
	public long getTotalStringsCount() {
		return getCount(stringLst);
	}

	public long getTotalCommentsCount() {
		return getCount(commentLst);
	}
	

	public String findComments(String line) {
		if (!line.contains("#"))
			return null;

		return line.substring(line.indexOf("#") + 1, line.length());
	}

	public void process() throws Exception {

		String line = null;

		while ((line = br.readLine()) != null) {
			List<String> stringsFromLine = findString(line);
			String comment = findComments(line);
			stringLst.addAll(stringsFromLine);
			if (comment != null)
				commentLst.add(comment);
		}
	}

	public List<String> findString(String line) {

		List<String> stringsFromLine = new ArrayList<String>();

		int startingIndex = line.indexOf("\"");

		while(startingIndex != -1) {

			int nextIndex = line.indexOf("\"", startingIndex + 1);

			if (nextIndex == -1)
				break;

			String subSequence = line.substring(startingIndex + 1, nextIndex);
			stringsFromLine.add(subSequence);
			startingIndex = line.indexOf("\"", nextIndex + 1);
		}
		return stringsFromLine;
	}
	

	public long getCount(List<String> dataList) {
		long count = 0;
		for(String str: dataList) {
			count += str.length();
		}
		
		return count;
	}

}
