package it.epicode.be.elementoMultimediale.riproducibile.regAudio;

import it.epicode.be.elementoMultimediale.riproducibile.Riproducibile;

public class RegAudio extends Riproducibile {

    public RegAudio(String _titolo, int _durata) {
        super(_titolo, _durata);
    }

    @Override
    public void play() {
        String volume="";
        for (int i=0; i<Riproducibile.volume; i++){
            volume+="!";
        }
        String durata="";
        for (int i=0; i<this.durata; i++){
            durata+=this.titolo;
        }
        System.out.println(durata+volume);
    }
}
