package cz.malyzajic.pathfaker;

import java.util.Properties;

/**
 *
 * @author daop
 */
public class PathFakerImpl implements PathFaker {
    
    @Override
    public PathContext preparePathContext(PathRequest request, PathFakerProviderEnum provider, Properties properties) {
        PathContext result;
        result = getPathContext(provider);
        if (result != null) {
            result.setPathRequest(request);
            result.setProperties(properties);
            result.loadPath();
        }
        return result;
    }
    
    private PathContext getPathContext(PathFakerProviderEnum provider) {
        PathContext result;
        if (null != provider) {
            switch (provider) {
                case GOOGLE:
                    result = new GooglePathContext();
                    break;
                default:
                    result = null;
                    break;
            }
        } else {
            result = null;
        }
        
        return result;
    }
    
}
