package com.leon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.leon.entity.Record;
import com.leon.entity.RecordForQuery;

public class RecordRepositoryCustomImpl implements RecordRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Page<Record> findByCondition(RecordForQuery qryVO, PageRequest pageable) {
		
		String sql = "select * from record where 1=1 ";
		
		if (qryVO.getYear() > 0) {
			sql += " and year = " + qryVO.getYear();
		}
		
		Query query = entityManager
				.createNativeQuery(sql, Record.class)
				.setFirstResult(pageable.getPageSize()*pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize());
		List<Record>  resultList = query.getResultList();
		
		Query countQuery = entityManager
				.createNativeQuery(sql, Record.class);
		
		@SuppressWarnings("unchecked")
//		List<Record> recordVOList = query
//				.setFirstResult((pageable.getPageNumber()-1) * pageable.getPageSize()) 
//				.setMaxResults(pageable.getPageSize())
//				.getResultList();
		
		Page<Record> pageRecord = new PageImpl<Record>(resultList, pageable, countQuery.getResultList().size());
		
        return pageRecord;
	}

}
