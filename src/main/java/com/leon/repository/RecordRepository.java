package com.leon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leon.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Long>, RecordRepositoryCustom {

    Record findById(long id);

    void deleteById(Long id);
}