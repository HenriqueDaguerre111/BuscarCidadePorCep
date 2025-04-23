package org.example.entities;

public class Cep {

    private String Cidade;
    private Integer cepInicial;
    private Integer cepFinal;

    public Cep(String cidade, Integer cepInicial, Integer cepFinal) {
        this.Cidade = cidade;
        this.cepInicial = cepInicial;
        this.cepFinal = cepFinal;
    }

    public String getCidade() {
        return Cidade;
    }

    public int getCepInicial() {
        return cepInicial;
    }

    public int getCepFinal() {
        return cepFinal;
    }


    
}
