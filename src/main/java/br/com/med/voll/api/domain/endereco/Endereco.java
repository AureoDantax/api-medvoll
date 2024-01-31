package br.com.med.voll.api.domain.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();

    }

    public void atualizarDados(EnderecoDTO dadosEndereco) {
        if (!ObjectUtils.isEmpty(dadosEndereco.logradouro())) {
            this.logradouro = dadosEndereco.logradouro();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.bairro())) {
            this.bairro = dadosEndereco.bairro();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.cep())) {
            this.cep = dadosEndereco.cep();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.cidade())) {

            this.cidade = dadosEndereco.cidade();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.uf())) {

            this.uf = dadosEndereco.uf();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.numero())) {

            this.numero = dadosEndereco.numero();
        }
        if (!ObjectUtils.isEmpty(dadosEndereco.complemento())) {

            this.complemento = dadosEndereco.complemento();
        }
    }
}
