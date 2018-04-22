package pl.akademiakodu.miniblog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuoteResponse {
    private String type;
    @JsonProperty("value")
    private QuoteValue quoteValue;

    @Getter
    @Setter
    @ToString
    public class QuoteValue {
        private String id;
        private String quote;
    }
}
