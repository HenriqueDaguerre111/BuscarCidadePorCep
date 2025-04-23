package org.example.utils;

import org.example.entities.Cep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntervalTreeLogic {
    List<Cep> ceps;


    public IntervalTreeLogic() {
        this.ceps = new ArrayList<>();
    }

    public void addIntervalo(Integer cepInicial, Integer cepFinal, String cidade) {

        ceps.add(new Cep(cidade, cepInicial, cepFinal));
        ceps.sort(Comparator.comparingInt(Cep::getCepInicial));
    }

    public String searchCidade(int postalcode) {
        int index = buscar(postalcode);
        return index != -1 && postalcode >= ceps.get(index).getCepInicial() && postalcode <= ceps.get(index).getCepFinal()
                ? ceps.get(index).getCidade()
                : null;
    }
    private int buscar(int postalcode) {
        int low = 0;
        int high = ceps.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Cep midCep = ceps.get(mid);

            if (postalcode < midCep.getCepInicial()) {
                high = mid - 1;
            } else if (postalcode > midCep.getCepFinal()) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
