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
class MembroEfetivo extends Investigador implements Serializable {
    private String numeroGab;
    private String nTele;

    public MembroEfetivo(String TYPE,String nome, String mail, String gInv,String numeroGab,String nTele) {
        super(TYPE,nome, mail, gInv);
        this.numeroGab=numeroGab;
        this.nTele=nTele;
    }
    /**
     * String com informacao sobre Membros Efetivos
     * @return str
     */
    @Override
    public String toString() {
        return "<<<<<<Membro Efetivo>>>>>\n"+super.toString()+"Numero Gabinete: "+numeroGab+"\n"+"Numero Telemovel: "+nTele+"\n";
    }
    /**
     * Metodo que devolve o numero de gabinete
     * @return numeroGab
     */
    public String getNumeroGab() {
        return numeroGab;
    }
    /**
     *  permite ao utilizar mudar o numero de gabinete 
     * @param numeroGab 
     */
    public void setNumeroGab(String numeroGab) {
        this.numeroGab = numeroGab;
    }
    /**
     * Metodo que devolve o numero de telemovel
     * @return nTele
     */
    public String getnTele() {
        return nTele;
    }
    /**
     * permite ao utilizar mudar o numero de telemovel
     * @param nTele 
     */
    public void setnTele(String nTele) {
        this.nTele = nTele;
    }
    
    
}
