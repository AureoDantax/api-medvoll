package br.com.med.voll.api.domain.medico;

import br.com.med.voll.api.domain.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroMedicoDTO(
        @NotBlank(message = "Nome não pode ser vazio")
        String nome,
        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Crm não pode ser vazio")
        @Pattern(regexp = "\\d{4,6}", message = "O crm deve ter entre 4 e 6 dígitos")
        String crm,
        @NotBlank(message = "Telefone não pode ser vazio")
        String telefone,

        Especialidade especialidade,
        @NotNull
        @Valid
        EnderecoDTO enderecoDTO) {
}
