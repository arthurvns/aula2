public class Conta {

    public static int contadorNumContas = 0;

    // atributos
    public String nome;
    public int numConta;
    private double saldo;
    public String cpf;
    public boolean tipo;

    // ações
    public Conta(String nome, int numConta, String cpf, boolean tipo){
        this.nome = nome;
        this.numConta = numConta;
        this.saldo = 0;
        this.cpf = cpf;
        this.tipo = tipo;
        Conta.contadorNumContas++;
    }

    public void imprimirSaldo(){
        System.out.println("==== Conta " +this.numConta + " ====");
        System.out.println("Nome:  "+ this.nome);
        System.out.println("Saldo: "+ this.saldo);
    }

    public boolean sacar(double valor){
        if(valor > this.saldo || valor < 0){
            return false;
        } else{
            this.saldo -=valor;
            return true;
        }
    }

    public boolean depositar(double valor){
        if(valor < 0){
            return  false;
        } else{
            this.saldo += valor;
            return true;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        } else{
            return false;
        }

    }

    public double getSaldo(){
        return this.saldo;
    }
}