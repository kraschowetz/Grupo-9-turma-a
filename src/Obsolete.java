package src;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Obsolete {
	static int temp_dialog = 0;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int escolha;

		Texto("\nAbro meus olhos ...", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nOlho ao redor...", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nEstá muito frio aqui", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nNão me lembro de nada...", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nPor que não sinto medo ...?", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nQuem me trouxe pra cá ...?", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);

		do {
			Texto("\nVocê observa ao redor? ", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n1 - Sim", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n2 - Não", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n)", TimeUnit.MILLISECONDS, temp_dialog);
			escolha = input.nextInt();
			if (escolha != 1 && escolha != 2) {
				Texto("\nVocê observa ao redor? ", TimeUnit.MILLISECONDS, temp_dialog);
				Texto("\n1 - Sim", TimeUnit.MILLISECONDS, temp_dialog);
				Texto("\n2 - Não", TimeUnit.MILLISECONDS, temp_dialog);
				Texto("\n)", TimeUnit.MILLISECONDS, temp_dialog);
			}
		} while (escolha != 1 && escolha != 2);

		if (escolha == 1) {
			Texto("\nEstou sozinha e este lugar é muito estranho. Tem uma cama, uma porta e alguns outros objetos velhos.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nA Sala tem um papel de parede florido amarelo que lembra o quarto de minha infância. Tem alguns brinquedos espalhados pelo chão.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nAbro a porta e saio para fora do quarto. Tem uma estrada e muitas arvores em volta.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nVejo um pacote no chão de tamanho e formato semelhante a um corpo.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nMe aproximo dele ...", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
		} else if (escolha == 2) {
			Texto("\nAbro a porta e saio para fora do quarto. Tem uma estrada e muitas arvores em volta.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nVejo um pacote no chão de tamanho e formato semelhante a um corpo.",
					TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\nMe aproximo dele ...", TimeUnit.MILLISECONDS, temp_dialog);
			Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
		}

		Texto("\nSou eu...", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nNão...", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nComo isso pode acontecer...?", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\n", TimeUnit.MILLISECONDS, temp_dialog);
		Texto("\nImpossível. Só pode ser um sonho, logo irei acordar.", TimeUnit.MILLISECONDS, temp_dialog);
		

		input.close();
	}

	public static void Texto(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
		for (char caractere : mensagem.toCharArray()) {
			System.out.print(caractere);
			unit.sleep(tempo_mensagem);
		}
	}
}
