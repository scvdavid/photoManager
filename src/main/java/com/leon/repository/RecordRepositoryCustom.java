package com.leon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leon.entity.Record;
import com.leon.entity.RecordForQuery;

public interface RecordRepositoryCustom {

	List<Record> findByCondition(RecordForQuery qryVO);
}