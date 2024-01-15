package it.epicode.be.elementoMultimediale.nonRiproducibile.immagine;

import it.epicode.be.elementoMultimediale.nonRiproducibile.NonRiproducibile;

public class Immagine extends NonRiproducibile{

    public Immagine(String _titolo) {
        super(_titolo);
    }

    @Override
        public void show(){
        String lum="";
        for (int i=0; i<this.luminosita; i++){
            lum+="*";
        }
        if(this.luminosita>0)
            System.out.println(this.titolo + lum + "\n");
        else
            System.out.println(this.titolo + "\n");

    }
}
