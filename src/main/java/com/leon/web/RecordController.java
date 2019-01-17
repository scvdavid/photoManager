package com.leon.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.leon.entity.Record;
import com.leon.entity.RecordForQuery;
import com.leon.service.RecordService;

@Controller
public class RecordController {

	@Resource
	RecordService recordService;

	@RequestMapping("/")
	public String index() {
		return "redirect:/list";
	}
	
	@RequestMapping("/login")
	public String toLoginPage() {
		return "login";
	}

	// no page
//    @RequestMapping("/list")
//    public String list(Model model) {
//        List<User> users=userService.getUserList();
//        model.addAttribute("users", users);
//        return "user/list";
//    }

	// 分頁參考來源
	// ref: https://www.baeldung.com/spring-thymeleaf-pagination
	// ref: https://www.tianmaying.com/tutorial/spring-jpa-page-sort
	@RequestMapping("/list")
	public String listRecords(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size, @ModelAttribute("qryVO") RecordForQuery qryVO) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Record> recordPage = recordService.findByConditon(qryVO, PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("recordPage", recordPage);

		int totalPages = recordPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "record/list";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "record/recordAdd";
	}

	@RequestMapping("/add")
	public String add(Record record, @RequestParam("file1") MultipartFile file1) throws IOException {
		record.setPhoto1(file1.getBytes());
		recordService.save(record);
		return "redirect:/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Long id) {
		Record record = recordService.findRecordById(id);
		model.addAttribute("record", record);
		return "record/recordEdit";
	}

	@RequestMapping("/edit")
	public String edit(Record record) {
		recordService.edit(record);
		return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		recordService.delete(id);
		return "redirect:/list";
	}

	
	@ModelAttribute(value = "qryVO")
	public RecordForQuery newEntity()
	{
	    return new RecordForQuery();
	}

}
