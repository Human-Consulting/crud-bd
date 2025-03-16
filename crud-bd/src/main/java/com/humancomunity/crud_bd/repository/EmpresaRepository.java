package com.humancomunity.crud_bd.repository;

import com.humancomunity.crud_bd.model.Empresa;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpresaRepository {
    private final JdbcClient jdbcClient;

    public EmpresaRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Empresa adicionarEmpresa(Empresa empresa) {
        String sql = "INSERT INTO empresas (cnpj, nome, idDiretor) VALUES (?, ?, ?)";

        int result = jdbcClient.sql(sql)
                .param(empresa.getCnpj())
                .param(empresa.getNome())
                .param(empresa.getDiretor())
                .update();

        if (result > 0) {
            String selectIdSql = "SELECT LAST_INSERT_ID()";
            Integer id = jdbcClient.sql(selectIdSql).query(Integer.class).single();

            empresa.setId(id);

            return empresa;
        } else return null;
    }

    public List<Empresa> buscarTodasEmpresas() {
        String sql = "SELECT * FROM empresas";

        return jdbcClient.sql(sql)
                .query(Empresa.class)
                .list();
    }

    public Empresa atualizarEmpresa(Integer id, Empresa empresa) {
        String sql = "UPDATE empresas SET cnpj = ?,  nome = ?, diretor = ? WHERE id = ?";

        int result = jdbcClient.sql(sql)
                .param(empresa.getCnpj())
                .param(empresa.getNome())
                .param(empresa.getDiretor())
                .param(id)
                .update();

        if (result > 0) {
            empresa.setId(id);

            return empresa;
        } else return null;
    }


    public String deletarEmpresa(Integer id) {
        String sql = "DELETE FROM empresas WHERE id = ?";

        int result = jdbcClient.sql(sql)
                .param(id).update();

        if(result <= 0) return null;

        return "Empresa removida com sucesso!";
    }
}
