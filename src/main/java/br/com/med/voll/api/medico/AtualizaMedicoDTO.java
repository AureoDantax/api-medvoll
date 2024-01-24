package br.com.med.voll.api.medico;

import br.com.med.voll.api.endereco.EnderecoDTO;
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
