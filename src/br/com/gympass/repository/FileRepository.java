package br.com.gympass.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileRepository {

	public List<String> readFile(String filename) throws IOException {
		List<String> records = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));
		String line;
		while ((line = reader.readLine()) != null) {
			records.add(line);
		}
		reader.close();
		return records;
	}

}
