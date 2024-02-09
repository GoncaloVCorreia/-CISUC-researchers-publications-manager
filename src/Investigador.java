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
class Investigador implements Serializable {
    protected String nome;
    protected String mail;
    protected String gInv;
    protected ArrayList<Publicacao> publicacoes;
    protected String TYPE;
    

    public Investigador(String TYPE,String nome, String mail, String gInv) {
        this.nome = nome;
        this.mail = mail;
        this.gInv = gInv;
        publicacoes = new ArrayList<Publicacao>();
        this.TYPE=TYPE;
        
    }
    /**
     * String com informacao sobre Investigador
     * @return str
     */
    public String toString() {
        return  "Nome: "+nome +"\n"+ "Email: "+mail +"\n"+ "Grupo de Investigacao: "+gInv+"\n" ;
    }
    /**
     * Metodo que devolve o nome do investigador
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * permite ao utilizar mudar o nome do investigador 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo que devolve o mail do investigador
     * @return mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * permite ao utilizar mudar o mail do investigador 
     * @param mail 
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    /**
     * Metodo que devolve o grupo de investigacao
     * @return gInv
     */
    public String getgInv() {
        return gInv;
    }
    /**
     * permite ao utilizar mudar o grupo de investigacao 
     * @param gInv 
     */
    public void setgInv(String gInv) {
        this.gInv = gInv;
    }
    /**
     * Metodo que devolve o array de publicacoes do investigador
     * @return publicacoes
     */
    public ArrayList<Publicacao> getPublicacoes() {
        return publicacoes;
    }
    /**
     * permite ao utilizar mudar o array de publicacoes 
     * @param publicacoes 
     */
    public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
    /**
     * Metodo que devolve o tipo do investigador
     * @return 
     */
    public String getTYPE() {
        return TYPE;
    }
    /**
     * permite ao utilizar mudar o type do investigador
     * @param TYPE 
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
    
    
}

