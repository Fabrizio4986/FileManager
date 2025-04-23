import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String scelta = "";
        String titolo;
        String autore;
        String contenuto;
        String numPag;
        boolean inputValido = false;
        int numPagine =0;
        String titoloPerRicerca;
        List<Documento> docSalvati = new ArrayList<>();
        while(scelta.compareToIgnoreCase("termina") != 0) {
            System.out.println("Benvenuto, che operazione vuoi fare?");
            System.out.println("Digita 'inserisci' per Inserire un nuovo documento");
            System.out.println("Digita 'cerca' per cercare un documento");
            System.out.println("Digita 'elimina' per eliminare un documento ");
            System.out.println("Digita 'visualizza' per visualizzare l'elenco dei documenti salvati");
            System.out.println("Digita 'termina' per terminare il programma");

            scelta = scr.nextLine();

            switch(scelta){
                case "inserisci":
                    System.out.println("Inserisci il titolo del documento");
                    titolo = scr.nextLine();
                    System.out.println("Inserisci l'autore del documento");
                    autore = scr.nextLine();
                    System.out.println("Inserisci il contenuto del documento");
                    contenuto = scr.nextLine();
                    while(!inputValido) {
                        System.out.println("Inserisci il numero di pagine del documento");
                        numPag = scr.nextLine();
                        try {
                            numPagine = Integer.parseInt(numPag);
                            if (numPagine < 1 || numPagine > 999) {
                                throw new IllegalArgumentException();
                            } else {
                                inputValido = true;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Input non valido. Inserire un numero intero compreso tra 1 e 999");
                        }
                    }
                    inputValido = false;
                    Documento doc = new Documento(titolo, autore, contenuto, numPagine);
                    docSalvati.add(doc);
                    doc.salvaSuFile(doc);

                    break;
                case "cerca":
                    System.out.println("Inserisci il titolo del documento che stai cercando");
                    titoloPerRicerca = scr.nextLine();

                    for (Documento d : docSalvati) {
                        if (titoloPerRicerca.compareToIgnoreCase(d.getTitolo()) == 0) {
                            FileManager.leggiDaFile(d.getAutore() + d.getTitolo());
                            break;
                        }
                    }
                    break;
                case "elimina":
                    System.out.println("Inserisci il titolo del documento da eliminare");
                    titoloPerRicerca = scr.nextLine();
                    for (Documento d : docSalvati) {
                        if (titoloPerRicerca.compareToIgnoreCase(d.getTitolo()) == 0) {
                            FileManager.eliminaFile(d.getAutore() + d.getTitolo());
                            docSalvati.remove(d);
                            break;
                        }
                    }
                    break;
                case "visualizza":
                    System.out.println("Ecco la lista dei documenti attualmente salvati:");
                    for (Documento d : docSalvati){
                        d.stampaInfo();
                        System.out.println("-----------------------------------");
                    }
                    break;
                case "termina":
                    System.out.println("Programma terminato");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }

        }

    }

}
