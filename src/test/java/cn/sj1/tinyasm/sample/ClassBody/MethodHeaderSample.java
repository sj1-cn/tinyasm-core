package cn.sj1.tinyasm.sample.ClassBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MethodHeaderSample {

	public void throwException() throws IOException {
		File file;
		FileInputStream fileInputStream;
		file = new File("./");
		if (file.exists()) {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read();
			fileInputStream.close();
		}
	}

}
