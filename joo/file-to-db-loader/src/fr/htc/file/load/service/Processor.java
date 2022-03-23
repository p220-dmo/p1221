package fr.htc.file.load.service;

import java.util.List;

import fr.htc.file.load.data.FileWrapper;
import fr.htc.file.load.data.Sale;

public interface Processor {

	public List<Sale> process(FileWrapper file);

}
