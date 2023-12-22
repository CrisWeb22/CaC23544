package ar.com.codoacodo.interfaces;

public class MainLoggerPrueba {

	public static void main(String[] args) {
		
		String target = getTargetFromDB();
		LoggerManager lm = new LoggerManager(target);
		ILogger logger = lm.getLogger();
		logger.log();
		 
		 

	}
	
	public static String getTargetFromDB(){
		 return "C";
	 }

}
