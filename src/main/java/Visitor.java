import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Visitor {
    private String fullName, assistant_Name, comments;
    LocalDate dateOfVisit;
    LocalTime timeOfVisits;
    int age;

    static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public Visitor() {
        this.fullName = fullName;
        this.assistant_Name = assistant_Name;
        this.comments = comments;
        this.dateOfVisit = dateOfVisit;
        this.timeOfVisits = timeOfVisits;
        this.age = age;
    }

    public Visitor(String fullName, String nameOfPersonWhoAssistedTheVisitor, String comments, LocalDate dateOfVisit, LocalTime timeOfVisits, int age) {
    }


    void save() throws IOException {
        //convert file name
        String convertFileName = "visitor_" + fullName + ".txt";

        //name of the file must be in lower case and space is replaced by underscore.
        String fileName = convertFileName.toLowerCase().replace(" ", "_");

        // use try catch to create and open the file
        try (FileWriter fileWriter = new FileWriter(fileName)) {

            fileWriter.write("Full Name :" + fullName + "\n");
            fileWriter.write("Age :" + age + "\n");
            fileWriter.write("Date of Visit :" + LocalDate.now() + "\n");
            fileWriter.write("Time of Visit :" + LocalTime.now() + "\n");
            fileWriter.write("Comments :" + comments + "\n");
            fileWriter.write("Assistant Name :" + assistant_Name);

            logger.info("Saved Successfully!\n");

        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new IOException("error with a file");
        }
    }

    void load(String name) throws IOException {

        // the name should be converted into the proposed file convention
        String full_Name = "visitor_" + name.toLowerCase().replace(" ", "_") + ".txt";

        //To open the file
        String line;
        int i = 0;

        try(BufferedReader fileReader = new BufferedReader(new FileReader(full_Name))){
            while ((line = fileReader.readLine()) != null ){
                i++;
                System.out.println(line);
            }
            logger.info("File Was Successfully Read!\n");
        } catch (Exception e) {

            logger.error(e.getMessage());
            throw new IOException("File Not Found");
        }
    }


}
