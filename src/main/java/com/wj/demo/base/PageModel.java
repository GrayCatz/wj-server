package com.wj.demo.base;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wtang
 * @date 15-4-23
 */
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = 567569244790636789L;

    public static final int DEFAULT_SIZE = 10;

    public PageModel() {
        this.size = DEFAULT_SIZE;
    }

    private int pageNo;
    private int pages = -1;
    private int size;
    private long total = -1;
    private List<T> data;
    private Map<String, Object> params;
    //private Query<T> query;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
//        return this;
    }

    public int getPages() {
        if (pages == -1) {
            setPageCount();
        }
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
//        return this;
    }

    private void setPageCount() {
        //total = DaoFactory.getDao().count(query.getEntityClass(), query.getCri());
        //pages = (int)(total % size == 0 ? total / size : total / size + 1);
    }

    public long getTotal() {
        if (total == -1) {
            setPageCount();
        }
        return total;
    }

    public void setTotal(long total) {
        this.total = total;

    }

    public List<T> getData() {
        if (data == null) {
            data = new ArrayList();
        }
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
//        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
//        return this;
    }

    public PageModel<T> addParam(String name, Object param) {
        if (params == null) {
            params = new LinkedHashMap<String, Object>();
        }
        params.put(name, param);
        return this;
    }

    public String getParamJson() {
        return null;
    }

    public String getQueryString() {
        if (params == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append('&');
            }

            try {
                stringBuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return stringBuilder.toString();
    }
}
