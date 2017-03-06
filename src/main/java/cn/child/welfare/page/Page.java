package cn.child.welfare.page;

import java.io.Serializable;

/**
 * 分页对象
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 7988644768190662583L;
	protected int pageSize = 2;
	protected int currentPage = 1;
	protected int totalPages = 0;
	protected int totalRows = 0;
	protected boolean pagination = false;

	public Page() {
		super();
	}

	public Page(int rows, int pageSize) {
		this.init(rows, pageSize);
	}

	public void init(int rows, int pageSize) {
		this.pageSize = pageSize;
		this.totalRows = rows;
		if ((totalRows % pageSize) == 0) {
			totalPages = totalRows / pageSize;
		} else {
			totalPages = totalRows / pageSize + 1;
		}

	}

	public void init(int rows, int pageSize, int currentPage) {
		this.pageSize = pageSize;
		this.totalRows = rows;
		if ((totalRows % pageSize) == 0) {
			totalPages = totalRows / pageSize;
		} else {
			totalPages = totalRows / pageSize + 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalPages(int i) {
		totalPages = i;
	}

	public void setCurrentPage(int i) {
		currentPage = i;
	}

	public void setPageSize(int i) {
		pageSize = i;
	}

	public void setTotalRows(int i) {
		totalRows = i;
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
}
