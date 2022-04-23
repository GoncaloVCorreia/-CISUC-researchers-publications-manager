/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package maincisuc;

import java.util.Scanner;

/**
 *
 * @author goncalocorreia
 */
public class MainCISUC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainCISUC m = new MainCISUC();
    }

    public MainCISUC() {
        Gere g = new Gere();
        //Ler ficheiros 
        g.readFiles();
        
        
        
        
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        while (escolha != -1) {
            System.out.print("OPCOES: \n" + "1- Apresentar os indicadores gerais do CISUC\n" + "2- Listar publicacoes de um Grupo de Investigação\n" + "3- Listar os membros de um grupo de investigação\n" +"4- Listar as publicações de um investigador \n"+"5- Listar todos os grupos de investigação\n"+ "6- Sair\n" + "Escolha: ");
            escolha = sc.nextInt();
            if (escolha == 1) {
                //Apresenta os indicadores Gerais 1)
                System.out.print(g.indicadoresGeraisCisuc());
            }
            if (escolha == 2) {
                //Apresenta as publicacoes de um grupo 2)
                System.out.println(g.listaPubGrupo());

            }
            if (escolha == 3) {
                //Apresenta os membros agrupados de um grupo 3)
                System.out.println(g.listarMembrosGrupo());
            }
            if (escolha == 4) {
                //Listar as publicações de um investigador
                System.out.println(g.pubInv());
               

            }
            if (escolha == 5) {
                //5)Listar todos os grupos de investigação
                System.out.print(g.listarTodosGruposInv());
            }
            if (escolha == 6) {
                //Sair e escrever a informacao para ficheiro de objetos 
                g.writeFiletoObj();
                escolha = -1;
            }
        }
    }

}
