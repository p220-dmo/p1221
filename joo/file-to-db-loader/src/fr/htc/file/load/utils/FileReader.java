package fr.htc.file.load.utils;

import fr.htc.file.load.data.FileWrapper;

public class FileReader {

	public static FileWrapper read(final String path) {
		return new FileWrapper(path);

	}

}
