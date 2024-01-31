package br.com.med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
        @NotBlank(message = "Logradouto não pode ser vazio")
        String logradouro,
        @NotBlank(message = "Bairro não pode ser vazio")
        String bairro,
        @NotBlank(message = "CEP não pode ser vazio")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 digitos")
        String cep,
        @NotBlank(message = "Cidade não pode ser vazio")
        String cidade,
        @NotBlank(message = "UF não pode ser vazio")
        String uf,
        @NotBlank(message = "Número não pode ser vazio, se não possuir, escreva SEM NÚMERO")
        String numero,

        String complemento
) {
}
