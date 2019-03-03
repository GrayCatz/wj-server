package com.wj.demo.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BasePageDTO implements Serializable {
    private Integer page = 1;
    private Integer size = 10;

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public Integer getSize() {
        return size == null ? 10 : size;
    }
}
