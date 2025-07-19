import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    private double num1;
    private double num2;
    private double result;
    private String operacao;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public static double lerNumero(Scanner scanner, String mensagem){
        double num = 0; //GUARDARÁ O VALOR RECEBIDO
        boolean valido = false; //VALIDADOR DE ENTRADA

        //ENQUANTO O VALOR NÃO FOR VÁLIDO, SOLICITARÁ A ENTRADA NOVAMENTE
        while (!valido){
            System.out.print(mensagem);
            try{
                num = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) { //UTILIZA ESSA EXECESSAO PQ TRATA EXATAMENTE DE ERRO NUMERICO
                System.out.println("Valor Inválido! Digite um número válido.");
                scanner.next(); //IGNORAR O DADO RECEBIDO E RETORNAR AO WHILE
            }
        }
        return num;
    }

   public static String validarOperador(Scanner scanner){
        String op = "";
        boolean valido = false;
        while (!valido) {

            System.out.println("==== Qual tipo de operação deseja realizar? ====");
            System.out.println("[+] | [-] | [*] | [/]");
            System.out.print("Operador: ");
            op = scanner.next();

            if (op.equalsIgnoreCase("+") || op.equalsIgnoreCase("-") || op.equals("*") || op.equals("/")){
                valido = true;
            }else {
                System.out.println("Operador Inválido! Digite novamente.");
                //scanner.next();
            }
        }
        return op;
   }

    public void calcular(double num1, double num2){
        switch (operacao){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0){
                    System.out.print("Erro! Não é possível dividir por Zero.");
                }else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("Operação Inválida!");
                return;
        }
    }

    public String getDescricaoOperador(){
        switch (operacao){
            case "+": return "MAIS";
            case "-": return "MENOS";
            case "*": return "MULTIPLICADO POR";
            case "/": return "DIVIDIDO POR";
            default: return "INVÁLIDO";
        }
    }
}




































