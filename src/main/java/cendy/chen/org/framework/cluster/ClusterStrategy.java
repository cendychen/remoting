package cendy.chen.org.framework.cluster;

import cendy.chen.org.framework.model.ProviderService;

import java.util.List;

public interface ClusterStrategy {

    /**
     * 负载策略算法
     *
     * @param providerServices
     * @return
     */
    public ProviderService select(List<ProviderService> providerServices);
}
