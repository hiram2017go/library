package com.zyy.demo.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.zyy.demo.util.wx.XStreamCDataConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@XStreamAlias("xml")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxMpXmlOutTextMessage extends WxMpXmlOutMessage {
  private static final long serialVersionUID = -3972786455288763361L;

  @XStreamAlias("Content")
  @XStreamConverter(value = XStreamCDataConverter.class)
  private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WxMpXmlOutTextMessage() {
    this.msgType = WxConsts.XmlMsgType.TEXT;
  }

}
