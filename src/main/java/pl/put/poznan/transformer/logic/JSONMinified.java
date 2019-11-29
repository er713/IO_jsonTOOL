package pl.put.poznan.transformer.logic;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONMinified extends Decorator {

    public JSONMinified(Component componentDecorating) {
        super(componentDecorating);
    }

    public String minify(String jsonString) throws JSONException {
        return doMinify(JSONTransformer.transform(jsonString));
    }

    private String doMinify(JSONArray array) {
        String minified = String.valueOf(array);
        minified = minified.substring(1, minified.length() - 1);
        return minified;
    }

    @Override
    public void Operation() throws JSONException {
        newDecoration = minify(component.getJsonString());
    }

    @Override
    public String Compare(Component component) {
        return null;
    }
}
