/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package maincisuc;

import java.io.Serializable;

/**
 *
 * @author goncalocorreia
 */
class LivroArtigo extends Livro implements Serializable{
    
    private String nomeConf;
    private String numArtigos;
    
    public LivroArtigo(String tipoPub, String[] autores, String titulo, String palChave, String resumo, String anoPub, String dimAud, String editoraIsbn,String nomeConf, String numArtigos) {
        
        super(tipoPub, autores, titulo, palChave, resumo, anoPub, dimAud, editoraIsbn);
        this.nomeConf=nomeConf;
        this.numArtigos=numArtigos;
    }
    /**
     * Calcula o fator impacto do Livro de Artigo
     * @return str
     */
     @Override
    public String fatorImapacto(){
        String str="";
        if(Integer.parseInt(dimAud)>=7500){
            str+="A";
         
        }
        if(5000<=Integer.parseInt(dimAud) && Integer.parseInt(dimAud)<7500){
            str+="B";
        }
        if(5000>Integer.parseInt(dimAud)){
            str+="C";
        }
        return str;
    }
    /**
     * String com as informacoes sobre o Livro Artigo
     * @return str
     */
    @Override
    public String toString() {
        String str=super.toString();
        str+="Nome Conferencia: "+nomeConf+"\n";
        str+="Numero de Artigos: "+numArtigos+"\n";
        return str;
    }
    
    /**
     * Metodo que devolve o nome da conferencia
     * @return nomeConf
     */
    public String getNomeConf() {
        return nomeConf;
    }
    /**
     * permite ao utilizar mudar o nome do livro artigo
     * @param nomeConf 
     */
    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }
    /**
     * Metodo que devolve o numero de artigos
     * @return numArtigos
     */
    public String getNumArtigos() {
        return numArtigos;
    }
    /**
     * permite ao utilizar mudar o numero de artigos
     * @param numArtigos 
     */
    public void setNumArtigos(String numArtigos) {
        this.numArtigos = numArtigos;
    }

   
    
}
