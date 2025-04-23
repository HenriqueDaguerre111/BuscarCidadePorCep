package org.example;

import org.example.utils.IntervalTreeLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        String path = "src/main/resources/ceps.txt";

        IntervalTreeLogic treeSearch = new IntervalTreeLogic();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null && !linha.equals("--")) {
                String[] parts = linha.split(",");
                treeSearch.addIntervalo(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[0]);
            }

            int cep = Integer.parseInt(br.readLine());
            String cidade = treeSearch.searchCidade(cep);

            System.out.println(cidade != null ? cidade : "Cidade Não Encontrada: " + cep);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    }