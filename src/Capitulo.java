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
class Capitulo extends Livro implements Serializable {
    private String nomeCap;
    private String paginaInicial;
    private String paginaFinal;
    
    public Capitulo(String tipoPub, String[] autores, String titulo, String palChave, String resumo, String anoPub, String dimAud, String editoraIsbn,String nomeCap,String pInicial,String pFinal) {
        super(tipoPub, autores, titulo, palChave, resumo, anoPub, dimAud, editoraIsbn);
        this.nomeCap=nomeCap;
        this.paginaInicial=pInicial;
        this.paginaFinal=pFinal;
    }
    /**
     * Calcula o fator impacto do Livro
     * @return str
     */
     @Override
    public String fatorImapacto(){
        String str="";
        if(Integer.parseInt(dimAud)>=10000){
            str+="A";
         
        }
        if(5000<=Integer.parseInt(dimAud) && Integer.parseInt(dimAud)<10000){
            str+="B";
        }
        if(5000>Integer.parseInt(dimAud)){
            str+="C";
        }
        return str;
    }
    /**
     * String com a informacao sobre o Capitulo
     * @return str
     */
    @Override
    public String toString() {
        String str=super.toString();
        str+="Nome Capitulo: " + nomeCap +"\n";
        str+="Pagina Inicial: " + paginaInicial +"\n";
        str+="Pagina Final: " + paginaFinal +"\n";
        return str;
    }
    
    /**
     * Metodo que devolve o nome do Capitulo
     * @return nomeCap
     */
    public String getNomeCap() {
        return nomeCap;
    }
    /**
     * permite ao utilizar mudar o nome do capitulo  
     * @param nomeCap 
     */
    public void setNomeCap(String nomeCap) {
        this.nomeCap = nomeCap;
    }
    /**
     * Metodo que devolve a pagina inicial de um artigo
     * @return paginaInicial
     */
    public String getPaginaInical() {
        return paginaInicial;
    }
    /**
     * permite ao utilizar mudar o a pagina inicial do capitulo
     * @param paginaInical 
     */
    public void setPaginaInical(String paginaInical) {
        this.paginaInicial = paginaInical;
    }
    /**
     * Metodo que devolve a paginal final do artigo
     * @return paginaFinal
     */
    public String getPaginaFinal() {
        return paginaFinal;
    }
    /**
     * permite ao utilizar mudar a pagina final do capitulo
     * @param paginaFinal 
     */
    public void setPaginaFinal(String paginaFinal) {
        this.paginaFinal = paginaFinal;
    }
    

    
}
