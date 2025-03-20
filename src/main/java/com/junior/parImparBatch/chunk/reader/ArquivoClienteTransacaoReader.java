package com.junior.parImparBatch.chunk.reader;

import com.junior.parImparBatch.dto.ClienteDto;
import com.junior.parImparBatch.dto.TransacaoDto;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;

public class ArquivoClienteTransacaoReader implements ItemStreamReader  <ClienteDto> {

    private Object objetoAtual;
    private ItemStreamReader<ClienteDto> delegate;

    public ArquivoClienteTransacaoReader(ItemStreamReader<ClienteDto> delegate) {
        this.delegate = delegate;
    }


    @Override
    public ClienteDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(objetoAtual == null){
                objetoAtual = delegate.read();
        }
        ClienteDto clienteDto = (ClienteDto) objetoAtual;
        objetoAtual = null;
        if (clienteDto != null) {
            while (peek() instanceof TransacaoDto)
                clienteDto.getListaTransacoes().add((TransacaoDto) objetoAtual);
        }
        return clienteDto;
    }

    private Object peek() throws Exception {
        objetoAtual = delegate.read();
        return objetoAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}
