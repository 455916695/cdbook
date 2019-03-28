package com.ax.entity;

import java.io.Serializable;

public class Result implements Serializable {

  private boolean success; // 状态

  private String message; // 消息体

  private Object data; // 数据

  public Result() {}

  public Result(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public Result(boolean success, String message, Object data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
