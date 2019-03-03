package com.wj.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.demo.api.TokenService;
import com.wj.demo.base.BaseController;
import com.wj.demo.base.Response;
import com.wj.demo.dto.req.TokenAddReq;
import com.wj.demo.dto.resp.TokenAddResp;
import com.wj.demo.entity.Token;
import com.wj.demo.entity.User;
import com.wj.demo.exception.ApiException;
import com.wj.demo.repository.BrandRepository;
import com.wj.demo.repository.TokenRepository;
import com.wj.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class TokenController extends BaseController implements TokenService {


    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Response add(TokenAddReq dto) throws Exception {
        String username = dto.getUsername().trim();
        String password = dto.getPassword().trim();
        User user = userRepository.findByUsername(username);
        if (user == null) throw new ApiException("该用户不存在");
        if (!user.getPassword().equals(password)) throw new ApiException("密码错误");
        String token = addLoginTicket(user.getId());
        //ticket=e75932bb92904defa98e13a8aad860b2
        return new Response(new TokenAddResp(user.getUsername(), token));
    }

    public String addLoginTicket(Long userId) {
        Token token = new Token();
        token.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 30);
        token.setExpired(date.getTime());
        token.setStatus(Token.Status.ENABLE);
        token.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        tokenRepository.save(token);
        System.out.println("生成ticket: " + JSONObject.toJSONString(token));
        //int a=loginTicketDao.insertLoginticket(loginTicket);
        //System.out.println("ticket插入结果: "+a);

        //return loginTicket.getTicket();
        return token.getTicket();
    }
}