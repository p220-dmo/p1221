package fr.htc.file.load.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import fr.htc.file.load.data.FileWrapper;
import fr.htc.file.load.data.Sale;
import fr.htc.file.load.service.Processor;


public class CSVProcessor implements Processor {

	@Override
	public List<Sale> process(FileWrapper file) {
		
		System.out.println("Process CSV file : " + file.getFile().getName());
		List<Sale> sales = new ArrayList<Sale>();
		//TODO CSV parser not implemented yet
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file.getPath()));
			
			
			
			try {
				String line;
				while ((line = bf.readLine()) !=  null) {
					
					System.out.println(line);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Sale sale = new Sale(100, 3, 2.5f, "MT100-1");
		sales.add(sale);
		
		return sales;
	}

}
