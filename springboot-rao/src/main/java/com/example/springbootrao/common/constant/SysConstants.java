package com.example.springbootrao.common.constant;

/**
 * @author Administrator
 * @date 2019/7/8 22:08
 */
public class SysConstants {

    private SysConstants() {
    }

    /**
     * 定义session中保存的用户名称
     */
    public static final String USER_INFO = "USER_INFO_SESSION_NAME";

    /**
     * /sessionId失效
     */
    public static final String AUTO = "AUTO";

    /**
     * 通用成功码
     */
    public static final int SUCCESS = 200;

    /**
     * 通用失败码
     */
    public static final int FAILURE = 400;
    /**
     * 未认证
     */
    public static final int UNAUTHORIZED = 401;
    /**
     * 系统错误
     */
    public static final int ERROR_UNKNOWN = 500;
    /**
     * 资源位置不存在
     */
    public static final int NOT_FOUND = 404;

    /**
     * 提示信息：缺少必要参数或参数错误
     */
    public static final String MSG_ERROR_UNKNOWN = "系统未知错误";

    /**
     * 提示信息：缺少必要参数或参数错误
     */
    public static final String MSG_ERROR_PARAM = "缺少必要参数或参数错误";

    /**
     * 提示信息：参数范围错误
     */
    public static final String PARAM_RANGE_ERROR = "参数范围错误";

    /**
     * 提示信息：操作失败
     */
    public static final String MSG_ERROR_OPERATE = "操作失败";

    /**
     * 提示信息：非法访问
     */
    public static final String MSG_ERROR_ILLEGAL = "非法访问";


    /**
     * 提示信息：获取信息失败
     */
    public static final String MSG_ERROR_GET = "获取信息失败";

    /**
     * 提示信息：操作成功
     */
    public static final String MSG_SUCCSS_OPERATE = "操作成功";

    /**
     * 重新登录
     */
    public static final String MSG_UNKNOWN_USER = "请重新登录";

    /**
     * 提示信息：返回消息key
     */
    public static final String MSG_RETURN_KEY = "message";

    /**
     * 提示信息：返回消息code
     */
    public static final String MSG_RETURN_CODE = "code";
    /**
     * 提示信息：返回消息state
     */
    public static final String MSG_RETURN_STATE = "state";

    /**
     * 提示信息：返回数据data,key
     */
    public static final String RETURN_DATA_KEY = "data";
    /**
     * 接口服务版本
     */
    public static final String VERSION = "1.0.0";

    /**
     * MD5加密键组合
     */
    public static final String MD5_KEY = "ANT_CHINA";
}
