public class Cliente {
    //Creamos los atributos
    private String rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono;
    private CuentaCorriente cuentaCorriente;

    //Creamos el constructor
    //Uno vacio y otro con los atributos

    public Cliente() {
    }

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, int numeroCuenta) {

        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaCorriente = new CuentaCorriente(numeroCuenta); //Creamos una cuenta corriente vinculada al cliente con el numero de cuenta proporcionado
    }

    //Este get es para poder utilizar los metodos de la cuenta corri
    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    //Metodos

    public void mostrarDatos() {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("Numero de Cuenta: " + cuentaCorriente.getNumeroCuenta());
        System.out.println("Saldo: " + cuentaCorriente.getSaldo());
    }

}
