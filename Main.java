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
        33;*Talvez você devesse tentar converter este número. Você ainda tem o papel e o lápis.;0;/0>0/puzzleJanela
        34;*Vejo o meu carro, ele acertou em cheio uma arvore na floresta e está completamente destruído;1;/[continuar]>350
        350;DESCONHECIDA: Chovia tanto naquele dia... a senhorita perdeu o controle de seu carro, que saiu da estrada.;2;/A senhora por acaso é a morte?>36;Eu estou no Inferno?>36
        36;DESCONHECIDA: Hahahaha a Senhorita faz muitas perguntas, assim como todos. Não, você não está no Inferno. E eu ?. As pessoas me chamam de diversos nomes. Eu não sou A Morte, eu nunca matei ninguém. Estou aqui somente para te recepcionar. Você pode me chamar de {morte}. ;1;/ [continuar] >37
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
        99; CAPITULO 2 ;1;/[continuar]>1000
        1000; *Acordo dentro de meu carro, minha cabeça dói muito, mas não tem nenhum ferimento nela. O Som do alarme está muito alto e não consigo desligá-lo.;1;/[continuar]>101
        101; *Não consigo me lembrar de nada dos últimos dias. Exceto do meu último sonho, eu bati o carro. Mas como isso foi acontecer?.;1;/[continuar]>102
        102; *Olho para o lado direito. Vejo a caixa que Margot me entregou. Tem um Bilhete ao lado dela. A Caixa tem um sistema de senha de 4 dígitos nela.;1;/[continuar]>103
        103; *O bilhete diz PENSE COMO UM COMPUTADOR. Na parte de trás contém o número 11.;1;/[continuar]>104
        104; *Portanto, os números do bilhete são números decimais. Eles não cabem no leitor da caixa. Quais números eu deveria inserir?.;0;/0>0/puzzleCaixa
        105; *A caixa se abre no instante em que eu insiro o último número. Tem um pequeno gato {gato} esculpido em madeira.;1;/[continuar]>106
        106; *Ele se parece com um gato que passeia pelo prédio onde eu moro, me pergunto o que ele representa.;1;/[continuar]>107
        107; *Posso escutar alguns sons de sirenes se aproximando. Tem sangue escorrendo pelo meu rosto. Me sinto tonta, como se estivesse prestes a desmaiar novamente...;1;/[continuar]>200
        200; CAPITULO 3 ;1;/[continuar]>202
        202; *Eu apaguei após pegar o pequeno gato de madeira e acordei em meu apartamento.;1;/[continuar]>203
        203; *Não me lembro de ter sido de meu carro e nem de como fiz o caminho até em casa. Me lembro apenas de meu ultimo sonho, aquele com a senhora {morte};1;/[continuar]>204
        204; *Me levanto e me dirijo logo ao quarto de minha filha...;1;/[continuar]>206
        206; *O Quarto dela esta vazio. Você observa ao redor ?;2;/[sim]>207;[não]>209
        207; *Ele está vazio, ela não está aqui e todas as coisas dela sumiram. O guarda-roupas dela está completamente limpo, as estantes de brinquedos também. Até o tapete e as cortinas foram levados.;1;/[continuar]>209
        209; *Me pergunto quem esvaziou este quarto ... ;1;/[continuar]>210
        210; *Minha esposa também não está em casa.;1;/[continuar]>211
        211; Você se dirige até a cozinha ou seu quarto ?;2;/[cozinha]>212;[quarto]>213
        212; A comida da geladeira está toda estragada, parece que os cômodos não são limpos a muitos dias. Eu me pergunto onde as duas estão.;1;/[ir ao quarto]>213
        213; *Volto para meu quarto, preciso pegar novas roupas para substituir as minhas rasgadas. Tem um espelho ao lado da porta. Você se observa nele ?;2;/[sim]>214;[não]>215 
        214; *Tem um curativo em minha cabeça e ela já não dói mais. Me observo no espelho próximo a estante e me vejo com as mesmas roupas que vestia no sonho que tive com aquela velha senhora, a {morte}.;1;/[continuar]>215
        215; *Mexo em meu bolso antes de colocar novas roupas e percebo que ainda possuo o mesmo pedaço de papel e o mesmo lápis. Me pergunto como isso é possível ;1;/[continuar]>216
        216; *Aquilo foi apenas um sonho, correto ? ;1;/[continuar]>217
        217; *Observo meu gaveteiro de roupas, tem uma pequena fechadura na primeira gaveta com entrada para 4 números. Observo que no meu quadro de casamento está riscado o número 12. Qual número eu deveria inserir na fechadura ?;0;/0>0/puzzleGaveteiro
        218; *A gaveta se abre. Tem varios objetos junto a uma carta.;1;/[continuar]>219
        219; *A carta foi escrita com a letra de minha esposa. Ela diz: ;1;/[continuar]>220
        220; Querida Susan, Me perdoe por te deixar sem me despedir, eu estava em desespero por ficar dentro deste apartamento, uma dor rasga meu peito todas as vezes em que eu observo os cômodos. Quando você ler esta carta, saiba que estou na casa de minha mãe. Sei o quão cruel fui por te deixar sozinha neste momento, mas eu não pude, não consigo te encarar nos olhos depois de tudo. Todos dizem que a culpa não foi nossa, mas no fundo, não posso deixar de acreditar que somos sim, culpadas. Sempre sua, Agnes. ;1;/[continuar]>221
        221; *No momento em que terminei de ler a carta, senti meu corpo todo se arrepiar. Não consigo me lembrar do que fizemos, somos culpadas de que ? ;1;/[continuar]>222
        222; *Cai em lagrimas após sentar na cama, foi quando ouvi um ruido na porta da varanda, algo esta arranhando a porta como se quisesse entrar ;1;/[continuar]>223
        223; *Abro a porta e um gato {gato} entra em meu quarto. Ele é da mesma cor do gatinho de madeira que estava na caixa de {morte};1;/[continuar]>224
        224; *Ele tem olhos grandes e amarelos. Me encara como se quisse me comunicar algo.;1;/[continuar]>225
        226; *Ele mia e se dirige para o corredor, como se disesse para eu segui-lo. Você o acompanha ? ;2;/[sim]>227;[não]>227
        227; Continua...;1;/[continuar]>228
        228; Muito Obrigada Por jogar! Maria Fernanda Silva Leite e João Pedro Krachowetz
        100;hora do input! dona morte se chama {morte}!;0;/0>0/input
        """;

    static String possiveisCoresDoGato[] = {
         "laranja",
         "cinza",
         "preto",
         "branco",
         "preto e branco"
    };
    static String possiveisNomesDaMorte[] = {
        "Margot",
        "Maria",
        "Elise",
        "Diana",
        "Nala"
    };
    static String nomeDaMorte = "";

    static String corDoGato = "";

    static String nomeDoPlayer = "Susan";

    static Scanner input;
    static Random rand;
    static String linhaAtual;
    static int estadoDialogo = 105;

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
         * 1)Inicializa o Random.
         * 2)Inicializa o Scanner.
         *
         * 3)Escolhe o nome da morte.
         * 4)Escolhe a cor do gato.
         * 5)Chama a função "formatarTextoBruto" para aplicar o nome da morte e a cor do gato no texto bruto.
         *
         * 6)Inicia o menu de opções do jogo.
         */

        //1)
        rand = new Random();
        //2)
        input = new Scanner(System.in);

        //3)
        nomeDaMorte = possiveisNomesDaMorte
        [
            rand.nextInt(possiveisNomesDaMorte.length)
        ];
         
        //4)
        corDoGato = possiveisCoresDoGato
        [
            rand.nextInt(possiveisCoresDoGato.length)
        ];

        //5)
        formatarTextoBruto();
        
        //6)
        iniciarMenu();
    }

    static void formatarTextoBruto()
    {
        textoBruto = textoBruto.replace("{gato}", corDoGato);
        textoBruto = textoBruto.replace("{morte}", nomeDaMorte);
        textoBruto = textoBruto.replace("{player}", nomeDoPlayer);
    }

    static void iniciarMenu() throws Exception
    {
        /*
         * FUNÇÃO INICIAR MENU:
         *
         * Enquanto o Menu não for fechado:
         *  
         * 1)Estado Padrão:
         *      ("case 0") limpa o console, Exibe o titulo do jogo e, as Opções (4 Opções).
         *
         * 2)Caso a opção (Input do Usuário) seja 1:
         *      Exibe as instruções do jogo e aguarda um Input para voltar ao estado inicial.
         *
         * 3)Caso a opção (Input do Usuário) seja 2:
         *      Fecha o menu e chama a função iniciarLoopDeDialogo (Função que Inicializa o Jogo).
         *
         * 4)Caso a opção (Input do Usuário) seja 3:
         *      Exibe os Créditos do jogo e aguarda um Input para voltar ao estado inicial.
         *  
         * 5)Caso a opção (Input do Usuário) seja 4:
         *      Fecha o Scanner, fecha o Menu e fecha o Jogo.
         */

        //1)
        String estado = "0";
        boolean fechado = false;

        do
        {
            switch (estado)
            {
                case "0":   //Estado Inicial (0).
                    System.out.print("\033[H\033[2J");
                    System.out.flush();


                    System.out.println("\nSeja Bem Vindo ao Limbo!");
                    System.out.println("\n1) Instruções\n2) Novo Jogo\n3) Créditos\n4) Sair");


                    estado = input.nextLine();
                    break;
                
                //2)    
                case "1": //estado instruções
                    System.out.println("\nLeia os textos, digite os numeros de 1-9 para selecionar a opção de diálogo escolhida. ");


                    input.nextLine();
                    estado = "0";
                    break;

                //3)
                case "2": //estado jogar
                    iniciarLoopDeDialogo();
                    fechado = true;
                    break;
                
                //4)
                case "3": //estado créditos
                    System.out.println("\nfeito por: João Pedro Kraschowetz Souza e Maria Fernanda Silva Leite");


                    input.nextLine();
                    estado = "0";
                    break;

                //5)
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
         * 1) Transforma o texto atual em uma lista de Strings. (Ele entente o "\n" como o ponto de divisão do texto em linhas).
         *
         * 2) Para cada uma das linhas da Lista:
         *      -Verifica se o 1° elemento da linha verificada antes do ";" (DIVISOR) == estado do diálogo.
         *
         *      -Se for: coloca a linha de texto sendo processada na variavel "linha atual" e fecha a função.
         *      
         * 3) Caso não ache a linha que corresponde ao estado de diálogo atual:
         *      -Exibe a linha padrão de erro e reseta o diálogo.
         *
         */

        //1)
        String[] linhas = textoBruto.split("\n");

        //2)
        for(String l : linhas)
        {
            if(Integer.parseInt(l.split(DIVISOR_DE_DIALOGOS)[0]) == estadoDialogo)
            {
                linhaAtual = l;
                return;
            }
        }
        //3)
        linhaAtual = "0;erro! nao foi possivel achar a linha de dialogo (" + estadoDialogo +");1;/okay>0";

    }


    static void atualizarDialogo(String entrada) throws Exception
    {
        /*
         * FUNÇÃO ATUALIZAR DIÁLOGO:
         *
         * 1) Chama a Função pegarLinhaDeDialogo ();.
         *
         * 2) Verifica se a entrada do usuário não ira causar nenhum erro:
         *
         *    -Se entrada não for um número:
         *    Exibe mensagem de erro, reseta linha de diálogo atual.
         * 
         *    -Se entrada for < 0 ou > quantidade de opções:
         *     Exibe mensagem de erro, reseta linha de diálogo atual.
         *
         *    -Se entrada do usuário não for 0:
         *      Verifica qual foi a opção selecionada;
         *      Muda o estado do diálogo baseado na opção selecionada;
         *      Pega a linha de dialogo nova();
         *      Atualiza a quantidade de opções baseado na linha nova;
         *      Verifica se a linha de dialogo não possui nenhuma flag.
         *
         * -exibe o texto da linha de diálogo atual
         *
         * -exibe todas as opções de resposta para a linha atual
         *
         * -caso exista, executa o código da flag
         */


        String flag = "";
        
        //1)
        pegarLinhaDeDialogo();  

        //2)
        //Se entrada não for um número:
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
 
        //Se entrada for < 0 ou > quantidade de opções:
        if(Integer.parseInt(entrada) < 0 || Integer.parseInt(entrada) > qntDeOpcoes)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();


            System.out.println("erro: opção invalida");
            atualizarDialogo("0");
            return;
        }
        
        //Se entrada do usuário não for 0:
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
         * FUNÇÃO ATUALIZAR:
         * 
         * 1) Pega a entrada de usuário
         *
         * 2) Atualiza o dialogo (Chamando a Função de Atualizar o Diálogo) o dialogo baseado na entrada do usuário();.
         *
         * 3) Se o estado do diálogo não for negativo:
         *    -Atualiza novamente.
         */
        //1
        String entrada = input.nextLine();

        //2
        atualizarDialogo(entrada);

        //3
        if(estadoDialogo >= 0)
        {
            atualizar();
        }
    }


    static void iniciarLoopDeDialogo() throws Exception
    {
        /*
         * FUNÇÃO QUE INICIA O LOOP DO JOGO:
         *
         * 1) AtuaLiza a linha de dialogo chamando a função atualizarDialogo.
         * 
         * 2) Chama a função atualizar();.
         */

        //1
        atualizarDialogo("0");

        //2
        atualizar();
    }


    static void lerInput(String alvo, int linhaAlvo, String textoDeErro) throws Exception
    {  
        /*
         * FUNÇÃO LER INPUT
         * 
         * 1) Após ser exibido um desafio, pedirá para que o usuário digite a resposta do desafio
         *    -Se a resposta foi igual ao alvo da questão (O Alvo foi definido na função interpretarFlag). O Estado do Diálogo será atualizado para a Linha Alvo,
         *    Significa que o Usuário Acertou.
         * 
         * 2) Se o usuário errar, será exibido o textoDeErro (O textoDeErro foi definido na função interpretarFlag).
         * 
         * 3)Isto se reperitá enquanto o usuário não acertar a questão (Não possuindo limite de respostas erradas).
         */
        boolean acertou = false;
        
        //1)
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
        //3)
        while(!acertou);
    }


    static void interpretarFlag(String flag) throws Exception
    {
        /*
         * 1) Roda um switch case com a flag a ser interpretada:
         *    -Cada Flag tem um nome referente ao seu Desafio. Desafios diferentes aparecem em momentos diferentes do jogo.
         *    -Cada Desafio tem um nome. 
         *    -Nesta função, cada Desafio programado informará a função lerInput as informações de seus:
         *    alvo (Resposta), linhaAlvo (Próxima linha caso acerte o desafio) e, Texto de erro (Caso jogador erre).
         */

         //1
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
                break;

            case "puzzleCaixa":
                lerInput("1011", 105, "*a caixa permanece fechada");
                break;
            
            case "puzzleGaveteiro":
                lerInput("1100", 218, "*a gaveta permanece fechada");
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
