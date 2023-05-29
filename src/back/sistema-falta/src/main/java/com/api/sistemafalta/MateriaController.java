package com.api.sistemafalta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sistemafalta.modelos.materia.Materia;
import com.api.sistemafalta.modelos.materia.NovaMateriaDTO;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MateriaController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/materia")
    public ResponseEntity<Response> registraMateria(@RequestBody NovaMateriaDTO materia) {
        try {
            String query = "INSERT INTO gimenez.materia (descricao) VALUES (:descricao);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("descricao", materia.getDescricao());
            jdbcTemplate.update(query, params);
            Response response = new Response("Materia registrada com sucesso", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/materia")
    public ResponseEntity<Response> resgataMateria() {
        try {
            String query = "SELECT * FROM gimenez.materia;";
            List<Materia> materiasResgatadas = jdbcTemplate.query(query, rs -> {
                List<Materia> materias = new ArrayList<Materia>();
                while (rs.next()) {
                    Materia m = new Materia();
                    m.setId(rs.getInt("id"));
                    m.setDescricao(rs.getString("descricao"));
                    materias.add(m);
                }
                return materias;
            });
            Response response = new Response(materiasResgatadas, HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @DeleteMapping("/materia/{idMateria}")
    public ResponseEntity<Response> deletar(@PathVariable Integer idMateria) {
        try {
            String query = "DELETE FROM gimenez.materia WHERE id = :idMateria;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idMateria", idMateria);
            jdbcTemplate.update(query, params);
            Response response = new Response("Matéria excluída.", HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/materia/{idMateria}")
    public ResponseEntity<Response> resgataMateriaPorId(@PathVariable Integer idMateria) {
        try {
            String query = "SELECT * FROM gimenez.materia WHERE id = :idMateria;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idMateria", idMateria);
            List<Materia> materiasResgatadas = jdbcTemplate.query(query, params, rs -> {
                List<Materia> materias = new ArrayList<Materia>();
                while (rs.next()) {
                    Materia m = new Materia();
                    m.setId(rs.getInt("id"));
                    m.setDescricao(rs.getString("descricao"));
                    materias.add(m);
                }
                return materias;
            });
            Response response = new Response(materiasResgatadas, HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }
}
