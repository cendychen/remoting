package cendy.chen.org.framework.cluster.engine;

import cendy.chen.org.framework.cluster.ClusterStrategy;
import cendy.chen.org.framework.cluster.impl.*;
import avro.shaded.com.google.common.collect.Maps;

import java.util.Map;

/**
 * 负载均衡引擎
 *
 */
public class ClusterEngine {

    private static final Map<ClusterStrategyEnum, ClusterStrategy> clusterStrategyMap = Maps.newConcurrentMap();

    static {
        clusterStrategyMap.put(ClusterStrategyEnum.Random, new RandomClusterStrategyImpl());
        clusterStrategyMap.put(ClusterStrategyEnum.WeightRandom, new WeightRandomClusterStrategyImpl());
        clusterStrategyMap.put(ClusterStrategyEnum.Polling, new PollingClusterStrategyImpl());
        clusterStrategyMap.put(ClusterStrategyEnum.WeightPolling, new WeightPollingClusterStrategyImpl());
        clusterStrategyMap.put(ClusterStrategyEnum.Hash, new HashClusterStrategyImpl());
    }


    public static ClusterStrategy queryClusterStrategy(String clusterStrategy) {
        ClusterStrategyEnum clusterStrategyEnum = ClusterStrategyEnum.queryByCode(clusterStrategy);
        if (clusterStrategyEnum == null) {
            //默认选择随机算法
            return new RandomClusterStrategyImpl();
        }

        return clusterStrategyMap.get(clusterStrategyEnum);
    }

}
