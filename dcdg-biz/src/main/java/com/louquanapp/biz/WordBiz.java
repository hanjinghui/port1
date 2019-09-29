package com.louquanapp.biz;

import com.huhuamin.common.HuhuaminException;
import com.huhuamin.common.HuhuaminExceptionPlan;
import com.huhuamin.common.model.JsonResult;
import com.louquanapp.dao.mapper.CustomerWordsMapper;
import com.louquanapp.dao.mapper.HotWordsMapper;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqSearchWord;
import com.louquanapp.resp.WordDto;
import com.louquanapp.service.JedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2018/11/16 15:18
 * @email:175759041@qq.com
 * @Description: 搜素词返回业务逻辑
 */
@Service
public class WordBiz {
    private final HotWordsMapper hotWordsMapper;
    private final CustomerWordsMapper customerWordMapper;
    private final JedisService jedisService;


    public WordBiz(HotWordsMapper hotWordsMapper, CustomerWordsMapper customerWordMapper, JedisService jedisService) {
        this.hotWordsMapper = hotWordsMapper;
        this.customerWordMapper = customerWordMapper;
        this.jedisService = jedisService;
    }

    /**
     * 获取搜素模块 历史 和热搜词realSend
     *
     * @param reqSource
     * @return
     */
    public TypeJsonResult<WordDto> words(ReqSearchWord reqSource) {

        try {
            WordDto wordDto = new WordDto();
            TypeJsonResult<WordDto> typeJsonResult = new TypeJsonResult<>();
            String custId = "";
            if (StringUtils.isNotEmpty(reqSource.getToken())) {
                custId = jedisService.getCustIdByToken(reqSource.getToken());
            }
            List<String> custWords = customerWordMapper.selectByCustId(custId, reqSource.getDeviceId());
            wordDto.setCustWords(custWords);
            List<String> hotwords = hotWordsMapper.selectAllWordsVal();
            wordDto.setHotwords(hotwords);
            typeJsonResult.setType(wordDto);
            typeJsonResult.setStatusCode(true);
            return typeJsonResult;
        } catch (Exception e) {
           if (e instanceof HuhuaminException) {
                throw new HuhuaminExceptionPlan(e.getMessage());
            }
            throw new HuhuaminException("在获取搜素词过程中，服务器开小差了！", e);
        }

    }

    /**
     * 清空搜索词
     *
     * @param reqSource
     * @return
     */
    public JsonResult wordDel(ReqSearchWord reqSource) {
        try {
            JsonResult jsonResult = new JsonResult();
            jsonResult.setStatusCode(false);
            String custId = "";
            if (StringUtils.isNotEmpty(reqSource.getToken())) {
                custId = jedisService.getCustIdByToken(reqSource.getToken());
            }
            customerWordMapper.deleteByCustId(custId, reqSource.getDeviceId());
            jsonResult.setStatusCode(true);
            return jsonResult;
        } catch (Exception e) {

            throw new HuhuaminException("在清空搜素词过程中，服务器开小差了！", e);
        }
    }


//    /**
//     * 更新热门搜索词和我的搜索词
//     *
//     * @param searchWord
//     * @return
//     */
//    @Transactional
//    public synchronized JsonResult searchWordAdd(String searchWord, String custId, String deviceId) {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setStatusCode(false);
//        String hotwordId = "";
//        //热门搜索词
//        int hotwordsCount = hotWordsMapper.selectCountByWordsVal(searchWord);
//        int hotCount = 0;
//        if (hotwordsCount > 0) {
//            Map<String, Object> hotwordIdMap = new HashMap<>();
//            hotwordIdMap.put("wordsVal", searchWord);
//            hotwordIdMap.put("wordsType", wordsType);
//            hotwordId = hotwordsMapper.selectIdByWordsValAndWordsType(hotwordIdMap);
//            Map<String, Object> map = new HashMap<>();
//            map.put("wordsId", hotwordId);
//            map.put("updateTime", new Date());
//            hotCount = hotwordsMapper.updateCountById(map);
//        } else {
//            hotwordId = UUIDUtils.generateUuid22();
//            Hotwords hotwords = new Hotwords();
//            hotwords.setWordsId(hotwordId);
//            hotwords.setWordsVal(searchWord);
//            hotwords.setSearchCount((long) 1);
//            hotwords.setAddTime(new Date());
//            hotwords.setUpdateTime(new Date());
//            hotwords.setWordsType(wordsType);
//            hotCount = hotwordsMapper.insert(hotwords);
//        }
//        if (hotCount == 0) {
//            jsonResult.setMessage("更新热门搜索记录失败");
//            return jsonResult;
//        }
//
//        //我的搜索词
//        Map<String, Object> custWordMap = new HashMap<>();
//        custWordMap.put("wordsVal", searchWord);
//        custWordMap.put("custId", custId);
//        custWordMap.put("wordsType", wordsType);
//        int custWordCount = custWordMapper.selectCountByWordsVal(custWordMap);
//        int custCount = 0;
//        if (custWordCount > 0) {//更新时间
//            Map<String, Object> wordMap = new HashMap<>();
//            wordMap.put("wordsVal", searchWord);
//            wordMap.put("custId", custId);
//            wordMap.put("wordsType", wordsType);
//            wordMap.put("updateTime", new Date());
//            custCount = custWordMapper.updateUpdateTimeByWordsValAndCustId(wordMap);
//        } else {//添加我的搜索词
//            CustWord custWord = new CustWord();
//            custWord.setCustWordsId(UUIDUtils.generateUuid22());
//            custWord.setWordsVal(searchWord);
//            custWord.setWordsId(hotwordId);
//            custWord.setAddTime(new Date());
//            custWord.setUpdateTime(new Date());
//            custWord.setCustId(custId);
//            custWord.setWordsType(wordsType);
//            custCount = custWordMapper.insert(custWord);
//        }
//        if (custCount == 0) {
//            jsonResult.setMessage("更新我的搜索记录失败");
//            return jsonResult;
//        }
//        jsonResult.setStatusCode(true);
//        return jsonResult;
//    }
}
