package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/4/15 17:09
 * @description:
 */
public class ReqMyEvaluate extends ReqTokenPage {


    /**
     * 评价结果[0-全部  1-有图 ]
     */
    @Range(min = 0, max = 1, message = "评价结果范围[0-全部 1-有图]！")
    private Integer evaluateResult;


    public Integer getEvaluateResult() {
        return evaluateResult;
    }

    public void setEvaluateResult(Integer evaluateResult) {
        this.evaluateResult = evaluateResult;
    }


}
