package Prog3_Trab1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

final class Report {
	
	private String reportPath;
	private static final String reportEncoding = "utf-8"; 
	private MediaCollection collection;
	private Writer currentWriter;
	
	public Report(MediaCollection collection) {
		this.collection = collection;
	}
	
	public void createReport(Callable<Void> specialReportGenerator) throws ProgramException {
		File reportFile = new File(this.reportPath);
		
		try {
			if(!reportFile.exists()) {
				reportFile.createNewFile();
			}
			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(this.reportPath), Report.reportEncoding));
				this.currentWriter = writer;
				specialReportGenerator.call();
				this.currentWriter = null;
				writer.close();
		}
		catch(IOException e) {
			System.out.println("Erro de I/O");
			throw new ProgramException();
		}
		catch(Exception e) {
			System.out.println("Unexpected Exception");
			throw new ProgramException();
		}
		
	}
	
	private void generateStatisticsReport() throws IOException {
		long wantToWatchTime = 0;
		long haveWatchedTime = 0;
		Map<String,int[]> seriesMap = new TreeMap<String,int[]>(new TvSeriesWatchComparator());
		
		for(Media media : this.collection.getMedias()) {
			if(TvSeriesSeason.isTvSeriesSeason(media)) {
				TvSeriesSeason season = (TvSeriesSeason) media;
				int[] comsuptionArray;
				if(!seriesMap.containsKey(season.getSeriesName())) {
					comsuptionArray = new int[2];
					comsuptionArray[0] = 0;
					comsuptionArray[1] = 0;
					seriesMap.put(season.getSeriesName(),comsuptionArray);
				}
				else {
					comsuptionArray = seriesMap.get(season.getSeriesName());
				}
				
				if(media.getConsumptionStatus(Media.WANT)) {
					wantToWatchTime += season.getSeasonLength();
					comsuptionArray[0] += 1;
				}
				else if(media.getConsumptionStatus(Media.WATCHED)) {
					haveWatchedTime += season.getSeasonLength();
					comsuptionArray[1] += 1;
				}
			}
			else if(Movie.isMovie(media)) {
				Movie movie = (Movie) media;
				if(media.getConsumptionStatus(Media.WATCHED)) {
					haveWatchedTime += movie.getFeatureLength();
				}
				if(media.getConsumptionStatus(Media.WANT)){
					wantToWatchTime += movie.getFeatureLength();
				}
			}
		}
		
		this.currentWriter.write("Horas consumidas: " + haveWatchedTime + " minutos\n");
		this.currentWriter.write("Horas a consumir: " + wantToWatchTime + " minutos\n\n");
		this.currentWriter.write("Mídias por gênero:\n");
		
		ListIterator<Genre> genreIterator = this.collection.getSortedGenreIterator(new GenreComparator());
		
		while(genreIterator.hasNext()) {
			Genre genre = genreIterator.next();
			this.currentWriter.write("\t"+genre.getName()+": "+genre.getMediaCount()+"\n");
		}
		
		this.currentWriter.write("\nTemporadas por série:\n");
		
		for(Map.Entry<String,int[]> entry: seriesMap.entrySet()) {
			int value[] = entry.getValue();
			this.currentWriter.write("\t"+entry.getKey()+": "+value[1]+" assistidas, "+value[0]+" a assistir\n");
		}
	}
	
	private void generateMediasByPersonReport() throws IOException {
		ListIterator<Person> personIterator = this.collection.getSortedPersonIterator(new PersonComparator());
		
		this.currentWriter.write("Pessoa;Produção\n");
		
		while(personIterator.hasNext()) {
			Person person = personIterator.next();
			if(person.getMediaCount() > 0) {
				this.currentWriter.write(person.getPersonName()+";");
				ListIterator<Media> mediaIterator = person.getMediaIterator();
				if(mediaIterator.hasNext()) {
					this.currentWriter.write(mediaIterator.next().getName());
				}
				while(mediaIterator.hasNext()) {
					this.currentWriter.write(", "+mediaIterator.next().getName());
				}
				this.currentWriter.write("\n");
			}
		}
	}
	
	private void generateLoanReport() throws IOException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, Calendar.NOVEMBER, 6);
		ListIterator<Loan> loanIterator = this.collection.getSortedLoanIterator(new LoanComparator());
		Date todayDate = calendar.getTime();
		
		this.currentWriter.write("Data;Tomador;Atrasado?;Dias de Atraso\n");
		
		while(loanIterator.hasNext()) {
			Loan loan = loanIterator.next();
			String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(loan.getStartDate());
			String lentTo = loan.getPersonName();
			String lateString = "Sim";
			loan.setReturnDate(todayDate);
			if(!loan.isLate()) {
				lateString = "Não";
			}
			long daysLate = loan.daysLate(calendar);
			this.currentWriter.write(formattedDate+";"+lentTo+";"+lateString+";"+daysLate+"\n");
		}
	}
	
	private void generateWhishListReport() throws IOException {
		ListIterator<Media> wishListIterator = this.collection.getSortedWishListIterator(
				new WhishListMediaComparator());
		
		this.currentWriter.write("Tipo;Mídia;Gênero;Preço\n");
		
		while(wishListIterator.hasNext()) {
			Media media = wishListIterator.next();
			String mediaTypeName = "";
			if(Book.isBook(media)) {
				mediaTypeName = "Livro";
			}
			else if(Movie.isMovie(media)) {
				mediaTypeName = "Filme";
			}
			else if(TvSeriesSeason.isTvSeriesSeason(media)) {
				mediaTypeName = "Série";
			}
			if(mediaTypeName != "") {
				Locale loc = new Locale("fr", "CA");
				NumberFormat nf = NumberFormat.getNumberInstance(loc);
				DecimalFormat formatter = (DecimalFormat)nf;
				formatter = new DecimalFormat("$ ##.00");
//				String moneyString = formatter.format(media.getPrice());
				String money = formatter.format(media.getPrice());
				this.currentWriter.write(mediaTypeName+";"+media.getName()+";"+
						media.getGenre().getName()+";"+"R"+money+"\n");
			}
		}
	}
	
	public void createStatisticsReport(String reportPath) throws ProgramException {
		this.reportPath = reportPath;
		Callable<Void> generateReport = new Callable<Void>() {

			@Override
			public Void call() throws IOException {
				generateStatisticsReport();
				return null;
			}			
		};
		this.createReport(generateReport);
	}
	
	public void createMediasByPersonReport(String reportPath) throws ProgramException {
		this.reportPath = reportPath;
		Callable<Void> generateReport = new Callable<Void>() {

			@Override
			public Void call() throws IOException {
				generateMediasByPersonReport();
				return null;
			}
			
		};
		this.createReport(generateReport);
	}
	
	public void createLoanReport(String reportPath) throws ProgramException {
		this.reportPath = reportPath;
		Callable<Void> generateReport = new Callable<Void>() {

			@Override
			public Void call() throws IOException {
				generateLoanReport();
				return null;
			}
			
		};
		this.createReport(generateReport);
	}
	
	public void createWishListReport(String reportPath) throws ProgramException {
		this.reportPath = reportPath;
		Callable<Void> generateReport = new Callable<Void>() {

			@Override
			public Void call() throws IOException {
				generateWhishListReport();
				return null;
			}
			
		};
		this.createReport(generateReport);
	}
}


