public class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta);
    }

    @Override
    public void mostrarDetalleEspecifico() {
        System.out.println("Tipo de cuenta: Corriente");
        System.out.println("Característica: Sin límite de giro descubierto");
    }
}
