package com.example.mpd.model;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.*;
import com.example.mpd.enums.SexEnum;
import com.example.mpd.mapper.handler.JSONTypeHandler;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Date;

/**
 * @author EDZ
 */
@Data
@ToString
@TableName(value = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -5223436669413172015L;

    @TableId(value = "student_number",type = IdType.AUTO)
    private Integer studentNumber;

    @TableField(value = "name",updateStrategy = FieldStrategy.IGNORED)
    private String name;

    @TableField(value = "address",updateStrategy = FieldStrategy.NOT_NULL)
    private String address;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "detail_info",typeHandler = JSONTypeHandler.class)
    private JSONObject detailInfo;

    /**
     * 年龄，IEnum接口的枚举处理
     * 数据库字段：age INT(3)
     *
     */
//    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    @TableField(value = "sex")
    private SexEnum sex;

    /*如果逻辑删除标志字段上面没有添加该注解，那么就是用全局配置里面的逻辑删除字段，如果都没标注，那么直接就会直接删除*/
//    @TableLogic
    @TableField(value = "is_delete",select = false)
    private Integer isDelete;

}
