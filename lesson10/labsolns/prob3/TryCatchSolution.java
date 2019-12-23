package lesson10.labsolns.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryCatchSolution {
	
	List<String> processList(List<String> list) {

	    return list.stream()
	    		.map(l -> {
	    			String ret =null;
	    			try {
	    				ret = validateString(l);
	    			}catch( LenghtException e)
	    			{
	    				throw new RuntimeException(e);
	    			}
	    			return ret;
	    		})
	    		.collect(Collectors.toList());
	    
	    		   
	 
	}
	
	private String validateString(String x) throws LenghtException
	{
		if(x.length()>3) throw new LenghtException();
		return x;
	}
	

	public static void main(String[] args) {
		TryCatchSolution tcs = new TryCatchSolution();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet", "oop");
		System.out.println(tcs.processList(words1));
	}
	
	class LenghtException extends Exception
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		LenghtException()
		{
			super("Word lenght more than 3!!");
		}
		LenghtException(String msg)
		{
			super(msg);
		}
		
		LenghtException(Throwable throwable)
		{
			super(throwable);
		}
		
		LenghtException(String msg, Throwable throwable)
		{
			super(msg,throwable);
		}
		
	}
	
}
