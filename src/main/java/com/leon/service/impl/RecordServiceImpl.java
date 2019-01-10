package com.leon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leon.entity.Record;
import com.leon.repository.RecordRepository;
import com.leon.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> getRecordList() {
        return recordRepository.findAll();
    }

    @Override
    public Record findRecordById(long id) {
        return recordRepository.findById(id);
    }

    @Override
    public void save(Record record) {
        recordRepository.save(record);
    }

    @Override
    public void edit(Record record) {
        recordRepository.save(record);
    }

    @Override
    public void delete(long id) {
        recordRepository.deleteById(id);
    }
    
    public Page<Record> findPaginated(Pageable pageable) {
//    	List<User> users = userRepository.findAll();
//    	
//    	
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage * pageSize;
//        List<User> list;
// 
//        if (users.size() < startItem) {
//            list = Collections.emptyList();
//        } else {
//            int toIndex = Math.min(startItem + pageSize, users.size());
//            list = users.subList(startItem, toIndex);
//        }
// 
//        Page<User> userPage
//          = new PageImpl<User>(list, PageRequest.of(currentPage, pageSize), users.size());
// 
//        return userPage;
        return recordRepository.findAll(pageable);
    }
}


