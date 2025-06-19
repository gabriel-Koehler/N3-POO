public class Pagamento {
    private static Long idInterator=0L;
    private Long id;
    private String metodo;
    private String status;
    private Double valor;

    
    public Pagamento(String metodo, String status) {
        this.id=idInterator++;
        idInterator=this.id;
        this.metodo = metodo;
        this.status = status;
    }
    public String exibirPagamento(){
        return " Método do Pagamento: "+this.metodo+"\n"+
                " Status do Pagamento: "+this.status+"\n"+
                " Total a Pagar: "+this.valor+"\n";
    }
    public String getMetodo() {
        return metodo;
    }
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void cancelarPagamento(){
        this.setStatus("Cancelado");
    }
    public void confirmarPagamento(){
        this.setStatus("Confirmado");
    }
    
}
