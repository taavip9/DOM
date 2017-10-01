package dragons;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "gameId",
        "knight"
})
public class Game {

    @JsonProperty("gameId")
    private static Integer gameId;
    @JsonProperty("knight")
    private Knight knight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gameId")
    public static Integer getGameId() {
        return gameId;
    }

    @JsonProperty("gameId")
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("knight")
    public Knight getKnight() {
        return knight;
    }

    @JsonProperty("knight")
    public void setKnight(Knight knight) {
        this.knight = knight;
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