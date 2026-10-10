package API.agenda.desafio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaRequestDTO {

    @NotBlank(message = "Nome do evento é obrigatório!")
    private String nome;
    @NotNull(message = "A data do evento é obrigatória!")
    private LocalDate data;
    private boolean concluido;

}
