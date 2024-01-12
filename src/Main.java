import it.epicode.be.elementoMultimediale.nonRiproducibile.immagine.Immagine;
import it.epicode.be.elementoMultimediale.riproducibile.video.Video;

import java.util.Scanner;

public class Main {

    public static void menuIniziale(){
        Integer scelta;
        do {
            System.out.println("\n\n***Pagina Principale***\n");
            System.out.println("Cosa vuoi far partire?");
            System.out.println("0: Annulla tutto");
            System.out.println("1: Audio");
            System.out.println("2: Video");
            System.out.println("3: Immagine");
            scelta = Main.verificaScelta(4);
            switch (scelta) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    scelta2();
                    break;
                case 3:
                    scelta3();
                    break;
            }
        } while (scelta != 0);
    }
    public static int verificaScelta(int numScelte){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("La tua scelta: ");
        Integer scelta=scanner.nextInt();
        while (scelta>=numScelte || !(scelta instanceof Integer)) {
            System.out.printf("Scelta non valida: ");
            System.out.println("Controlla la tua scelta?");
            scelta=scanner.nextInt();
        }

        return scelta;
    }
    public static void scelta2() {
        System.out.printf("Come si chiama il tuo video? Digita qui: ");
        Scanner scanner = new Scanner(System.in);
        String titolo = scanner.nextLine();
        Integer durata;
        do{
            System.out.printf("Quanto dura il tuo video? Digita qui: ");
            durata = scanner.nextInt();
            if (durata<1) {
                System.out.println("La durata non può essere 0");
            } else if (durata>10) {
                System.out.println("La durata non può superare i 10min");
            }
        }while (!(durata>0 && durata<11));

        Video video = new Video(titolo, durata);
        System.out.printf("\nEcco il tuo video: ");
        video.play();
        System.out.println("Azioni possibili: ");
        System.out.println("0: Alza la luminosità");
        System.out.println("1: Abbassa la luminosità");
        System.out.println("2: Alza il volume");
        System.out.println("3: Abbassa il volume");
        System.out.println("4: Torna alla pag. principale: ");
        Integer scelta = Main.verificaScelta(5);
        while(scelta!=4){
            switch (scelta) {
                case 0:
                    video.aumentaLum();
                    System.out.printf("Ecco il tuo video: ");
                    video.play();
                    break;
                case 1:
                    video.diminusciLum();
                    System.out.printf("Ecco il tuo video: ");
                    video.play();
                    break;
                case 2:
                    video.aumentaVol();
                    System.out.printf("Ecco il tuo video: ");
                    video.play();
                    break;
                case 3:
                    video.diminusciVol();
                    System.out.printf("Ecco il tuo video: ");
                    video.play();
                    break;
                case 4:
                    menuIniziale();
                    return;
            }
            System.out.println("Azioni possibili: ");
            System.out.println("0: Alza la luminosità");
            System.out.println("1: Abbassa la luminosità");
            System.out.println("2: Alza il volume");
            System.out.println("3: Abbassa il volume");
            System.out.println("4: Torna alla pag. principale: ");
            scelta = Main.verificaScelta(5);
        }
    }
    public static void scelta3() {
        System.out.printf("Come si chiama la tua immagine? Digita qui: ");
        Scanner scanner = new Scanner(System.in);
        String titolo = scanner.nextLine();
        Immagine immagine = new Immagine(titolo);
        System.out.printf("\nEcco la tua immagine: ");
        immagine.show();
        System.out.println("Azioni possibili: ");
        System.out.println("0: Alza la luminosità");
        System.out.println("1: Abbassa la luminosità");
        System.out.println("2: Torna alla pag. precedente: ");
        Integer scelta = Main.verificaScelta(3);
        while(scelta!=2){
            switch (scelta) {
                case 0:
                    immagine.aumentaLum();
                    System.out.printf("Ecco la tua immagine: ");
                    immagine.show();
                    break;
                case 1:
                    immagine.diminusciLum();
                    System.out.printf("Ecco la tua immagine: ");
                    immagine.show();
                    break;
                case 2:
                    menuIniziale();
                    return;
            }
            System.out.println("Azioni possibili: ");
            System.out.println("0: Alza la luminosità");
            System.out.println("1: Abbassa la luminosità");
            System.out.println("2: Torna alla pag. precedente: ");
            scelta = Main.verificaScelta(3);
        }
    }

    public static void main() {
        menuIniziale();
    }

}




