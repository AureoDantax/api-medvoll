package br.com.med.voll.api.paciente;

import br.com.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Paciente(CadastroPacienteDTO cadastroPacienteDTO) {

        this.nome = cadastroPacienteDTO.nome();
        this.email = cadastroPacienteDTO.email();
        this.cpf = cadastroPacienteDTO.cpf();
        this.telefone = cadastroPacienteDTO.telefone();
        this.endereco = new Endereco(cadastroPacienteDTO.enderecoDTO());

    }
}

