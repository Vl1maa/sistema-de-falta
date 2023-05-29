package com.api.sistemafalta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sistemafalta.modelos.autenticacao.LoginDTO;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AutenticacaoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping(value = "/login")
    public ResponseEntity<?> novo(@RequestBody LoginDTO login) {
        try {
            String query = "SELECT * FROM gimenez.usuario WHERE usuario = :usuario LIMIT 1;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("usuario", login.getUsuario());
            Response status = jdbcTemplate.query(query, params, rs -> {
                if (rs.next()) {
                    if (rs.getString("senha").equals(login.getSenha())) {
                        return new Response(rs.getString("usuario"), 200);
                    } else {
                        return new Response("Dados incorretos de login", 401);
                    }
                }
                return null;
            });
            if (status != null) {
                return ResponseEntity.status(status.getStatusCode()).body(status);
            } else {
                return ResponseEntity.badRequest().body("Nenhum usuário encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
