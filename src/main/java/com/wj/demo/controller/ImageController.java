
package com.wj.demo.controller;

import com.wj.demo.api.ImageService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.converter.ImagePagingConverter;
import com.wj.demo.dto.req.ImageAddReq;
import com.wj.demo.dto.req.ImageBatchAddReq;
import com.wj.demo.dto.req.ImagePagingReq;
import com.wj.demo.entity.Image;
import com.wj.demo.exception.ApiException;
import com.wj.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageController extends BaseController implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Response paging(ImagePagingReq dto) {
        Specification<Image> spec = (Specification<Image>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getName() != null && !"".equals(dto.getName())) {
                predicates.add(builder.like(root.get("name"), "%" + dto.getName() + "%"));
            }
            if (dto.getType() != null) {
                predicates.add(builder.equal(root.get("type"), Image.Type.valueOf(dto.getType().name())));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, dto.getSize(), Sort.Direction.DESC, "id");
        Page<Image> pageModel = imageRepository.findAll(spec, pageRequest);
        return new Response(new ImagePagingConverter().toPaginate(pageModel));
    }

    @Override
    public Response add(@Valid ImageAddReq dto) {
        Image image = new Image();
        image.setName(dto.getName());
        image.setType(Image.Type.valueOf(dto.getType().name()));
        image.setUrl(dto.getUrl());
        image.setCreateTime(System.currentTimeMillis());
        return new Response(new ImagePagingConverter().toDTO(imageRepository.save(image)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response batchAdd(ImageBatchAddReq dto) {
        try {
            for (ImageBatchAddReq.Image item : dto.getImages()) {
                Image image = new Image();
                String[] split1 = item.getName().split("\\.");
                image.setName(split1[0]);
                String[] split = split1[0].split("-");
                String typeStr = split[2];
                Image.Type type = null;
                switch (typeStr) {
                    case "产品图":
                        type = Image.Type.PRODUCT;
                        break;
                    case "产品鉴别图标":
                        type = Image.Type.PRODUCT_EXAMPLE;
                        break;
                    case "产品鉴别示例图":
                        type = Image.Type.PRODUCT_REAL_EXAMPLE;
                        break;

                }
                image.setType(type);
                image.setUrl(item.getUrl());
                image.setCreateTime(System.currentTimeMillis());
                imageRepository.save(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("导入文件失败");
        }
        return new Response();
    }

    @Override
    public Response remove(Long id) {
        Image entity = imageRepository.findById(id).get();
        imageRepository.delete(entity);
        return new Response();
    }

    @Override
    public Response upload() {
        return null;
    }
}
