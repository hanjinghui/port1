package com.louquanapp.req;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/8/14 14:41
 * @description:
 */
public class ReqDeniedAfterSale extends ReqToken {

    /**
     * 商家回复
     */
    private String replyCont;
    /**
     * 退货退款id
     */
    private String returnId;

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getReplyCont() {
        return replyCont;
    }

    public void setReplyCont(String replyCont) {
        this.replyCont = replyCont;
    }
}
