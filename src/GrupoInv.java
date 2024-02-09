/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package maincisuc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author goncalocorreia
 */
class GrupoInv implements Serializable {
    private String acronimo;
    private String nome;
    private String investigadorRp;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Publicacao> publicacoes;
    

    public GrupoInv(String acronimo, String nome, String InvestigadorRp) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.investigadorRp = InvestigadorRp;
        investigadores = new ArrayList<Investigador>();
        publicacoes = new ArrayList<Publicacao>();
        
    }
    /**
     * String com informacao sobre o Grupo de investigacao
     * @return str
     */
    public String toString() {
        String str="Nome: "+ nome+"\n"+"Acronimo: " + acronimo+"\n"+"Investigador Responsavel: "+ investigadorRp+"\n";
        str+="Investigadores do grupo: ";
        str+=investigadorRp+" ";
        for (int i=0;i<investigadores.size();i++){
            str+=investigadores.get(i).nome+" ";
        }
        str+="\n";
        return  str;
    }
    /**
     * Metodo que devolve o nome do grupo de investigacao
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * permite ao utilizar mudar o nome do grupo
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que devolve o acronimo do grupo de investigacao
     * @return 
     */
    public String getAcronimo() {
        return acronimo;
    }
    /**
     * permite ao utilizar mudar o acronimo
     * @param acronimo 
     */
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }
    /**
     * Metodo que devolve o investigador responsável do grupo de investigação
     * @return investigadorRp
     */
    public String getInvestigadorRp() {
        return investigadorRp;
    }
    /**
     * permite ao utilizar mudar o investigador responsavel 
     * @param InvestigadorRp 
     */
    public void setInvestigadorRp(String InvestigadorRp) {
        this.investigadorRp = InvestigadorRp;
    }
    /**
     * Metodo que devolve um array com os investigadores que fazem parte do grupo de investigacao
     * @return investigadores
     */
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }
    /**
     * permite ao utilizar adicionar investigador
     * @param investigador 
     */
    public void adicionaInvestigadores(Investigador investigador) {
        investigadores.add(investigador);
    }
    /**
     *  Metodo que devolve um array com publicacoes do grupo de investigacao
     * @return publicacoes
     */
    public ArrayList<Publicacao> getPublicacoes() {
        return publicacoes;
    }
    /**
     * permite ao utilizar mudar o array de publicacoes do grupo de investigacao
     * @param publcicacoes 
     */
    public void setPublicacoes(ArrayList<Publicacao> publcicacoes) {
        this.publicacoes = publcicacoes;
    }
    
    
}

