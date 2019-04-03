package com.zyy.demo.message;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.zyy.demo.util.wx.XStreamCDataConverter;
import lombok.Data;


/**
 * <pre>
 *  Created by BinaryWang on 2017/5/4.
 * </pre>
 *
 * @author Binary Wang
 */
@XStreamAlias("ScanCodeInfo")
@Data
public class ScanCodeInfo implements Serializable {
  private static final long serialVersionUID = 4745181270645050122L;

  /**
   * 扫描类型，一般是qrcode.
   */
  @XStreamAlias("ScanType")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String scanType;

  /**
   * 扫描结果，即二维码对应的字符串信息.
   */
  @XStreamAlias("ScanResult")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String scanResult;

//  @Override
//  public String toString() {
//    return WxMpGsonBuilder.create().toJson(this);
//  }

}
