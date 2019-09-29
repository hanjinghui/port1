package com.louquanapp.dao.extra;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/13 下午6:46
 */
public class SelectedExtra {
    /**
     * 选中状态
     */
    private Boolean selected;
    private Boolean collected;

    private String updateSku;

    public String getUpdateSku() {
        return updateSku;
    }

    public void setUpdateSku(String updateSku) {
        this.updateSku = updateSku;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getCollected() {
        return collected;
    }

    public void setCollected(Boolean collected) {
        this.collected = collected;
    }
}
