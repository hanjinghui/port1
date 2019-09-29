package com.louquanapp.web.basic.api;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.ReportBiz;
import com.louquanapp.dao.mapper.ReportCatMapper;
import com.louquanapp.dao.model.ReportCat;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqComm;
import com.louquanapp.req.ReqDoReport;
import com.louquanapp.service.JedisService;
import com.louquanapp.web.customer.api.AuthCustomerApi;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/5/6 19:03
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class ReportController {

    private final ReportCatMapper reportCatMapper;
    private final ReportBiz reportBiz;
    private final JedisService jedisService;

    public ReportController(ReportCatMapper reportCatMapper, ReportBiz reportBiz, JedisService jedisService) {
        this.reportCatMapper = reportCatMapper;
        this.reportBiz = reportBiz;
        this.jedisService = jedisService;
    }

    @PostMapping("/no/reportCat")
    public TypeJsonResult<List<ReportCat>> reportCats(@Valid @RequestBody ReqComm reqSource, BindingResult bindingResult) {
        try {
            TypeJsonResult<List<ReportCat>> typeJsonResult = new TypeJsonResult<>();
            List<ReportCat> temp = reportCatMapper.selectAll();
            typeJsonResult.setType(temp);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
            String msg = "举报分类";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg + e.getMessage(), e);
        }
    }

    /**
     * 举报
     *
     * @param reqSource
     * @param bindingResult
     * @return
     */
    @PostMapping("auth/doReport")
    public JsonResult doReport(@Valid @RequestBody ReqDoReport reqSource, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult();
        String custId = jedisService.getCustIdByToken(reqSource.getToken());
        if (AuthCustomerApi.tokenDie(jsonResult, custId)) return jsonResult;
        return reportBiz.doReport(reqSource, custId);
    }
}
