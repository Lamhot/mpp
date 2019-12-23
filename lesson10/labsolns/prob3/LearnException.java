package lesson10.labsolns.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LearnException {

	List<String> processList(List<String> list) {
	    return list.stream()
	    		.map((String x)-> inputStringByHelper(x))
	               .collect(Collectors.toList());
	 
	}
	
	public static void main(String[] args) {
		FixThisSolnEasy ft = new FixThisSolnEasy();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet");
		System.out.println(ft.processList(words1));
		List<String> words2 = Arrays.asList("but", "now", "we", "have", "a", "problem");
		System.out.println(ft.processList(words2));
	}
	
	public String inputString(String input)throws InputTooLongException
	{
		if(input.length()>3) throw new InputTooLongException();
		else return input;
		
	}
	
	public String inputStringByHelper(String x)
	{
		try {
			return inputString(x);
		}catch (InputTooLongException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	class InputTooLongException extends Exception{
		
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		InputTooLongException()
		 {
			 super("Input greater than 3");
		}
		 
		 InputTooLongException(String msg)
		 {
			 super(msg);
		 }
		 
		 InputTooLongException(Throwable throwable)
		 {
			 super(throwable);
		 }
		 
		 InputTooLongException(String msg, Throwable throwable)
		 {
			 super(msg,throwable);
		 }
		
	}
}
