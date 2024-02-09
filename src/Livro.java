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
class Livro extends Publicacao implements Serializable{
    protected String resumo;
    protected String editoraIsbn;
    
   

    public Livro(String tipoPub,String[] autores, String titulo, String palChave,String resumo, String anoPub,  String dimAud, String editoraIsbn) {
        super(autores, titulo, palChave, anoPub, tipoPub, dimAud);
        this.resumo = resumo;
        this.editoraIsbn = editoraIsbn;
        
    }
    /**
     * Calcula o fator impacto do Artigo de Conferencia
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
     * String com o a informacao sobre o Livro
     * @return str
     */
    @Override
    public String toString() {
        return super.toString()+"Resumo: "+resumo+"\n"+"Editora/ISBN: "+editoraIsbn+"\n";
    }
    
    /**
     * Metodo que devolve o resumo do artigo
     * @return resusmo
     */
    public String getResumo() {
        return resumo;
    }
    /**
     * permite ao utilizar mudar o resumo 
     * @param resumo 
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    /**
     * Metodo que devolve a editora e o ISBN do artigo
     * @return editoraIsbn
     */
    public String getEditoraIsbn() {
        return editoraIsbn;
    }
    /**
     * permite ao utilizar mudar a editora/Isbn
     * @param editoraIsbn 
     */
    public void setEditoraIsbn(String editoraIsbn) {
        this.editoraIsbn = editoraIsbn;
    }
    
}
