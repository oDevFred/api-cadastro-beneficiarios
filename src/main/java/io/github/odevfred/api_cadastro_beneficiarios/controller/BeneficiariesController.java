package io.github.odevfred.api_cadastro_beneficiarios.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.odevfred.api_cadastro_beneficiarios.DTO.BeneficiariesDTO;
import io.github.odevfred.api_cadastro_beneficiarios.model.Beneficiaries;
import io.github.odevfred.api_cadastro_beneficiarios.model.Document;
import io.github.odevfred.api_cadastro_beneficiarios.service.BeneficiariesService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiariesController {
    private final BeneficiariesService beneficiariesService;

    public BeneficiariesController(BeneficiariesService beneficiariesService) {
        this.beneficiariesService = beneficiariesService;
    }

    // Listar beneficiários
    @GetMapping
    public List<Beneficiaries> listBeneficiaries() {
        return beneficiariesService.findBeneficiaries();
    }

    // Buscar beneficiários por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findBeneficiaries(@PathVariable UUID id) {
        Beneficiaries beneficiaries = beneficiariesService.findById(id);
        return ResponseEntity.ok(beneficiaries);
    }

    // Buscar documentos
    @GetMapping("/{id}/documents")
    public ResponseEntity<List<Document>> listDocuments(@PathVariable UUID id) {
        List<Document> documents = beneficiariesService.listDocuments(id);
        return ResponseEntity.ok(documents);
    }
    

    // Criar beneficiário
    @PostMapping
    public Beneficiaries createBeneficiaries(@Valid @RequestBody BeneficiariesDTO dto) {
        return beneficiariesService.createBeneficiaries(dto);
    }

    // Atualizar beneficiário
    @PutMapping("/{id}")
    public Beneficiaries updateBeneficiaries(@PathVariable UUID id, @Valid @RequestBody BeneficiariesDTO dto) {
        return beneficiariesService.updateBeneficiaries(id, dto);
    }

    // Deletar beneficiário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiaries(@PathVariable UUID id) {
        beneficiariesService.deleteBeneficiaries(id);
        return ResponseEntity.noContent().build();
    }
    
}
