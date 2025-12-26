package genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

	public String readDataFromPropertFile(String key) throws IOException
	{
//		FileInputStream f = new FileInputStream(IPathConstants.filePath);
		Properties pObj = new Properties();
//		pObj.load(f);
		String value = pObj.getProperty(key);
		return value;
	}
	}

