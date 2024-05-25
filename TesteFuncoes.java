import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TesteFuncoes {
   
    static String textoBruto = 
    """
    0; *este é um texto de teste!;1;/[resposta]>1
    1; *resposta lida com sucesso!;1;/[esta resposta acionara um erro]>2        
    """;

    static String listaStringAleatoria[] = {
        "STRING ALEATORIA 1",
        "STRING ALEATORIA 2",
        "STRING ALEATORIA 3"
    };

    static String stringAleatoria = "";
    
    static Scanner input;
    static Random rand;
    static String linhaAtual;
    static int estadoDialogo = 0;
    
    static final int TEMPO_DE_DIALOGO = 15;
    static final int INTERVALO_DE_OPCOES = 40;
    static final int TEMPO_DE_OPCOES = 7;

    static final String DIVISOR_DE_DIALOGOS = ";";
    static final String DIVISOR_DIALOGO_OPCAO = "/";

    public static void main(String args[]) throws Exception {    
        rand = new Random();
        input = new Scanner(System.in);
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("-Iniciando Função principal!");

        stringAleatoria = listaStringAleatoria[
            rand.nextInt(listaStringAleatoria.length)
        ];

        formatarTextoBruto();
        iniciarLoopDeDialogo();
    }

    static void formatarTextoBruto() {
        textoBruto.replace("{string}", stringAleatoria);
        System.out.println("-Texto Bruto Formatado com sucesso!");        
    }

    static void pegarLinhaDeDialogo() {
        String[] linhas = textoBruto.split("\n");
        
        for(String l : linhas)
        {
            if(Integer.parseInt(l.split(DIVISOR_DE_DIALOGOS)[0]) == estadoDialogo)
            {
                linhaAtual = l;
                System.out.printf("linha de dialogo %S encontrada!\n", estadoDialogo);
                return;
            }
        }

        linhaAtual = "0;erro! nao foi possivel achar a linha de dialogo (" + estadoDialogo +");1;/okay>0";
    }

    static void atualizarDialogo(String entrada) {
        
        pegarLinhaDeDialogo(); 
        
        //proteção contra entrada != int
        try
        {
            Integer.parseInt(entrada);
        }
        catch(NumberFormatException e)
        {
            
            System.out.println("erro: entrada não é um numero");
            atualizarDialogo("0");
            return;
        }
        
        int qntDeOpcoes = Integer.parseInt(linhaAtual.split(DIVISOR_DE_DIALOGOS)[2]);
        
        //Se entrada for < 0 ou > quantidade de opções:
        if(Integer.parseInt(entrada) < 0 || Integer.parseInt(entrada) > qntDeOpcoes)
        {
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
                System.out.printf("flag detectada: ('%s')\n", linhaAtual.split("/")[2]);
            }
        }

        System.out.println("\n" + linhaAtual.split(DIVISOR_DE_DIALOGOS)[1] + "\n");

        for(int i = 0; i < qntDeOpcoes; i++)
        {
            String[] opcoes = linhaAtual.split(DIVISOR_DIALOGO_OPCAO)[1].split(DIVISOR_DE_DIALOGOS);
            System.out.println((i + 1) +") " + opcoes[i].split(">")[0]);
        }
    }

    static void atualizar() {

        String entrada = input.nextLine();

        atualizarDialogo(entrada);

        if(estadoDialogo >= 0)
        {
            atualizar();
        }
    }

    static void iniciarLoopDeDialogo() {
        atualizarDialogo("0");
        atualizar();
    }
}
