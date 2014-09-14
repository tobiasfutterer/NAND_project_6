import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	private FileReader hackReader;

	public Parser(FileReader hackInput) {
		hackReader = hackInput;
	}

	public String parseInputFile() throws IOException {
		String binaryCommand, parsedString;
		parsedString = "";
		Command c;
		SymbolTable s = new SymbolTable();

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(hackReader);
		String strLine;
		ArrayList<String> ans = new ArrayList<String>();
		while ((strLine = br.readLine()) != null) {
			if (strLine.length() > 0 && strLine.contains("/"))
				strLine = strLine.substring(0, strLine.indexOf("//"));
			strLine = strLine.replaceAll("\\s+", "");
			if (strLine.length() > 0)
				ans.add(strLine);
		}

		int counter = 0;
		// load L_COMMANDs into SymbolTable
		for (String result : ans) {
			c = new Command(result);
			if (c.commandType() == "L_COMMAND")
				s.addEntry(c.commandSymbol(), counter);
			if (c.commandType() != "L_COMMAND")
				counter += 1;
		}
		// add A_COMMAND_symbols (NOT INTEGERS) to  SymbolTable
		for (String result : ans) {

			c = new Command(result);
			if (c.commandType() != "L_COMMAND")
				s.addEntry(c.commandSymbol());
		}
		
		// translate Assembly to Binary Code
		for (String result : ans) {
			c = new Command(result, s);
			binaryCommand = c.binaryCommand();
			if (binaryCommand != null && !binaryCommand.isEmpty()) {
				sb.append(binaryCommand);
				sb.append(System.lineSeparator());
			}
		}
		parsedString = sb.toString();

		return parsedString;
	};
}
