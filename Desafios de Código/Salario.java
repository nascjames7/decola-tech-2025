/**
 * Faça um programa que calcule e imprima o salário a ser transferido para um funcionário
 * de uma empresa. Para realizar o cáculo, receba o valor bruto do salário e o adicional de 
 * benefícios.O salário a ser transferido é calculado da seguinte forma: (valor bruto - percentual 
 * de desconto) + adicional de benefícios. Para o cálculo do percentual de imposto, considere:
 * 
 * De 0.00 R$ - 1100.00 R$: 5.00%
 * De 1100.01 R$ - 2500.00 R$: 10.00%
 * Maior que 2500.00 R$: 15.00%
 */

import java.util.Scanner;

public class Salario{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double salarioBruto, adicionalBeneficios, salarioLiquido, desconto = 0.0;

        System.out.print("Digite o valor bruto do salário: ");
        salarioBruto = input.nextDouble();
        System.out.print("Digite o valor do adicional de benefícios: ");
        adicionalBeneficios = input.nextDouble();

        if(salarioBruto <= 1100.00){
            desconto = 0.05;
        }else if(salarioBruto > 1100.00 && salarioBruto <= 2500.00){
            desconto = 0.10;
        }else if(salarioBruto > 2500.00){
            desconto = 0.15;
        }

        salarioLiquido = (salarioBruto - (salarioBruto * desconto)) + adicionalBeneficios;

        System.out.println("O salário a ser transferido é de R$ " + salarioLiquido);
    }
}