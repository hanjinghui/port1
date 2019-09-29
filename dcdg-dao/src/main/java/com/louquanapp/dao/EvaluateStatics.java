package com.louquanapp.dao;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/10 下午6:40
 * 统计数据
 */
public class EvaluateStatics {

    /**
     * 好评数
     */
    private int count1;
    /**
     * 中评数
     */
    private int count2;
    /**
     * 差评数
     */
    private int count3;
    /**
     * 有图
     */
    private int count4;
    private int total;
    /**
     * 好评百分比
     */
    private Double percent1;
    /**
     * 中评百分比
     */
    private Double percent2;
    /**
     * 差评百分比
     */
    private Double percent3;
    /**
     * 有图百分比
     */
    private Double percent4;

    public EvaluateStatics(int count1, int count2, int count3, int count4, Double percent1, Double percent2, Double percent3, Double percent4) {
        this.count1 = count1;
        this.count2 = count2;
        this.count3 = count3;
        this.count4 = count4;
        this.percent1 = percent1;
        this.percent2 = percent2;
        this.percent3 = percent3;
        this.percent4 = percent4;
        this.total=count1+count2+count3;
    }

    public EvaluateStatics() {

    }

    /**
     * 好评数
     *
     * @return
     */
    public int getCount1() {
        return count1;
    }

    /**
     * 好评数
     *
     * @param count1
     */
    public void setCount1(int count1) {
        this.count1 = count1;
    }

    /**
     * 中评数
     *
     * @return
     */
    public int getCount2() {
        return count2;
    }

    /**
     * 中评数
     *
     * @param count2
     */
    public void setCount2(int count2) {
        this.count2 = count2;
    }

    /**
     * 差评数
     *
     * @return
     */
    public int getCount3() {
        return count3;
    }

    /**
     * 差评数
     *
     * @param count3
     */
    public void setCount3(int count3) {
        this.count3 = count3;
    }

    /**
     * 好评百分比
     *
     * @return
     */
    public Double getPercent1() {
        return percent1;
    }


    /**
     * 好评百分比
     *
     * @param percent1
     */
    public void setPercent1(Double percent1) {
        this.percent1 = percent1;
    }

    /**
     * 中评百分比
     *
     * @return
     */
    public Double getPercent2() {
        return percent2;
    }

    /**
     * 中评百分比
     *
     * @param percent2
     */
    public void setPercent2(Double percent2) {
        this.percent2 = percent2;
    }

    /**
     * 差评百分比
     *
     * @return
     */
    public Double getPercent3() {
        return percent3;
    }

    /**
     * 差评百分比
     *
     * @param percent3
     */
    public void setPercent3(Double percent3) {
        this.percent3 = percent3;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount4() {
        return count4;
    }

    public void setCount4(int count4) {
        this.count4 = count4;
    }

    public Double getPercent4() {
        return percent4;
    }

    public void setPercent4(Double percent4) {
        this.percent4 = percent4;
    }
}
