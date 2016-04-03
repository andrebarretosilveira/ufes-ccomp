/**
 * Trabalho 2 de Prog3
 * André Barreto e Lucas Piske
 */

#include "MediaCollection.hpp"
#include "ConsoleInput.hpp"
#include "CsvInput.hpp"
#include "Report.hpp"

int main(int argc, const char** argv )
{
    string* filePath;
    MediaCollection mediaCollection = MediaCollection();
    ConsoleInput consoleInput = ConsoleInput(argc, argv);
    CsvInput csvInput = CsvInput(mediaCollection);

    if(argc == 1) return 1;

    try {
        // Read Genres
        filePath = consoleInput.getFilePath("-g");
        csvInput.readGenreCsv(*filePath);

        // Read People
        filePath = consoleInput.getFilePath("-p");
        csvInput.readPersonCsv(*filePath);

        // Read Medias
        filePath = consoleInput.getFilePath("-m");
        csvInput.readMediaCsv(*filePath);

        // Read Loans
        filePath = consoleInput.getFilePath("-e");
        csvInput.readLoanCsv(*filePath);
    }
    catch(IOException e) {
        cout << e.what() << endl;
    }

    try {
        // Generate reports
        Report report = Report(mediaCollection);
        report.createStatisticsReport("1-estatisticas.txt");
        report.createMediasByPersonReport("2-porpessoa.csv");
        report.createLoanReport("3-emprestimos.csv");
        report.createWishListReport("4-wishlist.csv");
    }
    catch(ProgramException e) {
        // ERRO DE PROGRAMA
        return 1;
    }
}
