package com.wj.demo.controller;

import com.wj.demo.api.AppraisalService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.converter.AppraisalDetailConverter;
import com.wj.demo.converter.AppraisalPagingConverter;
import com.wj.demo.dto.req.AppraisalPagingReq;
import com.wj.demo.dto.req.AppraisalResultUpdateReq;
import com.wj.demo.entity.Appraisal;
import com.wj.demo.entity.AppraisalImage;
import com.wj.demo.entity.Product;
import com.wj.demo.exception.ApiException;
import com.wj.demo.repository.AppraisalRepository;
import com.wj.demo.repository.FileRepository;
import com.wj.demo.repository.OrderImageRepository;
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
public class AppraisalController extends BaseController implements AppraisalService {


    @Autowired
    private AppraisalRepository appraisalRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private OrderImageRepository orderImageRepository;

    @Override
    public Response paging(AppraisalPagingReq dto) {

        Specification<Appraisal> spec = (Specification<Appraisal>) (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (dto.getSerial() != null && !"".equals(dto.getSerial())) {
                predicates.add(builder.like(root.get("serial"), "%" + dto.getSerial() + "%"));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, dto.getSize(), Sort.Direction.DESC, "id");
        Page<Appraisal> pageModel = appraisalRepository.findAll(spec, pageRequest);
        return new Response(new AppraisalPagingConverter().toPaginate(pageModel));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response get(Long id) {
        Appraisal order = appraisalRepository.findById(id).get();
        if (order == null) throw new ApiException("未找到该鉴别单");
        Product product = order.getProduct();
        return new Response(new AppraisalDetailConverter().toDTO(order));
    }

    @Override
    public Response get(AppraisalResultUpdateReq req) {
        Appraisal order = appraisalRepository.findById(req.getId()).get();
        if (order == null) throw new ApiException("未找到该鉴别单");
        order.setResult(Appraisal.Result.valueOf(req.getResult().name()));
        appraisalRepository.save(order);
        return new Response();
    }

//    //
//    public Response submit(Request request) {
//        Long userId = getUserInfo().getUserId();
//        SubmitOrderDTO dto = null;
////        SubmitOrderDTO dto = JSON.parseObject(request.getParam(), SubmitOrderDTO.class);
//        Appraisal order = new Appraisal();
//        order.setProductId(dto.getProductId());
//        order.setMasterId(dto.getMasterId());
//        order.setUserId(userId);
//        //保存必选照片
//        dto.getMajors().forEach((SubmitOrderDTO.Image item) -> {
//            saveOrderImage(order.getId(), item, 1);
//        });
//        //保存备选照片
//        dto.getMinors().forEach((SubmitOrderDTO.Image item) -> {
//            saveOrderImage(order.getId(), item, 1);
//        });
//        return new Response();
//    }
//
//    @Override
//    public Response orderDetail(Request request) {
//        Long userId = getUserInfo().getUserId();
//        Long orderId = 0L;
//        Appraisal order = appraisalRepository.findById(orderId).get();
//        return new Response(order);
//    }
//
//    private void saveOrderImage(Long orderId, SubmitOrderDTO.Image item, int category) {
//        File file = new File();
//        file.setBucket("mz-dev");
//        file.setName(item.getName());
//        file.setSuffix(item.getSuffix());
//        fileRepository.save(file);
//        OrderImage orderImage = new OrderImage();
//        orderImage.setAppraisalId(orderId);
//        orderImage.setCategory(1);
//        orderImage.setImageId(file.getId());
//        orderImageRepository.save(orderImage);
//    }
//
//    //
//    public Response myOrders(Request request) {
////        MyOrdersDTO dto = JSON.parseObject(request.getParam(), MyOrdersDTO.class);
//        Long userId = getUserInfo().getUserId();
//
//        int page = 1;
//        int size = 10;
//
//        Specification<Appraisal> spec = (Specification<Appraisal>) (root, query, builder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            predicates.add(builder.equal(root.get("user_id"), userId));
//            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
//        };
//        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.Direction.DESC, "id");
//        Page<Appraisal> pageModel = appraisalRepository.findAll(spec, pageRequest);
////        return new PermissionQueryFactory().buildPage(page);
//        return new Response(pageModel);
//    }
//
//    //
//    public Response latestOrders(Request request) {
//        int page = 1;
//        int size = 10;
//
//        Specification<Appraisal> spec = (Specification<Appraisal>) (root, query, builder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
//        };
//        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.Direction.DESC, "id");
//        Page<Appraisal> pageModel = appraisalRepository.findAll(spec, pageRequest);
////        return new PermissionQueryFactory().buildPage(page);
//        return new Response(pageModel);
//    }


}
