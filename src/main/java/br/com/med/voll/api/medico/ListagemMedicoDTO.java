package br.com.med.voll.api.medico;

public record ListagemMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public ListagemMedicoDTO(Medico medico) {
        this( medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
