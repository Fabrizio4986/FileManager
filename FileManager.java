import java.io.*;

public class FileManager {
    private String basePath = "C:\\Users\\Francesca\\Documents\\Fab\\Java\\file_java\\";

    public void scriviSuFile(String nomeFile, String contenuto) {
        String filePath = basePath + nomeFile;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(contenuto);
        } catch (IOException e) {
            System.out.println("Errore nella gestione del file: " + e.getMessage());


        }
    }

    public void leggiDaFile(String nomeFile) {
        String filePath = basePath + nomeFile;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Testo letto dal file:");
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Errore nella gestione del file: " + e.getMessage());
        }

    }

    public void copiaFile(String sorgente, String destinazione) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sorgente));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinazione))) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Copia completata con successo!");
        } catch (IOException e) {
            System.out.println("Errore nella gestione del file: " + e.getMessage());
        }
    }

    public void eliminaFile(String nomeFile) {
        String filePath = basePath + nomeFile;
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Il file non esiste");
        } else {
            if (file.delete()) {
                System.out.println("Il file è stato eliminato");
            } else {
                System.out.println("Non è possibile eliminare il file");
            }
        }

    }
}
