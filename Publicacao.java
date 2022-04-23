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
class Publicacao implements Serializable,Comparable<Publicacao>{
    protected String[] autores;
    protected String titulo;
    protected String palChave;
    protected String anoPub;
    protected String tipoPub;
    protected String dimAud;
    protected ArrayList<Investigador> investigadores;

    public Publicacao(String[] autores,String titulo, String palChave, String anoPub, String tipoPub, String dimAud) {
        this.autores=autores;
        this.titulo = titulo;
        this.palChave = palChave;
        this.anoPub = anoPub;
        this.tipoPub = tipoPub;
        this.dimAud = dimAud;
        investigadores = new ArrayList<Investigador>();
       
    }
    /**
     * Calcula Fator Impacto de acordo com tipo de publicacao
     * @return str
     */
    public String fatorImapacto(){
        String str="";
        return str;
    }
    /**
     * String com as informacoes sobre a publicacao
     * @return 
     */
    public String toString() {
        String str="Tipo de Publicacao: "+tipoPub+"\n";
        str+="Autores: ";
        for (int i=0;i<autores.length;i++){
            str+=autores[i]+" ";
        }
        str+="\n"+"Titulo: "+titulo+"\n"+"Palavra Chave: "+palChave+"\n"+"Ano de Publicacao: "+anoPub+"\n"+"Dimensao Auditorio: "+dimAud+"\n";
        return str;
    }

    
    /**
     * Metodo que devolve o titulo da publicacao
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * permite ao utilizar mudar o titulo 
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Metodo que devolve a palavra chave
     * @return palChave
     */
    public String getPalChave() {
        return palChave;
    }
    /**
     * permite ao utilizar mudar a palavra chave
     * @param palChave 
     */
    public void setPalChave(String palChave) {
        this.palChave = palChave;
    }
    /**
     * Metodo que devolve o ano de publicacao 
     * @return 
     */
    public String getAnoPub() {
        return anoPub;
    }
    /**
     * permite ao utilizar mudar o ano de publicacao 
     * @param anoPub 
     */
    public void setAnoPub(String anoPub) {
        this.anoPub = anoPub;
    }
    /**
     * Metodo que devolve o tipo de publicacao
     * @return tipoPub
     */
    public String getTipoPub() {
        return tipoPub;
    }
    /**
     * permite ao utilizar mudar o tipo de publicacao
     * @param tipoPub 
     */
    public void setTipoPub(String tipoPub) {
        this.tipoPub = tipoPub;
    }
    /**
     * Metodo que devolve a dimensao da audiencia
     * @return dimAud
     */
    public String getDimAud() {
        return dimAud;
    }
    /**
     * permite ao utilizar mudar a dimensao da audiencia
     * @param dimAud 
     */
    public void setDimAud(String dimAud) {
        this.dimAud = dimAud;
        
    }
    /**
     * Metodo que devolve um array com o nome dos autores
     * @return autores
     */
    public String[] getAutores() {
        return autores;
    }
    /**
     * permite ao utilizar mudar o array de autores 
     * @param autores 
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }
    /**
     * Metodo que devolve um array com os investigadores que fazem parte da publicacao
     * @return investigadores
     */
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }
    /**
     * permite ao utilizar mudar o array de investigadores da publicacao
     * @param investigadores 
     */
    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    
    /**
     * Ordena de acordo com o data, se a data for igual ordena de acordo com o fator impacto
     * @param p
     * @return 
     */
    @Override
    public int compareTo(Publicacao p) {
       
        if(Integer.parseInt(p.anoPub)<Integer.parseInt(anoPub)){
            return -1;
        }
        if(Integer.parseInt(p.anoPub)==Integer.parseInt(anoPub)){
           
            if(Integer.parseInt(p.dimAud)<Integer.parseInt(dimAud)){
                return -1;
            }
            else{
                return 1;
            }
        }
        
        else{
            return 1;
        }
    }
    
    
}
        

