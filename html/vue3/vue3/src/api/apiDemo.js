/*
 * @Author: Booleen
 * @Date: 2019-12-04 10:47:13
 * @Last Modified time: 2019-12-04 11:03:55
 * api层示例代码，针对各种请求方式的demo
 */
import request from './request/fetch';
import axios from './request/request';
const url = '';
class apiDemo {
    // credentials: 'include' 代表传用户cookie

    /**
     * 客户端方法，例如判断用户是否为游客
     * @param {*} params 
     */
    isGuest() {
        return new Promise((resolve, reject) => {
            API.use({
                method: 'Util.isGuestAccount',
                success: data => {
                    resolve(data);
                },
                error: (errorcode, errormsg) => {
                    reject({
                        message: errormsg
                    });
                },
                notClient: () => {
                    resolve();
                }
            });
        });
    }

    /**
     * get请求
     * @param {*} params 传对象
     * @param {*} credentials : 'include',可选，代表传用户cookie
     */
    get(params) {
        return request.get(url, {
            data: params,
            credentials: 'include'
        });
    }
    /**
     * post请求之一
     * @param {*} params 传对象
     * @param {*} credentials : 'include',可选，代表传用户cookie
     */
    post() {
        return axios.post(url, params, {
            credentials: 'include'
        });
    }
    /**
     * post请求之二
     * @param {*} params 传对象
     * @param {*} credentials : 'include',可选，代表传用户cookie
     */
    post2(params) {
        return request.post(url, {
            data: params,
            credentials: 'include'
        });
    }
    /**
     * jsonp
     * @param {*} params 传对象
     * @param {*} credentials : 'include',可选，代表传用户cookie
     * @param {*} jsonpCallback 可不传，生成的callback是个带时间戳的字符串
     */
    jsonp(params) {
        return request.jsonp(url, {
            jsonpCallback: 'callback',
            data: params
        });
    }
}

export default new apiDemo();