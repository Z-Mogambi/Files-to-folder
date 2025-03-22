import java.io.File;
import java.io.IOException;

public class AddFilesToFolder {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java AddFilesToFolder <folder_name> <file1> <file2> ...");
            return;
        }

        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + File.separator + "Desktop";
        String folderName = args[0];
        File targetFolder = new File(desktopPath, folderName);

        // Create folder if it does not exist
        if (targetFolder.mkdirs() || targetFolder.exists()) {
                System.out.println("The folder is ready: "+targetFolder.getAbsolutePath());
        }else{
                System.out.println("Failed to create folder");
                return;
        }
      
        // Looping through file names and creating them inside the folder
        // index 0 is the fileName so start with 1
        for (int i = 1; i < args.length; i++) {
            File newFile = new File(targetFolder, args[i]);
            try {
                if (newFile.createNewFile()) {
                    System.out.println("Created file: " + newFile.getAbsolutePath());
                } else {
                    System.out.println("File already exists: " + newFile.getAbsolutePath());
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + newFile.getName());
                e.printStackTrace();
            }
        }
    }
}
