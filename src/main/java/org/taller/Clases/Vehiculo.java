package org.taller.Clases;

class Vehiculo {
    protected String tipo;
    protected String marca;

    Vehiculo(String tipo, String marca) {
        this.tipo = tipo;
        this.marca = marca;
    }

    void mostrarVehiculo() {
        System.out.println("Vehículo | Tipo: " + tipo + " | Marca: " + marca);
    }
}

class Moto extends Vehiculo {
    int cilindrada;

    Moto(String marca, int cilindrada) {
        super("Moto", marca);
        this.cilindrada = cilindrada;
    }

    @Override
    void mostrarVehiculo() {
        // Puede acceder a tipo y marca porque son protected y Moto es subclase
        System.out.println("Moto | Marca: " + marca + " | Cilindrada: " + cilindrada + "cc | Tipo: " + tipo);
    }
}