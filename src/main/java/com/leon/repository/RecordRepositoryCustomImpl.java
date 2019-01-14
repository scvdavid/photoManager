package com.leon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.leon.entity.Record;
import com.leon.entity.RecordForQuery;

public class RecordRepositoryCustomImpl implements RecordRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<Record> findByCondition(RecordForQuery qryVO) {
		List<Record> recordVOList = entityManager
				.createNativeQuery("select * from record", Record.class)
				.getResultList();
		
		
        return recordVOList;
	}

}
