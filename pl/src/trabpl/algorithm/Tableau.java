package trabpl.algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Tableau {
		
		private double[][] tableau;
		private String problemType;
		private int numberOfRestrictions;
		private int numberOfVariables;
		private int numberOfSlackVariables;
		private int objectiveFunctionLine = 0;
		private int m; //lines
		private int n; // columns
		double[] artificialVariables;
		int[] currentBaseVarIndexes;
		ArrayList<Integer> removedLinesIndexes = new ArrayList<Integer>();
		boolean tableauSolved;
		boolean solvingArtificialFunction;
		String solutionType;
		
		public Tableau(String problemType, int numberOfRestrictions, int numberOfVariables,
				int numberOfSlackVariables, int numberOfArtificialVariables,
				double[] objectiveFunction, double[][] naturalVariables, 
				double[] rightSideVariables, double[] slackVariables, double[] artificialVariables) {
			
			this.tableauSolved = false;
			this.solvingArtificialFunction = true;
			this.solutionType = "Not solved yet";
			this.currentBaseVarIndexes = new int[numberOfRestrictions];
			this.problemType = problemType;
			this.numberOfRestrictions = numberOfRestrictions;
			this.numberOfVariables = numberOfVariables;
			this.numberOfSlackVariables = numberOfSlackVariables;
			this.artificialVariables = artificialVariables;
			
			if(numberOfArtificialVariables > 0) {
				
				this.m = numberOfRestrictions + 2;
				this.n= numberOfVariables + numberOfSlackVariables + numberOfArtificialVariables + 1;
				tableau = new double[m][n];
				//Fill Artificial Function
				for(int i=0;i<numberOfArtificialVariables;i++) {
					tableau[0][numberOfVariables + numberOfSlackVariables + 1 + i] = -1;
				}
				objectiveFunctionLine++;
				
			} else {
				
				this.m = numberOfRestrictions + 1;
				this.n = numberOfVariables + numberOfSlackVariables + 1;
				tableau = new double[m][n];
			}
			
			//Fill Objective function
			tableau[objectiveFunctionLine][0] = 0;
			for(int i=1;i<numberOfVariables + 1;i++) {
				tableau[objectiveFunctionLine][i] = objectiveFunction[i-1];
			}
			
			int line = objectiveFunctionLine + 1;
						
			//Fill natural variables
			for(int i=line;i<numberOfRestrictions+line;i++) {
				for(int j=1;j<numberOfVariables + 1;j++) {
					tableau[i][j] = naturalVariables[i- line][j-1];
				}
			}
			
			//Fill slack variables
			int firstSlack = numberOfVariables + 1;
			for (int i = 0; i < numberOfRestrictions; i++) {
				if(slackVariables[i] != 0) {
					//currentBaseVarIndexes[i] = firstSlack;
					if(slackVariables[i] > 0) {
						//currentBaseVarIndexes.add(firstSlack);
						currentBaseVarIndexes[i] = firstSlack;
					}
					tableau[i+line][firstSlack++] = slackVariables[i];
				}
			}
			
			//Fill Results 
			for(int i=line;i<numberOfRestrictions + line;i++) {
				tableau[i][0] = rightSideVariables[i- line];
			}
			
			//Fill artificial variables
			int firstArtificial = numberOfVariables +  numberOfSlackVariables + 1;

			for(int i=2;i<numberOfRestrictions+2;i++) {
				if(artificialVariables[i-2] > 0) {
					currentBaseVarIndexes[i-2] = firstArtificial;
					//currentBaseVarIndexes.add(firstArtificial);
					tableau[i][firstArtificial++] = 1;
				}
			}

		}
		
		public void solve() {
			printVBs();

			//if there's an artificial function
			if(objectiveFunctionLine > 0) {
				this.solvingArtificialFunction = true;
				
				//Phase 1
				System.out.println("\n----------Início da Fase 1--------\n");
				
				System.out.println("Normalizando função artificial...\n");
				this.normalizeArtificialFunction();
				this.printTableau();

				boolean solvedPhase1 = this.solvePhase(0, n);
				if(!solvedPhase1) return;
								
				int artificialBaseIndex = isArtificialInBase(); 
				
				while(artificialBaseIndex != -1) {
					System.out.println("\n* Variável artificial na base ao fim da Fase 1");
					System.out.println("  Iniciando procedimento de remoção...");
					int artificialLineIndex = 2 + artificialBaseIndex + removedLinesIndexes.size();
					
					boolean pivotFound = false;
					
					System.out.print("  Candidato a entrar na base: ");

					for(int i=1;i<numberOfVariables+numberOfSlackVariables;i++) {
						if(!isBaseVariable(i) && tableau[artificialLineIndex][i] != 0) {
//							System.out.println("Pivot: " + i);
							pivotFound = true;
							
							currentBaseVarIndexes[artificialLineIndex-(objectiveFunctionLine + 1)] = i;
							
							System.out.println("x" + i);
							System.out.println("  Realizando pivoteamento...\n");
							adjustPivotLine(artificialLineIndex, i);
//							System.out.println("\n Ajustando linha do pivô");
//							printTableau();
							
							for(int j=0;j<m;j++) {
								if(j == artificialLineIndex) {
									continue;
								} else {
									addLines(j, artificialLineIndex, (-1) * tableau[j][i]);
									
								}
							}
//							System.out.println("\n Linhas somadas");
							printTableau();
							
							break;
						}
					}
					if(pivotFound == false) {
						System.out.println("Nenhum. Removendo a restrição por completo...");
						removedLinesIndexes.add(artificialLineIndex);
						currentBaseVarIndexes[artificialBaseIndex] = -1;
					}
					artificialBaseIndex = isArtificialInBase(); 
//					System.out.println(artificialBaseIndex);
				}
				
				this.solvingArtificialFunction = false;
				System.out.println("\nFim da Fase 1");

				//Phase 2
				System.out.println("\n----------Inicio da Fase 2--------\n");
				printTableau();
				printVBs();

				boolean solvedPhase2 = this.solvePhase(1, numberOfVariables + numberOfRestrictions + 1);
				
				System.out.println("\nFim da Fase 2");
				
				if(solvedPhase2) this.tableauSolved = true;
			} else {
				
				this.solvingArtificialFunction = false;

				//Phase 2
				System.out.println("\n----------Inicio da Fase 2--------\n");
				printTableau();
				printVBs();
				
				boolean solved = this.solvePhase(0, numberOfVariables + numberOfRestrictions + 1);
				
				System.out.println("\nFim da Fase 2");

				if(solved) this.tableauSolved = true;
			}
						
		}
		
		public boolean solvePhase(int x, int finalIndex) {
			
			int columnIndex;
			int lineIndex;
			boolean phaseSolved = false;
			
			do {
				System.out.println("\n * Passo do algoritmo * \n");

				System.out.print("Candidato a entrar na base: ");
				columnIndex = getColumnIndex(x, finalIndex);
				if(columnIndex == -1) {
					System.out.println("Nenhum.");

					// Solving artificial function
					if(this.solvingArtificialFunction) {
						if(this.tableau[0][0] != 0.0) {
							// finished Phase 1 but artificial func is not zero: no solution
							this.solutionType = "conjunto vazio";
							phaseSolved = false;
						}
						else {
							phaseSolved = true;
						}
					}
					else {
						phaseSolved = true;
						
						if(this.hasUniqueSolution()) {
							this.solutionType = "única";
						}
						else {
							this.solutionType = "múltipla";
						}
						
						if(this.hasDegeneratedSolution()) {
							this.solutionType += " e degenerada";
						}
					}
					
					break;
				}
				System.out.println("x" + columnIndex);
				
				System.out.print("Candidato a sair da base: ");
				lineIndex = getPivotLine(columnIndex);
				if(lineIndex == -1) {
					System.out.println("Nenhum.");

					// Couldn't remove a pivot
					phaseSolved = false;
					
					// Solving artificial function
					if(this.solvingArtificialFunction) {
						this.solutionType = " couldnt remove someone in phase 1";

					}
					else {
						String signal = "-";
						if(this.problemType.equals("max")) signal = "+";
						
						this.solutionType = "z -> " + signal + "∞";
					}
					
					break;
					
				} else {
					System.out.println("x" + currentBaseVarIndexes[lineIndex-(objectiveFunctionLine + 1)]);

					currentBaseVarIndexes[lineIndex-(objectiveFunctionLine + 1)] = columnIndex;
					
					adjustPivotLine(lineIndex, columnIndex);
					System.out.println("Realizando pivoteamento...\n");
//					printTableau();
					for(int i=0;i<m;i++) {
						if(i == lineIndex) {
							continue;
						} else {
							addLines(i, lineIndex, (-1) * tableau[i][columnIndex]);
							
						}
					}
					printTableau();
					printVBs();
				}
				//columnIndex = -1;
				
			} while(true);
			
			return phaseSolved;
			
		}
		
		//Get Column with biggest value in a line
		public int getColumnIndex(int line, int finalIndex) {
			double biggestNumber = 0;
			int index = -1;
			for(int i=1;i<finalIndex;i++) {
				if(tableau[line][i] > biggestNumber) {
					biggestNumber = tableau[line][i];
					index = i;
				}
			}
			return index;
		}
		
		//get pivot from a column
		public int getPivotLine(int columnIndex) {
			double smallestNumber = 100000000;
			int index = -1;
			double pivotValue;
			
			for(int i=objectiveFunctionLine + 1;i<m;i++) {
				if(tableau[i][columnIndex] <= 0 || isRemovedLine(i)) {
					continue;
				}
				pivotValue = tableau[i][0]/tableau[i][columnIndex]; 
				/*if(pivotValue == smallestNumber) {
					if(artificialVariables[i - objectiveFunctionLine - 1] == 1 && tableau[i][columnIndex] > tableau[index][columnIndex]) {
						smallestNumber = tableau[i][0]/tableau[i][columnIndex];
						index = i;
					}
				}*/
				if(pivotValue < smallestNumber) {
					smallestNumber = tableau[i][0]/tableau[i][columnIndex];
					index = i;
				}
			}
			return index;
		}
				
		//add second line multiplied by multiplier to first line
		public void addLines(int firstLineIndex, int secondLineIndex, double multiplier) {
			for(int i=0;i<n;i++) {
				tableau[firstLineIndex][i] += (multiplier * tableau[secondLineIndex][i]);
			}
			
		}
		
		//add lines with artificial functions to artificial function line
		public void normalizeArtificialFunction() {
			for(int i =2;i<m;i++) {
				if(artificialVariables[i-2] > 0) {
					this.addLines(0, i, 1);
				}
			}
		}
		
		public void adjustPivotLine(int line, int column) {
			double denominator = tableau[line][column];
			for(int i=0;i<n;i++) {
				tableau[line][i] /= denominator;
			}
		}
		
		public void printTableau() {
			
			int startLine = 0;
			int endColumn = n;
			
			if(!this.solvingArtificialFunction) {
				startLine = objectiveFunctionLine;
				endColumn = numberOfVariables + numberOfSlackVariables + 1;
			}
			
			System.out.printf("       ");

			for(int j=1;j<endColumn;j++) {
				System.out.printf("x" + j + "     ");
			}
			System.out.println();

			for(int i=startLine;i<m;i++) {
				for(int j=0;j<endColumn;j++) {
					System.out.printf("%.2f   ", tableau[i][j]);
				}
				System.out.println();
			}
			
		}
		
		public void printSolution() {
			if(this.tableauSolved) {
				// get z value
				double z = tableau[objectiveFunctionLine][0];
				
				if(this.problemType.equals("max")) z = -z;
				
				System.out.print("z* = " + round(z, 2) + "   x* = ( ");
				
				double[] solutionVector = new double[numberOfVariables + numberOfSlackVariables + artificialVariables.length];
				for (int i = 0; i < currentBaseVarIndexes.length; i++) {
					//System.out.println("\n\n"+currentBaseVarIndexes.get(i));
					if(currentBaseVarIndexes[i] != -1) {
						solutionVector[currentBaseVarIndexes[i] - 1] = tableau[i + objectiveFunctionLine + 1][0];
					}
				}
				
				for (int i = 0; i < numberOfVariables + numberOfSlackVariables; i++) {
					if(solutionVector[i] != -1) {
						System.out.print(round(solutionVector[i], 2) + " ");
					}
				}
				
				System.out.println(")");
			}
		}
		
		public void printSolutionType() {
			System.out.println(this.solutionType);
		}

		public double[][] getTableau() {
			return tableau;
		}

		public int getNumberOfRestrictions() {
			return numberOfRestrictions;
		}

		public int getNumberOfVariables() {
			return numberOfVariables;
		}

		public int getM() {
			return m;
		}

		public int getN() {
			return n;
		}		
		
		private boolean isBaseVariable(int columnIndex) {
			//return Arrays.toString(currentBaseVarIndexes).contains("" + columnIndex);
			for (int i = 0 ; i < currentBaseVarIndexes.length; i++) {
				if(currentBaseVarIndexes[i] == columnIndex) {
					return true;
				}
			}
			return false;
		}
		
		private boolean isRemovedLine(int lineIndex) {
			for (int i = 0 ; i < removedLinesIndexes.size(); i++) {
				if(removedLinesIndexes.get(i) == lineIndex) {
					return true;
				}
			}
			return false;
		}
		
		private boolean hasUniqueSolution() {
			boolean uniqueSolution = true;
			
			for (int j = 1; j < numberOfVariables + numberOfRestrictions; j++) {			
				if(tableau[objectiveFunctionLine][j] == 0.00) {
					// check if is a VNB
					if(!isBaseVariable(j)) {
						uniqueSolution = false;
						break;
					}
				}
			}
			
			return uniqueSolution;
		}
		
		private boolean hasDegeneratedSolution() {
			boolean degeneratedSolution = false;
			
			for (int i = 1 + objectiveFunctionLine; i < this.m; i++) {
				if(tableau[i][0] == 0) {
					degeneratedSolution = true;
				}
			}
			
			return degeneratedSolution;
		}
		
		private int isArtificialInBase() {
			for (int i = 0 ; i < currentBaseVarIndexes.length; i++) {
				if(currentBaseVarIndexes[i] > numberOfVariables + numberOfSlackVariables) {
					return i;
				}
			}
			return -1;
		}
		
		public void printVBs() {
			System.out.print("\nVBs = ");

			for (int i = 0 ; i < currentBaseVarIndexes.length; i++) {
				if(currentBaseVarIndexes[i] != -1) {
					System.out.print("x" +currentBaseVarIndexes[i] + " ");
				}
			}
			System.out.println();
		}
		
		public static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = new BigDecimal(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		}
}
