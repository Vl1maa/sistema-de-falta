package com.api.sistemafalta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.sistemafalta.modelos.aluno.Aluno;
import com.api.sistemafalta.modelos.falta.Falta;
import com.api.sistemafalta.modelos.falta.NovaFaltaDTO;
import com.api.sistemafalta.modelos.materia.Materia;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FaltaController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/falta/registra-falta")
    public ResponseEntity<Response> registraFalta(@RequestBody NovaFaltaDTO falta) {
        try {
            String query = "INSERT INTO falta (id_aluno, id_materia, data) VALUES (:idAluno, :idMateria, :data);";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("data", new Date());
            params.addValue("idAluno", falta.getIdAluno());
            params.addValue("idMateria", falta.getIdMateria());
            jdbcTemplate.update(query, params);
            Response response = new Response("Falta registrada com sucesso", HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/falta/{idAluno}")
    public ResponseEntity<Response> resgataFaltasPorIdAluno(@PathVariable Integer idAluno) {
        try {
            String query = "SELECT f.id as id_falta, f.data as data_falta, a.id as id_aluno, a.nome as nome_aluno, m.id as id_materia, m.descricao as descricao_materia FROM falta f INNER JOIN aluno a on (a.id = f.id_aluno) INNER JOIN materia m on (m.id = f.id_materia) WHERE a.id = :idAluno;";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("idAluno", idAluno);
            List<Falta> listaFaltas = jdbcTemplate.query(query, params, rs -> {
                List<Falta> faltasResgatadas = new ArrayList<Falta>();
                while (rs.next()) {
                    Falta f = new Falta();
                    Aluno a = new Aluno();
                    Materia m = new Materia();
                    f.setId(rs.getInt("id_falta"));
                    f.setData(rs.getDate("data_falta"));
                    a.setId(rs.getInt("id_aluno"));
                    a.setNome(rs.getString("nome_aluno"));
                    m.setId(rs.getInt("id_materia"));
                    m.setDescricao(rs.getString("descricao_materia"));
                    f.setAluno(a);
                    f.setMateria(m);
                    faltasResgatadas.add(f);
                }
                return faltasResgatadas;
            });
            Response response = new Response(listaFaltas, HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }

    @GetMapping("/falta/")
    public ResponseEntity<Response> resgataFaltas() {
        try {
            String query = "SELECT f.id as id_falta, f.data as data_falta, a.id as id_aluno, a.nome as nome_aluno, m.id as id_materia, m.descricao as descricao_materia FROM falta f INNER JOIN aluno a on (a.id = f.id_aluno) INNER JOIN materia m on (m.id = f.id_materia); ";
            List<Falta> listaFaltas = jdbcTemplate.query(query, rs -> {
                List<Falta> faltasResgatadas = new ArrayList<Falta>();
                while (rs.next()) {
                    Falta f = new Falta();
                    Aluno a = new Aluno();
                    Materia m = new Materia();
                    f.setId(rs.getInt("id_falta"));
                    f.setData(rs.getDate("data_falta"));
                    a.setId(rs.getInt("id_aluno"));
                    a.setNome(rs.getString("nome_aluno"));
                    m.setId(rs.getInt("id_materia"));
                    m.setDescricao(rs.getString("descricao_materia"));
                    f.setAluno(a);
                    f.setMateria(m);
                    faltasResgatadas.add(f);
                }
                return faltasResgatadas;
            });
            Response response = new Response(listaFaltas, HttpStatus.CREATED.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        } catch (Exception e) {
            Response response = new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }
    }
}
