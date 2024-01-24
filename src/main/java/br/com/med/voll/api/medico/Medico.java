package br.com.med.voll.api.medico;


import br.com.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.ObjectUtils;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Medico(CadastroMedicoDTO medicoModel) {
        this.crm = medicoModel.crm();
        this.especialidade = medicoModel.especialidade();
        this.email = medicoModel.email();
        this.telefone = medicoModel.telefone();
        this.endereco = new Endereco(medicoModel.enderecoDTO());
        this.nome = medicoModel.nome();
        this.ativo = true;
    }

    public void atualizaDados (AtualizaMedicoDTO dados){
        if(!ObjectUtils.isEmpty(dados.nome())){
            this.nome = dados.nome();
        }
        if(!ObjectUtils.isEmpty(dados.telefone())){
            this.telefone = dados.telefone();
        }
        if(!ObjectUtils.isEmpty(dados.enderecoDTO())){
            this.endereco.atualizarDados(dados.enderecoDTO());
        }

    }

    public void delete() {
        this.ativo=false;
    }
}
