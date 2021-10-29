package br.com.zup.Lead.Lead.DTOS;

import java.util.List;

public class LeadDTO {
    private String nome;
    private String telefone;
    private String email;
    private List<ProdutoDTO> listaDeProdutos;

    public LeadDTO() {

    }

    public LeadDTO(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void adicionarProduto(ProdutoDTO novoProduto){
        listaDeProdutos.add(novoProduto);
    }
}
