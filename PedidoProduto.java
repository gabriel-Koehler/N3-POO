public class PedidoProduto {
    private static Long idInterator=0L;
    private Long id;
    private Produto produtoId;
    private Pedido pedidoId;
    private Long quantidade;

    

    public PedidoProduto(Produto produtoId, Pedido pedidoId, Long quantidade) {
        this.id = idInterator+1;
        idInterator=this.id;
        this.produtoId = produtoId;
        this.pedidoId = pedidoId;
        this.quantidade = quantidade;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Produto getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }
    public Pedido getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }
    public Long getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    


}
