package com.leon.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.leon.entity.Record;
import com.leon.entity.RecordForQuery;

public interface RecordRepositoryCustom {

	Page<Record> findByCondition(RecordForQuery qryVO, PageRequest pageable);
}