package Prog3_Trab1;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Callable;

final class CsvInput {
	
	private String CsvFilePath; 
	private String[] currentBufferedFields;
	private MediaCollection mediaCollection;
	
	public CsvInput(MediaCollection mediaCollection) {
		this.mediaCollection = mediaCollection;
	}
	
	private void readCsvInput(Callable<Void> specialReadMethod) throws ProgramException {
		
		try(Scanner CsvFileScanner = new Scanner(new File(this.CsvFilePath),"UTF-8")) {
			String line = CsvFileScanner.nextLine();
			while(CsvFileScanner.hasNextLine()) {
				line = CsvFileScanner.nextLine();
				this.currentBufferedFields = line.split(";");
				
				try { specialReadMethod.call(); }
				catch (DataFormatException dfe) {
					System.out.println("Erro de formatação");
					throw new ProgramException();
				}
				catch (InconsistentDataException ide) {
					System.out.println("Dados inconsistentes " + ide.getDataLocation());
					throw new ProgramException();
				}
				catch(Exception e) {
					System.out.println("Unexpected Exception");
					throw new ProgramException();
				}
			}
			this.currentBufferedFields = null;
		}
		catch (IOException e) {
			System.out.println("Erro de I/O");
			throw new ProgramException();
		}
	}
	
	private void insertGenreFromString() throws DataFormatException {
		String[] lineFields = this.currentBufferedFields;
		if(lineFields.length == 2) {
			String genreInitials = lineFields[0];
			String genreName = lineFields[1];
			Genre genre = new Genre(genreInitials);
			genre.setName(genreName);
			this.mediaCollection.addGenre(genre);
		}
		else {
			throw new DataFormatException();
		}
	}
	
	private void insertPersonFromString() throws DataFormatException {
		String[] lineFields = this.currentBufferedFields;
		if(lineFields.length == 2) {
			long personId;
			try { personId = Long.parseLong(lineFields[0]); }
			catch(NumberFormatException e) {
				throw new DataFormatException();
			}
			String personName = lineFields[1];
			Person person = new Person(personId);
			person.setPersonName(personName);
			this.mediaCollection.addPerson(person);
		}
		else {
			throw new DataFormatException();
		}
	}
	
	private Media insertBookFromString() throws DataFormatException, InconsistentDataException {
		String[] lineFields = this.currentBufferedFields;
		long mediaId;
		int numberPages;
		try {
			mediaId = Long.parseLong(lineFields[0]);
			numberPages = Integer.parseInt(lineFields[5]);
		}
		catch(NumberFormatException e) {
			throw new DataFormatException();
		}
		String mediaName = lineFields[1];
		Genre genre = this.mediaCollection.getGenreByInitials(lineFields[6]);
		Book book = new Book(mediaId,mediaName,numberPages,genre);
		
		String[] authorCodesStr = lineFields[4].split(",");
		for(int i = 0; i < authorCodesStr.length; i++) {
			long authorCode;
			try { authorCode = Long.parseLong(authorCodesStr[i]); }
			catch(NumberFormatException e) {
				throw new DataFormatException();
			}
			Person person = this.mediaCollection.getPersonByCode(authorCode);
			if(person == null) {
				throw new InconsistentDataException("Autor", authorCodesStr[i]);
			}
			book.addAuthors(person);
		}
		return (Media) book;
	}
	
	private Media insertMovieFromString() throws DataFormatException, InconsistentDataException {
		String[] lineFields = this.currentBufferedFields;
		long mediaId, directorId;
		int featureLength;
		try {
			mediaId = Long.parseLong(lineFields[0]);
			featureLength = Integer.parseInt(lineFields[5]);
			directorId = Integer.parseInt(lineFields[3]);
		}
		catch(NumberFormatException e) {
			throw new DataFormatException();
		}
		String mediaName = lineFields[1];
		Genre genre = this.mediaCollection.getGenreByInitials(lineFields[6]);
		Person director = this.mediaCollection.getPersonByCode(directorId);
		if(director == null) {
			throw new InconsistentDataException("Diretor", Long.toString(directorId));
		}	
		Movie movie = new Movie(mediaId,mediaName,director,featureLength,genre);
		
		if(lineFields[4].length() == 0) return (Media) movie;
		
		String[] actorCodesStr = lineFields[4].split(",");
		for(int i = 0; i < actorCodesStr.length; i++) {
			long actorCode;
			try { actorCode = Long.parseLong(actorCodesStr[i]); }
			catch(NumberFormatException e) {
				throw new DataFormatException(); 
			}
			Person person = this.mediaCollection.getPersonByCode(actorCode);
			if(person == null) {
				throw new InconsistentDataException("Ator", actorCodesStr[i]);
			}
			movie.addMainActors(person);
		}
		return (Media) movie;
	}
	
	private Media insertTvSeriesSeasonFromString() throws DataFormatException, InconsistentDataException {
		String[] lineFields = this.currentBufferedFields;
		long mediaId;
		int featureLength, seasonNumber;
		try {
			mediaId = Long.parseLong(lineFields[0]);
			featureLength = Integer.parseInt(lineFields[5]);
			seasonNumber = Integer.parseInt(lineFields[8]);
		}
		catch(NumberFormatException e) {
			throw new DataFormatException();
		}
		String mediaName = lineFields[1];
		Genre genre = this.mediaCollection.getGenreByInitials(lineFields[6]);
		String seriesName = lineFields[7];
		
		TvSeriesSeason season = new TvSeriesSeason(mediaId, mediaName, seriesName,
				featureLength, seasonNumber, genre);
		
		if(lineFields[4].length() == 0) return (Media) season;
		
		String[] actorCodesStr = lineFields[4].split(",");
		for(int i = 0; i < actorCodesStr.length; i++) {
			long actorCode;
			try { actorCode = Long.parseLong(actorCodesStr[i]); }
			catch(NumberFormatException e) {
				throw new DataFormatException();
			}
			Person person = this.mediaCollection.getPersonByCode(actorCode);
			if(person == null) {
				throw new InconsistentDataException("Ator", actorCodesStr[i]);
			}
			season.addMainActors(person);
		}
		return (Media) season;
	}
	
	private void insertMediaFromString() throws DataFormatException, InconsistentDataException {
		String[] lineFields = this.currentBufferedFields;
		if(lineFields.length == 13) {
			Media media = null;
			
			String genreInitials = lineFields[6];
			Genre genre = this.mediaCollection.getGenreByInitials(genreInitials);
			if(genre == null) {
				throw new InconsistentDataException("Gênero", genreInitials);
			}
			
			if(lineFields[2].equals("L")) {
				media = this.insertBookFromString();
			}
			else if(lineFields[2].equals("F")) {
				media = this.insertMovieFromString();
			}
			else if(lineFields[2].equals("S")) {
				media = this.insertTvSeriesSeasonFromString();
			}
			else { throw new InconsistentDataException("Tipo", lineFields[2]); }
			
			try {
				double price = NumberFormat.getInstance(Locale.FRANCE).parse(lineFields[12]).doubleValue();
				media.setPrice(price);
			} catch (ParseException e) {
				throw new DataFormatException();
			}
			media.setConsumptionStatus(Media.WANT,lineFields[11].equals("x"));
			media.setConsumptionStatus(Media.WATCHED,lineFields[10].equals("x"));
			media.setConsumptionStatus(Media.NOTWATCHED,lineFields[9].equals("x"));
			this.mediaCollection.addMedia(media);
		}
		else {
			throw new DataFormatException();
		}
	}
	
	private void insertLoanFromString() throws DataFormatException, InconsistentDataException {
		String[] lineFields = this.currentBufferedFields;
		if(lineFields.length == 4) {
			int mediaId;
			try { mediaId = Integer.parseInt(lineFields[0]); }
			catch(NumberFormatException e) {
				throw new DataFormatException();
			}
			
			String lentTo = lineFields[1];
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date limitDate;
			Date startDate;
			try {
				startDate = dateFormat.parse(lineFields[2]);
				limitDate = dateFormat.parse(lineFields[3]);
			}
			catch (ParseException e) {
				throw new DataFormatException();
			}
			
			Media media = this.mediaCollection.getMediaById(mediaId);
			if(media == null) {
				throw new InconsistentDataException("Mídia", Integer.toString(mediaId));
			}
			Loan loan = new Loan(lentTo,media,startDate,limitDate);
			this.mediaCollection.lend(loan);
		}
		else {
			throw new DataFormatException();
		}
	}
	
	public void readGenreCsv(String filePath) throws ProgramException {
		this.CsvFilePath = filePath;
		Callable<Void> readInput = new Callable<Void>() {

			@Override
			public Void call() throws DataFormatException {
				insertGenreFromString();
				return null;
			}
		};
		this.readCsvInput(readInput);
	}
	
	public void readPersonCsv(String filePath) throws ProgramException {
		this.CsvFilePath = filePath;
		Callable<Void> readInput = new Callable<Void>() {

			@Override
			public Void call() throws DataFormatException {
				insertPersonFromString();
				return null;
			}
		};
		this.readCsvInput(readInput);
	}
	
	public void readMediaCsv(String filePath) throws ProgramException {
		this.CsvFilePath = filePath;
		Callable<Void> readInput = new Callable<Void>() {

			@Override
			public Void call() throws DataFormatException, InconsistentDataException {
				insertMediaFromString();
				return null;
			}
		};
		this.readCsvInput(readInput);
	}
	
	public void readLoanCsv(String filePath) throws ProgramException {
		this.CsvFilePath = filePath;
		Callable<Void> readInput = new Callable<Void>() {

			@Override
			public Void call() throws DataFormatException, InconsistentDataException {
				insertLoanFromString();
				return null;
			}
		};
		this.readCsvInput(readInput);
	}
	
}
