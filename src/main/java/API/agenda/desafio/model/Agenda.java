package API.agenda.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    private Long id;
    private String nome;
    private LocalDate data;
    private boolean concluido;
}
