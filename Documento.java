import java.io.*;

public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titolo;
    private String autore;
    private String contenuto;
    private String basePath = "C:\\Users\\Francesca\\Documents\\Fab\\Java\\file_java\\";

    public Documento(String titolo, String autore, String contenuto){
        this.titolo = titolo;
        this.autore = autore;
        this.contenuto = contenuto;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void stampaInfo() {
        System.out.println("Titolo: " + titolo + ", Autore: " + autore);
        System.out.println("Contenuto: " + contenuto);
    }

    public void salvaSuFile(String nomeFile){

        String filePath = basePath + nomeFile +".ser";

        Documento doc = new Documento("Tesi","Fabrizio", "contenuto tesi");

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(doc);
            System.out.println("Oggetto serializzato con successo!");
        } catch (IOException e ){
            System.out.println("Errore durante la serializzazione: " + e.getMessage());
        }
    }

    public void caricaDaFile(String nomeFile){

        String filePath = basePath + nomeFile +".ser";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Documento doc = (Documento) ois.readObject();
            System.out.println("Oggetto deserializzato con successo!");
            doc.stampaInfo();
        }catch (IOException | ClassNotFoundException e ){
            System.out.println("Errore durante la deserializzazione: " + e.getMessage());
        }

    }
}
