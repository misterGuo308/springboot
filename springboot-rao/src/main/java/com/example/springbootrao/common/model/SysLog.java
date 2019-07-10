package com.example.springbootrao.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author guoyou
 * @since 2019-07-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="sys_log")
public class SysLog extends Model<SysLog> {

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
    private LocalDateTime dateTime;

    /**
     * 请求ip
     */
    private String ip;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
