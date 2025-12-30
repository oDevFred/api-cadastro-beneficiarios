package io.github.odevfred.api_cadastro_beneficiarios.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.odevfred.api_cadastro_beneficiarios.DTO.BeneficiariesDTO;
import io.github.odevfred.api_cadastro_beneficiarios.model.Beneficiaries;
import io.github.odevfred.api_cadastro_beneficiarios.model.Document;
import io.github.odevfred.api_cadastro_beneficiarios.repository.BeneficiariesRepository;
import io.github.odevfred.api_cadastro_beneficiarios.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BeneficiariesService {
    @Autowired
    private BeneficiariesRepository beneficiariesRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public List<Beneficiaries> findBeneficiaries() {
        return beneficiariesRepository.findAll();
    }

    // Lista Beneficiários por id
    public Beneficiaries findById(UUID id) {
        return beneficiariesRepository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException("Beneficiário com ID: " + id + " não encontrado"));
    }

    // Criar Beneficiário
    public Beneficiaries createBeneficiaries(BeneficiariesDTO dto) {
        Beneficiaries entity = new Beneficiaries();
        BeanUtils.copyProperties(dto, entity);

        if (entity.getDocuments() != null) {
            dto.getDocuments().forEach(doc -> doc.setBeneficiary(entity));
            entity.getDocuments().forEach(document -> ((Document) document).setBeneficiary(entity));
        }
        return beneficiariesRepository.save(entity);
    }

    // Atualizar Beneficiário
    public Beneficiaries updateBeneficiaries(UUID id, BeneficiariesDTO dto) {
        Beneficiaries beneficiariesExistent = findById(id);
        BeanUtils.copyProperties(dto, beneficiariesExistent);
        return beneficiariesRepository.save(beneficiariesExistent);
    }

    // Deletar Beneficiário
    public void deleteBeneficiaries(UUID id) {
        if (!beneficiariesRepository.existsById(id)) {
            throw new EntityNotFoundException("Beneficiário com ID: " + id + " não encontrado");
        }

        beneficiariesRepository.deleteById(id);
    }

    // Pegar documentos do beneficiários
    public List<Document> listDocuments(UUID id) {
    if (!beneficiariesRepository.existsById(id)) {
        throw new RuntimeException("Beneficiário não encontrado com o ID: " + id);
    }
    return documentRepository.findByBeneficiaryId(id);
}
}
