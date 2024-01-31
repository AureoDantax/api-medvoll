package br.com.med.voll.api.domain.medico;

import br.com.med.voll.api.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid
        EnderecoDTO enderecoDTO) {
}
