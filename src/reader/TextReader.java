package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

	public String read(String fileName)
	{
		BufferedReader fileReader = null;
		String rawData = new String();
		
		try
		{
			fileReader = new BufferedReader(new FileReader(fileName));
			rawData = new String();
			rawData = fileReader.readLine();
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return rawData;
	}

}
