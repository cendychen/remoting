package cendy.chen.org.framework.revoker;

import cendy.chen.org.framework.model.AresResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientInvokeHandler extends SimpleChannelInboundHandler<AresResponse> {


    public NettyClientInvokeHandler() {
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, AresResponse response) throws Exception {
        //将Netty异步返回的结果存入阻塞队列,以便调用端同步获取
        RevokerResponseHolder.putResultValue(response);
    }


}
