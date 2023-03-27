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
import com.api.sistemafalta.modelos.professor.NovoProfessorDTO;
import com.api.sistemafalta.modelos.professor.Professor;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping(value = "/professor")
    public ResponseEntity<Response> novo(@RequestBody NovoProfessorDTO professor) {
        try {
            String query = "INSERT INTO professor (nome, id_materia) VALUES (:nome, :idMateria);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("nome", professor.getNome());
            params.addValue("idMateria", professor.getIdMateria());
            jdbcTemplate.update(query, params);
            Response response = new Response("Professor cadastrado com sucesso!", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/professor")
    public ResponseEntity<Response> listar() {
        try {
            String query = "SELECT p.*, m.descricao as materia_descricao FROM professor p INNER JOIN materia m on (m.id = p.id_materia);";
            List<Professor> professoresListados = jdbcTemplate.query(query, rs -> {
                List<Professor> professores = new ArrayList<Professor>();
                while (rs.next()) {
                    Professor p = new Professor();
                    Materia m = new Materia();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    m.setId(rs.getInt("id_materia"));
                    m.setDescricao(rs.getString("materia_descricao"));
                    p.setMateria(m);
                    professores.add(p);
                }
                return professores;
            });
            Response response = new Response(professoresListados, HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @DeleteMapping("/professor/{idProfessor}")
    public ResponseEntity<Response> deletar(@PathVariable Integer idProfessor) {
        try {
            String query = "DELETE FROM professor WHERE id = :idProfessor;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idProfessor", idProfessor);
            jdbcTemplate.update(query, params);
            Response response = new Response("Professor excluído.", HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }
}
