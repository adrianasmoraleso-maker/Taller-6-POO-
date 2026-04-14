package org.taller.Clases.prueba;

import org.taller.Clases.Vehiculo;

class Prueba {
      void prueba() {
         Vehiculo v = new Vehiculo("Auto", "Ford");
         System.out.println(v.tipo);  // Error si Prueba está en otro paquete
         System.out.println(v.marca); // Error: protected no es accesible desde una clase
                                      // que NO hereda y está en otro paquete
     }
 }

// El modificador 'protected' permite acceso:
// Dentro de la misma clase (Si)
// Desde subclases (en cualquier paquete) (Si)
// Desde cualquier clase del mismo paquete (Si)
// Desde clases externas NO relacionadas en otros paquetes (No)
