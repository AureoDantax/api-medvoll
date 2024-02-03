package br.com.med.voll.api.controller;

import br.com.med.voll.api.domain.paciente.CadastroPacienteDTO;
import br.com.med.voll.api.domain.paciente.Paciente;
import br.com.med.voll.api.domain.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping(value = "pacientes/cadastro")
    @Transactional
    public CadastroPacienteDTO cadastraPaciente(@Valid @RequestBody CadastroPacienteDTO cadastroPacienteDTO) {
        pacienteRepository.save(new Paciente(cadastroPacienteDTO));
        return cadastroPacienteDTO;
    }
}
