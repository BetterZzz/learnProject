package com.zzz.aop.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zjc
 * @Date 2023/2/17 11:00
 */
@TableName("tb_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    @TableField(value = "user_code")
    private String      userCode;

    @TableField(value = "user_name")
    private String      userName;

    @TableField(value = "deleted")
    private Integer     deleted;

    @TableField(value = "create_date")
    private Date        createDate;

    @TableField(value = "update_date")
    private Date        updateDate;
}
