package com.zyy.demo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.zyy.demo.util.wx.XStreamCDataConverter;
import com.zyy.demo.util.wx.XStreamTransformer;
import lombok.Data;


import java.io.Serializable;

@XStreamAlias("xml")
@Data
public abstract class WxMpXmlOutMessage implements Serializable {
  private static final long serialVersionUID = -381382011286216263L;

  @XStreamAlias("ToUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String toUserName;

  @XStreamAlias("FromUserName")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String fromUserName;

  @XStreamAlias("CreateTime")
  protected Long createTime;

  @XStreamAlias("MsgType")
  @XStreamConverter(value = XStreamCDataConverter.class)
  protected String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
   * 获得文本消息builder
   */
  public static TextBuilder TEXT() {
    return new TextBuilder();
  }

//  /**
//   * 获得图片消息builder
//   */
//  public static ImageBuilder IMAGE() {
//    return new ImageBuilder();
//  }
//
//  /**
//   * 获得语音消息builder
//   */
//  public static VoiceBuilder VOICE() {
//    return new VoiceBuilder();
//  }
//
//  /**
//   * 获得视频消息builder
//   */
//  public static VideoBuilder VIDEO() {
//    return new VideoBuilder();
//  }
//
//  /**
//   * 获得音乐消息builder
//   */
//  public static MusicBuilder MUSIC() {
//    return new MusicBuilder();
//  }
//
//  /**
//   * 获得图文消息builder
//   */
//  public static NewsBuilder NEWS() {
//    return new NewsBuilder();
//  }
//
//  /**
//   * 获得客服消息builder
//   */
//  public static TransferCustomerServiceBuilder TRANSFER_CUSTOMER_SERVICE() {
//    return new TransferCustomerServiceBuilder();
//  }

  @SuppressWarnings("unchecked")
  public String toXml() {
    return XStreamTransformer.toXml((Class<WxMpXmlOutMessage>) this.getClass(), this);
  }

//  /**
//   * 转换成加密的xml格式
//   */
//  public String toEncryptedXml(WxMpConfigStorage wxMpConfigStorage) {
//    String plainXml = toXml();
//    WxMpCryptUtil pc = new WxMpCryptUtil(wxMpConfigStorage);
//    return pc.encrypt(plainXml);
//  }
}
