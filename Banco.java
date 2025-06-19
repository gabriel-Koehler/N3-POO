import java.util.ArrayList;

public class Banco {
    private static ArrayList<Pessoa> listOfPeoples = new ArrayList<>();
    private static ArrayList<Produto> listOfProduct = new ArrayList<>();
    private static ArrayList<Pedido> listOfPedidos = new ArrayList<>();
    public static ArrayList<Pessoa> getListOfPeoples() {
        return listOfPeoples;
    }
    public static void addPeoples(Cliente pessoa) {
        Banco.listOfPeoples.add(pessoa);
    }
    public static ArrayList<Produto> getListOfProduct() {
        return listOfProduct;
    }
    public static void addProduct(Produto produto) {
        Banco.listOfProduct.add(produto) ;
    }
    public static ArrayList<Pedido> getListOfPedidos() {
        return listOfPedidos;
    }
    public static void addPedidos(Pedido pedido) {
        Banco.listOfPedidos.add(pedido);
    }
    
}
