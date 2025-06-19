import java.util.Random;
import java.util.random.RandomGenerator;

public class Produto {
    private Long id;
    private String name;
    private double preco;

    public Produto(String name, double preco){
        Long randomNumber;
        Produto searchProduct;
        do{
            randomNumber=new Random().nextLong(99999);
            final Long randomFinalNumber=randomNumber;
            if(Banco.getListOfProduct().stream().filter(e -> e.getId().equals(randomFinalNumber)).findFirst().isPresent()){
                searchProduct=Banco.getListOfProduct().stream().filter(e -> e.getId().equals(randomFinalNumber)).findFirst().get();
            }else{
                searchProduct=null;
            }
            
        }while(searchProduct!=null);

        this.id=randomNumber;
        this.name=name;
        this.preco=preco;
        Banco.addProduct(this);
    }
    public String exibirDetalhes(){
        return "Produto=================\n"+
                "  Id: "+this.id+"\n"+
                "  Nome: "+this.name+"\n"+
                "  Preço: "+this.preco+"\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
