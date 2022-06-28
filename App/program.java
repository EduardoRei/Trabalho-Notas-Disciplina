package Trabalhos_poo.Trabalho_Disciplina.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Trabalhos_poo.Trabalho_Disciplina.Entidades.Aluno;


public class program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Aluno> List = new ArrayList<>();

        System.out.print("Quantos alunos fazem essa disciplina? ");
        int n = sc.nextInt();
        System.out.print("Quantos trabalhos/provas compõe a nota? ");
        int j = sc.nextInt();

        double notas[] = new double[j];
        System.out.println("Algum trabalho tem peso diferente? (s/n) ");
        char ch = sc.next().charAt(0);

        if(ch == 's'){
            for(int z = 0; z<notas.length; z ++){
                System.out.println("Digite o peso do trabalho #" + (z+1) +" em porcentagem");
                notas[z] = sc.nextDouble();
                notas[z] = (notas[z] / 100);
            }
        }
        for(int i=1; i <= n; i++){
            System.out.print("Informe o nome do aluno: ");
            sc.nextLine();
            String nome = sc.nextLine();
            double nota,  mediaFinal, soma = 0;
            if(ch == 's'){
                for(int k = 0; k<notas.length; k++){
                    System.out.print("Digite a nota do trabalho #" + (k+1) + " ");
                    nota = sc.nextDouble();
                    soma += (nota * notas[k]);
                }
            }
            else{
                for(int k = 0; k<notas.length; k++){
                    System.out.print("Digite a nota do trabalho #" + (k+1) + " ");
                    nota = sc.nextDouble();
                    soma += nota;
                }
                soma = soma / notas.length;
            }
            mediaFinal = soma;
            List.add(new Aluno(nome, mediaFinal));
        }
        for (Aluno aluno : List) {
            System.out.printf("%s: Media final: %.1f%n", aluno.getNome(), aluno.getNotaFinal());

        }
        sc.close();
    }
}
