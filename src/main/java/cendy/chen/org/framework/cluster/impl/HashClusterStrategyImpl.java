package cendy.chen.org.framework.cluster.impl;

import cendy.chen.org.framework.helper.IPHelper;
import cendy.chen.org.framework.cluster.ClusterStrategy;
import cendy.chen.org.framework.model.ProviderService;

import java.util.List;

/**
 * 软负载哈希算法实现
 *
 */
public class HashClusterStrategyImpl implements ClusterStrategy {

    @Override
    public ProviderService select(List<ProviderService> providerServices) {
        //获取调用方ip
        String localIP = IPHelper.localIp();
        //获取源地址对应的hashcode
        int hashCode = localIP.hashCode();
        //获取服务列表大小
        int size = providerServices.size();

        return providerServices.get(hashCode % size);
    }
}
