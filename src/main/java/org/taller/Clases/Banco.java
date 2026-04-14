package org.taller.Clases;

// Ejercicio 3: Banco con saldo protected (inseguro)
/*
 * Problema: saldo como protected:
 */

class Banco {
      protected double saldo;  // es accesible desde cualquier subclase y clase del paquete
  }
  class BancoMalo extends Banco {
      void hackearSaldo() {
         saldo = 999999999; // compila, pero es inseguro: cualquier subclase puede
                             //modificar el saldo sin ninguna validación ni control
      }
  }

  // * ¿Por qué no es seguro?
// * Marcar 'saldo' como protected expone el dato a todas las subclases y a todas las
// * clases del mismo paquete. Cualquiera de ellas puede asignar valores arbitrarios
// * sin pasar por ninguna lógica de negocio (validar montos, registrar transacciones,
// * verificar límites, etc.). El saldo es un dato crítico que debe estar bajo control total.
// *
// * Solucion Propuesta:
// */

class BancoB {
    private double saldo; // con private solo esta clase puede modificarlo directamente

    BancoB(double saldoInicial) {
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
            System.out.println("Saldo inicial inválido. Se asigna 0.");
        }
    }

    // Acceso controlado a través de métodos que encapsulan las reglas de negocio
    public double getSaldo() {
        return saldo;
    }

    public void consignar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Consignación de $" + valor + ". Saldo: $" + saldo);
        } else {
            System.out.println("Valor de consignación inválido.");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retiro de $" + valor + ". Saldo: $" + saldo);
        } else {
            System.out.println("Retiro no autorizado: fondos insuficientes o valor inválido.");
        }
    }

    @Override
    public String toString() {
        return "Banco{saldo=$" + saldo + "}";
    }
}

/*
 * En teoria, cada modificador de acceso en java puede acceder a otras clases de la siguiente forma:
 *
 * | Modificador | Misma clase | Mismo paquete | Subclase (otro paquete) | Cualquier clase |
 * |-------------|-------------|---------------|-------------------------|-----------------|
 * | public      |     Si      |      Si       |           Si            |       Si        |
 * | protected   |     Si      |      Si       |           Si            |       No        |
 * | default     |     Si      |      Si       |           No            |       No        |
 * | private     |     Si      |      No       |           No            |       No        |
 */

