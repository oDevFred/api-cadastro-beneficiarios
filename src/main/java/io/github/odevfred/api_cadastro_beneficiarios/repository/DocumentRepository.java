package io.github.odevfred.api_cadastro_beneficiarios.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.odevfred.api_cadastro_beneficiarios.model.Document;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
    List<Document> findByBeneficiaryId(UUID beneficiaryId);
}
