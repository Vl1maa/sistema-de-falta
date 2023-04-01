package com.api.sistemafalta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sistemafalta.modelos.turma.NovaTurmaDTO;
import com.api.sistemafalta.modelos.turma.Turma;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/turma")
    public ResponseEntity<Response> registraTurma(@RequestBody NovaTurmaDTO turma) {
        try {
            String query = "INSERT INTO turma (descricao) VALUES (:descricao);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("descricao", turma.getDescricao());
            jdbcTemplate.update(query, params);
            Response response = new Response("Turma registrada com sucesso", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/turma")
    public ResponseEntity<Response> lista() {
        try {
            String query = "SELECT * FROM turma;";
            List<Turma> turmas = jdbcTemplate.query(query, rs -> {
                List<Turma> turmasResgatadas = new ArrayList<Turma>();
                while (rs.next()) {
                    Turma t = new Turma();
                    t.setId(rs.getInt("id"));
                    t.setDescricao(rs.getString("descricao"));
                    turmasResgatadas.add(t);
                }
                ;
                return turmasResgatadas;
            });
            Response response = new Response(turmas, HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }
}
