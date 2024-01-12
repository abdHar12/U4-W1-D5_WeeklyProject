package it.epicode.be.elementoMultimediale.nonRiproducibile;

import it.epicode.be.elementoMultimediale.ElementoMultimediale;
import it.epicode.be.elementoMultimediale.Visivo;

public abstract class NonRiproducibile extends ElementoMultimediale implements Visivo {

    protected static int luminosita;
    public NonRiproducibile(String _titolo) {
        super(_titolo);
    }

    abstract protected void show();

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
