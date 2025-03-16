package com.humancomunity.crud_bd.controller;

import com.humancomunity.crud_bd.model.Empresa;
import com.humancomunity.crud_bd.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empresa> adicionarEmpresa(@RequestBody Empresa empresa) {
        Empresa result = service.adicionarEmpresa(empresa);

        if(result == null) return ResponseEntity.internalServerError().build();

        return ResponseEntity.status(201).body(service.adicionarEmpresa(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = service.buscarTodasEmpresas();

        if(empresas.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(empresas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(
            @PathVariable Integer id,
            @RequestBody Empresa empresa
    ) {
        Empresa result = service.atualizarEmpresa(id, empresa);

        if(result == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEmpresa(
            @PathVariable Integer id
    ) {
        String result = service.deletarEmpresa(id);

        if(result == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }
}
