package planeta;

public class Planeta {
    // Atributos
    private String nombre;
    private int cantidadSatelites;
    private double masa; 
    private double volumen; 
    private int diametro; 
    private double distanciaMediaAlSol; 
    private TipoPlaneta tipo; 
    private boolean observableADiSimpleVista;

    // Enumerado para el tipo de planeta
    public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    // Constructor
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, 
                   int diametro, double distanciaMediaAlSol, TipoPlaneta tipo, 
                   boolean observableADiSimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaAlSol = distanciaMediaAlSol;
        this.tipo = tipo;
        this.observableADiSimpleVista = observableADiSimpleVista;
    }

    // Método para imprimir los atributos del planeta
    public void imprimirAtributos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa (kg): " + masa);
        System.out.println("Volumen (km³): " + volumen);
        System.out.println("Diámetro (km): " + diametro);
        System.out.println("Distancia media al Sol (millones de km): " + distanciaMediaAlSol);
        System.out.println("Tipo: " + tipo);
        System.out.println("Observable a simple vista: " + observableADiSimpleVista);
    }

    // Método para calcular la densidad
    public double calcularDensidad() {
        if (volumen == 0) {
            return 0; 
        }
        return masa / volumen;
    }

    // Método para determinar si el planeta es exterior
    public boolean esPlanetaExterior() {
        // Convertir distancia media al Sol a UA
        double distanciaMediaAlSolEnKm = distanciaMediaAlSol * 1000000; 
        double distanciaMediaAlSolEnUA = distanciaMediaAlSolEnKm / 149597870; 
        return distanciaMediaAlSolEnUA > 3.4;
    }

    // Método main para crear planetas y mostrar información
    public static void main(String[] args) {
        // Crear dos planetas con valores corregidos
        Planeta marte = new Planeta("Marte", 2, 6.39e23, 1.6318e11, 6779, 227.9, 
                                     TipoPlaneta.TERRESTRE, true);
        Planeta jupiter = new Planeta("Júpiter", 79, 1.898e27, 1.43e15, 
                                       139820, 778.5, TipoPlaneta.GASEOSO, false);

        // Imprimir atributos y resultados
        System.out.println("Información de Marte:");
        marte.imprimirAtributos();
        System.out.println("Densidad: " + marte.calcularDensidad() + " kg/km³");
        System.out.println("Es planeta exterior: " + marte.esPlanetaExterior());

        System.out.println("\nInformación de Júpiter:");
        jupiter.imprimirAtributos();
        System.out.println("Densidad: " + jupiter.calcularDensidad() + " kg/km³");
        System.out.println("Es planeta exterior: " + jupiter.esPlanetaExterior());
    }
}
