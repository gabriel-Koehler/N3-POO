import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Produto> produtos = new ArrayList<Produto>();
    static Pedido currentPedido=new Pedido();
    static final Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        new Cliente("null", "null@email", "123456");
        new Cliente("nully", "nully@email", "1");
        new Produto("Pedra", 35);
        new Produto("Areia", 15);
        new Produto("Cal", 55);
        new Produto("Cimento", 75);

        do  {} while(firstMenu());

    }

    public static Boolean firstMenu(){
        System.out.println("""
                1 - Fazer Pedido
                2 - Adicionar Produto
                3 - Conferir Pedidos
                4 - Realizar Pagamento de Pedidos
                5 - Conferir Clientes
                6 - Finalizar Sistema

                Escolha uma opção:
                """);
        switch (SC.nextInt()) {
            case 1:
                emitOrder();
                break;
            case 2:
                addNewproduct();
                break;
            case 3:
                viewOrders();
                break;
            case 4:
                confirmPayments();
                break;
            case 5:
                viewClients();
                break;
            case 6:
            return false;

            default:
                break;
        }
        return true;
    }
    public static void emitOrder(){
        String clientCpf;
        Pessoa pessoaEncontrada = null;
    
        // Loop até encontrar um cliente válido no banco de dados
        do {
            System.out.print("Atribua o CPF do Cliente: ");
            clientCpf = SC.next();
            final String cpfFinal = clientCpf;
            // Realiza a busca fora da lambda para evitar o erro
            pessoaEncontrada = Banco.getListOfPeoples()
                .stream()
                .filter(p -> p.getCpf().equals(cpfFinal))
                .findFirst()
                .orElse(null);
    
            if (pessoaEncontrada == null) {
                System.out.println("Cliente não encontrado. Tente novamente.");
            }
    
        } while (pessoaEncontrada == null);
    
        // Define o cliente no pedido atual
        currentPedido.setCliente(new Cliente(pessoaEncontrada));

        do{} while(addProductsInOrder());
        
    }
    public static void viewClients(){
        System.out.println("Clientes:");
        for (Pessoa cliente : Banco.getListOfPeoples()) {
            System.out.println(" - "+cliente.getCpf());
            System.out.println("=-=-=-==-=-=-=-=-=-=-=-=-=");
        }
    }
    public static Boolean addProductsInOrder(){
        Produto searchProduct;
        System.out.println("Produtos Disponiveis=====");
        for(Produto produto : Banco.getListOfProduct()){
            System.out.println(produto.getId()+" - "+produto.getName()+" - "+produto.getPreco());
        }
        do{
            System.out.println("Escolha um Prduto: ");
            Long produtoId=SC.nextLong();
            searchProduct=Banco.getListOfProduct().stream().filter(e -> e.getId().equals(produtoId)).findFirst().get();
            if(searchProduct==null){
                System.out.println("Produto Inexistente ");
            }
        }while(searchProduct==null);

        System.out.println("Qual a quantidade desse Prduto: ");
        Long qtd =SC.nextLong();
        PedidoProduto pedidoProduto=
            new PedidoProduto(
                searchProduct,
                currentPedido,
                qtd
            );
        System.out.println("Deseja continuar (Não = 0 / Sim = 1): ");
        Integer option =SC.nextInt();
        List<PedidoProduto> currentList=currentPedido.getProdutos();
        currentList.add(pedidoProduto);
        currentPedido.setProdutos(currentList);

        if(option == 1){
            return true;
        }
        return false;    

    }
    public static void addNewproduct(){
        System.out.println("Insira o Nome desse novo Produto:");
        String nameProduct=SC.next();
        System.out.println("Insira o Preço desse novo Produto:");
        Double priceProduct=SC.nextDouble();
        new Produto(nameProduct, priceProduct);
        System.out.println("Produto Criado!!!!");
    }
    public static void viewOrders(){
        System.out.println("Pedidos==================================");
        for(Pedido order:Banco.getListOfPedidos()){
            System.out.println(order.exibirResumo());
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }
    public static void confirmPayments(){
        System.out.println("Pedidos==================================");
        for(Pedido order:Banco.getListOfPedidos()){
            System.out.println(order.exibirResumo());
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        Pedido searchOrder;
        do{
            System.out.println("Qual Pedido deseja Pagar: ");
            Long idOrder=SC.nextLong();
            searchOrder=Banco.getListOfPedidos().stream().filter(e -> e.getId().equals(idOrder)).findFirst().get();
            if(searchOrder==null){
                System.out.println("Pedido Inexistente ");
            }
        }while(searchOrder==null);

        String metodo="";
        System.out.println("""
                    1 - Debito
                    2 - Crétido
                    3 - Boleto
                    Indique a forma de Pagamento:
                """);
        switch (SC.nextInt()) {
            case 1:
                metodo="Débito";
                break;
            case 2:
            metodo="Crédito";
                break;
            case 3:
            metodo="Boleto";
                break;
            default:
                break;
        }
        searchOrder.getPagamento().setMetodo(metodo);
        System.out.println("Deseja Realmente Pagar?(Não = 0 / Sim = 1): ");
        switch (SC.nextInt()) {
            case 1:
            searchOrder.getPagamento().confirmarPagamento();
            System.out.println("Tá Pago!!!");
                break;
            default:
                break;
        }
    }
}
