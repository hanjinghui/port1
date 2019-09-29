package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.Arith;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.CustomerAccountMapper;
import com.louquanapp.dao.mapper.CustomerMapper;
import com.louquanapp.dao.mapper.CustomerPointMapper;
import com.louquanapp.dao.mapper.SystemParamMapper;
import com.louquanapp.dao.model.CustomerPoint;
import com.louquanapp.dao.model.SystemParam;
import com.louquanapp.req.ReqBalance;
import com.louquanapp.req.ReqPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther: Huhuamin
 * @Date: 2019/4/18 09:30
 * @Description:
 */
@Service
public class GameServerBiz {
    private final SystemParamMapper systemParamMapper;
    private final CustomerPointMapper customerPointMapper;
    private final CustomerMapper customerMapper;
    private final CustomerAccountMapper customerAccountMapper;

    public GameServerBiz(SystemParamMapper systemParamMapper, CustomerPointMapper customerPointMapper, CustomerMapper customerMapper, CustomerAccountMapper customerAccountMapper) {
        this.systemParamMapper = systemParamMapper;
        this.customerPointMapper = customerPointMapper;
        this.customerMapper = customerMapper;
        this.customerAccountMapper = customerAccountMapper;
    }

    /**
     * 赠送游戏积分
     *
     * @param pointNum 积分数
     * @param custId   用户
     * @return
     */
    @Transactional
    public JsonResult addPoint(ReqPoint reqSource, String custId, String gameName) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            int pointNum=reqSource.getPointNum();
            //单日最大积分
            SystemParam perPoint = systemParamMapper.selectByIndex(SystemParamBiz.GAME_MAX_PER_POINT);
            if (null != perPoint && !"0".equals(perPoint.getParamValue().trim())) {
                Integer perMaxPoint = Integer.valueOf(perPoint.getParamValue());
                if (pointNum > perMaxPoint) {
                    jsonResult.setMessage("单次最大可获得积分" + perMaxPoint + "," + "本次获得积分" + pointNum);
                    return jsonResult;
                }
            }

            SystemParam dayPoint = systemParamMapper.selectByIndex(SystemParamBiz.GAGE_MAX_DAY_POINT);
            if (null != dayPoint && !"0".equals(dayPoint.getParamValue().trim())) {
                Integer perDayPoint = Integer.valueOf(dayPoint.getParamValue());

                Double custDayPointSum = customerPointMapper.dayGamePoint(custId);
                Double cur = Arith.add(pointNum, custDayPointSum);
                if (Arith.compareDoubleSize(cur, perDayPoint) > 0) {
                    jsonResult.setMessage("每天累计最大获得" + perDayPoint + "," + "本次获得积分" + pointNum + ",今天已经获得" + custDayPointSum);
                    return jsonResult;
                }
            }

            Double versionDeductionPoint = customerMapper.getDeductionPointByCustId(custId);
            CustomerPoint customerPoint = new CustomerPoint();
            gainType1Init(custId, reqSource.getGameId(), Double.valueOf(pointNum), customerPoint, gameName);
            int result = customerPointMapper.insert(customerPoint);
            if (result == 0) {
                jsonResult.setMessage("保存积分记录失败");
                return jsonResult;
            }

            result = customerMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, Double.valueOf(pointNum), versionDeductionPoint);
            if (result == 0) {
                throw new HuhuaminException("更新主账号表失败");
            }

            result = customerAccountMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, Double.valueOf(pointNum), versionDeductionPoint);
            if (result == 0) {
                throw new HuhuaminException("更新主账号表失败");
            }

            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "玩游戏获得积分";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    @Transactional
    public JsonResult signPoint(String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            Integer custDaySignSum = customerPointMapper.daySignPoint(custId);
            if (custDaySignSum > 0) {
                jsonResult.setMessage("今天已经签到了");
                return jsonResult;
            }
            //累计签到次数
            Integer times = customerPointMapper.weekSignPoint(custId);

            //系统参数获得积分
            SystemParam signPoint = systemParamMapper.selectByIndex(SystemParamBiz.SIGN_POINT);
            //系统参数每天递增分数
            SystemParam signPointPer = systemParamMapper.selectByIndex(SystemParamBiz.SIGN_POINT_PER);
            Double sendPoint = 0.00d;
            if (null != signPoint && !"0".equals(signPoint.getParamValue().trim())) {

                Double versionDeductionPoint = customerMapper.getDeductionPointByCustId(custId);
                sendPoint = Double.valueOf(signPoint.getParamValue().trim());
                CustomerPoint customerPoint = new CustomerPoint();
                if (null != signPointPer && !"0".equals(signPointPer.getParamValue().trim())) {
                    sendPoint = Arith.add(sendPoint, Double.valueOf(signPointPer.getParamValue()));
                }


                gainType1IniSign(custId, "", sendPoint, customerPoint);
                int result = customerPointMapper.insert(customerPoint);
                if (result == 0) {
                    jsonResult.setMessage("签到保存积分记录失败");
                    return jsonResult;
                }


                result = customerMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, customerPoint.getPointValue(), versionDeductionPoint);
                if (result == 0) {
                    throw new HuhuaminException("签到更新主账号表失败");
                }

                result = customerAccountMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, customerPoint.getPointValue(), versionDeductionPoint);
                if (result == 0) {
                    throw new HuhuaminException("签到更新主账号表失败");
                }

            } else {
                jsonResult.setMessage("系统参数没有配置签到积分");

            }


            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "签到";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }

    /**
     * 玩游戏送余额
     * @param reqBalance
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult addBalance(ReqBalance reqBalance, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            CustomerPoint customerPoint=new CustomerPoint();


            customerPoint.setGainType((byte) 1);//获取
            customerPoint.setCustId(custId);
            customerPoint.setSourceId(reqBalance.getGameId());
            customerPoint.setPointId(UUIDUtils.generateUuid22());
            customerPoint.setPointValue(reqBalance.getBalance());
            customerPoint.setAddTime(new Date());
            customerPoint.setAuditStatus((byte) 2);
            customerPoint.setAuditTime(customerPoint.getAddTime());
            customerPoint.setAuditUser("system");
            customerPoint.setAuditUserName("system");
            customerPoint.setSourceType((byte) 5);
            customerPoint.setPointMold((byte) 2);
                customerPoint.setPointDesc("玩游戏送余额" + reqBalance.getBalance());
                customerPoint.setPointType((byte) 1);//积分类型[1-余额 3-积分]
                int result = customerPointMapper.insert(customerPoint);
                if (result == 0) {
                    throw new HuhuaminException("玩游戏送余额获得余额记录失败");
                }

                result =customerMapper.addConsumePoint(custId,reqBalance.getBalance());
                if (result == 0) {
                    throw new HuhuaminException("在玩游戏送余额用户跟新过程中,系统开小差了！！！");
                }


            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String msg = "玩游戏送余额";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }
    }
    private static void gainType1Init(String custId, String orderId, Double deMoney, CustomerPoint customerPoint, String gameName) {
        customerPoint.setGainType((byte) 1);//获取
        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
        customerPoint.setAddTime(new Date());
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditTime(customerPoint.getAddTime());
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setPointType((byte) 3); //商城积分
        customerPoint.setSourceType((byte) 5);//游戏
        customerPoint.setPointDesc("玩游戏" + gameName + ",获得" + deMoney);


    }

    private static void gainType1IniSign(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 1);//获取
        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
        customerPoint.setAddTime(new Date());
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditTime(customerPoint.getAddTime());
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setPointType((byte) 3); //商城积分
        customerPoint.setSourceType((byte) 6);//游戏
        customerPoint.setPointDesc("签到获得" + deMoney);


    }


    private static void gainType1InitPlus(String custId, String orderId, Double deMoney, CustomerPoint customerPoint) {
        customerPoint.setGainType((byte) 2);//消费
        customerPoint.setCustId(custId);
        customerPoint.setSourceId(orderId);
        customerPoint.setPointId(UUIDUtils.generateUuid22());
        customerPoint.setPointValue(deMoney);
        customerPoint.setAddTime(new Date());
        customerPoint.setAuditStatus((byte) 2);
        customerPoint.setAuditTime(customerPoint.getAddTime());
        customerPoint.setAuditUser("system");
        customerPoint.setAuditUserName("system");
        customerPoint.setPointType((byte) 3); //商城积分
        customerPoint.setSourceType((byte) 6);//游戏
        customerPoint.setPointDesc("消息消耗" + deMoney);


    }

    /**
     * 减积分
     *
     * @param pointNum 积分数
     * @param custId   用户
     * @param gameName 游戏名称
     * @return
     */
    @Transactional
    public JsonResult minusPoint(ReqPoint reqSource, String custId, String gameName) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            CustomerPoint customerPoint = new CustomerPoint();
            Double versionDeductionPoint = customerMapper.getDeductionPointByCustId(custId);
            int pointNum=reqSource.getPointNum();
            if (Arith.sub(versionDeductionPoint - pointNum, 0.00) < 0) {
                jsonResult.setMessage("积分不足");
                return jsonResult;
            }
            gainType1InitPlus(custId, reqSource.getGameId(), Double.valueOf(pointNum), customerPoint);
            int result = customerMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, -customerPoint.getPointValue(), versionDeductionPoint);
            if (result == 0) {
                throw new HuhuaminException("签到更新主账号表失败");
            }

            result = customerAccountMapper.updatePlusDeductionPointBydVersionDeductionPointAndCustId(custId, -customerPoint.getPointValue(), versionDeductionPoint);
            if (result == 0) {
                throw new HuhuaminException("签到更新主账号表失败");
            }


            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (
                Exception e) {
            String msg = "签到";
            msg = String.format("在%s过程中,服务器开小差了", msg);
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException(msg, e);
        }

    }
}
