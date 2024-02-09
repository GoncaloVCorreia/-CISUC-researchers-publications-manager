/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package maincisuc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author goncalocorreia
 */
class Gere {

    private ArrayList<GrupoInv> gruposInv;
    private ArrayList<Investigador> investigadores;
    private ArrayList<Publicacao> publicacoes;
    

    public Gere() {
        gruposInv = new ArrayList<GrupoInv>();
        investigadores = new ArrayList<Investigador>();
        publicacoes = new ArrayList<Publicacao>();
       
    }
    /**
     * Verifica se a existencia dos ficheiros de objetos
     */
    public void readFiles() {
        //Ficheiro dos Grupos de investigacao Objeto
        File foG = new File("ficheiroGInvObj.obj");
        //Ficheiro dos Insvestigacao Objeto
        File foI = new File("ficheiroInvObj.obj");
        //Ficheiro das Publicacoes Objeto
        File foP = new File("ficheiroPubObj.obj");
        //Se o ficheiro dos Grupos de Investigacao objeto existir faz-se a leitura correspondente
        if (foG.exists() && foG.isFile()) {

            readFilesObj("ficheiroGInvObj.obj");

        //Caso nao haja ficheiro objeto dos Grupos de Investigacao e usado o ficheiro de texto dos alunos
        } else {

            System.out.println("Ficheiro Objeto Grupo Investigacao não existe. Ficheiro de Texto correspondente irá ser usado");
            readFilesTxt("fichGruposInv.txt");
        }
        //Se o ficheiro dos Investigadores objeto existir faz-se a leitura correspondente
        if (foI.exists() && foI.isFile()) {

            readFilesObj("ficheiroInvObj.obj");

        //Caso nao haja ficheiro objeto dos Investigadores e usado o ficheiro de texto das diciplinas
        } else {
            System.out.println("Ficheiro Objeto Investigadores não existe. Ficheiro de Texto correspondente irá ser usado");
            readFilesTxt("fichInvestigadores.txt");
        }
        //Se o ficheiro das Publicaceos objeto existir faz-se a leitura correspondente
        if (foP.exists() && foP.isFile()) {

            readFilesObj("ficheiroPubObj.obj");

        //Caso nao haja ficheiro objeto das Publicacoes e usado o ficheiro de texto das diciplinas
        } else {
            System.out.println("Ficheiro Objeto Publicacoes não existe. Ficheiro de Texto correspondente irá ser usado");
            readFilesTxt("fichPublicacoes.txt");
        }

    }
    /**
     * Direciona os ficheiros de texto
     * @param nomeFich 
     */
    public void readFilesObj(String nomeFich) {
        //Recebe o nome do ficheiro de Objetos
        File fo = new File(nomeFich);

        try {

            FileInputStream fis = new FileInputStream(fo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //Se for o ficheiro objetos de Grupos de investigacao faz a seguinte leitura
            if ("ficheiroGInvObj.obj".equals(nomeFich)) {

                gruposInv = (ArrayList<GrupoInv>) ois.readObject();
                System.out.println("Ficheiro Objeto lido com sucesso");
                ois.close();

            }
            //Se for o ficheiro objetos de Investigadores faz a seguinte leitura
            if ("ficheiroInvObj.obj".equals(nomeFich)) {

                investigadores = (ArrayList<Investigador>) ois.readObject();
                System.out.println("Ficheiro Objeto lido com sucesso");

                ois.close();

            }
             //Se for o ficheiro objetos de Publicacoes faz a seguinte leitura
            if ("ficheiroPubObj.obj".equals(nomeFich)) {

                publicacoes = (ArrayList<Publicacao>) ois.readObject();
                System.out.println("Ficheiro Objeto lido com sucesso");

                ois.close();

            }
            

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");

        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }

    }

    /**
     * Le ficheiro de texto
     * @param nomeFicheiro 
     */
    public void readFilesTxt(String nomeFicheiro) {
        // Se for o ficheiro de Grupos de investigacao faz a seguinte leitura
        if ("fichGruposInv.txt".equals(nomeFicheiro)) {
            readFileGrupos(nomeFicheiro);
        }
        // Se for o ficheiro de Investigadores de investigacao faz a seguinte leitura
        if ("fichInvestigadores.txt".equals(nomeFicheiro)) {
            readFileInv(nomeFicheiro);
        }
        // Se for o ficheiro de Publicacoes de investigacao faz a seguinte leitura
        if ("fichPublicacoes.txt".equals(nomeFicheiro)) {
            readFilePub(nomeFicheiro);
        }

    }

    /**
     * Faz a leitura do ficheiro de Grupos de Investigacao
     * @param nomeFicheiro 
     */
    public void readFileGrupos(String nomeFicheiro) {
        try {
            System.out.println(nomeFicheiro);
            File f = new File(nomeFicheiro);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                //Separa a informacao de cada linha
                String[] linha = line.split("#");
                //Cria novo grupo de investigacao
                GrupoInv gi = new GrupoInv(linha[0], linha[1], linha[2]);
               
                gruposInv.add(gi);
            }

        } catch (FileNotFoundException e) {

            System.out.println("Ficheiro inexistente fichGruposInv.txt");

        } catch (IOException e) {

            System.out.println("Exceção ao ler uma linha do ficheiro");

        }

    }
    /**
     * Le o ficheiro de investigadores
     * @param nomeFicheiro 
     */
    public void readFileInv(String nomeFicheiro) {
        try {
            File f = new File(nomeFicheiro);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                //Separa a informacao de cada linha
                String[] linha = line.split("#");
                //Se for membro efetivo 
                if ("MembroEfetivo".equals(linha[0])) {
                    MembroEfetivo m = new MembroEfetivo(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5]);
                    investigadores.add(m);
                    adicionaGrupoInv(m);
                   
                }
                 //Se for Estudante 
                if ("Estudante".equals(linha[0])) {
                    Estudante e = new Estudante(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5], linha[6]);
                    investigadores.add(e);
                    adicionaGrupoInv(e);
                   
                }
            }

        } catch (FileNotFoundException e) {

            System.out.println("Ficheiro inexistente fichGruposInv.txt");

        } catch (IOException e) {

            System.out.println("Exceção ao ler uma linha do ficheiro");

        }

    }
    /**
     * Le ficheiro de Publicacoes
     * @param nomeFicheiro 
     */
    public void readFilePub(String nomeFicheiro) {
        try {

            File f = new File(nomeFicheiro);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                //Separa a informacao de cada linha
                String[] linha = line.split("#");
                // Se for artigo de Conferencia
                if ("Artigo de Conferencia".equals(linha[0])) {

                    ArtigoConferencia ac = new ArtigoConferencia(linha[0], linha[1].split(","), linha[2], linha[3], linha[4], linha[5], linha[6], linha[7], linha[8], linha[9]);
                    publicacoes.add(ac);
                    
                }
                // Se for artigo de Revista
                if ("Artigo de Revista".equals(linha[0])) {

                    ArtigoRevista ar = new ArtigoRevista(linha[0], linha[1].split(","), linha[2], linha[3], linha[4], linha[5], linha[6], linha[7], linha[8], linha[9]);
                    publicacoes.add(ar);
                    

                }
                //Se for livro
                if ("Livro".equals(linha[0])) {

                    Livro l = new Livro(linha[0], linha[1].split(","), linha[2], linha[3], linha[4], linha[5], linha[6], linha[7]);
                    publicacoes.add(l);
                   

                }
                //Se for capitulo
                if ("Capitulo".equals(linha[0])) {

                    Capitulo c = new Capitulo(linha[0], linha[1].split(","), linha[2], linha[3], linha[4], linha[5], linha[6], linha[7], linha[8], linha[9], linha[10]);
                    publicacoes.add(c);
                   

                }
                //Se for livro artigo
                if ("Livro artigo".equals(linha[0])) {

                    LivroArtigo la = new LivroArtigo(linha[0], linha[1].split(","), linha[2], linha[3], linha[4], linha[5], linha[6], linha[7], linha[8], linha[9]);
                    publicacoes.add(la);
                   

                }
            }
            //Adiciona as publicaoes ao grupos de investigacao e aos investigadores e adiciona o investigador ao array de investigadores da publicacao
            publicacaoGrupo();
            

        } catch (FileNotFoundException e) {

            System.out.println("Ficheiro inexistente fichGruposInv.txt");

        } catch (IOException e) {

            System.out.println("Exceção ao ler uma linha do ficheiro");

        }
    }
    /**
     * Calcula o numero de publicacoes de cada tipo
     * @return String com as numero de publicacoes de cada tipo
     */
    public String publicacoesCadaTipo(){
        int nArtigoConf = 0;
        int nArtigoRev = 0;
        int nLivro = 0;
        int nCapitulos = 0;
        int nLivroArtigo = 0;
        //percorre array de publicacoes
        for (int i = 0; i < publicacoes.size(); i++) {
            //Se for aritgo conferencia
            if ("Artigo de Conferencia".equals(publicacoes.get(i).tipoPub)) {
                nArtigoConf += 1;
            }
            //Se for artigo revista
            if ("Artigo de Revista".equals(publicacoes.get(i).tipoPub)) {
                nArtigoRev += 1;
            }
            //Se for capitulo
            if ("Capitulo".equals(publicacoes.get(i).tipoPub)) {
                nCapitulos += 1;
            }
            //Se for livto
            if ("Livro".equals(publicacoes.get(i).tipoPub)) {
                nLivro += 1;
            }
            //Se for livro artigo
            if ("Livro artigo".equals(publicacoes.get(i).tipoPub)) {
                nLivroArtigo += 1;
            }
        }
        String str = "Numero de publicacoes Artigo de Conferencia: " + nArtigoConf + "\n";
        str += "Numero de publicacoes Artigo de Revista: " + nArtigoRev + "\n";
        str += "Numero de publicacoes Livro: " + nLivro + "\n";
        str += "Numero de publicacoes Capitulo: " + nCapitulos + "\n";
        str += "Numero de publicacoes Livros de Artigo: " + nLivroArtigo + "\n";
        return str;
     }
    
    /**
     * Adiciona um investigador ao respeitvo grupo de investigacao
     * @param investigador 
     */
    public void adicionaGrupoInv(Investigador investigador) {
        //Percorre array de Grupos de Investigacao
        for (int i = 0; i < gruposInv.size(); i++) {
            //se o investigador estiver no grupo de investiacao
            if ((investigador.gInv).equals(gruposInv.get(i).getAcronimo())) {
                //Adiciona investigador ao grupo de investigacao
                gruposInv.get(i).adicionaInvestigadores(investigador);
                break;
            }
        }

    }

   /**
    *  Retorna todal de investigadores
    * @return numero de investigadores
    */
    public int totalMembros() {
        return investigadores.size();
    }

    /**
     * String com o numero de membros de cada categoria
     * @return str
     */
    public String membrosCadaCategoria() {
        int nEstudantes=0;
        int nMembrosEfetivos=0;
        //percorre array de investigadores
        for (int i = 0; i < investigadores.size(); i++) {
            //Se for estudante
            if ("Estudante".equals(investigadores.get(i).TYPE)) {
                nEstudantes += 1;
            }
            //Se for membro efetivo
            if ("MembroEfetivo".equals(investigadores.get(i).TYPE)) {
                nMembrosEfetivos += 1;
            }
        }
        String str = "Numero de Estudantes: " + nEstudantes + "\n";
        str += "Numero de Membros Efetivos: " + nMembrosEfetivos + "\n";

        return str;
    }

    /**
     * numero de publicacoes dos ultimos cinco anos
     * @param pub
     * @return npubCincoAnos
     */
    public int ultimosCincoAnos(ArrayList<Publicacao> pub) {
        int npubCincoAnos = 0;
        //Percorre array de publicacoes
        for (int i = 0; i < pub.size(); i++) {
            //Se a publicacao for dos ultimos 5 anos
            if (2020 - Integer.parseInt(pub.get(i).anoPub) <= 5) {

                npubCincoAnos += 1;
            }
        }
        return npubCincoAnos;
    }

    //ALIENA 1)
    /**
     * indicadoresGeraisCisuc
     * @return 
     */
    public String indicadoresGeraisCisuc() {
        String str = "";
        str += "Total de Membros: " + totalMembros() + "\n";
        str += membrosCadaCategoria();
        str += "Numero de publicacoes nos ultimos cinco anos: " + ultimosCincoAnos(publicacoes) + "\n";
        str += publicacoesCadaTipo();
        return str;
    }

    /**
     * Retorna investigador 
     * @param nomeAutor
     * @return investigador
     */
    public Investigador getInv(String nomeAutor) {
        //Percorre array de investigadores
        for (int i = 0; i < investigadores.size(); i++) {
            //Se encontrar o investigador a que corresponde o nomeAutor
            if (investigadores.get(i).nome.equals(nomeAutor)) {
                return investigadores.get(i);
            }
        }
        //Se nao encontrar nenhum retorna null
        return null;

    }

    /**
     * Retorna grupo de investigacao a partir do nome do grupo
     * @param grupo
     * @return grupo de investigacao
     */
    public GrupoInv grupoInv(String grupo) {
        //Percorre array de Grupos de Ivestigacao
        for (int i = 0; i < gruposInv.size(); i++) {
            //Se encontrar o grupo correspondete ao nome 
            if (gruposInv.get(i).getAcronimo().equals(grupo)) {
                return gruposInv.get(i);
            }
        }
        //Se nao encontrar retorna null
        return null;

    }

    /**
     * Retorna grupo de investigacao a partit do investigador
     * @param inv
     * @return grupo de investigacao
     */
    public GrupoInv getGInv(Investigador inv) {
        //Percorre array de grupode de investigacao
        for (int i = 0; i < gruposInv.size(); i++) {            
            if (inv.gInv.equals(gruposInv.get(i).getAcronimo())) {
                return gruposInv.get(i);
            }
        }
        //Se nao encontrar retorna null
        return null;

    }

    /**
     * Verifica se p grupo de investigacao ja contem a publicacao
     * @param pub
     * @param ginv
     * @return true or false
     */
    public boolean verificaPub(Publicacao pub, GrupoInv ginv) {
        //Percorre array de publicaoes de um dado grupo de investigacao
        for (int i = 0; i < ginv.getPublicacoes().size(); i++) {
            //se a publicacao ja estiver nesse grupo retorna false
            if (ginv.getPublicacoes().get(i) == pub) {
                return false;
            }
        }
        //Se a publicacao nao estiver no grupo de investiacao
        return true;
    }

    /**
     * Adiciona publicacao ao grupo de investigacao que lhe corresponde
     * @param pub
     * @param ginv 
     */
    public void addPubGInv(Publicacao pub, GrupoInv ginv) {
        //Verifica primeiro se a publicacao ja esta ou nao no grupo de investigacao
        if (verificaPub(pub, ginv)) {

            ginv.getPublicacoes().add(pub);
        }

    }

    /**
     * Adiciona a publicacao a um dos seus investigadores
     * @param pub
     * @param inv 
     */
    public void addPubInv(Publicacao pub, Investigador inv) {
        inv.getPublicacoes().add(pub);
    }

    /**
     * Adiciona as publicaoes ao grupos de investigacao e aos investigadores
     */
    public void publicacaoGrupo() {
        //Percorre as publicacoes todas
        for (int i = 0; i < publicacoes.size(); i++) {
            //Percorre o array de autores da publicacao
            for (int j = 0; j < publicacoes.get(i).autores.length; j++) {
                //vai buscar o investigador que corresponde ao autor
                Investigador inv = getInv((publicacoes.get(i).autores)[j]);
                //adiciona o investigador ao array de investigadores da publicacao
                publicacoes.get(i).getInvestigadores().add(inv);
                //vai buscar o grupo de investigacao ao qual o investigador pertence
                GrupoInv ginv = getGInv(inv);
                //Adiciona publicacao ao array de publicacoes do grupo de investigacao
                addPubGInv(publicacoes.get(i), ginv);
                //Adiciona publicacao ao array de publicacoes do investigador
                addPubInv(publicacoes.get(i), inv);
            }

        }

    }

    /**
     * String que contem as publicacoes dos ultimos cinco anos de um grupo organizada por data fator impacto
     * @param type
     * @param pub
     * @return string
     */
    public String printPub(String type, ArrayList<Publicacao> pub) {
        //Agrupa de acordo com a data e o fator impacto
        Collections.sort(pub);
        String str = "";
        //Para a alinea 2) onde se usa so as publicacoes dos ultimos 5 anos
        if ("grupo".equals(type)) {
            for (int i = 0; i < pub.size(); i++) {
                if (2020 - Integer.parseInt(pub.get(i).anoPub) <= 5) {
                    str += "    Publicacao: " + pub.get(i).getTitulo() + " " + pub.get(i).anoPub + " " + pub.get(i).fatorImapacto() + "(" + pub.get(i).dimAud + ")" + "\n";
                }
            }
        }
        //Para a alinea 4) onde nao se usam todas as publicacoes
        if ("investigador".equals(type)) {
            for (int i = 0; i < pub.size(); i++) {

                str += "    Publicacao: " + pub.get(i).getTitulo() + " " + pub.get(i).anoPub + " " + pub.get(i).fatorImapacto() + "(" + pub.get(i).dimAud + ")" + "\n";

            }
        }
        return str;
    }

    /**
     * Retorna uma string com as publicacoes dos ultimos cinco anos de um grupo de investigacao agrupadas por data e fator impacro
     * @param type (para distinguir consoante seja a alinea 2) ou 4))
     * @param pub
     * @return 
     */
    public String pubPubCincoAnosGInv(String type, ArrayList<Publicacao> pub) {

        ArrayList<Publicacao> livro = new ArrayList<>();
        ArrayList<Publicacao> capitulo = new ArrayList<>();
        ArrayList<Publicacao> artConf = new ArrayList<>();
        ArrayList<Publicacao> artRev = new ArrayList<>();
        ArrayList<Publicacao> livArt = new ArrayList<>();
        //Percorre array de publicacoes dado agrupando os tipos de publicacoes nos resptivos arrays
        for (int i = 0; i < pub.size(); i++) {
            
            if ("Artigo de Conferencia".equals(pub.get(i).tipoPub)) {
                artConf.add(pub.get(i));
            }
            if ("Artigo de Revista".equals(pub.get(i).tipoPub)) {
                artRev.add(pub.get(i));
            }
            if ("Capitulo".equals(pub.get(i).tipoPub)) {
                capitulo.add(pub.get(i));
            }
            if ("Livro".equals(pub.get(i).tipoPub)) {
                livro.add(pub.get(i));
            }
            if ("Livro artigo".equals(pub.get(i).tipoPub)) {
                livArt.add(pub.get(i));
            }
        }
        String str = "\n    >>>>ARTIGOS CONFERENCIA<<<<\n";
        str += printPub(type, artConf);
        str += "\n    >>>>ARTIGOS REVISTA<<<<\n";
        str += printPub(type, artRev);
        str += "\n    >>>>LIVROS<<<<\n";
        str += printPub(type, livro);
        str += "\n    >>>>CAPITULOS DE LIVRO<<<<\n";
        str += printPub(type, capitulo);
        str += "\n    >>>>LIVROS DE ARTIGO<<<<\n";
        str += printPub(type, livArt);
        return str;
    }

    /**
     * Pede acronimo do Grupo de Investigacao ao utilizador
     * @return 
     */
   
    public String pedeGrupo() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Grupo (acronimo) que pretende selecionar para ver as publicacoes: ");
        String grupoInv = sc.nextLine();
        return grupoInv;

    }

    //ALINEA 2)
    /**
     * Lista as publicacoes de um grupo de investigacao pedido ao utilizador
     * @return str
     */
    public String listaPubGrupo() {
        String type = "grupo";
        //pede grupo ao utlizaor
        String grupoInv = pedeGrupo();
        //obtem grupo
        GrupoInv ginv = grupoInv(grupoInv);
        String str = "\nGrupo selecionado: " + ginv.getNome() + " " + ginv.getAcronimo() + "\n";
 
        str += pubPubCincoAnosGInv(type, ginv.getPublicacoes());
        return str;

    }

    /**
     * Retorna uma string com os investigadores de um grupo
     * @param investigadores
     * @return str
     */
    public String printInv(ArrayList<Investigador> investigadores) {
        String str = "";
        for (int i = 0; i < investigadores.size(); i++) {
            str += "    Investigador: " + investigadores.get(i).nome + "\n";
        }
        return str;
    }

    /**
     * String dos investigadores separados por categoria de um grupo de investigação
     * @param ginv
     * @return 
     */
    public String membrosPorCategoria(GrupoInv ginv) {
        

        ArrayList<Investigador> estudantes = new ArrayList<>();
        ArrayList<Investigador> membroEfetivo = new ArrayList<>();
        //Percorre o array de investigadores de um grupo de investigacao
        for (int i = 0; i < ginv.getInvestigadores().size(); i++) {
            if ("Estudante".equals(ginv.getInvestigadores().get(i).TYPE)) {
                estudantes.add(ginv.getInvestigadores().get(i));
            }
            if ("MembroEfetivo".equals(ginv.getInvestigadores().get(i).TYPE)) {
                membroEfetivo.add(ginv.getInvestigadores().get(i));
            }
        }
        String str = "\n    >>>>ESTUDANTES<<<<\n";
        str += printInv(estudantes);
        str += "\n    >>>>MEMBROS EFETIVOS<<<<\n";
        str += printInv(membroEfetivo);
        return str;
    }

    // ALINEA 3)
    /**
     * Retorna string com os membros de um grupo de investigacao agrupados por categoria
     * @return str
     */
     
    public String listarMembrosGrupo() {

        String grupoInv = pedeGrupo();
        GrupoInv ginv = grupoInv(grupoInv);
        String str = "\nGrupo selecionado: " + ginv.getNome() + " " + ginv.getAcronimo() + "\n";
        str += membrosPorCategoria(ginv);
        return str;

    }

    /**
     * /Pede investigador ao utilizador 
     * @return inv
     */
    public String pedeInv() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do investigador que pretende selecionar: ");
        String inv = sc.nextLine();
        return inv;
    }

    //ALINEA 4)
    /**
     * Lista as publicações de um investigador agrupadas por ano, tipo de publicação e fatorde impacto
     * @return str
     */
    public String pubInv() {
        String type = "investigador";
        String inv = pedeInv();
        //obtem investigador correspodente ao nome pedido
        Investigador investigador = getInv(inv);
        String str = "Investigador selecionado: " + investigador.nome + "\n";
        str += pubPubCincoAnosGInv(type, investigador.publicacoes);
        return str;

    }

    /**
     * Devolve o numero de membros por categoria de investigador
     * @param ginv
     * @return int[] numcat
     */
    public int[] numMembrosCategoria(GrupoInv ginv) {
        int[] numCat = new int[2];
        int nEst = 0;
        int nMemEf = 0;
        for (int i = 0; i < ginv.getInvestigadores().size(); i++) {
            //Se for estudante
            if ("Estudante".equals(ginv.getInvestigadores().get(i).TYPE)) {
                nEst += 1;
            }
            //Se for membero efetivo
            if ("MembroEfetivo".equals(ginv.getInvestigadores().get(i).TYPE)) {
                nMemEf += 1;
            }

        }
        //Primeiro elemento do array corresponde ao numero de estudantes do grupo de investiacao dado
        numCat[0] = nEst;
        //Segundo elemento do array corresponde ao numero de membros efetivos do grupo de investiacao dado
        numCat[1] = nMemEf;
        return numCat;

    }

    //ALINEA 5)
    /**
     * Listar todos os grupos de investigação
     * @return str
     */
    public String listarTodosGruposInv() {
        String str = "";
        String type = "grupo";
        for (int i = 0; i < gruposInv.size(); i++) {
            str += "\nGrupo: " + gruposInv.get(i).getNome() + "\n";

            //a) Total de membros 
            str += "Total de Membros: " + gruposInv.get(i).getInvestigadores().size() + "\n";
            //b) Número de membros de cada categoria
            int[] numMemb = numMembrosCategoria(gruposInv.get(i));
            str += "Numero de Estudantes: " + numMemb[0] + "\n";
            str += "Numero de Membros Efetivos: " + numMemb[1] + "\n";
            //c) Total de publicações dos últimos 5 anos
            str += "Numero de publicacoes do ultimos cinco anos: " + ultimosCincoAnos(gruposInv.get(i).getPublicacoes()) + "\n";
            //d) publicações, dos últimos 5 anos, agrupadas por ano, tipo de publicação e fator de impacto
            str += pubPubCincoAnosGInv(type, gruposInv.get(i).getPublicacoes());

        }
        return str;
    }
    /**
     * Escrever para ficheiros objetos
     */
    public void writeFiletoObj() {

        File f = new File("ficheiroGInvObj.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //Escreve os grupos de investigacao para ficheiro de objetos
            oos.writeObject(gruposInv);

            System.out.print("Ficheiro objeto Grupo Investigacao escrito com sucesso\n");
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }

        File f2 = new File("ficheiroInvObj.obj");

        try {
            FileOutputStream fos2 = new FileOutputStream(f2);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            //Escreve os investigadores para ficheiro de objetos
            oos2.writeObject(investigadores);

            System.out.print("Ficheiro objeto Investigadores escrito com sucesso\n");
            oos2.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
        File f3 = new File("ficheiroPubObj.obj");

        try {
            FileOutputStream fos3 = new FileOutputStream(f3);
            ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
            //Escreve as publicacoes para ficheiro de objetos
            oos3.writeObject(publicacoes);

            System.out.print("Ficheiro objeto Investigadores escrito com sucesso\n");
            oos3.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}
   