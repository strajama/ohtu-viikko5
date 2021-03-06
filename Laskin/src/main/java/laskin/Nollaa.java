/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author strajama
 */
public class Nollaa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int edellinen;
    private int arvo;

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
        
    }

    @Override
    public void peru() {
        if (edellinen >= 0) {
            sovellus.plus(edellinen);
        } else {
            sovellus.miinus(edellinen);
        }
        syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
    }

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinen = 0;
        this.arvo = 0;
    }

}
