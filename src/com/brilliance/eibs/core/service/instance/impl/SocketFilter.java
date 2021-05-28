//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.brilliance.eibs.core.service.instance.impl;

import com.brilliance.eibs.core.exception.InterfaceException;
import com.brilliance.eibs.core.frame.ISocketProxy;
import com.brilliance.eibs.core.model.IFieldDef;
import com.brilliance.eibs.core.service.Context;
import com.brilliance.eibs.packet.Packet;
import com.brilliance.eibs.packet.PacketManager;
import com.brilliance.eibs.util.StringUtil;
import java.io.IOException;
import java.util.regex.Pattern;

public class SocketFilter extends AbsFilter {
    private String tag = "";
    private Packet packet = null;

    public SocketFilter() {
    }

    public void execute(Context context) {
        this.logger.info(context, new Object[]{"############SocketFilter is running############"});
        context.setCurrentInstance(this);
        ISocketProxy socketProxy = context.getResource().getSocketProxy();
        if (socketProxy != null) {
            socketProxy.setEncoding(this.filterDef.getEncoding());
            super.execute(context);
        }

        this.logger.info(context, new Object[]{"############SocketFilter has finished running############"});
    }

    public String getDataStream(int len) throws IOException {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new RuntimeException("SocketProxy is null.");
        } else {
            String data = socketProxy.getDataStream(len);
            return data;
        }
    }

    public byte[] getDataStreamBytes(int len) throws IOException {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy != null) {
            byte[] data = socketProxy.getDataStreamBytes(len);
            return data;
        } else {
            return null;
        }
    }

    public Object[] readDataByBuffer() throws IOException {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new InterfaceException("02201");
        } else {
            return socketProxy.readDataByBuffer();
        }
    }

    public String getStrBySocketStream() throws IOException {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new InterfaceException("02201");
        } else {
            return socketProxy.getStrBySocketStream();
        }
    }

    public void sendMsg(Object message) throws IOException {
        this.logger.trace(this.context, new Object[]{"[sending] message:\n" + message});
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new InterfaceException("02201");
        } else {
            socketProxy.send(message);
        }
    }

    public void skip(int len) throws IOException {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new InterfaceException("02201");
        } else {
            socketProxy.skip((long)len);
        }
    }

    public void close() {
        ISocketProxy socketProxy = this.context.getResource().getSocketProxy();
        if (socketProxy == null) {
            throw new InterfaceException("02201");
        } else {
            socketProxy.close();
        }
    }

    public void closeSocket(ISocketProxy proxy) {
        proxy.close();
    }

    public Object getFieldValue(IFieldDef fieldDef) {
        return this.getFieldValueHandle(fieldDef);
    }

    public Object getFieldValueHandle(IFieldDef fieldDef) {
        this.logger.info(this.context, new Object[]{"############SOCKET接收解析############"});
        String etag = "" + this.elParser.getExPression(this.context, fieldDef.getEtag(), (Object[])null);
        if (etag.equals("close")) {
            this.close();
            return null;
        } else if (etag.equals("read")) {
            try {
                return this.readDataByBuffer();
            } catch (IOException var5) {
                throw new InterfaceException("02203", var5);
            }
        } else if (!Pattern.matches("^\\d+$", etag)) {
            try {
                String lenstr = "" + this.elParser.getExPression(this.context, "${" + this.tag + "}", (Object[])null);
                int dataLength = Integer.parseInt(lenstr);
                if (this.packet == null) {
                    this.packet = PacketManager.createPacket(this.context.getResource().getSocketProxy(), this.filterDef.getEncoding(), dataLength);
                }

                return PacketManager.readPartOfPacket(etag, this.packet);
            } catch (Exception var6) {
                throw new InterfaceException("02203", var6);
            }
        } else {
            int len = Integer.parseInt(etag);

            try {
                if (StringUtil.isEmpty(fieldDef.getTag())) {
                    this.skip(len);
                    return null;
                } else {
                    this.tag = fieldDef.getTag();
                    return this.getDataStreamBytes(len);
                }
            } catch (IOException var7) {
                this.logger.info(this.context, "############################# Client空请求不作处理！ #############################");
                return 0;
            }
        }
    }

    protected void packField(IFieldDef fieldDef, Object fieldValue) {
        this.packHandle(fieldDef, fieldValue);
    }

    protected void packHandle(IFieldDef fieldDef, Object fieldValue) {
        this.logger.info(this.context, new Object[]{"############SOCKET组包发送############"});
        String etag = "" + this.elParser.getExPression(this.context, fieldDef.getEtag(), (Object[])null);
        if (etag.equals("close")) {
            this.close();
        } else {
            try {
                this.sendMsg(fieldValue);
            } catch (IOException var5) {
                throw new InterfaceException("02204", var5);
            }
        }
    }
}
