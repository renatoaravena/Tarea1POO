public abstract class Cuenta {
    protected int numeroCuenta;
    protected int saldo;

    // Constructores sobrecargados (sobrecarga)
    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public Cuenta(int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Métodos comunes
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        } else {
            System.out.println("Error: El monto debe ser mayor a cero.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor a cero.");
        } else if (monto > saldo) {
            System.out.println("Error: Saldo insuficiente.");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

    // Metodo abstracto (sobreescrito en subclases)
    public abstract void mostrarDetalleEspecifico();

    // Getters
    public int getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
}
