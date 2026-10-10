package API.agenda.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaResponseDTO {

    private String nome;
    private LocalDate data;
    private boolean concluido;
}
