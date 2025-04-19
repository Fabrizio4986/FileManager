import java.io.File;
import java.io.IOException;

public class DownloaderDue extends Thread {
    private String basePath = "C:\\Users\\Francesca\\Documents\\Fab\\Java\\file_java\\";

    @Override
    public void run() {
        String nomeFile = "download2.txt";
        String filePath = basePath + nomeFile;
        File file = new File(filePath);

        try{
            if(!file.exists()) {
                if(file.createNewFile()) {
                    FileManager.scriviSuFile(nomeFile, "Download completato!" );
                    System.out.println("File creato con successo: " + file.getAbsolutePath());
                } else {
                    System.out.println("Impossibile creare il file");
                }
            } else {
                System.out.println("Il file esiste già");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Dimensione del file: " + file.length() + " byte");
        System.out.println("Thread in esecuzione: " + Thread.currentThread().getName());
    }

}
