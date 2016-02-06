package cz.malyzajic.pathfaker;

import java.util.Properties;

/**
 *
 * @author daop
 */
public interface PathFaker {

    PathContext preparePathContext(PathRequest request, PathFakerProviderEnum provider, Properties properties);

}
