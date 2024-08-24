package br.edu.ifs.farmacia.model.login;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public enum TipoUsuario implements Serializable {
    
    FUNCIONARIO("Funcionário", "Acesso básico, permitido apenas a funcionalidades padrão."),
    ADMINISTRADOR("Administrador", "Acesso completo, com permissão para gerenciar usuários e configurar o sistema.");

    private final String nome;
    private final String descricao;

    TipoUsuario(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + ": " + descricao;
    }
}