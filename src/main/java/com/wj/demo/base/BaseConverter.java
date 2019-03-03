package com.wj.demo.base;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<P, V> {

    public abstract V toDTO(P p);

    public void findDependence(Page<P> paginate) {

    }

    public PageModel<V> toPaginate(Page<P> paginate) {
        findDependence(paginate);
        PageModel<V> pageModel = new PageModel<>();
        pageModel.setPageNo(paginate.getPageable().getPageNumber()+1);
        pageModel.setSize(paginate.getPageable().getPageSize());
        pageModel.setPages(paginate.getTotalPages());
        pageModel.setTotal(paginate.getTotalElements());
        List<V> dataList = new ArrayList<>();
        for (P profitProduct : paginate.getContent()) {
            dataList.add(toDTO(profitProduct));
        }
        pageModel.setData(dataList);
        return pageModel;
    }

    public List<V> toList(List<P> list) {
        List<V> dataList = new ArrayList<>();
        for (P profitProduct : list) {
            dataList.add(toDTO(profitProduct));
        }
        return dataList;
    }
}
