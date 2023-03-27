package com.api.sistemafalta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sistemafalta.modelos.falta.NovaFaltaDTO;

@RestController()
public class FaltaController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/falta/registra-falta")
    public ResponseEntity<Response> registraFalta(@RequestBody NovaFaltaDTO falta) {
        try {
            String query = "INSERT INTO falta (id_aluno, id_aula) VALUES (:idAluno, :idAula);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idAluno", falta.getIdAluno());
            params.addValue("idAula", falta.getIdAula());
            jdbcTemplate.update(query, params);
            Response response = new Response("Falta registrada com sucesso", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

}
