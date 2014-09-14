import java.util.Hashtable;
public class SymbolTable {
private Hashtable<String,Integer> symbolTable;
private Integer lastno;
	public SymbolTable() {
		symbolTable = new Hashtable<String,Integer>();
		this.addEntry("SP",0);
		this.addEntry("LCL",1);
		this.addEntry("ARG",2);
		this.addEntry("THIS",3);
		this.addEntry("THAT",4);
		for (int i = 0; i < 16; i++) {
			this.addEntry("R"+Integer.toString(i),i);
		}
		this.addEntry("SCREEN",16384);
		this.addEntry("KBD",24576);
		lastno = 16;
	}
	
	public void addEntry(String symbol, Integer address){
		if (symbol != "") 
			if (!contains(symbol)){
				symbolTable.put(symbol, address);
			}
	}
	public void addEntry(String symbol){
		if (!contains(symbol) && symbol != ""){
			symbolTable.put(symbol, lastno);
			lastno += 1;
		}
	}
	public boolean contains(String symbol){
		if (symbolTable.containsKey(symbol)) return true;
		return false;
	}
	public Integer getAddress(String symbol){
		return Integer.parseInt(symbolTable.get(symbol).toString());
	}
}
