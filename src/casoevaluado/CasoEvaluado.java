/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoevaluado;

import javax.swing.JOptionPane;

/**
 *
 * @author milkyaakath
 */
public class CasoEvaluado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //solicitar datos del agente 
        String nombreAgente = JOptionPane.showInputDialog("Ingrese el nombre del agente: ");
        String cedulaAgente = JOptionPane.showInputDialog("Ingrese la cédula del agente: ");
        String codigoAgente = JOptionPane.showInputDialog("Ingrese el código del agente: ");
        String sucursalAgente = JOptionPane.showInputDialog("Ingrese la sucursal en la que labora el agente: ");
        String vehiculoAgente = JOptionPane.showInputDialog("¿El agente tiene vehículo? (sí/No): ");
        boolean tieneVehiculo =  vehiculoAgente.equalsIgnoreCase("sí");
        
        //objeto agente
        Agente a1 = new Agente(nombreAgente, cedulaAgente, codigoAgente,sucursalAgente, tieneVehiculo);
        
        //variables de cálculo
        int cantidadFacturas = 0;
        int puntosVendedor = 0;
        double totalComisiones = 0;
        double sumaMontos = 0;
        int mes;
        
        //aquí pediremos los datos de los clientes y facturación
        int continuar;
        do {            
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
            String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente: ");
            String codigoFatura = JOptionPane.showInputDialog("Ingrese el código de la factura: ");
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la fatura:"));
            do {                
                mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del mes en el que estamos (1-12): "));
            } while (mes < 1 && mes > 12);
                int cantElectricos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos eléctricos tiene?"));
                int cantAutomotrices = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos automotrices tiene?"));
                int cantConstruccion = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos productos de construcción tiene?"));
            
            sumaMontos += montoFactura;
            cantidadFacturas ++;
            
            //condiciones
            double montoBase = 0;
            double bono = 0;
            int puntos = 0;
            boolean tieneTresTipos = (cantElectricos > 0 && cantAutomotrices > 0 && cantConstruccion > 0);

            if (tieneTresTipos) {
                //regla especial
                bono += 0.10 * montoFactura;
                puntos += 3;
                if (montoFactura > 50_000) {
                    bono += 0.05 * montoFactura;
                    puntos += 1;
                }
            } else {
                //a) eléctricos
                if (cantElectricos >= 3) {
                    bono += 0.04 * montoFactura;
                } else {
                    bono += 0.02 * montoFactura;
                }
                puntos += 1;

                //b) automotrices
                if (cantAutomotrices > 4) {
                    bono += 0.04 * montoFactura;
                } else {
                    bono += 0.02 * montoFactura;
                }
                puntos += 1;

                //c) construcción
                if (cantElectricos > 0) {
                    bono += 0.08 * montoFactura;
                    puntos += 2;
                }

                //d) monto mayor a 50000
                if (montoFactura > 50_000) {
                    bono += 0.05 * montoFactura;
                    puntos += 1;
                }
            }
            
            //acumular lo faltante
            totalComisiones += bono;
            puntosVendedor += puntos;
              
            continuar = JOptionPane.showConfirmDialog(null, "desea ingresar otra factura?", "continuar", JOptionPane.YES_NO_OPTION); //una casilla donde habrá una opción de sí y no
             
        } while (continuar == JOptionPane.YES_OPTION); //si la opción fue un sí se vuelve a iniciar el do while
        
        //y por último el bono extra
        boolean bonoExtra =  cantidadFacturas > 3|| sumaMontos > 300000;
        if (bonoExtra) {
            totalComisiones += 20000;
        }
        
        //mensaje final
        String mensaje = "El agente vendedor " + a1.getNombreAgente() + " código " +a1.getCodigoAgente() +  " en el mes " + mes + "\n\n";
        mensaje += "Vendió un total de " + sumaMontos + " en facturas\n";
        mensaje += "Obtuvo un total en comisiones de " + totalComisiones + "\n";
        mensaje += bonoExtra ? "El agente logró el objetivo de obtener el BONO EXTRA.\n" : "El agente NO logró el bono extra.\n";
        mensaje += "Puntos obtenidos por el agente " + puntosVendedor + "\n";
        mensaje += a1.isVehículoAgente() ? "El agente cuenta con licencia profesional.\n" : "El agente NO cuenta con licencia profesional.\n";
        mensaje += "Sucursal: " + a1.getSucursalAgente();
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}
