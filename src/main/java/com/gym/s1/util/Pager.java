package com.gym.s1.util;

public class Pager {
	//시작번호
	private Long startNum;
	//끝번호
	private Long lastNum;
	//page
	private Long page;
	//page당 보여줄 갯수
	private Long perPage;
	//block에서 시작page 번호
	private Long startPageNum;
	//block에서 끝page번호
	private Long lastPageNum;
	//이전이 존재하는가
	private boolean pre;
	//이후가 존재하는가
	private boolean next;
	//검색어
	private String search;
	//검색종류
	private String kind;
	
	//시작번호 끝번호 구하기
	public void makeNum() {
		this.startNum= 1+(this.getPerPage()*(this.getPage()-1));
		this.lastNum=this.getPerPage()*this.getPage();
	}
	//페이지구하기
	public void makePageNum(Long totalNum) {
		//총 페이지 갯수 구하기
		Long totalPage = totalNum/this.getPerPage();
		if(totalNum%this.getPerPage()>0) {
			totalPage++;
		}
		//block 갯수 구하기 (하단바에 페이지갯수=block)
		Long perBlock = 10L;
		//전체 block갯수 구하기
		Long totalBlock = totalPage/perBlock;
		if (totalPage%perBlock>0) {
			totalBlock++;
		}
		//현재 페이지로 현재 블락구하기
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock>0) {
			curBlock++;
		}
		//block에서 시작페이지번호 끝페이지번호 구하기
		this.startPageNum= perBlock*(curBlock-1)+1;
		this.lastPageNum= perBlock*curBlock;
		//이전블락 이후블락 유무
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		this.next=false;
		if(curBlock<totalBlock) {
			this.next=true;
		}
		//현재블럭이 마지막블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastPageNum=totalPage;
		}
		
	}
	
	
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		if(this.perPage==null||this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(Long startPageNum) {
		this.startPageNum = startPageNum;
	}
	public Long getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(Long lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public String getSearch() {
		if(this.search==null) {
			search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
}
