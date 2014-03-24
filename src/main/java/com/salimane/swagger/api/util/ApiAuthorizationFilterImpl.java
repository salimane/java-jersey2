/**
 *
 *
 */

package com.salimane.swagger.api.util;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.ApiDescription;
import com.wordnik.swagger.model.Operation;
import com.wordnik.swagger.model.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * The rules are maintained in simple map with key as path and a boolean value
 * indicating given path is secure or not. For method level security the key is
 * combination of http method and path .
 * <p/>
 * If the resource or method is secure then it can only be viewed using a
 * secured api key
 * <p/>
 * Note: Objective of this class is not to provide fully functional
 * implementation of authorization filter. This is only a sample demonstration
 * how API authorization filter works.
 */

public class ApiAuthorizationFilterImpl implements SwaggerSpecFilter {
    static Logger logger = LoggerFactory.getLogger(ApiAuthorizationFilterImpl.class);

    public boolean isOperationAllowed(Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        boolean isAuthorized = checkKey(params, headers);
        if (isAuthorized) {
            return true;
        } else {
            if (!"GET".equals(operation.method()) || api.path().indexOf("/store") != -1) {
                return false;
            } else return true;
        }
    }

    public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        boolean isAuthorized = checkKey(params, headers);
        if ((parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")) && !isAuthorized)
            return false;
        else
            return true;
    }

    public boolean checkKey(Map<String, List<String>> params, Map<String, List<String>> headers) {
        String keyValue = null;
        if (params.containsKey("api_key"))
            keyValue = params.get("api_key").get(0);
        else {
            if (headers.containsKey("api_key"))
                keyValue = headers.get("api_key").get(0);
        }
        if ("special-key".equals(keyValue))
            return true;
        else
            return false;
    }
}
