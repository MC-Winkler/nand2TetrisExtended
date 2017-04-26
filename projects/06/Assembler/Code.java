// Michael Winkler
// 6.26.16

package nand2tetrisAssembler;

import java.util.HashMap;

public class Code {

	private static HashMap<String, String> destination;
	private static HashMap<String, String> jump;
	private static HashMap<String, String> computation;
	
	static{
		destination = new HashMap<String, String>();
		jump = new HashMap<String, String>();
		computation = new HashMap<String, String>();
		
		destination.put("null", "0000");
		destination.put("M", "0010");
		destination.put("D", "0100");
		destination.put("MD", "0110");
		destination.put("A", "1000");
		destination.put("AM", "1010");
		destination.put("AD", "1100");
		destination.put("AMD","1110");
		
		//My additions - writing to disk
		destination.put("E","0001");
		destination.put("DE","0101");
		destination.put("AE", "1001");
		destination.put("ADE", "1101");
		
		jump.put("null", "000");
		jump.put("JGT", "001");
		jump.put("JEQ", "010");
		jump.put("JGE", "011");
		jump.put("JLT", "100");
		jump.put("JNE", "101");
		jump.put("JLE", "110");
		jump.put("JMP", "111");
		
		computation.put("M", "10110000");
		computation.put("!M", "10110001");
		computation.put("-M", "10110011");
		computation.put("M+1", "10110111");
		computation.put("M-1", "10110010");
		computation.put("D+M", "10000010");
		computation.put("D-M", "10010011");
		computation.put("M-D", "10000111");
		computation.put("D&M", "10000000");
		computation.put("D|M", "10010101");
		
		computation.put("E", "01110000");
		computation.put("!E", "01110001");
		computation.put("-E", "01110011");
		computation.put("E+1", "01110111");
		computation.put("E-1", "01110010");
		computation.put("D+E", "01000010");
		computation.put("D-E", "01010011");
		computation.put("E-D", "01000111");
		computation.put("D&E", "01000000");
		computation.put("D|E", "01010101");
		
		computation.put("0", "0101010");
		computation.put("1", "0111111");
		computation.put("-1", "0111010");
		computation.put("D", "0001100");
		computation.put("A", "0110000");
		computation.put("!D", "0001101");
		computation.put("!A", "0110001");
		computation.put("-D", "0001111");
		computation.put("-A", "0110011");
		computation.put("D+1", "0011111");
		computation.put("A+1", "0110111");
		computation.put("D-1", "0001110");
		computation.put("A-1", "0110010");
		computation.put("D+A", "0000010");
		computation.put("D-A", "0010011");
		computation.put("A-D", "0000111");
		computation.put("D&A", "0000000");
		computation.put("D|A", "0010101");
	}
	
	protected static String dest(String assembly) {
		return destination.get(assembly);
	}
	
	protected static String jump(String assembly) {	
		return jump.get(assembly);
	}
	
	protected static String comp(String assembly) {
		return computation.get(assembly);
	}
}
