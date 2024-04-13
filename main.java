import java.util.Scanner;           //importa o scanner
import java.io.BufferedReader;      //importa a classe que pega o arquivo
import java.io.FileReader;          //importa a classe que le o arquivo como texto
import java.io.IOException;         //importa a classe que gerencia os erros

class Main{
    /**texto e input**/
    static Scanner input;
    static String textoAtual = "";
    static String linhaAtual = "";
    static int estadoDialogo = 0;

    //função principal
    public static void main(String[] args) {
        //iniciar variaveis
        input = new Scanner(System.in);

        //iniciar médotos
        lerArquivo("main.txt");
        
        iniciarMenu();
    }

    static void lerArquivo(String local){
        /*
         * FUNÇÃO LER ARQUIVO:
         * 
         * -tenta abrir o arquivo no local especificado
         * 
         * -caso consiga, lê todas as linhas do arquivo
         *  e guarda elas na variavel "textoAtual"
         * 
         * -caso não consiga exibe uma mensagem de erro
         * 
         */
        try{
            FileReader arquivo = new FileReader(local);
            BufferedReader leitor = new BufferedReader(arquivo);

            String linha = leitor.readLine();

            while(linha != null){
                textoAtual += linha + "\n";
                linha = leitor.readLine();
            }

            leitor.close();

        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("ocorreu um erro :(");
        }
    }

    static void iniciarMenu(){
        /*
         * FUNÇÃO INICIAR MENU:
         * 
         * enquanto o menu não for fechado:
         *  
         * -estado padrão:
         *      limpa o console, exibe o titulo do jogo e guarda input do usuário
         * 
         * -se o jogador apertar 1:
         *      exibe as instruções do jogo e aguarda um input para voltar ao estado inicial
         * 
         * -se o jogador apertar 2:
         *      fecha o menu e inicia o jogo
         * 
         * -se o jogador apertar 3:
         *      exibe os créditos do jogo e aguarda um input para voltar ao estado inicial
         *  
         * -se o jogador apertar 4:
         *      fecha o scanner, fecha o menu e fecha o jogo
         */

        String estado = "0";
        boolean fechado = false;

        do{
            switch (estado) {
                case "0":   //estado inicial
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nBEM VINDO AO JOGO!");
                    System.out.println("\n1) instruções\n2) jogar\n3) creditos\n4) sair");

                    estado = input.nextLine();
                    break;
                
                case "1": //estado instruções
                    System.out.println("\nLeia os textos, digite os numeros de 1-9 para selecionar a opção de diálogo escolhida");

                    input.nextLine();
                    estado = "0";
                    break;
                
                case "2": //estado jogar
                    iniciarLoopDeDialogo();
                    fechado = true;
                    break;
                
                case "3": //estado créditos
                    System.out.println("\nfeito por: João Pedro Kraschowetz Souza e Maria Fernanda Silva Leite");

                    input.nextLine();
                    estado = "0";
                    break;
                
                default: //estado sair
                    fechado = true;
                    input.close();
                    break;
            }
        }
        while(!fechado);
    }

    static void pegarLinhaDeDialogo(){
        /*
         * FUNÇÃO PEGAR LINHA DE DIÁLOGO:
         * 
         * -transforma o texto atual em uma lista de Strings
         * 
         * -para cada linha na lista:
         *      verifica se o 1° elemento da linha verificada antes do ":" == estado do diálogo
         * 
         *      se for: coloca a linha de texto sendo processada na variavel "linha atual" e fecha a função
         *      
         * -caso não ache a linha que corresponde ao estado de diálogo atual:
         *      exibe a linha padrão de erro e reseta o diálogo
         * 
         */
        String[] linhas = textoAtual.split("\n");

        for(String l : linhas){
            if(Integer.parseInt(l.split(":")[0]) == estadoDialogo){
                linhaAtual = l;
                return;
            }
        }
        linhaAtual = "0:erro! nao foi possivel achar a linha de dialogo (" + estadoDialogo +"):1:/okay>0"; 
    }

    static void atualizarDialogo(String entrada){
        /*
         * FUNÇÃO ATUALIZAR DIÁLOGO:
         * 
         * pegar linha de diálogo();
         * 
         * -verifica se a entrada do usuário não ira causar nenhum erro
         * 
         * -se entrada não for um número:
         *      exibe mensagem de erro, reseta linha de diálogo atual
         * -se entrada for < 0 ou > quantidade de opções:
         *      exibe mensagem de erro, reseta linha de diálogo atual
         * 
         * -se entrada do usuário não for 0:
         *      verifica qual foi a opção selecionada
         *      muda o estado do diálogo baseado na opção selecionada
         *      pega a linha de dialogo nova()
         *      atualiza a quantidade de opções baseado na linha nova
         * 
         * -exibe o texto da linha de diálogo atual
         * 
         * -exibe todas as opções de resposta para a linha atual
         */
        pegarLinhaDeDialogo();  

        try{
            Integer.parseInt(entrada);
        }
        catch(NumberFormatException e){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("erro: entrada não é um numero"); 
            atualizarDialogo("0");
            return;
        }

        int qntDeOpcoes = Integer.parseInt(linhaAtual.split(":")[2]);

        if(Integer.parseInt(entrada) < 0 || Integer.parseInt(entrada) > qntDeOpcoes){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("erro: opção invalida");
            atualizarDialogo("0");
            return;
        }

        if(!entrada.equals("0")){
            String opcoes = linhaAtual.split("/")[1];
            int opcaoSelecionada = Integer.parseInt(entrada) - 1;
            String subOpcao = opcoes.split(":")[opcaoSelecionada];
            estadoDialogo = Integer.parseInt(subOpcao.split(">")[1]);
            pegarLinhaDeDialogo();
            qntDeOpcoes = Integer.parseInt(linhaAtual.split(":")[2]);

            if(linhaAtual.split("/").length > 2){
                interpretarFlag(linhaAtual.split("/")[2]);
            }
        }

        System.out.println("\n" + linhaAtual.split(":")[1]);

        for(int i = 0; i < qntDeOpcoes; i++){
            String[] opcoes = linhaAtual.split("/")[1].split(":");
            System.out.println((i + 1) +") " + opcoes[i].split(">")[0]);
        }

    }

    static void atualizar(){
        /*
         * pega a entrada de usuário
         * 
         * atualiza o dialogo baseado na entrada do usuário()
         * 
         * se o estado do diálogo não for negativo:
         *      atualiza novamente
         */
        String entrada = input.nextLine();
        atualizarDialogo(entrada);

        if(estadoDialogo >= 0){
            atualizar();
        }
    }

    static void iniciarLoopDeDialogo(){
        /*
         * atualiza a linha de dialogo()
         * 
         * atualiza()
         */
        atualizarDialogo("0");
        atualizar();
    }

    static void interpretarFlag(String flag){
        /*
         * roda um switch case com a flag a ser interpretada
         */
        switch (flag) {
            case "flush":
                System.out.println("\033[H\033[2J");
                System.out.flush();
                break;
        }
    }

}