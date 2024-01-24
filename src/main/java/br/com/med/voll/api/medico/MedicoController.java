package br.com.med.voll.api.medico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/cadastro")
    @Transactional
    public CadastroMedicoDTO cadastra(@Valid @RequestBody CadastroMedicoDTO cadastroMedicoDTO) {
        medicoRepository.save(new Medico(cadastroMedicoDTO));

        return cadastroMedicoDTO;

    }

    @GetMapping("listagem")
    public Page<ListagemMedicoDTO> lista(@PageableDefault(sort = {"id"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
    }

    @PutMapping("/update")
    @Transactional
    public String atualiza(@Valid @RequestBody AtualizaMedicoDTO dados) {

        var medico = medicoRepository.getReferenceById(dados.id());
        try {
            medico.atualizaDados(dados);
            return "Dados atualizados com sucesso!";
        } catch (Exception e) {
            return "Médico não encontrado";
        }
    }
        @DeleteMapping("/delete/{id}")
        @Transactional
        public void delete(@PathVariable Long id){
            var medico = medicoRepository.getReferenceById(id);
            medico.delete();



        }
    }

