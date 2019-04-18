package net.wanho.util;

import lombok.Data;

@Data
public class JsonResult {
    private Integer status;
    private String msg;
    private Object data;
}
