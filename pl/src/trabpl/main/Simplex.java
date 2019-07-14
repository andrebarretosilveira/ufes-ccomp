package trabpl.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;

import trabpl.algorithm.Tableau;



public class Simplex {
	
	public static Tableau readTableau(InputStream input) throws Exception {
		
		boolean console = false;
		if(input == System.in) {
			console = true;
		}
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(input).useLocale(Locale.US);
		
		if(console) System.out.println("Insira o Tableau para começar.\n");
		
		//Get type of PPL (max or min)
		if(console) System.out.print("Tipo do problema (max ou min): ");
		String problemType = scanner.nextLine();

		if(!problemType.equals("max") && !problemType.equals("min")) {
			scanner.close();
			throw new Exception("Tipo de problema inexistente. Deve ser 'min' ou 'max'");
		}
		
		//Get number of restrictions and number of variables
		if(console) System.out.print("Dimensões da matriz (n m): ");
		int numberOfRestrictions = scanner.nextInt();		
		int numberOfVariables = scanner.nextInt();
		scanner.nextLine(); //consume newline buffer

		//Get Objective function
		if(console) System.out.print("z = ");
		double[] objectiveFunction = new double[numberOfVariables];
		for(int i=0; i<numberOfVariables; i++) {
			objectiveFunction[i] = scanner.nextDouble();

			if(problemType.equals("min")) {
				objectiveFunction[i] *= (-1);
			}
		}
		scanner.nextLine(); //consume newline buffer

		//Read the restrictions
		if(console) System.out.println("Restrições: ");
		double[][] naturalVariables = new double[numberOfRestrictions][numberOfVariables];
		double[] rightSideVariables = new double[numberOfRestrictions];
		String[] restrictionOperators = new String[numberOfRestrictions];

		for(int i=0; i < numberOfRestrictions; i++) {
			String restrictionLine = scanner.nextLine();
			String[] restriction = restrictionLine.split(" ");
			
			//Get right side variable
			rightSideVariables[i] = Double.parseDouble(restriction[numberOfVariables + 1]);
			
			//Get the restriction signal
			restrictionOperators[i] = restriction[numberOfVariables];
			
			

			
			//Get natural variables
			for(int j=0; j < numberOfVariables; j++) {
				double variable = Double.parseDouble(restriction[j]);
				naturalVariables[i][j] = variable;
				if(rightSideVariables[i] <= 0 && !restrictionOperators[i].equals("<=")) {
					naturalVariables[i][j] *= -1.0;
				}
			}
			
			if(rightSideVariables[i] <= 0) {
				
				if(restrictionOperators[i].equals(">=")) {
					restrictionOperators[i] = "<=";
					rightSideVariables[i] *= -1;
				}
				if(restrictionOperators[i].equals("=")) {
					rightSideVariables[i] *= -1;
				}
			}						
		}
		
		//Finished input/file reading
		scanner.close();

		
		//Add slack and artificial variables based on restriction operators
		double[] slackVariables = new double[numberOfRestrictions];
		double[] artificialVariables = new double[numberOfRestrictions];
		int numberOfArtificialVariables = 0;
		int numberOfSlackVariables = 0;
		
		for(int i=0; i < numberOfRestrictions; i++) {
			String operator = restrictionOperators[i];
		    switch (operator) {
		    	case "<=":
		    		slackVariables[i] = 1.0;
		    		artificialVariables[i] = 0.0;
		    		numberOfSlackVariables++;
		    		break;
		    	case ">=":
		    		slackVariables[i] = -1.0;
		    		artificialVariables[i] = 1.0;
		    		numberOfArtificialVariables++;
		    		numberOfSlackVariables++;
		    		break;
		    	default:
		    		artificialVariables[i] = 1.0;
		    		numberOfArtificialVariables++;
		    }
		}
		
		Tableau tableau = new Tableau(problemType, numberOfRestrictions, numberOfVariables,
				numberOfSlackVariables, numberOfArtificialVariables,
				objectiveFunction, naturalVariables, rightSideVariables,
				slackVariables, artificialVariables);
		
		return tableau;
		
	}
	
	public static void main(String[] args) {
		
		Tableau tableau;

		try {
			
			if(args.length < 1) {
				System.out.println("* Use 'java trabpl.main.Simplex [arquivo]' para ler PPL de um arquivo *\n\n");
				// Read tableau from console
				tableau = readTableau(System.in);
			}
			else {
				// Read tableau from file
				String filepath = args[0];
				File file = new File(filepath);
				tableau = readTableau(new FileInputStream(file));
			}
			
		} catch (Exception e) {
			System.err.println("\n" + e.getMessage());
			e.printStackTrace();
			System.err.println("Erro na leitura do PPL. Abortando programa.");
			return;
		}			

		System.out.println("\n----------Tableau inicial--------\n");
		tableau.printTableau();
					
		tableau.solve(); 
		
		System.out.println("\n----------Resultado--------\n");
		tableau.printSolution();
		tableau.printSolutionType();
	}
}
