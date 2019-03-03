package com.wj.demo.controller;

import com.wj.demo.api.BrandService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.base.UserInfo;
import com.wj.demo.converter.BrandPagingConverter;
import com.wj.demo.dto.req.BrandAddReq;
import com.wj.demo.dto.req.BrandPagingReq;
import com.wj.demo.entity.Brand;
import com.wj.demo.repository.BrandRepository;
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
public class BrandController extends BaseController implements BrandService {


    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private OrderImageRepository orderImageRepository;

    @Override
    public Response paging(BrandPagingReq dto) {
        Specification<Brand> spec = (Specification<Brand>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getName() != null && !"".equals(dto.getName())) {
                predicates.add(builder.like(root.get("chName"), "%" + dto.getName() + "%"));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, dto.getSize(), Sort.Direction.DESC, "id");
        Page<Brand> pageModel = brandRepository.findAll(spec, pageRequest);
        return new Response(new BrandPagingConverter().toPaginate(pageModel));
    }

    @Override
    public Response get(Long id) {
        Brand entity = brandRepository.findById(id).get();
        return new Response(new BrandPagingConverter().toDTO(entity));
    }

    @Override
    public Response add(@Valid BrandAddReq dto) {
        UserInfo userInfo = getUserInfo();
        Brand brand = new Brand();
        brand.setChName(dto.getName());
        brand.setRemark(dto.getRemark());
        brand.setCreator(userInfo.getUsername());
        brand.setCreateTime(System.currentTimeMillis());
        return new Response(new BrandPagingConverter().toDTO(brandRepository.save(brand)));
    }

    @Override
    public Response remove(Long id) {
        Brand entity = brandRepository.findById(id).get();
        brandRepository.delete(entity);
        return new Response();
    }
}
