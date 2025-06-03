public class CuentaCredito extends Cuenta {
    private int limiteCredito;

    public CuentaCredito(int numeroCuenta, int limiteCredito) {
        super(numeroCuenta);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto debe ser mayor a cero.");
        } else if (monto > (saldo + limiteCredito)) {
            System.out.println("Error: Excede límite de crédito.");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

    @Override
    public void mostrarDetalleEspecifico() {
        System.out.println("Tipo de cuenta: Crédito");
        System.out.println("Límite de crédito: " + limiteCredito + " pesos");
    }
}