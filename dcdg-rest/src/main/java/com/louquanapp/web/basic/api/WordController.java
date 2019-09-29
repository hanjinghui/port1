package com.louquanapp.web.basic.api;

import com.huhuamin.common.model.JsonResult;
import com.louquanapp.biz.WordBiz;
import com.louquanapp.model.TypeJsonResult;
import com.louquanapp.req.ReqSearchWord;
import com.louquanapp.resp.WordDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: Huhuamin
 * @Date: 2018/11/16 15:17
 * @email:175759041@qq.com
 * @Description: 搜素词相关数据返回
 */
@RestController
@RequestMapping("/api")
public class WordController {

    private final WordBiz wordBiz;


    public WordController(WordBiz wordBiz) {
        this.wordBiz = wordBiz;
    }


    @PostMapping("/no/words")
    public TypeJsonResult<WordDto> words(@Valid @RequestBody ReqSearchWord reqSource, BindingResult bindingResult) {
        return wordBiz.words(reqSource);
    }


    @PostMapping("/no/wordDel")
    public JsonResult wordDel(@Valid @RequestBody ReqSearchWord reqSource, BindingResult bindingResult) {
        return wordBiz.wordDel(reqSource);
    }

}
