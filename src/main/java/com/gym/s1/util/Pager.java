package com.gym.s1.util;

public class Pager {
	
	private Long perpage;
	
	private Long page;
	
	private Long startRow;
	private Long lastRow;
	
	
	private String search;
	private String kind;
	
	
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	
	
	public void makeRow() {
		this.startRow=(this.getPage()-1)*this.getPerpage()+1;
		this.lastRow=this.getPage()*this.getPerpage();
	}
	
	public void makeNum(Long totalCount) {
		totalCount = 203L;
		
		Long totalPage =totalCount/this.getPerpage();
		if(totalCount%this.getPerpage()!=0) {
			totalPage++;
		}
		
		Long perBlock =10L;
		
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		
		
		this.startNum= (curBlock-1)*perBlock+1;
		this.lastNum= curBlock*perBlock;
		
		
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock>curBlock) {
			this.next=true;
		}
		
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
	
	}

	public Long getPerpage() {
		if(this.perpage==null || this.perpage<1) {
			this.perpage=10L;
		}
		
		return perpage;
	}
	public void setPerpage(Long perpage) {
		this.perpage = perpage;
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
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
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

	public String getSearch() {
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
	
	

}
