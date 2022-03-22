package com.gym.s1.util;

public class Pager {
	
	private Long perPage;
	private Long page;
	private Long startRow;
	private Long lastRow;
	
	private Long startPage;
	private Long lastPage;
	private boolean pre;
	private boolean next;
	
	private String search;
	private String kind;
	
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();	
	}
	public void makeNum(Long totalRow) {
		
		//1. 총 row의 갯수 구하기
		//Long totalRow=107L;
		//2. 총 page의 갯수 구하기
		Long totalPage = totalRow / this.getPerPage();
		if(totalRow%this.getPerPage()!=0) {
			totalPage++;
		}
		//3. 한 Block 당 숫자의 갯수
		Long perBlock=10L;
		//4. 전체 block 갯수 구하기
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//5.  page번호로 현재 몇번째 Block인지 계산
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		//6. curBlock로 startPage, lastPage 구하기
		this.startPage=(curBlock-1)*perBlock+1;
		this.lastPage=curBlock*perBlock;
		//7. 이전, 다음 블럭 유무
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		this.next=false;
			if(curBlock<totalBlock) {
				this.next=true;
			}
		//8. 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastPage=totalPage;
		}
	}
	
	public Long getPerPage() {
		if(this.perPage== null || this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
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

	public Long getStartPage() {
		return startPage;
	}

	public void setStartPage(Long startPage) {
		this.startPage = startPage;
	}

	public Long getLastPage() {
		return lastPage;
	}

	public void setLastPage(Long lastPage) {
		this.lastPage = lastPage;
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
			this.search="";
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