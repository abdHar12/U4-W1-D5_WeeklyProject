package it.epicode.be.elementoMultimediale.riproducibile;

import it.epicode.be.elementoMultimediale.ElementoMultimediale;
import it.epicode.be.elementoMultimediale.Uditivo;

public abstract class Riproducibile extends ElementoMultimediale implements Uditivo {
    protected static int volume;
    protected Integer durata;

    public Riproducibile(String _titolo, Integer _durata) {
        super(_titolo);
        this.durata=_durata;
    }

    protected abstract void play();

    @Override
    public void aumentaVol(){
        if (this.volume <10)
            Riproducibile.volume++;
        else System.out.println("\nIl volume già al massimo\n");
    };
    @Override
    public void diminusciVol(){
        if (this.volume > 0)
            Riproducibile.volume--;
        else System.out.println("\nIl volume già al minimo\n");
    };
}
