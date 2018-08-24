package nebula.tinyasm.sample.ClassBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MethodHeaderSample {

	public void throwException() throws IOException {
		File file;
		FileInputStream fin;
		file = new File("./");
		if (file.exists()) {
			fin = new FileInputStream(file);
			fin.read();
			fin.close();
		}
	}

}
