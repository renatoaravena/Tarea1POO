public class CuentaAhorro extends Cuenta {
    private double tasaInteres;

    public CuentaAhorro(int numeroCuenta, double tasaInteres) {
        super(numeroCuenta);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void mostrarDetalleEspecifico() {
        System.out.println("Tipo de cuenta: Ahorro");
        System.out.println("Tasa de interés: " + tasaInteres + "%");
    }
}
