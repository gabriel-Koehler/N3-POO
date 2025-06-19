import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static Long idInterator=0L;
    private Long id;
    private Cliente cliente;
    private List<PedidoProduto> produtos;
    private Pagamento pagamento;

    public Pedido() {
        this.id = idInterator+1;
        idInterator=this.id;
        this.pagamento = new Pagamento("Sem","Não Finalizado");
        this.produtos=new ArrayList<PedidoProduto>();
        Banco.addPedidos(this);
    }

    public Double calcTotal(){
        Double total =0.0;
        for(PedidoProduto produto : produtos){
            total+=produto.getProdutoId().getPreco();
        }
        return total;
    }
    public String exibirResumo(){
        String produtosString="";
        for(PedidoProduto produto : produtos){
            produtosString+=" "+produto.getProdutoId().exibirDetalhes()+
                            "  Quantidade: "+produto.getQuantidade()+"\n"+
                            "---------------------------";
        }
        this.pagamento.setValor(this.produtos.stream().mapToDouble(e -> e.getProdutoId().getPreco()*e.getQuantidade()).sum());
        return "ID do Pedido: "+this.id+"\n"+
                "Cliente: "+this.cliente.getName()+"\n"+
                produtosString+"\n"+
                this.pagamento.exibirPagamento();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<PedidoProduto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<PedidoProduto> produtos) {
        this.produtos = produtos;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
}
