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

import com.api.sistemafalta.modelos.aluno.Aluno;
import com.api.sistemafalta.modelos.aluno.NovoAlunoDTO;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping(value = "/aluno")
    public ResponseEntity<Response> novo(@RequestBody NovoAlunoDTO aluno) {
        try {
            String query = "INSERT INTO aluno (nome, turma, email_responsavel) VALUES (:nome, :turma, :emailResponsavel);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("nome", aluno.getNome());
            params.addValue("turma", aluno.getTurma());
            params.addValue("emailResponsavel", aluno.getEmailResponsavel());
            jdbcTemplate.update(query, params);
            Response response = new Response("Aluno cadastrado com sucesso!", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping(value = "/aluno")
    public ResponseEntity<Response> lista() {
        try {
            String query = "SELECT * FROM aluno;";
            List<Aluno> alunos = jdbcTemplate.query(query, rs -> {
                List<Aluno> alunosTemp = new ArrayList<Aluno>();
                while (rs.next()) {
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setEmailResponsavel(rs.getString("email_responsavel"));
                    a.setTurma(rs.getString("turma"));
                    alunosTemp.add(a);
                }
                return alunosTemp;
            });
            Response response = new Response(alunos, HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @DeleteMapping("/aluno/{idAluno}")
    public ResponseEntity<Response> deletar(@PathVariable Integer idAluno) {
        try {
            String query = "DELETE FROM aluno WHERE id = :idAluno;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idAluno", idAluno);
            jdbcTemplate.update(query, params);
            Response response = new Response("Aluno excluído.", HttpStatus.OK.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }
}
