package fr.htc.file.load.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.htc.file.load.data.FileWrapper;
import fr.htc.file.load.data.Sale;
import fr.htc.file.load.service.Processor;

public class XMLProcessor implements Processor {

	@Override
	public List<Sale> process(FileWrapper file) {
		System.out.println("Process XML file : " + file.getFile().getName());
		
		return new ArrayList<Sale>();
	}

}
