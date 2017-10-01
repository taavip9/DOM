package dragons;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "scaleThickness",
        "clawSharpness",
        "wingStrength",
        "fireBreath"
})
public class Dragon {

    @JsonProperty("scaleThickness")
    private Integer scaleThickness;
    @JsonProperty("clawSharpness")
    private Integer clawSharpness;
    @JsonProperty("wingStrength")
    private Integer wingStrength;
    @JsonProperty("fireBreath")
    private Integer fireBreath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("scaleThickness")
    public Integer getScaleThickness() {
        return scaleThickness;
    }

    @JsonProperty("scaleThickness")
    public void setScaleThickness(Integer scaleThickness) {
        this.scaleThickness = scaleThickness;
    }

    @JsonProperty("clawSharpness")
    public Integer getClawSharpness() {
        return clawSharpness;
    }

    @JsonProperty("clawSharpness")
    public void setClawSharpness(Integer clawSharpness) {
        this.clawSharpness = clawSharpness;
    }

    @JsonProperty("wingStrength")
    public Integer getWingStrength() {
        return wingStrength;
    }

    @JsonProperty("wingStrength")
    public void setWingStrength(Integer wingStrength) {
        this.wingStrength = wingStrength;
    }

    @JsonProperty("fireBreath")
    public Integer getFireBreath() {
        return fireBreath;
    }

    @JsonProperty("fireBreath")
    public void setFireBreath(Integer fireBreath) {
        this.fireBreath = fireBreath;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
