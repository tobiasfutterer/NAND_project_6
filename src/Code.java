
public class Code {
private String code;
	public Code(String codeLine) {
		code=codeLine;
	}
	
	private String comp(){
		String comppart = "";
		if(code.contains("=")) comppart=code.substring(code.indexOf("=")+1);
		else if(code.contains(";")) comppart=code.substring(0,code.indexOf(";"));
		switch (comppart) {
		case "0":			
			return "0101010";
		case "1":			
			return "0111111";
		case "-1":			
			return "0111010";
		case "D":			
			return "0001100";
		case "A":			
			return "0110000";
		case "M":			
			return "1110000";
		case "!D":			
			return "0001101";
		case "!A":			
			return "0110001";
		case "!M":			
			return "1110001";
		case "-D":			
			return "0001111";
		case "-A":			
			return "0110011";
		case "-M":			
			return "1110011";
		case "D+1":			
			return "0011111";
		case "A+1":			
			return "0110111";
		case "M+1":			
			return "1110111";
		case "D-1":			
			return "0001110";
		case "A-1":			
			return "0110010";
		case "M-1":			
			return "1110010";
		case "D+A":			
			return "0000010";
		case "D+M":			
			return "1000010";
		case "D-A":			
			return "0010011";
		case "D-M":			
			return "1010011";
		case "A-D":			
			return "0000111";
		case "M-D":			
			return "1000111";
		case "D&A":			
			return "0000000";
		case "D&M":			
			return "1000000";
		case "D|A":			
			return "0010101";
		case "D|M":			
			return "1010101";
		default:
			return "0000000";
		}
	}
	private String dest(){
		String destpart = "";
		if(code.contains("=")) destpart=code.substring(0,code.indexOf("="));
		switch (destpart) {
		case "M":
			return "001";
		case "D":
			return "010";
		case "MD":
			return "011";
		case "A":
			return "100";
		case "AM":
			return "101";
		case "AD":
			return "110";
		case "AMD":
			return "111";
		default:
			return "000";
		}
	}
	private String jump(){
		String jumppart = "";
		if(code.contains(";")) jumppart=code.substring(code.indexOf(";")+1);
		switch (jumppart) {
		case "JGT":
			return "001";
		case "JEQ":
			return "010";
		case "JGE":
			return "011";
		case "JLT":
			return "100";
		case "JNE":
			return "101";
		case "JLE":
			return "110";
		case "JMP":
			return "111";
		default:
			return "000";
		}
	}
	
	public String binaryCommand(){
		return String.format("%16s", comp()+dest()+jump()).replace(' ', '1');
	}

}
