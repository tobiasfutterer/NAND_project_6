import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Assembler {
private static Parser p1;
	
	public static void main(String[] args) {
		if (hasCommands(args)){
			try {
				File f= new File(args[0]);	
//		if (true){
//			String test  = "C:\\Projects\\00_Eigenes\\Built Your Own Computer\\nand2tetris\\projects\\06\\max\\Max.asm";
//			try {
//				File f= new File(test);		
				p1 = new Parser(new FileReader(f));				
				try {
					PrintWriter writer = new PrintWriter(f.getAbsoluteFile().getParentFile().getAbsolutePath() +"\\" + f.getName().substring(0,f.getName().indexOf(".")) + ".hack", "UTF-8");
					writer.print (p1.parseInputFile());
					writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}			
		}
		else System.out.println("has no commands");
	
	}
	
	public static boolean hasCommands(String[] args)
	{
		if(args.length>0) return true;
		return false;
	}

	public static boolean hasMoreCommands(String[] args)
	{
		if(args.length>1) return true;
		return false;
	}


}
