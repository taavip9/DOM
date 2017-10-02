package dragons.objects;

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
        "name",
        "attack",
        "armor",
        "agility",
        "endurance"
})
public class Knight {

    @JsonProperty("name")
    private String name;
    @JsonProperty("attack")
    private Integer attack;
    @JsonProperty("armor")
    private Integer armor;
    @JsonProperty("agility")
    private Integer agility;
    @JsonProperty("endurance")
    private Integer endurance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("attack")
    public Integer getAttack() {
        return attack;
    }

    @JsonProperty("attack")
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @JsonProperty("armor")
    public Integer getArmor() {
        return armor;
    }

    @JsonProperty("armor")
    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    @JsonProperty("agility")
    public Integer getAgility() {
        return agility;
    }

    @JsonProperty("agility")
    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    @JsonProperty("endurance")
    public Integer getEndurance() {
        return endurance;
    }

    @JsonProperty("endurance")
    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
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
