package API.agenda.desafio.service;

import API.agenda.desafio.dto.AgendaRequestDTO;
import API.agenda.desafio.dto.AgendaResponseDTO;
import API.agenda.desafio.model.Agenda;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class AgendaService {

    private final Map<Long, Agenda> agendas = new ConcurrentHashMap<>();
    private Long idAtual = 1L;

    public void adicionarEvento(Agenda agenda){

        agenda.setId(idAtual++);
        agendas.put(agenda.getId(), agenda);
    }

    public AgendaResponseDTO buscarEventoPorId(Long id){
        Agenda agenda = agendas.get(id);

        if (agenda == null){
            return null;
        }

        return new AgendaResponseDTO(
                agenda.getNome(),
                agenda.getData(),
                agenda.isConcluido()
        );
    }

    public List<AgendaResponseDTO> listarTodosEventos(){

        return agendas.values().stream()
                .map(agenda -> new AgendaResponseDTO(
                        agenda.getNome(),
                        agenda.getData(),
                        agenda.isConcluido()
                )).collect(Collectors.toList());
    }

    public Agenda alterar(Long id, AgendaRequestDTO request){

        Agenda agenda = agendas.get(id);
        if (agenda == null){
            return null;
        }

        agenda.setNome(request.getNome());
        agenda.setData(request.getData());
        agenda.setConcluido(request.isConcluido());

        return agenda;
    }

    public boolean remover(Long id){

        return agendas.remove(id) != null;
    }


}
