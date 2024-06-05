package src;

import java.util.Scanner;

public class TesteFuncoes {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean resultado = false;
        int alvo = 0;

        System.out.println("insira a linha de diálogo a ser verificada:");

        alvo = input.nextInt();
        resultado = Main.pegarLinhaDeDialogo(alvo);
        if(resultado) {
            System.out.printf("linha n° %s existe!\n", alvo);
        }
        else{
            System.out.printf("linha n° %s não existe!\nexibindo mensagem de erro!\n", alvo);
        }
        System.out.println(Main.linhaAtual);

        input.close();
 
    }

}
