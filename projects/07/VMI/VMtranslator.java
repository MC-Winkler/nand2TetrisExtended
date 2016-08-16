package nand2tetrisVMI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VMtranslator {

	private static CodeWriter theCodeWriter;

	public static void main(String args[]) {

		File fileOrDir = new File(args[0]);
		String outputFileName = args[0].split("\\.")[0] + ".asm";
		BufferedWriter bufferedWriter;

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
			theCodeWriter = new CodeWriter(bufferedWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (fileOrDir.isFile()) {
			if (!(args[0].split("\\.")[1].equals("vm"))) {
				throw new IllegalArgumentException("file type must be .vm");
			} else {
				System.out.println("process single file");
				processFile(fileOrDir);
				theCodeWriter.finish();
			}
		} else if (fileOrDir.isDirectory()) {
			System.out.println("processing directory");
			for (File file : fileOrDir.listFiles()) {
				if (file.isFile()) {
					processFile(file);
				}
			}
			theCodeWriter.finish();
		} else {
			throw new IllegalArgumentException("input not recognzied as file or folder");
		}
	}

	private static void processFile(File file) {

		Parser parser = new Parser(file);

		while (parser.hasMoreCommands()) {
			if (parser.commandType().equals("C_ARITHMETIC")) {
				theCodeWriter.writeArithmetic((parser.arg1()));
			} else if (parser.commandType().equals("C_PUSH") || parser.commandType().equals("C_POP")) {
				theCodeWriter.writePushPop(parser.commandType(), parser.arg1(), parser.arg2());
			}
		}
	}
}