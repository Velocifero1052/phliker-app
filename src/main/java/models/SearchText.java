package models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
@Data
public class SearchText {
    Boolean next;
    String text;

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
}
