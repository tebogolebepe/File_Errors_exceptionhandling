
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner inputReader = new Scanner(System.in);


        System.out.println("Enter Student Name : ");
        String fullName = inputReader.nextLine();

        System.out.println("Assistant Name : ");
        String nameOfPersonWhoAssistedTheVisitor = inputReader.nextLine();

        System.out.println("Comments : ");
        String comments = inputReader.nextLine();


        LocalDate dateOfVisit = LocalDate.now();
        LocalTime timeOfVisits = LocalTime.now();

        System.out.println("How old is the student : ");
        int age = inputReader.nextInt();

        Visitor objVisit = new Visitor(fullName,nameOfPersonWhoAssistedTheVisitor, comments,dateOfVisit,timeOfVisits, age);


        objVisit.save();


        objVisit.load(fullName);
    }
}



