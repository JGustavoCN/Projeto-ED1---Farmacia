package br.edu.ifs.farmacia.model.login;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Funcionario extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    public Funcionario(String username, String password) {
        super(username, password);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.FUNCIONARIO;
    }
    
    @Override
    public String toString() {
        return super.toString()+" -> Restrição: " +this.getTipo()+ '}';
    }
    
}
