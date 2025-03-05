package com.devsuperior.EVENTOS.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private Double preco;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;
        return Objects.equals(id, atividade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @ManyToMany
    @JoinTable(name = "tb_atividade_participante",
             joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos = new ArrayList<>();

    public Atividade(Integer id, String descricao, String nome, Double preco, Set<Participante> participantes, Categoria categoria, List<Bloco> blocos) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.participantes = participantes;
        this.categoria = categoria;
        this.blocos = blocos;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }




}
