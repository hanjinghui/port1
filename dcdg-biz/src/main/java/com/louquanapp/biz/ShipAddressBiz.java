package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.huhuamin.common.utils.UUIDUtils;
import com.louquanapp.dao.mapper.ShipAddressMapper;
import com.louquanapp.dao.model.ShipAddress;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqShipAddress;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2019年03月29日14:02:40
 */
@Service
public class ShipAddressBiz {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ShipAddressMapper shipAddressMapper;

    public ShipAddressBiz(ShipAddressMapper shipAddressMapper) {
        this.shipAddressMapper = shipAddressMapper;
    }


    /**
     * 增加收货地址
     *
     * @param reqShipAddress
     * @return
     */
    @Transactional
    public JsonResult addShipAddress(ReqShipAddress reqShipAddress, String custId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            ShipAddress shipAddress = new ShipAddress();
            if (null == reqShipAddress.getDefaultFlag() && StringUtils.isEmpty(reqShipAddress.getShipId())) {
                reqShipAddress.setDefaultFlag((byte) 2);
            }
            BeanUtils.copyProperties(reqShipAddress, shipAddress);
            shipAddress.setCustId(custId);
            Date now = new Date();
            shipAddress.setAddTime(now);
            shipAddress.setUpdateTime(now);


            //先将以前的默认地址还原
            if (null != reqShipAddress.getDefaultFlag() && reqShipAddress.getDefaultFlag().intValue() == 1) {
                int changeResult = shipAddressMapper.setAllToNotDefaultByCustId(custId);
                if (logger.isDebugEnabled()) {
                    logger.debug("修改默认地址" + changeResult + "影响的行数");
                }
            }
            int result = 0;
            if (StringUtils.isEmpty(reqShipAddress.getShipId())) {
                shipAddress.setShipId(UUIDUtils.generateUuid22());
                //增加收货地址操作
                result = shipAddressMapper.insert(shipAddress);
                if (result == 0) {
                    throw new HuhuaminException("增加收货地址失败");
                }
            } else {

                //增加收货地址操作
                shipAddress.setUpdateTime(now);
                result = shipAddressMapper.updateByPrimaryKeyAndCustIdSelective(shipAddress);
                if (result == 0) {
                    throw new HuhuaminException("修改收货地址失败");
                }
            }

            shipAddress.setShipId(UUIDUtils.generateUuid22());


            jsonResult.setStatusCode(true);
            return jsonResult;

        } catch (Exception e) {
            if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            } else {
                String message = String.format("在%s过程中,系统开小差了!", "增加默认收货地址过程");
                throw new HuhuaminException(message + e.getMessage(), e);
            }
        }
    }


    /**
     * 获取用户默认收货地址
     *
     * @param custId
     * @return
     */
    public TypeJsonResult<ShipAddress> getDefaultByCustId(String custId) {
        try {
            ShipAddress address = shipAddressMapper.getDefaultByCustId(custId);
            TypeJsonResult<ShipAddress> jsonResult = new TypeJsonResult<>(address);
            return jsonResult;
        } catch (Exception e) {

            String message = String.format("在%s过程中,系统开小差了!", "获取用户默认收货地址");
            throw new HuhuaminException(message + e.getMessage(), e);
        }
    }


    /**
     * 根据用户查询地址列表
     *
     * @param custId
     * @return
     */
    public TypeJsonResult<List<ShipAddress>> selectAllByCustId(String custId) {
        try {
            List<ShipAddress> address = shipAddressMapper.selectAllByCustId(custId);
            TypeJsonResult<List<ShipAddress>> jsonResult = new TypeJsonResult<>(address);
            return jsonResult;
        } catch (Exception e) {
            String message = String.format("在%s过程中,系统开小差了!", "获取用户查询地址列表");
            throw new HuhuaminException(message + e.getMessage(), e);
        }
    }

    /**
     * 设置当前地址为默认收货地址
     *
     * @param custId
     * @return
     */
    @Transactional
    public JsonResult setCurrentUserDefaultAddr(String custId, String shipId) {
        try {

            JsonResult jsonResult = new JsonResult(false);
            if (StringUtils.isBlank(shipId)) {
                jsonResult.setMessage("地址id必传");
                return jsonResult;
            }

            ShipAddress address = shipAddressMapper.getAddressByCustIdAndShipId(custId, shipId);
            if (null == address) {
                jsonResult.setMessage("地址没有查询到，请核实id");
                return jsonResult;
            }

            int existDefault = shipAddressMapper.setAllToNotDefaultByCustId(custId);
            logger.debug("将已经默认的设置为非默认".concat(String.valueOf(existDefault)));
            int countUpdate = shipAddressMapper.setCurrentUserDefaultAddr(shipId);

            if (countUpdate == 0) {
                jsonResult.setMessage("设置当前地址为默认收货地址");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {

            String message = String.format("在%s过程中,系统开小差了!", "设置当前地址为默认收货地址");
            throw new HuhuaminException(message + e.getMessage(), e);
        }
    }

    /**
     * 新增收货地址
     *
     * @param custId
     * @param reqShipAddress
     * @return
     */
    @Transactional
    public JsonResult doAddAddress(String custId, ReqShipAddress reqShipAddress) {

        try {
            JsonResult jsonResult = new JsonResult(false);
            ShipAddress address = new ShipAddress();
            BeanUtils.copyProperties(reqShipAddress, address);
            address.setCustId(custId);
            if (reqShipAddress.getDefaultFlag() == (byte) 1) {
                int existDefault = shipAddressMapper.setAllToNotDefaultByCustId(custId);
                logger.debug("将已经默认的设置为非默认".concat(String.valueOf(existDefault)));
            }
            address.setShipId(UUIDUtils.generateUuid22());
            int countUpdate = shipAddressMapper.insert(address);

            if (countUpdate == 0) {
                jsonResult.setMessage("增加收货地址没有成功");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;

        } catch (Exception e) {
            String message = String.format("在%s过程中,系统开小差了!", "新增收货地址");
            throw new HuhuaminException(message + e.getMessage(), e);
        }
    }


    /**
     * 根据用户主键(防止信息被人恶意获取)和地址主键获取
     *
     * @param custId
     * @param shipId
     * @return
     */
    public TypeJsonResult<ShipAddress> getAddressByCustIdAndShipId(String custId, String shipId) {
        try {
            ShipAddress address = shipAddressMapper.getAddressByCustIdAndShipId(custId, shipId);
            TypeJsonResult<ShipAddress> jsonResult = new TypeJsonResult<>(address);
            return jsonResult;
        } catch (Exception e) {
            String message = String.format("在%s过程中,系统开小差了!", "单个查询用户收货地址");
            throw new HuhuaminException(message + e.getMessage(), e);

        }
    }

    /**
     * 根据用户主键(防止信息被人恶意获取)和地址主键删除
     *
     * @param custId
     * @param shipId
     * @return
     */
    public JsonResult delAddressByCustIdAndShipId(String custId, String shipId) {
        try {
            JsonResult jsonResult = new JsonResult(false);
            int delCount = shipAddressMapper.delAddressByCustIdAndShipId(custId, shipId);

            if (delCount == 0) {
                jsonResult.setMessage("删除地址没有成功");
                return jsonResult;
            }
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {
            String message = String.format("在%s过程中,系统开小差了!", "删除单个收货地址");
            throw new HuhuaminException(message + e.getMessage(), e);
        }
    }

    /**
     * 批量删除收货地址
     *
     * @param custId
     * @param ids
     * @return
     */
//    public JsonResult delAddressByCustIdAndShipIds(String custId, String ids) {
//        try {
//            List<String> listIds = new ArrayList<>();
//            if (ids.contains(",")) {
//                String[] temp = ids.split(",");
//                listIds = Arrays.asList(temp);
//            }
//            JsonResult jsonResult = new JsonResult(false);
//            int delCount = 0;
//            if (null != listIds && listIds.size() == 1) {
//                delCount = shipAddressMapper.delAddressByCustIdAndShipId(custId, listIds.get(0));
//            } else {
//                Map<String, Object> map = new HashMap<>(2);
//                map.put("shipIds", listIds);
//                map.put("custId", custId);
//                delCount = shipAddressMapper.delAddressByCustIdAndShipIds(map);
//            }
//
//
//            if (delCount == 0) {
//                jsonResult.setMessage("修改地址没有成功");
//                return jsonResult;
//            }
//            jsonResult.setStatusCode(true);
//            return jsonResult;
//        } catch (Exception e) {
//    String message = String.format("在%s过程中,系统开小差了!", "批量单个收货地址");
//            throw new HuhuaminException(message + e.getMessage(), e);
//        }
//    }
}
