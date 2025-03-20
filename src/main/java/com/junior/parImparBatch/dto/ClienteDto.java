package com.junior.parImparBatch.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteDto {
    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private List<TransacaoDto> listaTransacoes = new ArrayList<>() ;


    @Override
    public String toString() {
        return "ClienteDto{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade='" + idade + '\'' +
                ", email='" + email + '\'' +
                (listaTransacoes != null ? ", listaTransacoes=" + listaTransacoes : "") +
                '}';
    }
}
