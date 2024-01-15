import it.epicode.be.elementoMultimediale.ElementoMultimediale;
import it.epicode.be.elementoMultimediale.nonRiproducibile.immagine.Immagine;
import it.epicode.be.elementoMultimediale.riproducibile.regAudio.RegAudio;
import it.epicode.be.elementoMultimediale.riproducibile.video.Video;

import java.util.Scanner;

public class Main {
    public static void sceltaRiproduzione(Object Media){
        String exit="";
        do {
            switch (nameOf(Media)) {
                case "RegAudio":
                    sceltaAudio((RegAudio) Media);
                    break;
                case "Video":
                    sceltaVideo((Video) Media);
                    break;
                case "Immagine":
                    sceltaImmagine((Immagine) Media);
                    break;
                default:
                    exit="Esci";
                    return;
            }
            if(!(exit.equals("Esci"))){
                creationOfArray();
            }
        } while (!(exit.equals("Esci")));
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

    public static Integer insertDurata() {
        Integer durata;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.printf("Quanto dura? Digita qui: ");
            durata = scanner.nextInt();
            if (durata < 1) {
                System.out.println("La durata non può essere 0");
            } else if (durata > 10) {
                System.out.println("La durata non può superare i 10min");
            }
        } while (!(durata > 0 && durata < 11));

        return durata;
    }


    public static void sceltaAudio(RegAudio regAudio) {

        System.out.printf("\nEcco il tuo audio: ");
        regAudio.play();
        System.out.println("Azioni possibili: ");
        System.out.println("0: Alza il volume");
        System.out.println("1: Abbassa il volume");
        System.out.println("2: Torna alla pag. precedente: ");
        Integer scelta =Main.verificaScelta(3);

        while(scelta!=2){
            switch (scelta) {
                case 0:
                    regAudio.aumentaVol();
                    System.out.printf("Ecco il tuo audio: ");
                    regAudio.play();
                    break;
                case 1:
                    regAudio.diminusciVol();
                    System.out.printf("Ecco il tuo audio: ");
                    regAudio.play();
                    break;
                case 2:
                    return;
            }
            System.out.println("Azioni possibili: ");
            System.out.println("0: Alza il volume");
            System.out.println("1: Abbassa il volume");
            System.out.println("2: Torna alla pag. precedente: ");
            scelta=Main.verificaScelta(3);
        }
    }

    public static void sceltaVideo(Video video) {

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
    public static void sceltaImmagine(Immagine immagine) {
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
                    return;
            }
            System.out.println("Azioni possibili: ");
            System.out.println("0: Alza la luminosità");
            System.out.println("1: Abbassa la luminosità");
            System.out.println("2: Torna alla pag. precedente: ");
            scelta = Main.verificaScelta(3);
        }
    }
    public static void mostraMedia(Object[] listOfMedias){
        System.out.println("\n\nEcco i tuoi 5 media: ");
        for(int i=0; i<5; i++){
            System.out.println("Media " + i + ": " + nameOf(listOfMedias[i]) + " | Titolo: "+((ElementoMultimediale)listOfMedias[i]).getTitolo());
        }
        System.out.println("5: Se vuoi annullare l'operazione e spegnere il lettore");
        System.out.print("\nQuale vuoi riprodurre? ");
    }

    private static String nameOf(Object o) {
        return o.getClass().getSimpleName();
    }

    static Object[] listOfMedias = new Object[5];
    private static void creationOfArray(){
        if(listOfMedias[1]==null){
            System.out.println("Inserisci i 5 media: ");
            Scanner scanner = new Scanner(System.in);
            String titolo;
            Integer durata;
            for (int i = 0; i < 5; i++) {
                System.out.println("Cosa vuoi inserire?");
                System.out.println("0: Audio");
                System.out.println("1: Video");
                System.out.println("2: Immagine");
                System.out.println("3: Spegni il lettore");
                Integer scelta = Main.verificaScelta(4);
                switch (scelta) {
                    case 0:
                        System.out.printf("Come si chiama il tuo audio? Digita qui: ");
                        titolo = scanner.nextLine();
                        durata = insertDurata();
                        RegAudio regAudio = new RegAudio(titolo, durata);
                        listOfMedias[i] = regAudio;
                        break;
                    case 1:
                        System.out.printf("Come si chiama il tuo video? Digita qui: ");
                        titolo = scanner.nextLine();
                        durata = insertDurata();
                        Video video = new Video(titolo, durata);
                        listOfMedias[i] = video;
                        break;
                    case 2:
                        System.out.printf("Come si chiama la tua immagine? Digita qui: ");
                        titolo = scanner.nextLine();
                        Immagine immagine = new Immagine(titolo);
                        listOfMedias[i] = immagine;
                        break;
                    case 3:
                        return;
                }
            }
        }
        mostraMedia(listOfMedias);
        Integer riproduzione = Main.verificaScelta(6);
        if (riproduzione >= 0 && riproduzione < 5) sceltaRiproduzione(listOfMedias[riproduzione]);
        else if (riproduzione == 5) return;
    };
    public static void main() {
        creationOfArray();
    }

}




