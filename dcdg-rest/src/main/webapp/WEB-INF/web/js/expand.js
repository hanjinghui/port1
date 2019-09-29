/**
 * 公共方法的封装
 */
//关闭当前窗口
function closeWin() {
    api.closeWin({});
}

// 关闭子窗口
function closeFrame() {
    api.closeFrame({
        name: 'page2'
    });
}

//设置状态栏背景颜色 和字体颜色
function setStatus(style, color) {
    api.setStatusBarStyle({
        style: style,
        color: color
    });
}


//获取封装api.toast
function mytoast(msg, str_area) {
    var str_areas = str_area || 'bottom';
    api.toast({
        msg: msg,
        duration: 1500,
        location: str_areas
    });
}


//回到主界面
function backHomeWin() {
    //这个是回到主界面不会回到userwin
    api.closeToWin({
        name: 'root'
    });
}

//格式化价格
function formatPrice(price) {
    var newStr = '',
        count = 0,
        i = 0;
    price = (price || 0) + '';
    if (price.indexOf('.') == -1) {
        for (i = price.length - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                newStr = price.charAt(i) + newStr; //price.charAt(i) + ',' + newStr;
            } else {
                newStr = price.charAt(i) + newStr;
            }
            count++;
        }
        price = newStr + '.00';
    } else {
        for (i = price.indexOf('.') - 1; i >= 0; i--) {
            if (count % 3 == 0 && count != 0) {
                newStr = price.charAt(i) + newStr; //price.charAt(i) + ',' + newStr;
            } else {
                newStr = price.charAt(i) + newStr;
            }
            count++;
        }
        price = newStr + (price + '00').substr((price + '00').indexOf('.'), 3);
    }
    return price;
}


// 写文件
function writeFile(jsonData, fileName, successFn, errorFn) {
    api.writeFile({
        path: 'fs://wisdomLifeData/' + fileName,
        data: $api.jsonToStr(jsonData)
    }, function (ret, err) {
        if (ret.status) {
            if (successFn && $.isFunction(successFn)) {
                successFn.call(null);
                console.log('写入成功')
            }
        }
        else {
            if (errorFn && $.isFunction(errorFn)) {
                console.log(err.msg);
                console.log('写入失败')
            }
        }
    })
}

// 读取文件
function readFile(fileName, successFn) {
    api.readFile({
        path: 'fs://wisdomLifeData/' + fileName
    }, function (ret, err) {
        if (ret.status) {
            successFn.call(null, $api.strToJson(ret.data == "" ? null : ret.data), null);
        } else {
            console.log(err.msg);
            // errorFn.call(null, err);       
        }
    })
}

//验证手机号码
function isPoneAvailable(str) {
    var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
    if (!myreg.test(str)) {
        return false;
    } else {
        return true;
    }
}

// 创建dom
function createDom(tag) {
    return document.createElement(tag);
}

//查找dom
function getDom(selector) {
    return document.querySelector(selector);
}

//去除首尾空格
function trim(obj) {
    if (typeof obj === 'string') {
        return obj.replace(/^\s+|\s+$/gm, '');
    } else {
        return obj
    }
}

//验证密码 - 密码字数限制（6-16位英文，数字。可混组）
function checkPassword(s) {
    var regu = /^[a-zA-Z0-9]{6,16}$/;
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    } else {
        return false;
    }
}

/**
 * ajax提交封装
 * @param url ：接口地址
 * @param description ：功能描述，便于提示信息容易理解，如：首页公告获取、商品信息获取等等
 * @param data ：接口参数（JSON格式），此参数不传递时默认为空（{}）
 * @param fn ：回调函数，返回JSON对象或者异常信息，接口请求异常时返回null，接口请求不通时返回error，外部调用需判断是否为null或者error
 * @param uploapic ： 默认值 false    布尔值  如果是true上传图片  false普通数据上传
 * @param type ：异步请求方法类型 默认post
 */
function ajax(url, description, data, fn, fn2, uploapic, type, loads, loading) {
    //定义默认值
    var type = type || 'post',//默认post
        data = data || {},    //接口参数不传递时默认为空
        uploapic = uploapic === true ? true : false,  //默认false  true上传图片  false普通数据
        loads = loads === false ? false : true,   //默认true
        loading = loading === true ? true : false;  //默认false
    console.log(type);
    //将data数据的空格去除
    if (data.length != 0) {
        for (var i in data) {
            data[i] = trim(data[i]);
        }
    }
    //加载动画
    if (loading != false) {
        api.showProgress({
            title: '努力加载中...'
        });
    }

    var _data = {}, _headers = {'Content-Type': 'application/json;charset=utf-8'}, ajaxData = {}, param = '';
    if (!uploapic) {
        // ========= 签名算法，防止数据篡改 start ========= //
        //接口返回的JSON对象
        var registerSource = api.systemType;
        switch (registerSource) {
            case 'ios':
                registerSource = 4;
                break;
            case 'android':
                registerSource = 3;
                break;
            default:
                break;
        }
        var data1 = {
            deviceId: api.deviceId,
            registerSource: registerSource,
            timestamp: new Date().getTime()
        }
        var sendData = Object.assign(data1, data);
        // var sign = MD5Obj(sendData).toLowerCase();
        // sendData.sign = sign;
        // ========= 签名算法，防止数据篡改 end ========= //

        //ajax参数
        ajaxData = {
            url: url,
            method: type,
            timeout: 10,
            data: {body: sendData},
            headers: _headers
        };
    } else {
        _data = {files: data};  //上传参数
        sendData = _data;           //请求参数
        ajaxData = {
            url: url,
            method: type,
            timeout: 10,
            data: _data
        };
    }

    //发起ajax
    api.ajax(ajaxData, function (ret, err) {
        if (loading != false) {
            api.hideProgress();
        }
        if (loads == true) {
            console.log('************************ 请求开始 start ************************');
            console.log('接口描述：' + description);
            console.log('请求URL：' + url);
            console.log('请求参数：' + JSON.stringify(sendData));
            console.log('你的参数：' + JSON.stringify(data));
            console.log('接口返回：' + JSON.stringify(ret));
        }
        if (ret) { //请求服务器成功
            //正常回调
            if (typeof fn == 'function') {
                fn(ret);
            }

        } else { //请求服务器失败
            //错误回调
            if (typeof fn2 == 'function') {
                fn2(ret);
            }
            if (err.code == 1) {
                api.toast({
                    msg: '当前网络较差',
                    duration: 3000,
                    location: 'middle'
                });

                if (typeof fn2 == 'function') {
                    fn2(ret);
                }
            }
            if (loads == true) console.log('错误信息：' + JSON.stringify(err));
        }
        if (loads == true) console.log('************************ 请求结束 end ************************');
    });

}