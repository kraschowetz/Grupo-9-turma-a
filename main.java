import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main
{
    //São todas as linhas de dialogo do jogo. Sorria e acene.
    static String textoBruto =
        """
        0:*Você abre seus olhos:1:/...>1
        1:*Está muito frio:1:/...>2
        2:*Você não se lembra de nada:1:/...>3
        3:*Você não sente medo:1:/...>4
        4:*O que você faz?:3:/(sair do comodo)>10:(tentar se lembrar de algo)>5:(observar o comodo)>6
        5:*Você não se lembra de nada...:1:/...>4
        6:*Você está num lugar estranho, Tem uma cama, uma porta e alguns outros objetos velhos. A Sala tem um papel de parede florido amarelo que lembra o quarto da sua infância. Tem alguns brinquedos espalhados pelo chão.:1:/...>4
        10:*Você abre a porta e sai do quarto. Tem uma estrada e muitas arvores em volta. Você ve um pacote no chão de tamanho e formato semelhante a um corpo.:1:/...>11
        11:*O que você faz?:1:/(examinar o pacote)>12
        12:*É o seu corpo dentro do pacote...:3:/Não...>14:Não, isso é um sonho. Logo irei acordar>14:Como isso aconteceu?>13
        13:*Você não sabe como isso foi acontecer...:1:/...>14
        14:*O que você faz?:2:/(olhar em volta)>16:(olhar o seu corpo)>15
        15:*Você ve o seu rosto... assim como você se lembra ser...:1:/...>14
        16:*Tem uma casa no final da rua, as luzes estão acessas. Da pra ouvir uma melodia vinda de um piano, o som parece vir daquela casa:1:/...>17
        17:*Você vai até a casa?:2:/sim>18:não>14
        18:*Tem um pedaço de papel preso a porta, junto a um lápis. Na porta, a campainha está quebrada. Você tenta bater na porta, mas parece estar vazia. Na porta está riscado na porta o número 5 Acima da Frase 'PENSE COMO UM COMPUTADOR':1:/...>19
        19:*Você se lambra das aulas que teve de programação durante a Faculdade. Lá você aprendeu que que o computador pensa em binário, que é a linguagem dos computadores digitais.:1:/...>20
        20:*Na porta está riscado na porta o número 5 Acima da Frase 'PENSE COMO UM COMPUTADOR':0:/0>0/puzzlePortaPrologo
        21:*a porta se abre antes de você tocar nela:1:/uau ;)>0/flush
        100:hora do input! dona morte se chama {nomeMorte}!:0:/0>0/input
        """;

    static String possiveisNomesDaMorte[] = {
        "Margot",
        "Jucléia",
        "Marcela",
        "Somália",
        "DJ Arana"
    };
    static String nomeDaMorte = "";

    static String nomeDoPlayer = "Susan"; //talvez use

    static Scanner input;
    static Random rand;
    static String linhaAtual;
    static int estadoDialogo = 0;

    static final int TEMPO_DE_DIALOGO = 15;
    static final int INTERVALO_DE_OPCOES = 40;
    static final int TEMPO_DE_OPCOES = 7;

    public static void main(String args[]) throws Exception
    {
        /*
         * VOID MAIN:
         *
         * -inicializa o random
         * -inicializa o scanner
         *
         * -escolhe o nome da morte
         * -aplica o nome da morte no texto bruto
         *
         * -inicia o menu
         */


        rand = new Random();
        input = new Scanner(System.in);


        nomeDaMorte = possiveisNomesDaMorte
        [
            rand.nextInt(possiveisNomesDaMorte.length)
        ];
        textoBruto = textoBruto.replace("{nomeMorte}", nomeDaMorte);


        iniciarMenu();
    }

    static void iniciarMenu() throws Exception
    {
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

        do
        {
            switch (estado)
            {
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

    static void pegarLinhaDeDialogo()
    {
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
        String[] linhas = textoBruto.split("\n");

        for(String l : linhas)
        {
            if(Integer.parseInt(l.split(":")[0]) == estadoDialogo)
            {
                linhaAtual = l;
                return;
            }
        }
        linhaAtual = "0:erro! nao foi possivel achar a linha de dialogo (" + estadoDialogo +"):1:/okay>0";
    }

    static void atualizarDialogo(String entrada) throws Exception
    {
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
         *      verifica se a linha de dialogo não possui nenhuma flag
         *
         * -exibe o texto da linha de diálogo atual
         *
         * -exibe todas as opções de resposta para a linha atual
         *
         * -caso exista, executa o código da flag
         */


        String flag = "";

        pegarLinhaDeDialogo();  

        try
        {
            Integer.parseInt(entrada);
        }
        catch(NumberFormatException e)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();


            System.out.println("erro: entrada não é um numero");
            atualizarDialogo("0");
            return;
        }

        int qntDeOpcoes = Integer.parseInt(linhaAtual.split(":")[2]);

        if(Integer.parseInt(entrada) < 0 || Integer.parseInt(entrada) > qntDeOpcoes)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();


            System.out.println("erro: opção invalida");
            atualizarDialogo("0");
            return;
        }

        if(!entrada.equals("0"))
        {
            String opcoes = linhaAtual.split("/")[1];
            int opcaoSelecionada = Integer.parseInt(entrada) - 1;
            String subOpcao = opcoes.split(":")[opcaoSelecionada];
            estadoDialogo = Integer.parseInt(subOpcao.split(">")[1]);
            pegarLinhaDeDialogo();
            qntDeOpcoes = Integer.parseInt(linhaAtual.split(":")[2]);


            if(linhaAtual.split("/").length > 2)
            {
                flag = linhaAtual.split("/")[2];
            }
        }

        digitar("\n" + linhaAtual.split(":")[1] + "\n");

        for(int i = 0; i < qntDeOpcoes; i++)
        {
            String[] opcoes = linhaAtual.split("/")[1].split(":");
            exibirOpcoes((i + 1) +") " + opcoes[i].split(">")[0]);
        }

        if(!flag.equals("")){
            interpretarFlag(flag);
        }

    }


    static void atualizar() throws Exception
    {
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

        if(estadoDialogo >= 0)
        {
            atualizar();
        }
    }


    static void iniciarLoopDeDialogo() throws Exception
    {
        /*
         * atualiza a linha de dialogo()
         *
         * atualiza()
         */
        atualizarDialogo("0");
        atualizar();
    }


    static void lerInput(String alvo, int linhaAlvo, String textoDeErro) throws Exception
    {  
        boolean acertou = false;

        do
        {
            System.out.print("digite: ");
            String entrada =  input.nextLine();
            if(entrada.equals(alvo))
            {
                estadoDialogo = linhaAlvo;
                acertou = true;
            }
            else
            {
                System.out.println(textoDeErro);
            }
            atualizarDialogo("0");
        }
        while(!acertou);
    }


    static void interpretarFlag(String flag) throws Exception
    {
        /*
         * roda um switch case com a flag a ser interpretada
         */
        switch (flag)
        {
            case "flush":
                System.out.println("\033[H\033[2J");
                System.out.flush();
                break;
           
            case "input":
                lerInput("oi", 2, "sabe falar 'oi' não?");
                break;
            case "puzzlePortaPrologo":
                lerInput("101", 21, "a porta não se abre");
                break;
        }
        //System.out.println(flag);
    }


    static void digitar(String texto) throws InterruptedException
    {
        /*
         * VOID DIGITAR:
         *  
         * -para cada caractere no texto a ser digitado:
         *      -imprimir caractere
         *      -esperar TEMPO_DE_DIALGO milisegundos
         */


        for(char c : texto.toCharArray())
        {
            System.out.print(c);
            TimeUnit.MILLISECONDS.sleep(TEMPO_DE_DIALOGO);
        }
        System.out.print("\n");
    }


    static void exibirOpcoes(String texto) throws Exception
    {
        /*
         * VOID EXIBIR OPÇÕES:
         *
         * -esperar INTERVALO_DE_OPCOES milisegundos
         *
         * -para cada caractere no texto a ser exibido:
         *      -imprimir caractere
         *      -esperar TEMPO_DE_OPCOES milisegundos
         */


        TimeUnit.MILLISECONDS.sleep(INTERVALO_DE_OPCOES);
        for(char c : texto.toCharArray())
        {
            System.out.print(c);
            TimeUnit.MILLISECONDS.sleep(TEMPO_DE_OPCOES);
        }
        System.out.print("\n");
    }
}