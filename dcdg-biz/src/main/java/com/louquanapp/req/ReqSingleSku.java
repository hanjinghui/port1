package com.louquanapp.req;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Native;

/**
 * @Author: 朱宝瑞(zhubaorui)
 * @Date: 2019/9/18 20:59
 * @description:
 */
public class ReqSingleSku extends ReqToken{
    /**
     * 规格ID
     */
    @NotBlank(message = "规格ID不能空")
    private String specId;
    /**
     * 规格名称
     */
    @NotBlank(message = "规格名称不能空")
    private String optName;
    /**
     * 是否搜索[0-否 1-是]
     */
    @NotNull(message = "是否搜索不能空")
    @Range(min = 0,max = 1,message = "是否搜索范围[0-否 1-是]")
    private Byte isSearch;

    public Byte getIsSearch() {
        return isSearch;
    }

    public void setIsSearch(Byte isSearch) {
        this.isSearch = isSearch;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }
}
