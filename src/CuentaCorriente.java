public class CuentaCorriente {
    //Creamos los atributos
    private int numeroCuenta, saldo;

    //Creamos el constructor
    public CuentaCorriente() {
    }

    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    //Creamos los getters y setters segun lo que se nos pida
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    //Metodos

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos");
        } else {
            System.out.println("El monto a depositar debe ser mayor a 0");
        }
    }

    public void girar(int monto) {
        if (monto <= 0){
            System.out.println("El monto a girar debe ser mayor a 0");
        } else if (monto > saldo) {
            System.out.println("El monto a girar es mayor al saldo actual");
            System.out.println("El saldo actual es " + saldo + " pesos");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos");
        }
    }

}
