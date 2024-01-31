package br.com.med.voll.api.domain.medico;

import br.com.med.voll.api.domain.endereco.Endereco;

public record DetalhaMedicoDTO(String nome,
                               String email,
                               String crm,
                               String telefone,
                               Especialidade especialidade,
                               Endereco endereco) {
    public DetalhaMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(),
                medico.getEndereco());
    }
}
