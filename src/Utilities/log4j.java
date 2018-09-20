package utilities;

import org.apache.log4j.Logger;

public class log4j {
	
	static Logger log;
	public log4j()
	{
		log=Logger.getLogger(log4j.class);
	}
	
	public static void infoLog(String message)
	{
		log.info(message);
	}

	
	public static void errorLog(String message)
	{
		log.error(message);
	}

}
