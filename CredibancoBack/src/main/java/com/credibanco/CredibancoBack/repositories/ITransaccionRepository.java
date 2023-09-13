package com.credibanco.CredibancoBack.repositories;

import com.credibanco.CredibancoBack.models.TransaccionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<TransaccionModel, Long> {
}
