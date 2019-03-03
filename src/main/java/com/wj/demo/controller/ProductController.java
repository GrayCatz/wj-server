package com.wj.demo.controller;

import com.wj.demo.api.ProductService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.base.UserInfo;
import com.wj.demo.converter.ProductDetailConverter;
import com.wj.demo.converter.ProductPagingConverter;
import com.wj.demo.dto.req.ProductAddReq;
import com.wj.demo.dto.req.ProductPagingReq;
import com.wj.demo.entity.Brand;
import com.wj.demo.entity.Category;
import com.wj.demo.entity.Product;
import com.wj.demo.entity.ProductImage;
import com.wj.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController extends BaseController implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private OrderImageRepository orderImageRepository;

    @Override
    public Response paging(ProductPagingReq dto) {
        Specification<Product> spec = (Specification<Product>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, dto.getSize(), Sort.Direction.DESC, "id");
        Page<Product> pageModel = productRepository.findAll(spec, pageRequest);
        return new Response(new ProductPagingConverter().toPaginate(pageModel));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response get(Long id) throws Exception {
        Product entity = productRepository.findById(id).get();
        if (entity == null) throw new Exception("未找到该产品");
        List<ProductImage> images = entity.getImages();
        entity.getImages();
        return new Response(new ProductDetailConverter().toDTO(entity));
    }

    @Override
    public Response remove(Long id) throws Exception {
        Product entity = productRepository.findById(id).get();
        if (entity == null) throw new Exception("未找到该产品");
        productRepository.delete(entity);
        return new Response();
    }

    @Override
    public Response add(ProductAddReq req) {
        return null;
    }

    @Override
    public Response save(ProductAddReq req) throws Exception {
        UserInfo userInfo = getUserInfo();
//        ProductAddReq productAddReq = JSON.parseObject(data, ProductAddReq.class);
        Product product;
        if (req.getId() != null && req.getId() != 0) {
            product = productRepository.findById(req.getId()).get();
        } else {//新增
            product = new Product();
            if (productRepository.findByChName(req.getName()) != null) {
                throw new Exception("该名称已存在");
            }
        }
        product.setImg(req.getImg());
        product.setChName(req.getName());
        product.setCreator(userInfo.getUsername());
        product.setCreateTime(System.currentTimeMillis());
        Brand brand = brandRepository.findByChName(req.getBrand());
        if (brand == null) throw new Exception("未找到该品牌");
        product.setBrand(brand);
        Category category = categoryRepository.findByName(req.getCategory());
        if (category == null) throw new Exception("未找到该类别");
        product.setCategory(category);
        product.setStatus(req.getStatus() == ProductAddReq.Status.ENABLE ? Product.Status.ENABLE : Product.Status.DISABLE);
        productRepository.save(product);
        if (req.getRequired() != null) {
            List<ProductAddReq.ProductImageType> required = req.getRequired();
            if (req.getRequired() != null) {
                required.addAll(req.getOptional());
            }
            for (ProductAddReq.ProductImageType item : required) {
                Long id = item.getId();
                ProductImage productImage;
                if (item.getId() != null && item.getId() != 0) {
                    productImage = productImageRepository.findById(id).get();
                } else {
                    productImage = new ProductImage();
                }
                productImage.setName(item.getName());
                productImage.setExample(item.getExample().getUrl());
                productImage.setRealExample(item.getRealExample().getUrl());
                productImage.setProductId(product.getId());
                productImage.setType(item.getType() == ProductAddReq.ProductImageType.Type.REQUIRED ? ProductImage.Type.REQUIRED : ProductImage.Type.OPTIONAL);
                productImageRepository.save(productImage);
            }
        }

        if (req.getRemove() != null) {
            for (ProductAddReq.ProductImageType item : req.getRemove()) {
                Long id = item.getId();
                if (id == null || id == 0) continue;
                ProductImage productImage = productImageRepository.findById(id).get();
                productImageRepository.delete(productImage);
            }
        }
        return new Response(product.getId());
    }

//    @Override
//    public Response update(String data) {
//        ProductAddReq productAddReq = JSON.parseObject(data, ProductAddReq.class);
//        return null;
//    }


}