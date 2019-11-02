package br.com.gympass.util;

public class ConverterUtil {
	
	public static int convertStringToInt(String string) {
		if(string.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(string.replaceAll("\\D+", ""));
	}
	
	public static Double convertStringToDouble(String string) {
		if(string.isEmpty()) {
			return 0.0;
		}
		return Double.parseDouble(string.replaceAll(":", ""));
	}

}
