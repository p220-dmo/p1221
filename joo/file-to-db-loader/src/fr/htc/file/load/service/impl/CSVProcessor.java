package fr.htc.file.load.service.impl;

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
		Sale sale = new Sale(100, 3, 2.5f, "MT100-1");
		sales.add(sale);
		
		return sales;
	}

}
