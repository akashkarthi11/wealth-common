package com.wealth.common.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PaginationDto   implements Serializable {
	

	private static final long serialVersionUID = 6346857244561999163L;
	
	private int id;
	private String searchText;
	private int pageNo;
	private int pageSize;
	private String sortBy;
	private String status;
	private FilterDto filterBy;
	private List<FilterDto> filterByList;
	private List<SearchFilterDto> filterBy2List;
	private String type;
	private List<String> textList;
	private List<Integer> numberList;
	private int qId;
	private int menuId;
    private int permissionId;
    
}