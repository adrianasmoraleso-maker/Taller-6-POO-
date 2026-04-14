package org.taller.Clases;

class Empleado {
    protected String nombre;
    protected double salario;

    Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " | Salario: $" + salario);
    }
}

// Gerente hereda de Empleado y accede a los atributos protected
class Gerente extends Empleado {
    String departamento;

    Gerente(String nombre, double salario, String departamento) {
        super(nombre, salario); // llama al constructor del padre
        this.departamento = departamento;
    }

    // Sobrescribe mostrarInformacion para incluir el departamento
    @Override
    void mostrarInformacion() {
        System.out.println("Gerente: " + nombre + " | Salario: $" + salario
                + " | Departamento: " + departamento);
    }
}