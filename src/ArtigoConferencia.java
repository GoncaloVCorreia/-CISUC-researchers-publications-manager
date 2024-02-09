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
class ArtigoConferencia extends Publicacao implements Serializable{
   
    private String resumo;
    private String localConf;
    private String nomeConf;
    private String dataConf;
    
    public ArtigoConferencia(String tipoPub,String[] autores, String titulo, String palChave, String anoPub,  String dimAud,String resumo, String localConf, String nomeConf,String dataConf) {
        super(autores, titulo, palChave, anoPub, tipoPub, dimAud);
        this.resumo = resumo;
        this.localConf = localConf;
        this.nomeConf = nomeConf;
        this.dataConf = dataConf;
    }
    /**
     * Calcula o fator impacto do Artigo de Conferencia
     * @return str
     */
    @Override
    public String fatorImapacto(){
        String str="";
        if(Integer.parseInt(dimAud)>=500){
            str+="A";
         
        }
        if(200<=Integer.parseInt(dimAud) && Integer.parseInt(dimAud)<500){
            str+="B";
        }
        if(200>Integer.parseInt(dimAud)){
            str+="C";
        }
        return str;
    }
    /**
     * String com informacao sobre Artigo Conferencia
     * @return str
     */
    @Override
    public String toString() {
        return super.toString()+ "Resumo: "+resumo + "\n" +"Local: "+ localConf + "\n" +"Nome da Conferencia: "+ nomeConf + "\n" +"Data da Conferencia: "+dataConf+"\n" ;
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
     * Metodo que devolve o Local da Conferencia
     * @return localConf
     */
    public String getLocalConf() {
        return localConf;
    }
    /**
     * permite ao utilizar mudar o nome do local de Conferencia
     * @param localConf 
     */
    public void setLocalConf(String localConf) {
        this.localConf = localConf;
    }
    /**
     * Metodo que devolve o nome da conferencia
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
     * permite ao utilizar mudar a data da conferencia
     * @param dataConf 
     */
    public void setDataConf(String dataConf) {
        this.dataConf = dataConf;
    }
    
    
}

