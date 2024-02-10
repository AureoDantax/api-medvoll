package br.com.med.voll.api.controller;

import br.com.med.voll.api.domain.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("api/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<DetalhaMedicoDTO> cadastra(@Valid @RequestBody CadastroMedicoDTO cadastroMedicoDTO, UriComponentsBuilder uricb) {
        var medico = new Medico(cadastroMedicoDTO);
        medicoRepository.save(medico);
        var uri = uricb.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhaMedicoDTO(medico));

    }

    @GetMapping("listagem")
    public ResponseEntity<Page<ListagemMedicoDTO>> lista(@PageableDefault(sort = {"id"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<DetalhaMedicoDTO> atualiza(@Valid @RequestBody AtualizaMedicoDTO dados) {

        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
        return ResponseEntity.ok(new DetalhaMedicoDTO(medico));

    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.delete();
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/detalha/{id}")
    public ResponseEntity<DetalhaMedicoDTO> detalha(@PathVariable Long id) {

        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhaMedicoDTO(medico));

    }
}

