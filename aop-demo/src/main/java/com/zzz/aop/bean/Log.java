package com.zzz.aop.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zjc
 * @Date 2023/2/17 11:03
 */

@Data
@TableName("tb_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    @TableField(value = "log_code")
    private String logCode;

    @TableField(value = "operation")
    private String operation;

}
