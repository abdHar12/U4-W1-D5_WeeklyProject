package it.epicode.be.elementoMultimediale.riproducibile.video;

import it.epicode.be.elementoMultimediale.Visivo;
import it.epicode.be.elementoMultimediale.riproducibile.Riproducibile;

public class Video extends Riproducibile implements Visivo {
    private int luminosita;

    public Video(String _titolo, Integer _durata) {
        super(_titolo, _durata);
    }

    @Override
    public void play() {
        String lum="";
        for (int i=0; i<this.luminosita; i++){
            lum+="*";
        }
        String volume="";
        for (int i=0; i<this.volume; i++){
            volume+="!";
        }
        String durata="";
        for (int i=0; i<this.durata; i++){
            durata+=this.titolo;
        }
        System.out.println(durata+volume+lum);
    }

    @Override
    public void aumentaLum() {
        if(this.luminosita<10)this.luminosita++;
        else System.out.println("\nLuminosità già al massimo\n");
    }

    @Override
    public void diminusciLum() {
        if (this.luminosita > 0)
            this.luminosita--;
        else
            System.out.println("\nLuminosità già al minimo\n");
    }
}
