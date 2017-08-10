package org.apink.util;

public class PagingHandler {

    private int page;
    private int pagePerNum;
    private int offset;

    public PagingHandler() {
        this.page = 1;
        this.pagePerNum = 10;
        this.offset = (page-1) * this.pagePerNum;
    }

    public PagingHandler(int page) {
        this.page = page;
        this.pagePerNum = 10;
        this.offset = (page-1) * this.pagePerNum;
    }

    public PagingHandler(int page, int pagePerNum) {
        this.page = page;
        this.pagePerNum = pagePerNum;
        this.offset = (this.page-1) * this.pagePerNum;
    }


    @Override
    public String toString() {
        return "PagingHandler{" +
                "page=" + page +
                ", pagePerNum=" + pagePerNum +
                ", offset=" + offset +
                '}';
    }


    public void setPage(int page) {
        this.page = page;
        this.offset = (page-1) * this.pagePerNum;
    }

    public int getPage() {
        return page;
    }


    public int getPagePerNum() {
        return pagePerNum;
    }

    public void setPagePerNum(int pagePerNum) {
        this.pagePerNum = pagePerNum;
        this.offset = (page-1) * this.pagePerNum;
    }

    public int getOffset(){
        return this.offset;
    }
}
