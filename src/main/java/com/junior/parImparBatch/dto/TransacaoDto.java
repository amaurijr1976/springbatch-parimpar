package com.junior.parImparBatch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDto {
    public String id;
    public String descricao;
    public Double valor;

    @Override
    public String toString() {
        return "Transacao{" + "id='" + id + "'" + ", descricao='" + descricao + "'" + ", valor='" + valor + "'" + '}';
    }
}
