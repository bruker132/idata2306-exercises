package ntnu.no;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ImageUploader {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String destinationFolder = "uploads/"; // Definer målmappen

    // Sjekk og opprett målmappen hvis den ikke finnes
    Path destinationPath = Paths.get(destinationFolder);
    if (!Files.exists(destinationPath)) {
      try {
        Files.createDirectories(destinationPath);
      } catch (IOException e) {
        System.out.println("Kunne ikke opprette målmappen.");
        e.printStackTrace();
        return;
      }
    }

    while (true) {
      System.out.print("Enter the path of upload file: ");
      String imagePath = scanner.nextLine().trim();

      File file = new File(imagePath);

      // Sjekk om filen eksisterer og er gyldig
      if (!file.exists() || !file.isFile()) {
        System.out.println("File does not exist or is not a valid file. Please try again.");
        continue;
      }

      // Sjekk filtypen
      String fileName = file.getName().toLowerCase();
      if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png") && !fileName.endsWith(".bmp")) {
        System.out.println("You are not uploading a picture, try again!");
        continue;
      }

      // Sjekk om filen allerede finnes i målmappen
      File destinationFile = new File(destinationFolder + fileName);
      if (destinationFile.exists()) {
        System.out.println("File already exists in the destination folder. Upload failed.");
        continue;
      }

      // Kopier filen til målmappen
      try {
        Files.copy(file.toPath(), destinationFile.toPath());
        System.out.println("Upload completed!");
        break;
      } catch (IOException e) {
        System.out.println("An error occurred while uploading the file.");
        e.printStackTrace();
      }
    }

    scanner.close();
  }
}

