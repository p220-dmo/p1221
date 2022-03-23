package fr.htc.file.load;

import java.util.List;

import fr.htc.file.load.dao.SaleDao;
import fr.htc.file.load.data.FileWrapper;
import fr.htc.file.load.data.Sale;
import fr.htc.file.load.service.Processor;
import fr.htc.file.load.utils.FileProcessorFactory;
import fr.htc.file.load.utils.FileReader;

public class BatchLuncher {

	public static void main(String[] args) {
		// 1- Extract data from file
		final String path = args[0];
		FileWrapper file = FileReader.read(path);

		// 2- Transform data depends to file type
		Processor processor = FileProcessorFactory.newInstance(file.getExtension());
		List<Sale> sales = processor.process(file);
		
		
		// 3- Load Data on Data base
		SaleDao saleDao = new SaleDao();
		for (Sale sale : sales) {
			saleDao.save(sale);
		}

	}

}
