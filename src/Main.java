import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();
        Scanner scanner  = new Scanner(System.in);

        String continuar = "s";
        while (continuar.equalsIgnoreCase("s")) {

            double num1 = 0;
            double num2 = 0;
            boolean sucesso;

            do{

                /*UTILIZA "Calculadora.lerNumero()" PQ O METODO "lerNumero" É ESTÁTIC, ELE NÃO UTILIZA NENHUM OBJETO DA CLASSE.
                 *APENAS EXECUTA UM COMPORTAMENTO GERAL DE VALIDAR A ENTRADA DOS DADOS
                 */

                num1 = Calculadora.lerNumero(scanner, "Digite o primeiro número: ");
                num2 = Calculadora.lerNumero(scanner, "Digite o segundo número: ");

                //RECEBENDO O OPERADOR
                String op = Calculadora.validarOperador(scanner);

                calc.setNum1(num1);
                calc.setNum2(num2);
                calc.setOperacao(op);
                sucesso = calc.calcular(num1, num2); //

                if (!sucesso){
                    System.out.println("Digite novamente");
                }

            }while (!sucesso);

            System.out.printf("%.2f %s %.2f = %.2f%n", num1, calc.getDescricaoOperador(), num2, calc.getResult());


            System.out.println("Deseja realizar outro cálculo? (s/n)");
            continuar = scanner.next();
        }
    }
}