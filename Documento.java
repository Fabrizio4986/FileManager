import java.io.*;

public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titolo;
    private String autore;
    private String contenuto;
    private int numPagine;
    @SuppressWarnings("unchecked")
    private String basePath = "C:\\Users\\Francesca\\Documents\\Fab\\Java\\file_java\\";

    public Documento(String titolo, String autore, String contenuto, int numPagine){
        this.titolo = titolo;
        this.autore = autore;
        this.contenuto = contenuto;
        this.numPagine = numPagine;

    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    @SuppressWarnings("unchecked")
    public String getContenuto() {
        return contenuto;
    }

    @SuppressWarnings("unchecked")
    public int getNumPagine() {
        return numPagine;
    }

    @SuppressWarnings("unchecked")
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @SuppressWarnings("unchecked")
    public void setAutore(String autore) {
        this.autore = autore;
    }

    @SuppressWarnings("unchecked")
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @SuppressWarnings("unchecked")
    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    public void stampaInfo() {
        System.out.println("Titolo: " + titolo + ", Autore: " + autore + ", n° pagine: " + numPagine);
        System.out.println("Contenuto: " + contenuto);
    }

    public void salvaSuFile(Documento doc){
        String nomeFile = doc.getAutore() + doc.getTitolo();
        String filePath = basePath + nomeFile +".ser";

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(doc);
            System.out.println("Oggetto serializzato con successo!");
        } catch (IOException e ){
            System.out.println("Errore durante la serializzazione: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
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
