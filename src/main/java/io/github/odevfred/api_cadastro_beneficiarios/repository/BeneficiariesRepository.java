package io.github.odevfred.api_cadastro_beneficiarios.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.odevfred.api_cadastro_beneficiarios.model.Beneficiaries;

@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiaries, UUID> {
    
}