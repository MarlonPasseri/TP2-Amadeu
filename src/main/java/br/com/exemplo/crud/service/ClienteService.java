package br.com.exemplo.crud.service;

import br.com.exemplo.crud.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClienteService {

    private final Map<Long, Cliente> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequencia = new AtomicLong(0L);

    public List<Cliente> buscarTodos() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            long novoId = sequencia.incrementAndGet();
            cliente.setId(novoId);
        }
        storage.put(cliente.getId(), cliente);
        return cliente;
    }

    public void excluir(Long id) {
        storage.remove(id);
    }

    public void limpar() {
        storage.clear();
        sequencia.set(0L);
    }
}
