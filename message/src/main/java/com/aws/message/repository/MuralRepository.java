package com.aws.message.repository;

import com.aws.message.model.Mural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuralRepository extends JpaRepository<Mural, Integer> {
}
