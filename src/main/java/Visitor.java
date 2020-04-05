import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public  class Visitor {

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());


    public static void main(String[] args){

        Visitor visit = new Visitor();
        visit.setVisitorName("Tokelo lebepe");
        visit.setAge(25);
        visit.setComments("How can we help you");
        visit.setAssistantName("Tebogo lebepe");
 System.out.println(Save());

    }
  public  static String visitorName;
    public static int age;
  public static   DateTimeFormatter date;
  public  static String comments;
   public static String assistantName;



    public String getVisitorName(){
        return visitorName;
    }
    public void setVisitorName(String name){
        visitorName = name;

    }
public int getAge(){
        return  age;
}
public  void setAge(int age){
        age = age;
}
public  String getComments(){
        return comments;
}
public void setComments(String comment){
        comments = comment;
}
public String getAssistantName(){
        return assistantName;

}
public void setAssistantName(String assistant){
        assistantName = assistant;
}

    public static String Save(){
try{
    File myfile = new File("Visitor_"+visitorName+".txt");
    if(myfile.createNewFile()){
        System.out.println("successfully created");
    }else{
        System.out.println("file already created");
    }
}catch (IOException e){
    logger.debug("An error occured");
}
try {
    FileOutputStream write = new FileOutputStream("Visitor_"+ visitorName+".txt");
    ObjectOutputStream  object = new ObjectOutputStream(write);

    object.writeObject(visitorName);
    object.writeObject(age);
    object.writeObject(date);
    object.writeObject(comments);
    object.writeObject(assistantName);

    object.close();
    write.close();

    FileInputStream inpt = new FileInputStream("Visitor_"+ visitorName+".txt");
    ObjectInputStream ob = new ObjectInputStream(inpt);
}catch (FileNotFoundException e){
    System.out.println("File not found");
}catch (IOException e){
    logger.error("Error initializing string");
    e.printStackTrace();
}
return "";
    }
    public static String  Load(String visitorName){
        try {
            File myfile = new File("Visitor_"+ visitorName+".txt");
            Scanner scann = new Scanner(myfile);
            while ((scann.hasNextLine())){
                String data = scann.nextLine();
                System.out.println(data);
            }
scann.close();
        }catch (FileNotFoundException e){
            logger.debug("Arror occcured");
            e.printStackTrace();
        }


        return "";


    }

}
