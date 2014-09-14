public class Command {
	private String command;
	private SymbolTable st;

	public Command(String commandLine, SymbolTable s) {
		command = commandLine;
		st = s;
	}

	public Command(String commandLine) {
		command = commandLine;
	}

	public String commandType() {
		if (command.startsWith("@"))
			return "A_COMMAND";
		else if (command.startsWith("("))
			return "L_COMMAND";
		else if (command.isEmpty())
			return "";
		else if (command.startsWith("/"))
			return "";
		else
			return "C_COMMAND";
	}

	public String commandSymbol() {
		if ((commandType() == "A_COMMAND")
				&& !isInteger(command.substring(1)))
			return command.substring(1);
		else if ((commandType() == "L_COMMAND"))
			return command.substring(1, command.length() - 1);
		else
			return "";
	}

	public String binaryCommand() {
		switch (this.commandType()) {
		case "A_COMMAND":
			return convertAtoBinary();
		case "C_COMMAND":
			return convertCtoBinary();
		default:
			return "";
		}
	}

	private String convertAtoBinary() {
		if (isInteger(command.substring(1)))
			return String.format("%16s",
					Integer.toBinaryString(new Integer(command.substring(1))))
					.replace(' ', '0');
		else
			return String.format("%16s",
							Integer.toBinaryString(st.getAddress(command
									.substring(1)))).replace(' ', '0');
	}

	private String convertCtoBinary() {
		Code c = new Code(command);
		return c.binaryCommand();
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
