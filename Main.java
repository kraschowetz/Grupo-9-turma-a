import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main
{
    //São só todas as linhas de dialogo do jogo. Sorria e acene.
    static String textoBruto =
        """
        0;*Você abre seus olhos;1;/[continuar]>1
        1;*Está muito frio;1;/[continuar]>2
        2;*Você não se lembra de nada;1;/[continuar]>3
        3;*Você não sente medo;1;/[continuar]>4
        4;*O que você faz?;3;/[sair do comodo]>10;[tentar se lembrar de algo]>5;[observar o comodo]>6
        5;*Você não se lembra de nada...;1;/[continuar]>4
        6;*Você está num lugar estranho, Tem uma cama, uma porta e alguns outros objetos velhos. A Sala tem um papel de parede florido amarelo que lembra o quarto da sua infância. Tem alguns brinquedos espalhados pelo chão.;1;/[continuar]>4
        10;*Você abre a porta e sai do quarto. Tem uma estrada e muitas arvores em volta. Você ve um pacote no chão de tamanho e formato semelhante a um corpo.;1;/[continuar]>11
        11;*O que você faz?;1;/[examinar o pacote]>12
        12;*É o seu corpo dentro do pacote...;3;/Não...>14;Não, isso é um sonho. Logo irei acordar>14;Como isso aconteceu?>13
        13;*Você não sabe como isso foi acontecer...;1;/[continuar]>14
        14;*O que você faz?;2;/[olhar em volta]>16;[olhar o seu corpo]>15
        15;*Você ve o seu rosto... assim como você se lembra ser...;1;/[continuar]>14
        16;*Tem uma casa no final da rua, as luzes estão acessas. Da pra ouvir uma melodia vinda de um piano, o som parece vir daquela casa;1;/...>17
        17;*Você vai até a casa?;2;/sim>18;não>14
        18;*Tem um pedaço de papel preso a porta, junto a um lápis. Na porta, a campainha está quebrada. Você tenta bater na porta, mas parece estar vazia. Na porta está riscado na porta o número 5 Acima da Frase 'PENSE COMO UM COMPUTADOR';1;/[continuar]>19
        19;*Você se lambra das aulas que teve de programação durante a Faculdade. Lá você aprendeu que que o computador pensa em binário, que é a linguagem dos computadores digitais.;1;/[continuar]>20
        20;*Como você escreveria o número 5, na base binária, neste papel?;0;/0>0/puzzlePortaPrologo
        21;*a porta se abre antes de você tocar nela;1;/[continuar]>22
        22;Desconhecida: Entre, jovem.;1;/Olá, com licença [entrar na casa]>23
        23;Desconhecida: Você é {player}, correto?;2;/sim, sou eu>26;[olhar em volta]>24
        24;*Você ve uma senhora sentada próxima a um piano, ela veste um vestido verde que cobre seus pés, usa um colar com pedras vermelhas brilhantes. Seus cabelos parecem ser cacheados e esbranquiçados, ela os prendeu num coque alto.;1;/[continuar]>25
        25;*O piano é o único móvel dentro deste cômodo além de uma lareira. Tem uma lâmpada muito fraca pendurada ao teto, o papel de parede tem um padrão vitoriano e está bem descascado. As paredes têm diversos quadros de paisagens lindas, montanhas e cachoeiras. Tudo está muito empoeirado e tem aspecto de envelhecido.;1;/[continuar]>23
        26;Desconhecida: Estive esperando por você durante a noite toda, aprendi novas duas músicas com este piano, você escutou durante o caminho?;2;/sim, pude escutar>28;não[continuar]>27
        27;Desconhecida: uma pena...;1;/por que só tem a sua casa nesta rua, a senhora mora sozinha?>29
        28;Desconhecida: uma linda musica, não é mesmo?;1;/por que só tem a sua casa nesta rua, a senhora mora sozinha?>29
        29;Desconhecida: Sim, eu moro sozinha.;1;/Como a senhora conhece meu nome? Por que estava me esperando?>30
        30;Desconhecida: ...;1;/Senhora, por favor, me diga que não morri.>31
        31;Desconhecida: Infelizmente sim, senhorita. Olhe pela janela.;1;/[olhar pela janela]>32
        32;*Você Não consigue ver nada do lado de fora. Como se fosse apenas um cômodo escuro do outro lado. Você percebe riscado o número 3 no vidro como se alguém tivesse tentado quebrá-lo.;1;/[continuar]>33
        33;*Você percebe riscado o número 3... Talvez você devesse tentar converter este número. Você ainda tem o papel e o lápis.;0;/0>0/puzzleJanela
        34;*Vejo o meu carro, ele acertou em cheio uma arvore na floresta e está completamente destruído;1;/[continuar]>35
        35;DESCONHECIDA: Chovia tanto naquele dia... a senhorita perdeu o controle de seu carro, que saiu da estrada.;2;/A senhora por acaso é a morte?>36;Eu estou no Inferno?>36
        36;DESCONHECIDA: Hahahaha a Senhorita faz muitas perguntas, assim como todos. Não, você não está no Inferno. E eu?  as pessoas me chamam de diversos nomes, eu não sou “A Morte”, eu nunca matei ninguém. Estou aqui somente para te recepcionar. Você pode me chamar de {morte}. ;1;/ [continuar] >37
        37;{morte}: Susan, querida, não chore. Ambas sabemos que foi um acidente. Você não entrou de carro naquela floresta de propósito. Por mais que aquela tenha sido a sua vontade naquele momento, sabemos que, no fundo, não aquela sua intenção. ;3;/Como assim naquele momento ?>38;Eu dirigi rápido de propósito?>38;Não consigo me lembrar de nada dos últimos meses.>38
        38; {morte}: Susan, venha até mim...;1;/[continuar]>39
        39; Ela se levantou da cadeira e se dirigiu para outro cômodo da casa.;1;/[continuar]>40
        40; Sigo-a em silencio...;1;/[continuar]>41
        41; Você observa ao redor ? ... ;2;/[sim]>42;[não]>43
        42; Havia uma mesa de jantar com várias cadeiras, uma lareira e mais algumas decorações. Tudo estava muito empoeirado e a iluminação do cômodo era a base de velas.;1;/[continuar]>43
        43; {morte}: Susan, você gostaria de voltar, não gostaria?;1;/Mas é claro que sim, eu tenho um bebê, você sabia?>44
        44; {morte}: Sabia sim, a pequena Elise;1;/[continuar]>45
        45; {morte}: Senhorita, gostaria que tivéssemos mais tempo para conversar. Portanto, serei direta.;1;/[continuar]>46
        46; {morte}: Existe algo que um vivo roubou de mim, eu não posso te contar o que seja, por enquanto. Mas é algo simples...;1;/[continuar]>47
        47; {morte}: Portanto, eu irei propor a senhorita um acordo. Posso encaminhar sua alma de volta para o mundo dos vivos. Portanto, a senhorita devera prometer a mim que seguira minhas instruções para encontrar o que preciso. ;2;/Senhora Margot, estou confusa. Por que eu ?>48;O que roubaram da senhora ?>48
        48; {morte}: Não há tempo de explicar, logo encontrarão a senhorita morta em seu carro. Será simples, sua vida de volta em troca de seguir minhas instruções.;1;/Quais Instruções ?>49
        49; {morte}: Mandarei pistas, você saberá quando for o momento de seguir por determinado caminho.;1;/E caso eu não cumpra o que a senhora peça? >50
        50; {morte}: Não poderei fazer nada a não ser esperar nosso próximo encontro. Como eu disse, não mato as pessoas. Mesmo que a senhorita não cumpra com o acordo, jamais poderia te punir.;1;/Então eu aceito, eu faria de tudo para ver minha pequena Elise, mesmo que sejam por apenas mais alguns anos. Ela é somente um bebê.>51
        51; {morte}: Enquanto a isso.... Não, deixe para lá. Logo você descobrira. Espere um segundo...;1;/[continuar]>52
        52; *Ela andou sozinha até o próximo cômodo da casa. Ela retornou com uma pequena caixa em mãos e um bilhete.;1;/[continuar]>53
        53; {morte}: Agora vá, se apresse.;1;/[continuar]>54
        54; *Ela toca em minha testa.;1;/[continuar]>99

        99; CAPITULO 2 ;1;/[continuar]>100

        100; *Acordo dentro de meu carro, minha cabeça dói muito, mas não tem nenhum ferimento nela. O Som do alarme está muito alto e não consigo desligá-lo.;1;/[continuar]>101
        101; *Não consigo me lembrar de nada dos últimos dias. Exceto do meu último sonho, eu bati o carro. Mas como isso foi acontecer?.;1;/[continuar]>102
        103; *Olho para o lado direito. Vejo a caixa que Margot me entregou. Tem um Bilhete ao lado dela. A Caixa tem um sistema de senha de 4 dígitos nela.;1;/[continuar]>104
        104; *O bilhete diz “Pense como um computador”. Na parte de trás contém o número 11.;1;/[continuar]>105
        105; *Portanto, os números do bilhete são números decimais. Eles não cabem no leitor da caixa. Quais números eu deveria inserir?.;1;/[continuar]>106











        100;hora do input! dona morte se chama {morte}!;0;/0>0/input
        """;

    static String possiveisNomesDaMorte[] = {
        "Margot",
        "Maria",
        "Elise",
        "Diana",
        "Nala"
    };
    static String nomeDaMorte = "";

    static String nomeDoPlayer = "Susan";

    static Scanner input;
    static Random rand;
    static String linhaAtual;
    static int estadoDialogo = 35;

    static final int TEMPO_DE_DIALOGO = 15;
    static final int INTERVALO_DE_OPCOES = 40;
    static final int TEMPO_DE_OPCOES = 7;

    static final String DIVISOR_DE_DIALOGOS = ";";
    static final String DIVISOR_DIALOGO_OPCAO = "/";


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

        formatarTextoBruto();

        iniciarMenu();
    }

    static void formatarTextoBruto()
    {
        textoBruto = textoBruto.replace("{morte}", nomeDaMorte);
        textoBruto = textoBruto.replace("{player}", nomeDoPlayer);
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
            if(Integer.parseInt(l.split(DIVISOR_DE_DIALOGOS)[0]) == estadoDialogo)
            {
                linhaAtual = l;
                return;
            }
        }
        linhaAtual = "0;erro! nao foi possivel achar a linha de dialogo (" + estadoDialogo +");1;/okay>0";
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

        int qntDeOpcoes = Integer.parseInt(linhaAtual.split(DIVISOR_DE_DIALOGOS)[2]);

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
            String opcoes = linhaAtual.split(DIVISOR_DIALOGO_OPCAO)[1];
            int opcaoSelecionada = Integer.parseInt(entrada) - 1;
            String subOpcao = opcoes.split(DIVISOR_DE_DIALOGOS)[opcaoSelecionada];
            estadoDialogo = Integer.parseInt(subOpcao.split(">")[1]);
            pegarLinhaDeDialogo();
            qntDeOpcoes = Integer.parseInt(linhaAtual.split(DIVISOR_DE_DIALOGOS)[2]);


            if(linhaAtual.split("/").length > 2)
            {
                flag = linhaAtual.split("/")[2];
            }
        }

        digitar("\n" + linhaAtual.split(DIVISOR_DE_DIALOGOS)[1] + "\n");

        for(int i = 0; i < qntDeOpcoes; i++)
        {
            String[] opcoes = linhaAtual.split(DIVISOR_DIALOGO_OPCAO)[1].split(DIVISOR_DE_DIALOGOS);
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
                lerInput("101", 21, "*a porta não se abre");
                break;
            case "puzzleJanela":
                lerInput("11", 34, "*ainda não da pra ver nada");
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
