import java.util.ArrayList;

public class Cliente extends Pessoa {
    public Cliente(String name, String email, String cpf) {
        super(name, email, cpf);
        Banco.addPeoples(this);
        //TODO Auto-generated constructor stub
    }

    public Cliente(Pessoa pessoa){
        super(pessoa.getName(), pessoa.getEmail(), pessoa.getCpf());
    }
    
}
