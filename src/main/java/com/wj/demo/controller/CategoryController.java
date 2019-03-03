package com.wj.demo.controller;

import com.wj.demo.api.CategoryService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.base.UserInfo;
import com.wj.demo.converter.CategoryPagingConverter;
import com.wj.demo.dto.req.CategoryAddReq;
import com.wj.demo.dto.req.CategoryPagingReq;
import com.wj.demo.entity.Category;
import com.wj.demo.repository.CategoryRepository;
import com.wj.demo.repository.FileRepository;
import com.wj.demo.repository.OrderImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController extends BaseController implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private OrderImageRepository orderImageRepository;

    @Override
    public Response paging(CategoryPagingReq dto) {

        Specification<Category> spec = (Specification<Category>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getName() != null && !"".equals(dto.getName())) {
                predicates.add(builder.like(root.get("name"), "%" + dto.getName() + "%"));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, dto.getSize(), Sort.Direction.DESC, "id");
        Page<Category> pageModel = categoryRepository.findAll(spec, pageRequest);
        return new Response(new CategoryPagingConverter().toPaginate(pageModel));
    }

    @Override
    public Response get(Long id) {
        Category entity = categoryRepository.findById(id).get();
        return new Response(new CategoryPagingConverter().toDTO(entity));
    }

    @Override
    public Response add(@Valid CategoryAddReq dto) {
        UserInfo userInfo = getUserInfo();
        Category category = new Category();
        category.setName(dto.getName());
        category.setRemark(dto.getRemark());
        category.setCreator(userInfo.getUsername());
        category.setCreateTime(System.currentTimeMillis());
        return new Response(new CategoryPagingConverter().toDTO(categoryRepository.save(category)));
    }

    @Override
    public Response remove(Long id) {
        Category entity = categoryRepository.findById(id).get();
        categoryRepository.delete(entity);
        return new Response();
    }
}
