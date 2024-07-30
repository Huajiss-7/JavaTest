package CSC3101;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:5

import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Action movie:");
        System.out.print("Rating: ");
        String actionRating = sc.nextLine();
        System.out.print("ID Number: ");
        int actionId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Movie Title: ");
        String actionTitle = sc.nextLine();
        Action actionMovie = new Action(actionRating, actionId, actionTitle);

        System.out.println("Enter details for Comedy movie:");
        System.out.print("Rating: ");
        String comedyRating = sc.nextLine();
        System.out.print("ID Number: ");
        int comedyId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Movie Title: ");
        String comedyTitle = sc.nextLine();
        Comedy comedyMovie = new Comedy(comedyRating, comedyId, comedyTitle);

        System.out.println("Enter details for Drama movie:");
        System.out.print("Rating: ");
        String dramaRating = sc.nextLine();
        System.out.print("ID Number: ");
        int dramaId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Movie Title: ");
        String dramaTitle = sc.nextLine();
        Drama dramaMovie = new Drama(dramaRating, dramaId, dramaTitle);

        System.out.println("Cutermer id for each movie");
        int id1=sc.nextInt();
        int id2=sc.nextInt();
        int id3=sc.nextInt();
        System.out.println("Time of days late for each movie");
        int t1=sc.nextInt();
        int t2=sc.nextInt();
        int t3=sc.nextInt();
        Rental[] rentals = {
                new Rental(actionMovie, id1, t1),
                new Rental(comedyMovie, id2, t2),
                new Rental(dramaMovie, id3, t3)
        };

        int totalLateFees = Rental.lateFeesOwed(rentals);
        System.out.println("Total late fees: RM" + totalLateFees);

        sc.close();
    }
}

class Movie {
    private String rating;
    private int idNumber;
    private String movieTitle;

    public Movie(){}

    public Movie(String rating, int idNumber, String movieTitle) {
        this.rating = rating;
        this.idNumber = idNumber;
        this.movieTitle = movieTitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return idNumber == movie.idNumber;
    }

    public int calcLateFees(int daysLate) {
        return 10* daysLate;
    }
}

class Action extends Movie {
    public Action(String rating, int idNumber, String movieTitle) {
        super(rating, idNumber, movieTitle);
    }

    @Override
    public int calcLateFees(int daysLate) {
        return 8 * daysLate;
    }
}

class Comedy extends Movie {
    public Comedy(String rating, int idNumber, String movieTitle) {
        super(rating, idNumber, movieTitle);
    }

    @Override
    public int calcLateFees(int daysLate) {
        return 6 * daysLate;
    }
}

class Drama extends Movie {
    public Drama(String rating, int idNumber, String movieTitle) {
        super(rating, idNumber, movieTitle);
    }

    @Override
    public int calcLateFees(int daysLate) {
        return 4 * daysLate;
    }
}

class Rental {
    private Movie movie;
    private int customerId;
    private int daysLate;

    public Rental(Movie movie, int customerId, int daysLate) {
        this.movie = movie;
        this.customerId = customerId;
        this.daysLate = daysLate;
    }

    public static int lateFeesOwed(Rental[] rentals) {
        int totalLateFees = 0;
        for (int i = 0; i < rentals.length; i++) {
            if(rentals[i].movie instanceof Drama){
                totalLateFees+=4*rentals[i].daysLate;
            } else if (rentals[i].movie instanceof Comedy) {
                totalLateFees+=6*rentals[i].daysLate;
            } else if (rentals[i].movie instanceof Action) {
                totalLateFees+=8*rentals[i].daysLate;
            }else {
                totalLateFees+=10*rentals[i].daysLate;
            }
        }
        return totalLateFees;
    }
}





/*
public class lab5 {
    public static void main(String[] args) {

    }
}

class Movie{
    private String idNumber;
    private String movieTitle;

    public Movie() {
    }

    public Movie(String idNumber, String movieTitle) {
        this.idNumber = idNumber;
        this.movieTitle = movieTitle;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(idNumber, movie.idNumber) ;
    }

    public int calcLateFees(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of days a movie is late");
        return 10*sc.nextInt();
    }
}

class Action extends Movie{
    @Override
    public int calcLateFees() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of days a movie is late");
        return 8*sc.nextInt();
    }
}

class Comedy extends Movie{
    @Override
    public int calcLateFees() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of days a movie is late");
        return 6*sc.nextInt();
    }
}

class Drama extends Movie{
    @Override
    public int calcLateFees() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of days a movie is late");
        return 4*sc.nextInt();
    }
}*/
