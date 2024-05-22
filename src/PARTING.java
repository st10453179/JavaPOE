
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PARTING {
    
     //to store the user creditials
    public static String username = "";
    public static String password = "";
    
    //check if the creditials match then if so the user can login 
    public static String userNameMatch = "";
    public static String passWordMatch = "";
    
    //booleans for the user registration sucessful
    public static boolean checkUsername = false;
    public static boolean checkPassword = false;
    
    //the names of the user
    public static String name = "";
    public static String lastname = "";
    
   
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Easykanban");
        
        //Register
        System.out.println("\n **************");
        System.out.println("                 REGISTER");
        System.out.println("\n **************");
        
        
        //asking the user  to input first name
        System.out.print("ENTER YOUR FIRST NAME: ");
        name = sc.nextLine();
        //ask user for user to input last name
        System.out.print("ENTER YOUR LAST NAME: ");
        lastname = sc.nextLine();
        
       
        //asking user to create a login
        System.out.println("CREATE USERNAME \n username must contain an underscore'_' and should not be more than 5 charcters long");
        username = sc.nextLine();
         
       
        
        //called this method to check username has the underscore and not more than 5 characters long
       while(!checkUserName()){
        System.out.println("CREATE USERNAME \n username must contain an underscore'_' and should not be more than 5 charcters long");
        username = sc.nextLine();
        
       }
       
        //ask the user to create password
        System.out.println("CREATE PASSWORD \n password must contain a capitalletter,number,specialcharacter'/,?,@.> etc'and is should not be more than 8 characters long");
        password = sc.nextLine();
       
        
        //checks if the password has the speacial character and not more than 8 characters long
        while(!checkPassWordComplexity()){
        
              //ask the user to create password
        System.out.println("CREATE PASSWORD \n password must contain a capitalletter,number,specialcharacter'/,?,@.> etc'and is should not be more than 8 characters long");
        password = sc.nextLine();
        
        
        }
        
        //caling the register method
        registerUser();
        
        System.out.println("\n **************");
        System.out.println("                 LOGIN");
        System.out.println("\n **************");
        
        
        
        System.out.print("Enter USERNAME: ");
        userNameMatch = sc.nextLine();
        
        //call the method here
        
        System.out.print("Enter PASSWORD: ");
        passWordMatch = sc.nextLine();
         
        
        //method ask user to login with the created password and user name and check if their correct
        loginUser();
        
        //Part two starts here
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        int option = 0;

        while (option != 3) {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose an option \n 1. Add tasks \n 2. Show report \n 3.Quit"));

            switch (option) {

                case 1:
                    int tasksCount = Integer.parseInt(JOptionPane.showInputDialog("How many tasks you wish to enter?"));
                    Task[] tasks = new Task[tasksCount];

                    for (int i = 0; i < tasksCount; i++) {
                        tasks[i] = createTask(i + 1);
                        JOptionPane.showMessageDialog(null, tasks[i].toString());
                    }

                    int totalHours = getTotalHours(tasks);
                    
                    JOptionPane.showMessageDialog(null, "Total combined hours of all entered tasks: " + totalHours);
                    
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    System.exit(0);
                    //Part 2 ends here
            }
        }
    }
    
    //this method is for checking the created user has the underascre and not 5 characters long
    public static boolean checkUserName() {
        boolean underscore = false;
        boolean length = false;
        
      
        //checking for underscore on the username
        for (int ue = 0; ue < username.length(); ue++) {
            if (username.charAt(ue) == 95) {
                underscore = true;
                checkUsername = true;
                break;
            }
            
            else {
                underscore = false;
                checkUsername = false;

            }

        }
        
        //check if the username length is 5
        for (int lh = 0; lh < username.length(); lh++) {
            if (username.length() == 5) {
                length = true;
                checkUsername = true;
            }
            
            else {
                length = false;
                checkUsername = false;
            }

        }
        

        if (underscore && length) {
            
            System.out.println("USERNAME successfully CAPTURED");
            
            checkUsername = true;

        } 
        
        else {
            
            System.out.println("USERNAME is not correctly formated,please ensure that the USERNAME contains an underscore and is no more than 5 charcters in length.");
          
            checkUsername = false;
            
        }

        return checkUsername;
    }
    
    
    //this method is for checking if the user created password has special characters and is no more than 8 characters long
    public static boolean checkPassWordComplexity() {
        
        boolean length = false;
        boolean capitalletter = false;
        boolean number = false;
        boolean specialcharacter = false;


        //check is the password contains capital a letter
        for (int cl = 0; cl < password.length(); cl++) {
            if (password.charAt(cl) >= 65 && password.charAt(cl) <= 90) {
                capitalletter = true;
                checkPassword = true;
                break;
               
            } else {
                capitalletter = false;
                checkPassword = false;
            }
        }
       
        // checking if a password contains a number
        for (int n = 0; n < password.length(); n++) {
            if (password.charAt(n) >= 48 && password.charAt(n) <= 57) {
                number = true;
                checkPassword = true;
                break;

            } else {
                number = false;
                checkPassword = false;
            }
        }
         
        //check if password contain special character
        for (int sp = 0; sp < password.length(); sp++) {
             char ch = password.charAt(sp);
             if ((ch >= 32 && ch <= 47) || (ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96) || (ch >= 123 && ch <= 255)) {
                specialcharacter = true;
                checkPassword = true;
                 break;
            }
             else {
                specialcharacter = false;
                checkPassword = false;
             }
        }
        
        //check if the length is 8
        for (int len = 0; len < password.length(); len++) {
            if (password.length() == 8) {
                length = true;
                checkPassword = true;
                //break;
            } else {
                length = false;
                checkPassword = false;
            }
        }
 
        //condition to check if the required is found on the password created
        if (capitalletter && number && specialcharacter && length){
            System.out.println("PASSWORD successfully CAPTURED");
            checkPassword = true;
            
        }
        
        else{
            
            System.out.println("PASSWORD is not correctly formatted please ensure that the PASSWORD contains at least 8 characters,capital letter,a number and a speacial character.");
            
            checkPassword = false;
            
        }

        return checkPassword;

    }
    
    //method returning necessary registration messaging
    public static String registerUser(){
        
        
        if(!checkUsername && checkPassword){
            
            
            System.out.println("Username is incorrectly formatted");
            
            
        }
       
        else if(checkUsername && !checkPassword) {
            System.out.println("Password does not meet the complexity requirements");
            
            
        }
        
        else{
            
            System.out.println("The conditions above have been met and the user has been registered succesful");
            
           

        }

         return "";
        
    }
    
    
    
    
    //method to ask the user login and check id the created user and password corresponf with the ones the user will use to login
    public static boolean loginUser() {
        
        boolean userLoginCreditials = false;
          
        
        if(userNameMatch.equals(username) && passWordMatch.equals(password)){
            
            
            userLoginCreditials = true;
            
             //the method returns checks if user successfully logged in
             returnLoginStatus(userLoginCreditials);
         
        } 
        
        else {
            
            userLoginCreditials = false;
            returnLoginStatus(userLoginCreditials);
           
           
        }
        
        return userLoginCreditials;
    }

    public static String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            
            System.out.println("A SUCCESSFUL LOGIN");
            
            System.out.println("Welcome " + name + " " + lastname + " it is great to see you");
            
        } 
        
        else {
            System.out.println("A FAILED LOGIN");
        }


        return "";

    }

// Part 2 methods start here
    private static Task createTask(int taskNumber) {
        
        String taskName = JOptionPane.showInputDialog("Enter task name for Task " + taskNumber + ":");
        
        String taskDescription = getTaskDescription();
        
        String developerDetails = JOptionPane.showInputDialog("Enter developer details for Task (First name and Lastname) " + taskNumber + ":");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours for Task " + taskNumber + ":"));
        String taskStatus = chooseTaskStatus();

        return new Task(taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskStatus);
    }

    private static String getTaskDescription() {
        String taskDescription;
        do {
            taskDescription = JOptionPane.showInputDialog("Enter task description (should not exceed 50 characters):");
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Description length exceeds 50 characters. Please enter a shorter description.");
            }
        } while (taskDescription.length() > 50);
        return taskDescription;
    }

    private static String chooseTaskStatus() {
        String[] options = {"To Do", "Done", "Doing"};
        int choice = JOptionPane.showOptionDialog(null, "Choose task status:", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return options[choice];
    }

    private static int getTotalHours(Task[] tasks) {
        
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }
} //Part 2 methods end here
// part 2 internal class
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String toString() {
        String taskId = createTaskID(taskNumber, developerDetails);
        return "Task Status: " + taskStatus + "\n"
                + "Developer Details: " + developerDetails + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task Duration: " + taskDuration + " hrs" + "\n"
                + "Task ID: " + taskId + "\n"
                + "-----------------------------------------------";
    }

    public String createTaskID(int tasknum, String developer) {
        String ID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        JOptionPane.showMessageDialog(null, "Task ID Number: " + ID, "Easy Kanban", JOptionPane.PLAIN_MESSAGE);
        return ID;
    }
}
