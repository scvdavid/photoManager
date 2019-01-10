package com.leon.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leon.entity.Record;

public interface RecordService {

    public List<Record> getRecordList();

    public Record findRecordById(long id);

    public void save(Record record);

    public void edit(Record record);

    public void delete(long id);

    public Page<Record> findPaginated(Pageable pageable);

}
