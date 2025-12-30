package io.github.odevfred.api_cadastro_beneficiarios.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import io.github.odevfred.api_cadastro_beneficiarios.DTO.BeneficiariesDTO;
import io.github.odevfred.api_cadastro_beneficiarios.model.Beneficiaries;
import io.github.odevfred.api_cadastro_beneficiarios.repository.BeneficiariesRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BeneficiariesService {
    private final BeneficiariesRepository beneficiariesRepository;

    public BeneficiariesService(BeneficiariesRepository beneficiariesRepository) {
        this.beneficiariesRepository = beneficiariesRepository;
    }


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
}
