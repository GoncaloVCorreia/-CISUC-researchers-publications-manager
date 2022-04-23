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
class ArtigoRevista extends Publicacao implements Serializable{
    private String resumo;
    private String nomeConf;
    private String dataConf;
    private String numeroRevista;

    public ArtigoRevista(String tipoPub,String[] autores, String titulo, String palChave, String anoPub,  String dimAud, String resumo, String numRevista,String nomeRevista,String dataRevista) {
        super(autores, titulo, palChave, anoPub, tipoPub, dimAud);
        this.resumo=resumo;
        this.nomeConf = nomeRevista;
        this.dataConf = dataRevista;
        this.numeroRevista = numRevista;
    }
      /**
       * Calcula o fator impacto do Artigo de Revista
       * @return str
       */
     @Override
    public String fatorImapacto(){
        String str="";
        if(Integer.parseInt(dimAud)>=1000){
            str+="A";
         
        }
        if(500<=Integer.parseInt(dimAud) && Integer.parseInt(dimAud)<1000){
            str+="B";
        }
        if(500>Integer.parseInt(dimAud)){
            str+="C";
        }
        return str;
    }
    /**
     * String com informacao sobre Artigo Revista
     * @return str
     */
    @Override
    public String toString() {
        return super.toString()+ "Resumo: "+resumo + "\n" +"Nome da Revista: "+ nomeConf + "\n" +"Data da Revista: "+ dataConf + "\n" +"Numero da Revista: "+numeroRevista+"\n" ;
    }
    
    /**
     * Metodo que devolve o resumo
     * @return resumo
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
     * Metodo que devolve o nome da Conferencia
     * @return nomeConf
     */
    public String getNomeConf() {
        return nomeConf;
    }
    /**
     * permite ao utilizar mudar o nome da conferencia 
     * @param nomeConf 
     */
    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }
    /**
     * Metodo que devolve a data da Conferencia
     * @return dataConf
     */
    public String getDataConf() {
        return dataConf;
    }
    /**
     * permite ao utilizar mudar o a data da conferencia
     * @param dataConf 
     */
    public void setDataConf(String dataConf) {
        this.dataConf = dataConf;
    }
    /**
     * Metodo que devolve o numero de Revista
     * @return numeroRevista
     */
    public String getNumeroRevista() {
        return numeroRevista;
    }
    /**
     * permite ao utilizar mudar o numero da revista
     * @param numeroRevista 
     */
    public void setNumeroRevista(String numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

   
    
}
