package com.mao.baseapp.common.net.dto;

import java.util.List;


public class Page<E> {

	public int pageNo;
	public int pageSize;
	public long count;
	public int last;
	public List<E> list;

	

}
