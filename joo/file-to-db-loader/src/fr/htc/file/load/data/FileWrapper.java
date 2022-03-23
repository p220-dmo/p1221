package fr.htc.file.load.data;

import java.io.File;

public class FileWrapper {
	private File file;
	private String path;

	public FileWrapper(String path) {
		this.file = new File(path);
		this.path = path;
	}

	public FileWrapper(File file) {
		this.file = file;
	}

	public String getExtension() {

		return this.path.substring(this.path.lastIndexOf(".") + 1).toUpperCase();
	}

	// getter & setters

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
