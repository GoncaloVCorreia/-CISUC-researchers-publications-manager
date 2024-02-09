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
class Estudante extends Investigador implements Serializable {
    private String tituloTese;
    private String dataConclusao;
    private String orientador;

    public Estudante( String TYPE,String nome, String mail, String gInv,String tituloTese, String dataConclusao, String orientador) {
        super(TYPE,nome, mail, gInv);
        this.tituloTese = tituloTese;
        this.dataConclusao = dataConclusao;
        this.orientador = orientador;
    }
    /**
     * String com informacao sobre Estudantes
     * @return str
     */
    @Override
    public String toString() {
        return "<<<<<<<Estudante>>>>>\n"+super.toString() +"Titulo da Tese: "+ tituloTese +"\n"+"Data de conclusao: "+ dataConclusao +"\n" +"Orientador: "+ orientador+"\n";
    }
    
    /**
     * Metodo que devolve o titulo da tese
     * @return tituloTese
     */
    public String getTituloTese() {
        return tituloTese;
    }
    /**
     * permite ao utilizar mudar o titulo da tese
     * @param tituloTese 
     */
    public void setTituloTese(String tituloTese) {
        this.tituloTese = tituloTese;
    }
    /**
     * Metodo que devolve a data de conclusao da tese
     * @return dataConclusao
     */
    public String getDataConclusao() {
        return dataConclusao;
    }
    /**
     * permite ao utilizar mudar a data de conclusao
     * @param dataConclusao 
     */
    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
    /**
     * Metodo que devolve o nome do orientador
     * @return orientador
     */
    public String getOrientador() {
        return orientador;
    }
    /**
     * permite ao utilizar mudar o nome do orientador
     * @param orientador 
     */
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }
   
}

    

