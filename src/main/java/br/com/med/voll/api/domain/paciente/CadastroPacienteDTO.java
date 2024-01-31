package br.com.med.voll.api.domain.paciente;

import br.com.med.voll.api.domain.endereco.EnderecoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroPacienteDTO(
        @NotBlank(message = "Nome não pode ser vazio")
        String nome,
        @NotBlank(message = "CPF não pode ser vazio")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "CPF inválido")
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank(message = "Telefone não poder ser vazio")
        String telefone,
        EnderecoDTO enderecoDTO) {
}
