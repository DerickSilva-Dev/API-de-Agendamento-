package API.agenda.desafio.controller;


import API.agenda.desafio.dto.AgendaRequestDTO;
import API.agenda.desafio.dto.AgendaResponseDTO;
import jakarta.validation.Valid;
import API.agenda.desafio.model.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import API.agenda.desafio.service.AgendaService;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody AgendaRequestDTO request) {

        Agenda agenda = new Agenda();
        agenda.setNome(request.getNome());
        agenda.setData(request.getData());

        agendaService.adicionarEvento(agenda);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
        public ResponseEntity<List<AgendaResponseDTO>> listar() {

        List<AgendaResponseDTO> agenda = agendaService.listarTodosEventos();

        return ResponseEntity.ok().body(agenda);

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<AgendaResponseDTO> listarPorId(@PathVariable Long id){

        AgendaResponseDTO response = agendaService.buscarEventoPorId(id);
        if (response != null){
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Void>  alterar(@PathVariable Long id, @Valid @RequestBody AgendaRequestDTO request) {

        Agenda agenda = agendaService.alterar(id, request);
        if (agenda != null){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        boolean foiExcluido = agendaService.remover(id);

        if (foiExcluido){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
