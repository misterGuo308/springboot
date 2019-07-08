package com.example.springbootrao.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@Data
@Accessors(chain = true)
@TableName("sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 管理员id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 操作用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 操作类型：1新增2修改3删除4查询
     */
    private String operation;
    /**
     * 请求方法名
     */
    @TableField("method_name")
    private String methodName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 操作时间
     */
    @TableField("date_time")
    private Date dateTime;
    /**
     * 请求ip
     */
    private String ip;


}
