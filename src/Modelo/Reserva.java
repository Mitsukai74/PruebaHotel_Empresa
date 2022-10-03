
package Modelo;

public class Reserva {
    private int valor;
    private String formaPago;

    public Reserva(int valor,String formaPago) {
        this.valor = valor;
        
        this.formaPago = formaPago;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }  
    
    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
}
