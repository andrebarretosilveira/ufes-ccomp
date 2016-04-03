package Prog3_Trab1;

public final class Tester {

	private static final String DAT_PATH = "inventario.dat";
	
	public static void main(String[] args) {
		MediaCollection mediaCollection = new MediaCollection();
		ConsoleInput consoleInput = new ConsoleInput(args);
		CsvInput csvInput = new CsvInput(mediaCollection);
		Report report;
		String filePath;
		
		if(args.length == 0) return;
		
		try {
            if(consoleInput.getFlag() == ConsoleInput.WRITE_ONLY) {
        		mediaCollection = MediaCollection.readObjectFromFile(Tester.DAT_PATH);
        		report = new Report(mediaCollection);
            }
            else {
            	report = new Report(mediaCollection);
            	
				// Read Genres
				filePath = consoleInput.getFilePath("-g");
				csvInput.readGenreCsv(filePath);
				
				// Read People
		    	filePath = consoleInput.getFilePath("-p");
		    	csvInput.readPersonCsv(filePath);
		    	
		    	// Read Medias
		    	filePath = consoleInput.getFilePath("-m");
		    	csvInput.readMediaCsv(filePath);
		    	
		    	// Read Loans
		    	filePath = consoleInput.getFilePath("-e");
		    	csvInput.readLoanCsv(filePath);
            }
		
			if(consoleInput.getFlag() == ConsoleInput.READ_ONLY) {
				mediaCollection.writeObjectToFile(Tester.DAT_PATH);
			}
			else {
				report.createStatisticsReport("1-estatisticas.txt");
				report.createMediasByPersonReport("2-porpessoa.csv");
				report.createLoanReport("3-emprestimos.csv");
				report.createWishListReport("4-wishlist.csv");
			}
		}
		catch (ProgramException e) { return; }
	}
}
