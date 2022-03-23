package fr.htc.file.load.utils;

import static fr.htc.file.load.common.Constants.CSV;
import static fr.htc.file.load.common.Constants.JSON;
import static fr.htc.file.load.common.Constants.XML;

import fr.htc.file.load.service.Processor;
import fr.htc.file.load.service.impl.CSVProcessor;
import fr.htc.file.load.service.impl.DefaultProcessor;
import fr.htc.file.load.service.impl.JSONProcessor;
import fr.htc.file.load.service.impl.XMLProcessor;

public class FileProcessorFactory {

	public static Processor newInstance(String extension) {

		switch (extension) {
		case CSV:
			return new CSVProcessor();
		case XML:
			return new XMLProcessor();
		case JSON:
			return new JSONProcessor();
		default:
			return new DefaultProcessor();
		}
	}

}
