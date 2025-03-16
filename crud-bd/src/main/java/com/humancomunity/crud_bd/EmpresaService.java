package com.humancomunity.crud_bd;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa adicionarEmpresa(Empresa empresa) {
        return repository.adicionarEmpresa(empresa);
    }

    public List<Empresa> buscarTodasEmpresas() {
        return repository.buscarTodasEmpresas();
    }

    public Empresa atualizarEmpresa(Integer id, Empresa empresa) {
        return repository.atualizarEmpresa(id, empresa);
    }

    public String deletarEmpresa(Integer id) {
        return repository.deletarEmpresa(id);
    }
}
