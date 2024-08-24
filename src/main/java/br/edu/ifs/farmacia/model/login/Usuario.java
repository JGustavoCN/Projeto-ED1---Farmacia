package br.edu.ifs.farmacia.model.login;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Aluno
 */
public abstract class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract TipoUsuario getTipo(); // Método para retornar o tipo de usuário

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return Objects.equals(username, other.username)
                && Objects.equals(password, other.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + '}';
    }
    
}
