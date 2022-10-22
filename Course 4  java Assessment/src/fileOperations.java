import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;
import java.nio.file.Path;


public class fileOperations {
     //-------addFile() for adding user specified file.-------
     private static void addFile() {
        // System.out.println("------ To continue current execution enter 1 or enter 0 to return to main context");
         int a=0;
         do{
             System.out.println("------Enter the name of the file you want to add------ ");
             Scanner sc = new Scanner(System.in);
             String nameOfFile = "C:" +  File.separator + "project" + File.separator +  sc.nextLine() + ".txt";  // to store the path


             File file = new File(nameOfFile);
             boolean done; // for checking

             try { // to check exceptions
                 done = file.createNewFile();
                 if (done) {
                     System.out.println("****** User your file has been created ******");
                     System.out.println("------Want to new file again Enter 1 or 0 to the main menu------");
                     a = sc.nextInt();

                 } else {
                     System.out.println("------File is already exits with name you given------");
                     System.out.println("------If you want to try again enter 1 or 0 to exit the program----- ");
                      a = sc.nextInt();

                 }
             } catch (IOException e) {
                 System.out.println("-----please enter the valid file name----");
                 e.printStackTrace();

             }
         }while(a == 1);
     }


     //------retrieving() to get the all the files from the folder in ascending order-------
     private static void retrievingFile() {
         System.out.println("------Retrieving all files from directory------");
         try {
             File directory = new File("C:" + File.separator + "project");//----pathname---
             String[] fileNames = directory.list(); //-----to get the file name in files-----.

             int n = fileNames.length;
             // to get name in ascending order
             for (int i = 0; i < n - 1; i++) {
                 for (int j = i + 1; j < n; j++) {
                     if (fileNames[i].compareToIgnoreCase(fileNames[j]) > 0) {
                         String temp = fileNames[i];
                         fileNames[i] = fileNames[j];
                         fileNames[j] = temp;
                     }
                 }
             }


             for (int i = 0; i < n; i++) //-----for printing
             {
                 System.out.println(fileNames[i] + " ");
             }
         } catch (NullPointerException e) {
             e.printStackTrace();
             System.out.println("The directory is empty");
         }
     }



     //-------deleteFile() for deleting user specified file form directory-----.

     private static void deleteFile() throws IOException {
         int num=0;
         do {
             System.out.println("------Enter the name of the file you want to Delete------ ");
             Scanner sc = new Scanner(System.in);
             String file_toDelete = sc.nextLine() + ".txt";
             File directory = new File("C:"+  File.separator + "project" );
             String[] fList = directory.list();

             int flag = 0;
             if (fList == null) {
                 System.out.println("Folder or Directory is Empty");
             }
            else
             {
                 for (int i = 0; i < fList.length; i++) {  //linear Search used to search file.
                     String file_name = fList[i];
                     if (file_name.equals(file_toDelete)) {  // added case sensitivity to retrieve correct file
                         System.out.println(file_name + " ****** Searching successfully ******");
                         String fileDelete = "C:" + File.separator + "project" + File.separator + file_toDelete;//   // to store the path

                         Path path = Paths.get(fileDelete);

                         try {

                             Files.delete(path);
                             System.out.println("****** deletion successful ******");
                             System.out.println("------To Enter the file name again enter 1 or to exit enter 0------ ");
                             num = sc.nextInt();
                         } catch (IOException e) {
                             System.out.println("No such file/directory exists or Directory is empty");
                             System.out.println("------To Enter the file name again enter 1 or to exit enter 0------ ");
                             num = sc.nextInt();
                             e.printStackTrace();
                         }

                         retrievingFile(); // to show that the deletion is successful
                         flag = 1;

                     }
                 }
             }
             if (flag == 0) {
                 System.out.println("File not found");
                 System.out.println("------To Enter the file name again enter 1 or to exit enter 0------ ");
                  num = sc.nextInt();
             }
         }while(num==1);

     }


     //---- fileToSearch() to search the user specified file----
     public static void fileToSearch(){
         int num=0;
         do {
             System.out.println("------Enter the name of File you want to Search in folder files------");
             Scanner sc = new Scanner(System.in);
             String nameOfFile = sc.nextLine() + ".txt";
             File directory = new File("C:" + File.separator + "project" );
             String[] fileList = directory.list();
             int flag = 0;
             if (fileList == null) {
                 System.out.println("Folder or Directory is Empty");
             } else {
                 for (int i = 0; i < fileList.length; i++) {  //Linear Search used to search file.
                     String fileName = fileList[i];
                     if (fileName.equals(nameOfFile)) {  // added case sensitivity to retrieve correct file
                         System.out.println(fileName + " Search Successful");
                         flag = 1;

                     }
                 }
             }
             if (flag == 0) {
                 System.out.println("File not found");
                 System.out.println("------To Enter the file name again enter 1 or to exit enter 0------ ");
                 num = sc.nextInt();

             }
         }while(num==1);

     }

     public static void main(String[] args) throws IOException {
         int operations = 0;
         do {
             System.out.println("****** Welcome to the File operation program *****");
             System.out.println("Enter 1: To retrieving  file in given directory");
             System.out.println("Enter 2: To create file from given directory");
             System.out.println("Enter 3: To delete file in given directory");
             System.out.println("Enter 4: To search  file in given directory");
             System.out.println("Enter 5: To to exit the program");
             System.out.println("ENTER HERE");

             Scanner sc = new Scanner(System.in);
             int op = sc.nextInt();
             switch (op) {
                 case 1:
                     retrievingFile();
                     System.out.println("Enter 1 : to return to the main menu or 0 to exit the program");
                     operations = sc.nextInt();
                     break;

                 case 2:
                     addFile();
                     System.out.println("Enter 1 : to return to the main menu or 0 to exit the program");
                     operations = sc.nextInt();
                     break;

                 case 3:
                     deleteFile();
                     System.out.println("Enter 1 : to return to the main menu or 0 to exit the program");
                     operations = sc.nextInt();
                     break;
                 case 4:
                     fileToSearch();
                     System.out.println("Enter 1 : to return to the main menu or 0 to exit the program");
                     operations = sc.nextInt();
                     break;
                 case 5:
                     System.out.println("are you sure you want exit please Enter 1 to return to main menu or 0 to exit the program ");
                     operations = sc.nextInt();
                     break;

                 default:
                     System.out.println("You have Entered the wrong input please Enter 1 to return to main menu or 0 to exit the program");
                     operations = sc.nextInt();
             }
         }while(operations == 1);
     }
}


